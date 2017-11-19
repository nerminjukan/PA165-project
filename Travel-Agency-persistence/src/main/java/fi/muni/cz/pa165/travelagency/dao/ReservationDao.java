package fi.muni.cz.pa165.travelagency.dao;

import java.util.Date;
import java.util.List;

import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Trip;

/**
 * An interface that defines a Data access to the {@link Reservation} entity.
 * @author Radoslav Micko <445611>
 */
public interface ReservationDao {
    
    /**
     * Persisting created reservation.
     * 
     * @param   reservation Reservation to be persisted.
     */
    void create(Reservation reservation);
    
    /**
     * Method updates a reservation r in database
     * 
     * @param r reservation to update
     * @return updated reservation
     */
    Reservation update(Reservation r);
    
    /**
     * Get all current persisted reservations.
     * 
     * @return List of Reservations, null if there are no reservations.
     */
    List<Reservation> findAll();
    
    /**
     * Get all reservations for specified customer.
     * 
     * @param   customer Customer to find reservations for.
     * @return  List of Reservations for customer, null if there are no reservations.
     */
    List<Reservation> findByCustomer(Customer customer);
    
    /**
     * Get reservation by spicified id.
     * 
     * @param   id Id of wanted reservation.   
     * @return  Reservation with specific id, null if there is no sich reservation.
     */
    Reservation findById(Long id);
    
    /**
     * Get reservations for specified trip.
     * 
     * @param trip trip to find reservations for
     * @return list of reservation for specified trip
     */
    List<Reservation> findByTrip(Trip trip);
    
    /**
     * Remove specified persisted reservation from database.
     * 
     * @param   reservation                 Specific reservation to be removed.
     * @throws  IllegalArgumentException    if the instance is not an entity 
     *                                      or is a detached entity.
     */
    void remove(Reservation reservation) throws IllegalArgumentException;
    
    /**
     * Get all reservations that have been creaded between specified dates.
     * 
     * @param   start   Date from.
     * @param   end     Date to.
     * @return  List of reservations that meet the condition dates.
     */
    List<Reservation> getReservationsCreatedBetween(Date start, Date end);
}
