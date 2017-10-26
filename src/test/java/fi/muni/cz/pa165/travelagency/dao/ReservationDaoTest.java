package fi.muni.cz.pa165.travelagency.dao;


import fi.muni.cz.pa165.travelagency.PersistenceSampleApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by martin on 24.10.2017.
 * @author Martin Sevcik <422365>
 */
@ContextConfiguration(classes=PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ReservationDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ReservationDao reservationDao;

    @BeforeMethod
    public void setup(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void createTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void findAllTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void findByCustomerTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void findByIdTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void removeTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void getReservationsCreatedBetweenTest(){
        throw new UnsupportedOperationException();
    }
}
