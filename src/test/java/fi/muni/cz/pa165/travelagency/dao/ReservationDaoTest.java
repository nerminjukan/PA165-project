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
        cal.set(2017, 10, 10);
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

    @Test
    public void createTest(){
        reservationDao.create(reservation);

        Assert.assertEquals(reservationDao.findAll().size(), 1);
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
        Assert.assertEquals(list.get(0), reservation);
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
        Assert.assertEquals(reservationDao.findAll().isEmpty(), false);

        reservationDao.remove(reservation);
        Assert.assertEquals(reservationDao.findAll().isEmpty(), true);
    }

    @Test
    public void getReservationsCreatedBetweenTest(){

        throw new UnsupportedOperationException();
    }
}
