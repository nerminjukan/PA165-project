package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Radoslav Micko <445611>
 */
@Service
public interface ReservationService {
    
    /**
     * Add new reservation into database.
     * Throws TravelAgencyServiceException when there is no 
     * more free slots for trip.
     * 
     * @param reservation reservation to be added
     * @return added reservation
     */
    Reservation createReservation(Reservation reservation);
    
    /**
     * Update reservation in database.
     * 
     * @param reservation reservation to be updated
     * @return updated reservation
     */
    Reservation updateReservation(Reservation reservation);
    
    /**
     * Remove reservation from database.
     * 
     * @param reservation reservation to be removed
     */
    void removeReservation(Reservation reservation);
    
    /**
     * Adding excursion to existing reservation.
     * Throws TravelAgencyServiceException when reserved trip 
     * doesn't contains such excursion.
     * 
     * @param reservation reservation to add to
     * @param excursion excursion to be added to reservation
     */
    void addExcursionToReservation(Reservation reservation, Excursion excursion);
    
    /**
     * Add excursions to existing reservation.
     * Throws TravelAgencyServiceException when reserved trip doesn't 
     * contains one of excrusions.
     * 
     * @param reservation reservation to add to
     * @param excursions list of excursions to be added
     */
    void addExcrusionsToReservation(Reservation reservation, List<Excursion> excursions);
    
    /**
     * Get all reservations from database.
     * 
     * @return list of all reservations
     */
    List<Reservation> findAll();
    
    /**
     * Get all reservations sorted by date of creation.
     * 
     * @return list of sorted reservations.
     */
    List<Reservation> findAllSortedByDate();
    
    /**
     * Get all not paid reservations.
     * 
     * @return list of all not paid reservations.
     */
    List<Reservation> findAllNotPaid();
    
    /**
     * Get reservation by id.
     * 
     * @param id id to find reservation for
     * @return reservations with specific id
     */
    Reservation findById(Long id);
    
    /**
     * Get list of reservations for customer.
     * 
     * @param customer customr to find reservations for
     * @return list of reservations for specific customer
     */
    List<Reservation> findByCustomer(Customer customer);
    
    /**
     * Get list of reservations for trip.
     * 
     * @param trip trip to find reservations for
     * @return list of reservations for specific trip
     */
    List<Reservation> findByTrip(Trip trip);
    
    /**
     * Get total price for reservation.
     * 
     * @param reservation reservation to get price for
     * @return price of reservation
     */
    BigDecimal getTotalPrice(Reservation reservation);
    
    /**
     * Get reservations created between dates.
     * Throws TravelAgencyServiceException when start date is after end.
     * 
     * @param start date from
     * @param end date to
     * @return list of reservations created between specific dates
     */
    List<Reservation> getReservationsCreatedBetween(Date start, Date end);
    
    /**
     * Set paymentState for reservation to PAID.
     * 
     * @param reservation reservation to set paymentState for
     */
    void setPaidState(Reservation reservation);
    
    /**
     * Set paymentState for reservation to NOTPAID.
     * 
     * @param reservation reservation to set paymentState for
     */
    void setNotPaidState(Reservation reservation);
    
}
