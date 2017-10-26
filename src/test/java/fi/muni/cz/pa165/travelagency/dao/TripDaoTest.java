package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.PersistenceSampleApplicationContext;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Radoslav Micko <445611>
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TripDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public CustomerDao customerDao;
    
    @Autowired
    public ExcursionDao excursionDao;
    
    @Autowired
    public ReservationDao reservationDao;
    
    @Autowired
    public TripDao tripDao;
    
    private Trip t1;
    private Trip t2;
    private Trip t3;
    private Date dateFrom1;
    private Date dateFrom2;
    private Date dateFrom3;
    private Date dateTo1;
    private Date dateTo2;
    private Date dateTo3;
    
    
    
    
    @BeforeMethod
    public void createTrips() {
        Calendar cal = Calendar.getInstance();
        
        cal.set(2017, 10, 10);
        dateFrom1 = cal.getTime();
        cal.set(2017, 10, 15);
        dateTo1 = cal.getTime();
        
        cal.set(2017, 10, 15);
        dateFrom2 = cal.getTime();
        cal.set(2017, 10, 20);
        dateTo2 = cal.getTime();
        
        t1 = new Trip();
        t1.setDateFrom(dateFrom1);
        t1.setDateTo(dateTo1);
        t1.setName("Trip1");
        
        t2 = new Trip();
        t2.setDateFrom(dateFrom2);
        t2.setDateTo(dateTo2);
        t2.setName("Trip2");
        
        tripDao.create(t1);
        tripDao.create(t2);
    }
    
    @Test
    public void notExistingTripReturnNull() {
        Assert.assertNull(tripDao.findById(Long.MAX_VALUE));
    }
    
    
}
