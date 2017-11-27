package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.ReservationCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.ReservationDTO;
import java.util.Date;
import java.util.List;

/**
 * Facade for Reservation entity.
 * 
 * @author Radoslav Micko <445611>
 */
public interface ReservationFacade {
    
    /**
     * Create new reservation.
     * 
     * @param reservation ReservationCreateDTO to be created
     * @return if of created reservation
     */
    Long createReservation(ReservationCreateDTO reservation);
    
    /**
     * Update reservation with new parameters 
     * 
     * @param reservation ReservationDTO to be updated
     */
    void updateReservation(ReservationDTO reservation);
    
    /**
     * Remove reservation with specific id.
     * 
     * @param reservationId id of reservation to be removed
     */
    void removeReservation(Long reservationId);
    
    /**
     * Add excursion to reservation.
     * 
     * @param reservationId id of reservation to add to
     * @param excursionId id of excursion to be added
     */
    void addExcursionToReservation(Long reservationId, Long excursionId);
    
    /**
     * Add set of excursions to reservation.
     * 
     * @param reservationId id of reservation to add to
     * @param excursionsId id of excursion to be added
     */
    void addExcrusionsToReservation(Long reservationId, List<Long> excursionsId);
    
    /**
     * Get all reservations.
     * 
     * @return list of all ReservationDTO
     */
    List<ReservationDTO> findAllReservations();
    
    /**
     * Get reservation with specific id.
     * 
     * @param id id of reservation to be found
     * @return ReservationDTO of specific reservation
     */
    ReservationDTO findReservationById(Long id);
    
    /**
     * Get reservations with specific customer.
     * 
     * @param customerId id of customer
     * @return list of ReservationDTO for specific customer
     */
    List<ReservationDTO> findReservationByCustomer(Long customerId);
    
    /**
     * Get reservations for specific trip.
     * 
     * @param tripId id of trip
     * @return list of ReservationDTO for specific trip
     */
    List<ReservationDTO> findReservationByTrip(Long tripId);
    
    /**
     * Get reservations created between dates.
     * 
     * @param start date from
     * @param end date to
     * @return list of ReservationDTO created between dates
     */
    List<ReservationDTO> findReservationsCreatedBetween(Date start, Date end);
    
    /**
     * Set reservation as PAID.
     * 
     * @param reservationId id of reservation
     */
    void setReservationPaid(Long reservationId);
    
    /**
     * Set reservation as NOTPAID.
     * 
     * @param reservationId id of reservation
     */
    void setReservationNotPaid(Long reservationId);
    
    /**
     * Get all reservations sorted by date of creation.
     * 
     * @return list of sorted ReservationDTO
     */
    List<ReservationDTO> findAllSortedByDate();
    
    /**
     * Get all not paid reservations.
     * 
     * @return list of ReservationDTO that are not paid
     */
    List<ReservationDTO> findAllNotPaid();
    
}
