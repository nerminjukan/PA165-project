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
import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.service.spi.ServiceException;
import org.testng.annotations.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.verify;
import org.springframework.test.context.ContextConfiguration;
import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

/**
 * Excursion Facade Tests for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class ExcursionFacadeTest {
    
    @Mock
    private BeanMappingService beanMappingService;
    
    @Mock
    private ExcursionService excursionService;
    
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
    private List<Excursion> exHList;
    private List<ExcursionDTO> exHDTOList;
    private List<Excursion> exLList;
    private List<ExcursionDTO> exLDTOList;
    private List<Excursion> exSList;
    private List<ExcursionDTO> exSDTOList;
    
    private Trip trip;
    private TripDTO tripDTO;
    private Set<TripDTO> tripDTOSet;
    
    Calendar calendar =  Calendar.getInstance();
    
    @BeforeMethod
    public void prepareTests(){
        trip = new Trip();
        tripDTOSet = new HashSet();
        tripDTOSet.add(tripDTO);
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
        
        exHList = new ArrayList<>();
        exHList.add(ex2);
        exLList = new ArrayList<>();
        exLList.add(ex1);
        exSList = new ArrayList<>();
        exSList.add(ex2);
        
        exHDTOList = new ArrayList<>();
        exHDTOList.add(exDTO2);
        exLDTOList = new ArrayList<>();
        exLDTOList.add(exDTO1);
        exSDTOList = new ArrayList<>();
        exSDTOList.add(exDTO2);
    }
    
    @Test
    public void createExcursionTest(){
                
        when(beanMappingService.mapTo(exDTO1, Excursion.class)).thenReturn(ex1);
        when(excursionService.create(ex1)).thenReturn(ex1);
        excursionFacade.create(exDTO1);
        verify(excursionService).create(ex1);
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
        excursionFacade.updateExcursion(exDTO);
        verify(excursionService).update(ex1);
    }
    
    @Test
    public void deleteExcursionTest(){
        ex1.setId(1L);
        exDTO1.setId(1L);
        when(beanMappingService.mapTo(exDTO1, Excursion.class)).thenReturn(ex1);
        excursionFacade.deleteExcursion(exDTO1);
        verify(excursionService).deleteExcursion(ex1);
    }
    
    @Test
    public void findExcursionByIdTest(){
        when(excursionService.findById(1l)).thenReturn(ex1);
        when(beanMappingService.mapTo(ex1, ExcursionDTO.class)).thenReturn(exDTO1);
        assertEquals(excursionFacade.getByID(1l), exDTO1);
    }
    
    @Test
    public void getAllExcursionsTest(){
        when(excursionService.getAllExcursions()).thenReturn(Arrays.asList(ex1, ex2));
        when(beanMappingService.mapTo(Matchers.anyCollection(),
                Matchers.eq(ExcursionDTO.class))).thenReturn(exDTOList);
        assertEquals(excursionFacade.getAllExcursions().size(), 2);
    }
    
    @Test
    public void findExcursionByPriceLowerThanOrEqualTest(){
        when(beanMappingService.mapTo(exLList, ExcursionDTO.class)).thenReturn(exLDTOList);
        when(excursionService.findByPriceLowerThanOrEqual(500)).thenReturn(exLList);
        assertThat(excursionFacade.findByPriceLowerThanOrEqual(500)).containsExactly(exDTO1);
    }
    
    @Test
    public void findExcursionByPriceHigherThanOrEqualTest(){
        when(beanMappingService.mapTo(exHList, ExcursionDTO.class)).thenReturn(exHDTOList);
        when(excursionService.findByPriceHigherThanOrEqual(500)).thenReturn(exHList);
        assertThat(excursionFacade.findByPriceHigherThanOrEqual(500)).containsExactly(exDTO2);
    }
    
    @Test
    public void findExcursionByDurationTest(){
        when(beanMappingService.mapTo(exSList, ExcursionDTO.class)).thenReturn(exSDTOList);
        when(excursionService.findByDuration(5)).thenReturn(exSList);
        assertThat(excursionFacade.findByDuration(5)).containsExactly(exDTO2);
    }
}
