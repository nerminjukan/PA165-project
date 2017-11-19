package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.TripCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.TripDTO;

import java.util.Date;
import java.util.List;

/**
 * @author Pavel Kotala, 437164
 */
public interface TripFacade {
    Long createTrip(TripCreateDTO trip);
    void addExcursion(Long tripId, Long excursionId);
    void addAllExcursions(Long tripId, List<Long> excursionIds);
    void removeExcursion(Long tripId, Long excursionId);
    void updateTrip(TripDTO trip);
    void deleteTrip(Long tripId);
    List<TripDTO> getAllTrips();
    List<TripDTO> getTripsByName(String tripName);
    List<TripDTO> getTripsBetween(Date start, Date end);
    TripDTO getTripWithId(Long id);
}
