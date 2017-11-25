package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.ExcursionDao;
import fi.muni.cz.pa165.travelagency.dao.TripDao;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.exceptions.TravelAgencyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel Kotala
 */
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripDao tripDao;

    @Autowired
    private ExcursionDao excursionDao;

    @Override
    public Trip createTrip(Trip trip) {
        tripDao.create(trip);
        return trip;
    }

    @Override
    public void addExcursion(Trip trip, Excursion excursion) {
        trip.addExcursion(excursion);
    }

    @Override
    public void addAllExcursions(Trip trip, Set<Excursion> excursions) {
        trip.addAllExcursions(excursions);
    }

    @Override
    public void removeExcursion(Trip trip, Excursion excursion) {
        trip.removeExcursion(excursion);
    }

    @Override
    public void deleteTrip(Trip trip) {
        tripDao.remove(trip);
    }

    @Override
    public void updateTrip(Trip trip) {
        tripDao.update(trip);
    }

    @Override
    public List<Trip> findAllTrips() {
        return tripDao.findAll();
    }

    @Override
    public List<Trip> findTripsByName(String tripName) {
        return tripDao.findByName(tripName);
    }

    @Override
    public List<Trip> findTripsBetween(Date start, Date end) {
        return tripDao.getTripsBetween(start, end);
    }

    @Override
    public Trip findTripWithId(Long id) {
        return tripDao.findById(id);
    }

    @Override
    public List<Excursion> findAllSuitableExcursions(Trip trip) {
        List<Excursion> allExcursions = excursionDao.findByDestination(trip.getDestination());
        List<Excursion> suitable = new ArrayList<>();
        for(Excursion ex : allExcursions) {
            if(ex.getExcursionDate().compareTo(trip.getDateFrom()) >= 0 &&
                    ex.getExcursionDate().compareTo(trip.getDateTo()) <= 0) {
                suitable.add(ex);
            }
        }
        return suitable;
    }

    @Override
    public List<Trip> findNextTrips(Trip trip, int n) {
        if(n <= 0) {
            throw new TravelAgencyServiceException("number of trips to return must be greater than zero");
        }

        Date start = trip.getDateFrom();
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.MONTH, 1);
        Date end = cal.getTime();
        List<Trip> allTrips = tripDao.getTripsBetween(start, end);

        Collections.sort(allTrips);
        List<Trip> toRtn = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            toRtn.add(allTrips.get(i));
        }

        return toRtn;
    }
}
