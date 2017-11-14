package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.PersistenceSampleApplicationContext;
import fi.muni.cz.pa165.travelagency.dao.Impl.ExcursionDaoImpl;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Pavel Kotala, 437164
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ExcursionDaoImplTest extends AbstractTestNGSpringContextTests {
    private Excursion castle;
    private Excursion beach;
    private Excursion hike;
    private Excursion mountain;
    private Excursion swim;

    @Autowired
    private ExcursionDao excursionDao;

    @Autowired
    private TripDao tripDao;

    @BeforeMethod
    public void init() {
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2012, 4, 20);
        Trip europe = new Trip();
        europe.setName("europe");
        Trip world = new Trip();
        world.setName("world");
        castle = new Excursion("castle", "france", 2, calendar.getTime(), BigDecimal.valueOf(1999), europe);
        calendar.set(1999, 11, 31);
        beach = new Excursion("beach", "turkey", 4, calendar.getTime(), BigDecimal.valueOf(99.9999), europe, world);
        calendar.set(2099, 0, 30);
        hike = new Excursion("hike", "italy", 8, calendar.getTime(), BigDecimal.valueOf(100), europe);
        calendar.set(1222, 3, 3);
        mountain = new Excursion("mountain", "india", 10, calendar.getTime(), BigDecimal.valueOf(4232), world);
        calendar.set(1111, 1, 1);
        swim = new Excursion("swim", "greece", 1, calendar.getTime(), BigDecimal.valueOf(1));

        tripDao.create(europe);
        tripDao.create(world);

        excursionDao.create(castle);
        excursionDao.create(beach);
        excursionDao.create(hike);
        excursionDao.create(mountain);
        excursionDao.create(swim);
    }

    @Test
    public void findAllTest() {
        List<Excursion> all = excursionDao.findAll();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(all.size()).isEqualTo(5);

        softly.assertThat(all).contains(castle);
        softly.assertThat(all).contains(beach);
        softly.assertThat(all).contains(hike);
        softly.assertThat(all).contains(mountain);
        softly.assertThat(all).contains(swim);

        softly.assertAll();
    }

    @Test
    public void deleteTest() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(excursionDao.findById(hike.getId())).isNotNull();
        excursionDao.delete(hike);
        softly.assertThat(excursionDao.findById(hike.getId())).isNull();

        softly.assertAll();
    }

    @Test
    public void findTripsTest() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(excursionDao.findById(beach.getId())).isNotNull().isEqualToComparingFieldByFieldRecursively(beach);
        softly.assertThat(excursionDao.findById(hike.getId())).isNotNull().isEqualToComparingFieldByFieldRecursively(hike);
        softly.assertThat(excursionDao.findById(swim.getId())).isNotNull().isEqualToComparingFieldByFieldRecursively(swim);
        softly.assertThat(excursionDao.findById(mountain.getId())).isNotNull().isEqualToComparingFieldByFieldRecursively(mountain);
        softly.assertThat(excursionDao.findById(castle.getId())).isNotNull().isEqualToComparingFieldByFieldRecursively(castle);

        softly.assertAll();
    }

    @Test
    public void findByDestinationTest() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(excursionDao.findByDestination("turkey")).isNotNull().containsExactly(beach);
        softly.assertThat(excursionDao.findByDestination("turke")).isNotNull().isEmpty();
        softly.assertThat(excursionDao.findByDestination("adswqw")).isNotNull().isEmpty();
        softly.assertThat(excursionDao.findByDestination("france")).isNotNull().containsExactly(castle);

        softly.assertAll();
    }
}
