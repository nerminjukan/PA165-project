package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.dto.ExcursionDTO;
import fi.muni.cz.pa165.travelagency.dto.TripDTO;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.service.BeanMappingService;
import fi.muni.cz.pa165.travelagency.service.UserService;
import fi.muni.cz.pa165.travelagency.service.ExcursionService;
import fi.muni.cz.pa165.travelagency.service.ReservationService;
import fi.muni.cz.pa165.travelagency.service.TripService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.hibernate.service.spi.ServiceException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

/**
 * Excursion Facade Tests for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@RunWith(MockitoJUnitRunner.class)
public class ExcursionFacadeTest {
    
    @Mock
    private BeanMappingService beanMappingService;
    
    @Mock
    private ExcursionService excursonService;
    
    @Mock
    private UserService userService;
    
    @Mock
    private TripService tripService;
    
    @Mock
    ReservationService reservationService;
    
    @InjectMocks
    private ExcursionFacadeImpl excursionFacade = new ExcursionFacadeImpl();
    
    @BeforeClass
    public void setup() throws ServiceException{
        MockitoAnnotations.initMocks(this);
    }
    
    private Excursion ex1;
    private Excursion ex2;
    
    private ExcursionDTO exDTO1;
    private ExcursionDTO exDTO2;
    
    private List<Excursion> exList;
    private List<ExcursionDTO> exDTOList;
    
    private Trip trip;
    private Set<TripDTO> tripDTOSet;
    
    Calendar calendar =  Calendar.getInstance();
    
    @BeforeMethod
    public void prepareTests(){
        calendar.set(2012, 4, 20);
        
        ex1 = new Excursion("castle", "france", 2, calendar.getTime(), BigDecimal.valueOf(250), trip);
        ex2 = new Excursion("lake", "france", 5, calendar.getTime(), BigDecimal.valueOf(1500), trip);
        
        exDTO1 = new ExcursionDTO();
        exDTO1.setId(1l);
        exDTO1.setDescription("france");
        exDTO1.setDestination("castle");
        exDTO1.setDuration(2);
        exDTO1.setExcursionDate(calendar.getTime());
        exDTO1.setPrice(BigDecimal.valueOf(250));
        exDTO1.setTrips(tripDTOSet);
        
        exDTO2 = new ExcursionDTO();
        exDTO2.setId(2l);
        exDTO2.setDescription("france");
        exDTO2.setDestination("lake");
        exDTO2.setDuration(5);
        exDTO2.setExcursionDate(calendar.getTime());
        exDTO2.setPrice(BigDecimal.valueOf(1500));
        exDTO2.setTrips(tripDTOSet);
        
        exList = new ArrayList<>();
        exList.add(ex1);
        exList.add(ex2);
        
        exDTOList = new ArrayList<>();
        exDTOList.add(exDTO1);
        exDTOList.add(exDTO2);
    }
    
    @Test
    public void createExcursionTest(){
        ExcursionDTO exDTO = new ExcursionDTO();
        exDTO.setId(3l);
        exDTO.setDescription("france");
        exDTO.setDestination("cave");
        exDTO.setDuration(4);
        exDTO.setExcursionDate(calendar.getTime());
        exDTO.setPrice(BigDecimal.valueOf(750));
        exDTO.setTrips(tripDTOSet);
        Trip t = new Trip();
        
        when(beanMappingService.mapTo(exDTO, Excursion.class)).thenReturn(ex1);
        when(excursonService.create(ex1)).thenReturn(ex1);
        when(tripService.findTripWithId(t.getId())).thenReturn(t);
        excursionFacade.create(exDTO);
        verify(tripService).addExcursion(t, ex1);
    }
    
    @Test
    public void updateExcursionTest(){
        ExcursionDTO exDTO = new ExcursionDTO();
        exDTO.setId(1l);
        exDTO.setDescription("france");
        exDTO.setDestination("castle");
        exDTO.setDuration(2);
        exDTO.setExcursionDate(calendar.getTime());
        exDTO.setPrice(BigDecimal.valueOf(250));
        exDTO.setTrips(tripDTOSet);
        Trip newTrip = new Trip();
        Trip oldTrip = new Trip();
        
        newTrip.setId(1l);
        oldTrip.setId(2l);
        
        when(tripService.findTripWithId(2l)).thenReturn(oldTrip);
        when(tripService.findTripWithId(1l)).thenReturn(newTrip);
        when(beanMappingService.mapTo(exDTO, Excursion.class)).thenReturn(ex1);
        
        tripService.updateTrip(oldTrip);
        tripService.updateTrip(newTrip);
        verify(tripService).updateTrip(oldTrip);
        verify(tripService).updateTrip(newTrip);
        excursionFacade.updateExcursion(exDTO);
        verify(excursonService).update(ex1);
    }
    
    @Test
    public void deleteExcursionTest(){
        excursionFacade.deleteExcursion(exDTO1);
        verify(excursonService).deleteExcursion(ex1);
    }
    
    @Test
    public void findExcursionByIdTest(){
        when(excursonService.findById(1l)).thenReturn(ex1);
        when(beanMappingService.mapTo(ex1, ExcursionDTO.class)).thenReturn(exDTO1);
        assertEquals(excursionFacade.getByID(1l), exDTO1);
    }
    
    @Test
    public void getAllExcursionsTest(){
        when(excursonService.getAllExcursions()).thenReturn(Arrays.asList(ex1, ex2));
        when(beanMappingService.mapTo(Matchers.anyCollection(),
                Matchers.eq(ExcursionDTO.class))).thenReturn(exDTOList);
        assertEquals(excursionFacade.getAllExcursions().size(), 2);
    }
    
    @Test
    public void findExcursionByPriceLowerThanOrEqualTest(){
        when(excursonService.getAllExcursions()).thenReturn(Arrays.asList(ex1, ex2));
        when(beanMappingService.mapTo(Matchers.anyCollection(),
                Matchers.eq(ExcursionDTO.class))).thenReturn(exDTOList);
        assertEquals(excursionFacade.findByPriceLowerThanOrEqual(500).size(), 1);
    }
    
    @Test
    public void findExcursionByPriceHigherThanOrEqualTest(){
        when(excursonService.getAllExcursions()).thenReturn(Arrays.asList(ex1, ex2));
        when(beanMappingService.mapTo(Matchers.anyCollection(),
                Matchers.eq(ExcursionDTO.class))).thenReturn(exDTOList);
        assertEquals(excursionFacade.findByPriceHigherThanOrEqual(500).size(), 1);
    }
    
    @Test
    public void findExcursionByDestinationTest(){
        when(excursonService.getAllExcursions()).thenReturn(Arrays.asList(ex1, ex2));
        when(beanMappingService.mapTo(Matchers.anyCollection(),
                Matchers.eq(ExcursionDTO.class))).thenReturn(exDTOList);
        assertEquals(excursionFacade.findByDuration(2).size(), 1);
    }
}
