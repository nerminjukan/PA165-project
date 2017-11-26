package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.CustomerDao;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.enums.PaymentStateType;
import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.fail;

import java.util.Calendar;
import java.util.List;

@ContextConfiguration(classes = ServiceConfiguration.class)
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private CustomerDao customerDao;

    @Mock
    private ReservationService reservationService;

    @Autowired
    @InjectMocks
    private CustomerService customerService;

    private Customer customer, customerNew;
    private Reservation reservation;

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setup() {
        Calendar cal = Calendar.getInstance();
        customer = new Customer();
        customer.setEmail("email@email.com");
        customer.setIdCardNumber("idCardNumber");
        customer.setName("Name");
        customer.setSurname("Surname");
        customer.setPhoneNumber("7894556123");
        cal.set(2017, 28, 10);
        customer.setBirthDate(cal.getTime());

        customerNew = new Customer();
        customerNew.setEmail("email2@email.com");
        customerNew.setIdCardNumber("idCardNumber2");
        customerNew.setName("Name2");
        customerNew.setSurname("Surname2");
        customerNew.setPhoneNumber("123456789");
        cal.set(2017, 10, 9);
        customerNew.setBirthDate(cal.getTime());

        Reservation reservation = new Reservation();
        reservation.setPaymentState(PaymentStateType.NotPaid);
        reservation.setCustomer(customer);

        customer.addReservation(reservation);
    }

    @Test
    public void createCustomer() {
        customerService.create(customer);
        verify(customerDao).create(customer);
    }

    @Test
    public void updateCustomer() {
        customerService.update(customer);
        verify(customerDao).update(customer);
    }

    @Test
    public void getTotalPriceCustomersReservationsCustomer() {
        customerService.getTotalPriceCustomersReservations(customer);
        fail();
    }

    @Test
    public void changeCustomerOnReservationCustomer() {
        Assert.assertEquals(reservation.getCustomer(), customer.getId(), "Id equality");
        customerEqualsTest(reservation.getCustomer(), customer);

        customerService.changeCustomerOnReservation(customerNew, reservation);
        Assert.assertNotEquals(reservation.getCustomer(), customer.getId(), "Id non equality");
        Assert.assertEquals(reservation.getCustomer().getId(), customerNew.getId());
        customerEqualsTest(reservation.getCustomer(), customerNew);
    }

    @Test
    public void findAllCustomer() {
        List<Customer> customerList = customerService.findAll();
        Assert.assertEquals(customerList.size(), 1, "size is 1");
        Assert.assertEquals(customerList.get(0).getId(), customer.getId(), "Id quality");
        customerEqualsTest(customerList.get(0), customer);
    }

    @Test
    public void findByEmailCustomer() {
        Customer found = customerService.findByEmail("email@email.com");
        Assert.assertEquals(customer.getId(), found.getId(), "Id equality");
        customerEqualsTest(found, customer);
    }

    @Test
    public void findByIdCustomer() {
        Customer found = customerService.findById(customer.getId());
        Assert.assertEquals(customer.getId(), found.getId(), "Id equality");
        customerEqualsTest(found, customer);
    }

    @Test
    public void findByIdCardNumberCustomer() {
        Customer found = customerService.findByIdCardNumber("idCardNumber");
        Assert.assertEquals(customer.getId(), found.getId(), "Id equality");
        customerEqualsTest(found, customer);
    }

    @Test
    public void findByReservationCustomer() {
        Customer found = customerService.findByReservation(reservation);
        Assert.assertEquals(customer.getId(), found.getId(), "Id equality");
        customerEqualsTest(found, customer);
    }

    @Test
    public void removeCustomer() {
        customerService.remove(customer);
        verify(customerDao).remove(customer);
    }

    public void customerEqualsTest(Customer customerNew, Customer customerExpected) {
        Assert.assertEquals(customerNew.getIdCardNumber(), customerExpected.getIdCardNumber(),"IdCardNumber Equality");
        Assert.assertEquals(customerNew.getPhoneNumber(), customerExpected.getPhoneNumber(), "PhoneNumber Equality");
        Assert.assertEquals(customerNew.getBirthDate(), customerExpected.getBirthDate(), "BirthDate Equality");
        Assert.assertEquals(customerNew.getEmail(), customerExpected.getEmail(), "Email Equality");
        Assert.assertEquals(customerNew.getSurname(), customerExpected.getSurname(), "Surname Equality");
        Assert.assertEquals(customerNew.getName(), customerExpected.getName(), "Name Equality");
        Assert.assertEquals(customerNew.getReservations(), customerExpected.getReservations(), "Reservations Equality");
    }

}
