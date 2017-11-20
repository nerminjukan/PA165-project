package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.TripCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.TripDTO;

import java.util.Date;
import java.util.List;

/**
 * @author Pavel Kotala, 437164
 */
public interface TripFacade {
    
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     * @return *CHANGE ME*
     */
    Long createTrip(TripCreateDTO trip);
    
    /**
     * *CHANGE ME*
     * @param tripId *CHANGE ME*
     * @param excursionId *CHANGE ME*
     */
    void addExcursion(Long tripId, Long excursionId);
    
    /**
     * *CHANGE ME*
     * @param tripId *CHANGE ME*
     * @param excursionIds *CHANGE ME*
     */
    void addAllExcursions(Long tripId, List<Long> excursionIds);
    
    /**
     * *CHANGE ME*
     * @param tripId *CHANGE ME*
     * @param excursionId *CHANGE ME*
     */
    void removeExcursion(Long tripId, Long excursionId);
    
    /**
     * *CHANGE ME*
     * @param trip *CHANGE ME*
     */
    void updateTrip(TripDTO trip);
    
    /**
     * *CHANGE ME*
     * @param tripId *CHANGE ME*
     */
    void deleteTrip(Long tripId);
    
    /**
     * *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<TripDTO> getAllTrips();
    
    /**
     * *CHANGE ME*
     * @param tripName *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<TripDTO> getTripsByName(String tripName);
    
    /**
     * *CHANGE ME*
     * @param start *CHANGE ME*
     * @param end *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<TripDTO> getTripsBetween(Date start, Date end);
    
    /**
     * *CHANGE ME*
     * @param id *CHANGE ME*
     * @return *CHANGE ME*
     */
    TripDTO getTripWithId(Long id);
}
