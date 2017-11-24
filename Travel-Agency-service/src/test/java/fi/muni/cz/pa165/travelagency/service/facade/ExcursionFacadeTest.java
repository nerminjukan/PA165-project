package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.service.BeanMappingService;
import fi.muni.cz.pa165.travelagency.service.CustomerService;
import fi.muni.cz.pa165.travelagency.service.ExcursionService;
import fi.muni.cz.pa165.travelagency.service.ReservationService;
import fi.muni.cz.pa165.travelagency.service.TripService;
import org.hibernate.service.spi.ServiceException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    private CustomerService userService;
    
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
    
    
}
