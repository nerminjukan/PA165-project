package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.ExcursionDao;
import fi.muni.cz.pa165.travelagency.dao.TripDao;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = ServiceConfiguration.class)
public class TripServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    @Mock
    private TripDao tripDao;

    @Mock
    private ExcursionDao excursionDao;

    @Autowired
    @InjectMocks
    private TripService tripService;

    private Trip t1;
    private Trip t2;
    private Trip t3;
    private Trip t4;
    private Trip t5;
    private Excursion e;
    private HashSet<Excursion> es;
    private String tripName;
    private Long tripId;
    private Date tripStart;
    private Date tripEnd;
    private Excursion e1;
    private Excursion e2;
    private Excursion e3;
    private Excursion e4;
    private List<Excursion> excList;


    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void parametersSetup() {
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2012, 4, 20);
        Date start = calendar.getTime();

        t1 = new Trip(start, start, "Zimbabwe", 10, new HashSet<Excursion>(),
                "Zimbabwe trip", BigDecimal.valueOf(9999));

        calendar.set(2012, 4, 21);
        start = calendar.getTime();
        calendar.set(2012, 4, 24);
        t2 = new Trip(start, calendar.getTime(), "Wisconsin", 6, new HashSet<Excursion>(),
                "Wisconsin trip", BigDecimal.valueOf(8888));

        calendar.set(2012, 5, 20);
        start = calendar.getTime();
        calendar.set(2012, 5, 30);
        t3 = new Trip(start, calendar.getTime(), "Tanzania", 423, new HashSet<Excursion>(),
                "Tanzania trip", BigDecimal.valueOf(7777));

        calendar.set(2012, 5, 21);
        start = calendar.getTime();
        calendar.set(2012, 5, 26);
        t4 = new Trip(start, calendar.getTime(), "Syria", 22, new HashSet<Excursion>(),
                "Syria trip", BigDecimal.valueOf(6666));

        calendar.set(2013, 4, 22);
        start = calendar.getTime();
        calendar.set(2013, 4, 27);
        t5 = new Trip(start, calendar.getTime(), "Pakistan", 1, new HashSet<Excursion>(),
                "Pakistan trip", BigDecimal.valueOf(5555));

        e = new Excursion("e", "e", 1, start, BigDecimal.TEN, t1);
        es = new HashSet<>();
        es.add(e);

        calendar.set(2013, 4, 21);
        e1 = new Excursion("e1", "e1", 1, calendar.getTime(), BigDecimal.TEN, t5);
        calendar.set(2013, 4, 22);
        e2 = new Excursion("e2", "e2", 1, calendar.getTime(), BigDecimal.TEN, t5);
        calendar.set(2013, 4, 27);
        e3 = new Excursion("e3", "e3", 1, calendar.getTime(), BigDecimal.TEN, t5);
        calendar.set(2013, 4, 28);
        e4 = new Excursion("e4", "e4", 1, calendar.getTime(), BigDecimal.TEN, t5);

        excList = Arrays.asList(e1, e2, e3, e4);

        tripName = "TRIP_NAME";
        tripId = 123123L;
        tripStart = calendar.getTime();
        calendar.set(2033, 2, 2);
        tripEnd = calendar.getTime();

        when(excursionDao.findByDestination(any())).thenReturn(excList);
        when(tripDao.getTripsBetween(any(), any())).thenReturn(Arrays.asList(t5,t3,t2,t4,t1));
    }

    @Test
    public void testCreateTrip() {
        tripService.createTrip(t1);
        verify(tripDao).create(t1);
    }

    @Test
    public void testAddExcursion() {
        tripService.addExcursion(t1, e);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(t1.getExcursions()).isNotEmpty().containsExactly(e);
        softly.assertAll();
    }

    @Test
    public void testAddExcursions() {
        tripService.addAllExcursions(t1, es);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(t1.getExcursions()).isNotEmpty().containsExactly(e);
        softly.assertAll();
    }

    @Test
    public void testRemoveExcursion() {
        tripService.addAllExcursions(t1, es);
        tripService.removeExcursion(t1, e);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(t1.getExcursions()).isNotNull().isEmpty();
        softly.assertAll();
    }

    @Test
    public void testDeleteTrip() {
        tripService.deleteTrip(t1);
        verify(tripDao).remove(t1);
    }

    @Test
    public void testUpdateTrip() {
        tripService.updateTrip(t1);
        verify(tripDao).update(t1);
    }

    @Test
    public void testFindAllTrips() {
        tripService.findAllTrips();
        verify(tripDao).findAll();
    }

    @Test
    public void testFindTripsByName() {
        tripService.findTripsByName(tripName);
        verify(tripDao).findByName(tripName);
    }

    @Test
    public void testFindTripWithId() {
        tripService.findTripWithId(tripId);
        verify(tripDao).findById(tripId);
    }

    @Test
    public void testFindTripsBetween() {
        tripService.findTripsBetween(tripStart, tripEnd);
        verify(tripDao).getTripsBetween(tripStart, tripEnd);
    }

    @Test
    public void testFindAllSuitableExcursions() {
        List<Excursion> res = tripService.findAllSuitableExcursions(t5);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(res).isNotNull().containsExactly(e2, e3);
        softly.assertAll();
    }

    @Test
    public void testFindNextTrips() {
        List<Trip> res = tripService.findNextTrips(t2, 2);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(res).isNotNull().containsExactly(t3, t4);

        res = tripService.findNextTrips(t1, 6);
        softly.assertThat(res).isNotNull().containsExactly(t2, t3, t4, t5);
        softly.assertAll();
    }
}