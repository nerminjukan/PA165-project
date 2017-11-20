package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author *CHANGE ME*
 */
@Service
public interface TripService {
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     * @return *CHANGE ME*
     */
    Trip createTrip(Trip trip);
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     * @param excursion *CHANGE ME*
     */
    void addExcursion(Trip trip, Excursion excursion);
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     * @param excursions *CHANGE ME*
     */
    void addAllExcursions(Trip trip, List<Excursion> excursions);
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     * @param excursion *CHANGE ME*
     */
    void removeExcursion(Trip trip, Excursion excursion);
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     * @return *CHANGE ME*
     */
    Trip updateTrip(Trip trip);
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     */
    void deleteTrip(Trip trip);
    
    /**
     * *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<Trip> getAllTrips();
    
    /**
     * *CHANGE ME*
     * @param tripName *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<Trip> getTripsByName(String tripName);
    
    /**
     * *CHANGE ME*
     * @param start *CHANGE ME*
     * @param end *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<Trip> getTripsBetween(Date start, Date end);
    
    /**
     * *CHANGE ME*
     * @param id *CHANGE ME*
     * @return *CHANGE ME*
     */
    Trip getTripWithId(Long id);
}
