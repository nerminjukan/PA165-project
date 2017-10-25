package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.PersistenceSampleApplicationContext;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public TripDao tripDao;
    
    @Autowired
    public ExcursionDao excursionDao;
    
    private Trip t1;
    private Trip t2;
    private Date dateFrom1;
    private Date dateFrom2;
    private Date dateTo1;
    private Date dateTo2;
    
    @BeforeMethod
    public void createTrips() {
        Calendar cal = Calendar.getInstance();
        
        cal.set(2017, 10, 10);
        dateFrom1 = cal.getTime();
        cal.set(2017, 10, 15);
        dateTo1 = cal.getTime();
        
        t1 = new Trip();
        t1.setDateFrom(dateFrom1);
        t1.setDateTo(dateTo1);
        t1.setName("Trip1");
        t1.setDestination("Location1");
        t1.setAvailableSpots(10);
        t1.setPrice(new BigDecimal("1000.00"));
        
        tripDao.create(t1);
        
        cal.set(2017, 10, 15);
        dateFrom2 = cal.getTime();
        cal.set(2017, 10, 20);
        dateTo2 = cal.getTime();
        
        t2 = new Trip();
        t2.setDateFrom(dateFrom2);
        t2.setDateTo(dateTo2);
        t2.setName("Trip2");
        
        tripDao.create(t2);
    }
    
    @Test
    public void findAllTest() {
        List<Trip> found = tripDao.findAll();
        Assert.assertEquals(found.size(), 2);
    }
    
    @Test
    public void notExistingTripReturnNullTest() {
        Assert.assertNull(tripDao.findById(Long.MAX_VALUE));
    }
    
    @Test(expectedExceptions=ConstraintViolationException.class)
    public void nullNameNotAllowedTest(){
	Trip trip = new Trip();
	trip.setName(null);
	tripDao.create(trip);
        List<Trip> found = tripDao.findAll();
    }
    
    @Test(expectedExceptions=DataAccessException.class)
    public void nameIsUniqueTest(){
	Trip trip = new Trip();
	trip.setName("Trip1");
	tripDao.create(trip);
        List<Trip> found = tripDao.findAll();
    }
    
    @Test
    public void findByIdTest() {
        Trip found = tripDao.findById(t1.getId());
        
        Assert.assertEquals(found.getDateFrom(), dateFrom1);
        Assert.assertEquals(found.getDateTo(), dateTo1);
        Assert.assertEquals(found.getName(), "Trip1");
        Assert.assertEquals(found.getDestination(), "Location1");
        Assert.assertEquals(found.getAvailableSpots(), 10);
        Assert.assertEquals(found.getPrice(), new BigDecimal("1000.00"));
    }
    
    @Test
    public void findByNameTest() {
        List<Trip> found = tripDao.findByName("Trip1");
        Assert.assertEquals(found.size(), 1);
    }
    
    @Test
    public void findByNotExistingNameTest() {
        List<Trip> found = tripDao.findByName("Trip");
        Assert.assertEquals(found.size(), 0);
    }
    
    
    @Test
    public void removeAllTest() {
        List<Trip> found = tripDao.findAll();
        Assert.assertEquals(found.size(), 2);
        
        tripDao.remove(found.get(0));
        
        found = tripDao.findAll();
        Assert.assertEquals(found.size(), 1);
        
        tripDao.remove(found.get(0));
        
        found = tripDao.findAll();
        Assert.assertEquals(found.size(), 0);
        
        Assert.assertNull(tripDao.findById(t1.getId()));
    }
    
    @Test
    public void getTripsBetweenTest() {
        List<Trip> found = tripDao.getTripsBetween(dateFrom1, dateTo1);
        
        Assert.assertEquals(found.size(), 1);
        
        Calendar cal = Calendar.getInstance();
	cal.set(2017, 10, 11);
	Date date = cal.getTime();
        found = tripDao.getTripsBetween(date, dateTo1);
        
        Assert.assertEquals(found.size(), 0);
        
        cal.set(2017, 10, 14);
        date = cal.getTime();
        found = tripDao.getTripsBetween(dateFrom1, date);
        
        Assert.assertEquals(found.size(), 0);
        
        found = tripDao.getTripsBetween(dateFrom1, dateTo2);
        
        Assert.assertEquals(found.size(), 2);
    }
    
    @Test
    public void excursionsInTrip() {
        Trip trip = tripDao.findById(t1.getId());
        
        Excursion exc = new Excursion();
        Calendar cal = Calendar.getInstance();
	cal.set(2017, 10, 12);
	Date date = cal.getTime();
        exc.setExcursionDate(date);
        exc.setDescription("Description");
        exc.setDestination("Destination");
        exc.setDuration(2);
        exc.setPrice(new BigDecimal("1000.00"));
        //exc.addTrip(trip);
        excursionDao.create(exc);
        trip.addExcursion(exc);
        
        Trip found = tripDao.findById(t1.getId());
        Assert.assertEquals(found.getExcursions().size(), 1);
        
        //Excursion exc1 = excursionDao.findById(exc.getId());
        //Assert.assertEquals(exc1.getTrips().size(), 1);
    }
    
    
    
    
}
