package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.dto.ReservationCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.ReservationDTO;
import fi.muni.cz.pa165.travelagency.facade.ReservationFacade;
import fi.muni.cz.pa165.travelagency.service.BeanMappingService;
import fi.muni.cz.pa165.travelagency.service.CustomerService;
import fi.muni.cz.pa165.travelagency.service.ExcursionService;
import fi.muni.cz.pa165.travelagency.service.ReservationService;
import fi.muni.cz.pa165.travelagency.service.TripService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Radoslav Micko <445611>
 */
@Service
@Transactional
public class ReservationFacadeImpl implements ReservationFacade {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TripService tripService;

    @Autowired
    private ExcursionService excursionService;
    
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Override
    public Long createReservation(ReservationCreateDTO reservation) {
        //Reservation mappedReservation = beanMappingService.mapTo(reservation, Reservation.class);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateReservation(ReservationDTO reservation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeReservation(Long reservationId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addExcursionToReservation(Long reservationId, Long excursionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addExcrusionsToReservation(Long reservationId, List<Long> excursionsId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ReservationDTO> findAllReservations() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ReservationDTO findReservationById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ReservationDTO> findReservationByCustomer(Long customerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ReservationDTO> findReservationByTrip(Long tripId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ReservationDTO getReservationTotalPrice(Long reservationId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ReservationDTO> getReservationsCreatedBetween(Date start, Date end) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setReservationPaid(Long reservationId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setReservationNotPaid(Long reservationId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
