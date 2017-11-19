package fi.muni.cz.pa165.travelagency.dao;


import fi.muni.cz.pa165.travelagency.PersistenceSampleApplicationContext;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.enums.PaymentStateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by martin on 24.10.2017.
 * @author Martin Sevcik <422365>
 */
@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ReservationDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private TripDao tripDao;

    @Autowired
    private CustomerDao customerDao;

    private Customer customer;
    private Trip trip;
    private Reservation reservation;

    @BeforeMethod
    public void setup(){
        customer = new Customer();
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 10);
        customer.setBirthDate(cal.getTime());
        customer.setEmail("name@name.com");
        customer.setIdCardNumber("idCard");
        customer.setSurname("Surname");
        customerDao.create(customer);

        trip = new Trip();
        trip.setName("Trip");
        tripDao.create(trip);

        reservation = new Reservation();
        reservation.setPaymentState(PaymentStateType.NotPaid);
        reservation.setCreated(cal.getTime());
        reservation.setCustomer(customer);
        reservation.setReservedTrip(trip);
    }

    private void assertReservationsEqual(Reservation compared){
        Assert.assertEquals(compared.getCreated(), this.reservation.getCreated());
        Assert.assertEquals(compared.getCustomer(), this.reservation.getCustomer());
        Assert.assertEquals(compared.getId(), this.reservation.getId());
        Assert.assertEquals(compared.getPaymentState(), this.reservation.getPaymentState());
        Assert.assertEquals(compared.getReservedExcursions(), this.reservation.getReservedExcursions());
        Assert.assertEquals(compared.getReservedTrip(), this.reservation.getReservedTrip());
    }

    @Test
    public void createTest(){
        reservationDao.create(reservation);

        Assert.assertEquals(reservationDao.findAll().size(), 1);
        this.assertReservationsEqual(reservationDao.findAll().get(0));
    }

    @Test(expectedExceptions=ConstraintViolationException.class)
    public void createNullTest(){
        Reservation res = new Reservation();
        reservationDao.create(res);
    }

    @Test
    public void findAllTest(){
        List<Reservation> list = reservationDao.findAll();
        Assert.assertEquals(list.size(), 0);

        reservationDao.create(reservation);

        list = reservationDao.findAll();
        Assert.assertEquals(list.size(), 1);
        this.assertReservationsEqual(reservationDao.findAll().get(0));
    }

    @Test
    public void findByCustomerTest(){
        reservationDao.create(reservation);
        List<Reservation> list = reservationDao.findByCustomer(customer);

        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals(list.get(0), reservation);
        Assert.assertEquals(list.get(0).getCustomer(), customer);
    }

    @Test
    public void findByCustomerNoResultTest(){
        Customer customer2 = new Customer();
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 9, 9);
        customer2.setBirthDate(cal.getTime());
        customer2.setEmail("name2@name.com");
        customer2.setIdCardNumber("idCard2");
        customer2.setSurname("Surname2");
        customerDao.create(customer2);

        reservation.setCustomer(customer2);
        reservationDao.create(reservation);
        List<Reservation> list = reservationDao.findByCustomer(customer);

        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void findByIdTest(){
        reservationDao.create(reservation);
        Reservation found = reservationDao.findById(reservation.getId());

        Assert.assertNotNull(found);
        Assert.assertEquals(found, reservation);
    }

    @Test
    public void findByIdNullResultTest(){
        reservationDao.create(reservation);
        Reservation found = reservationDao.findById(-1L);

        Assert.assertNull(found);
    }

    @Test
    public void removeTest(){
        reservationDao.create(reservation);
        Assert.assertFalse(reservationDao.findAll().isEmpty());

        reservationDao.remove(reservation);
        Assert.assertTrue(reservationDao.findAll().isEmpty());
    }

    @Test
    public void testFindByTrip() {
        reservationDao.create(reservation);
        
        List<Reservation> resList = reservationDao.findByTrip(reservation.getReservedTrip());
        Assert.assertTrue(resList.size() == 1);
        Assert.assertEquals(resList.get(0), reservation);
    }
    
    @Test
    public void getReservationsCreatedBetweenTest(){
        Calendar cal = Calendar.getInstance();

        Customer customer2 = new Customer();
        cal.set(2016, 9, 9);
        customer2.setBirthDate(cal.getTime());
        customer2.setEmail("name2@name.com");
        customer2.setIdCardNumber("idCard2");
        customer2.setSurname("Surname3");
        customerDao.create(customer2);

        Customer customer3 = new Customer();
        cal.set(2016, 9, 3);
        customer3.setBirthDate(cal.getTime());
        customer3.setEmail("name3@name.com");
        customer3.setIdCardNumber("idCard3");
        customer3.setSurname("Surname3");
        customerDao.create(customer3);

        Trip trip2 = new Trip();
        trip2.setName("Trip2");
        tripDao.create(trip2);

        Trip trip3 = new Trip();
        trip3.setName("Trip3");
        tripDao.create(trip3);

        Reservation reservation2 = new Reservation();
        reservation2.setPaymentState(PaymentStateType.NotPaid);
        cal.set(2017, 10, 2);
        reservation2.setCreated(cal.getTime());
        reservation2.setCustomer(customer2);
        reservation2.setReservedTrip(trip2);
        reservationDao.create(reservation2);

        Reservation reservation3 = new Reservation();
        reservation3.setPaymentState(PaymentStateType.NotPaid);
        cal.set(2017, 10, 6);
        reservation3.setCreated(cal.getTime());
        reservation3.setCustomer(customer3);
        reservation3.setReservedTrip(trip3);
        reservationDao.create(reservation3);

        Calendar calStart = Calendar.getInstance();
        calStart.set(2017, 10, 1);
        Calendar calEnd = Calendar.getInstance();
        calEnd.set(2017, 10, 10);

        List<Reservation> list  = reservationDao.getReservationsCreatedBetween(calStart.getTime(), calEnd.getTime());
        Assert.assertEquals(list.size(), 2);
        Assert.assertTrue(list.contains(reservation2));
        Assert.assertTrue(list.contains(reservation3));

        calStart.set(2017, 10, 3);
        list = reservationDao.getReservationsCreatedBetween(calStart.getTime(), calEnd.getTime());
        Assert.assertEquals(list.size(), 1);
        Assert.assertTrue(list.contains(reservation3));
    }

    @Test
    public void getReservationsCreatedBetweenEmptyTest(){


        //reservationDao.create(reservation);

        Calendar calStart = Calendar.getInstance();
        calStart.set(2017, 10, 1);
        Calendar calEnd = Calendar.getInstance();
        calEnd.set(2017, 10, 10);

        Assert.assertTrue(reservationDao.getReservationsCreatedBetween(calStart.getTime(), calEnd.getTime()).isEmpty());
    }
}
