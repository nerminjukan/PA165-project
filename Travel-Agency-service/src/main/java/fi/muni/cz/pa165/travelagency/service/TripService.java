package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;

import java.util.Date;
import java.util.List;

public interface TripService {
    Trip createTrip(Trip trip);
    void addExcursion(Trip trip, Excursion excursion);
    void addAllExcursions(Trip trip, List<Excursion> excursions);
    void removeExcursion(Trip trip, Excursion excursion);
    Trip updateTrip(Trip trip);
    void deleteTrip(Trip trip);
    List<Trip> getAllTrips();
    List<Trip> getTripsByName(String tripName);
    List<Trip> getTripsBetween(Date start, Date end);
    Trip getTripWithId(Long id);
}
