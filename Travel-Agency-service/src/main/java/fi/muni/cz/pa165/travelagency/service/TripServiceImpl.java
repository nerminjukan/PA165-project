package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.ExcursionDao;
import fi.muni.cz.pa165.travelagency.dao.TripDao;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.exceptions.TravelAgencyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
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
        try {
            tripDao.create(trip);
        } catch (EntityExistsException e) {
            throw new TravelAgencyServiceException("entity exists", e);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("not an entity", e);
        } catch (TransactionRequiredException e) {
            throw new TravelAgencyServiceException("transaction required", e);
        }
        return trip;
    }

    @Override
    public void addExcursion(Trip trip, Excursion excursion) {
        trip.addExcursion(excursion);
        try {
            tripDao.update(trip);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("not an entity", e);
        } catch (TransactionRequiredException e) {
            throw new TravelAgencyServiceException("transaction required", e);
        }
    }

    @Override
    public void addAllExcursions(Trip trip, Set<Excursion> excursions) {
        trip.addAllExcursions(excursions);
        try {
            tripDao.update(trip);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("not an entity", e);
        } catch (TransactionRequiredException e) {
            throw new TravelAgencyServiceException("transaction required", e);
        }
    }

    @Override
    public void removeExcursion(Trip trip, Excursion excursion) {
        trip.removeExcursion(excursion);
        try {
            tripDao.update(trip);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("not an entity", e);
        } catch (TransactionRequiredException e) {
            throw new TravelAgencyServiceException("transaction required", e);
        }
    }

    @Override
    public void deleteTrip(Trip trip) {
        try {
            tripDao.remove(trip);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("not an entity or is a removed entity", e);
        } catch (TransactionRequiredException e) {
            throw new TravelAgencyServiceException("transaction required", e);
        }
    }

    @Override
    public void updateTrip(Trip trip) {
        try {
            tripDao.update(trip);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("not an entity or is a removed entity", e);
        } catch (TransactionRequiredException e) {
            throw new TravelAgencyServiceException("transaction required", e);
        }
    }

    @Override
    public List<Trip> findAllTrips() {
        try {
            return tripDao.findAll();
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("invalid query", e);
        } catch (Exception e) {
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public List<Trip> findTripsByName(String tripName) {
        try {
            return tripDao.findByName(tripName);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("invalid query", e);
        } catch (Exception e) {
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public List<Trip> findTripsBetween(Date start, Date end) {
        try {
            return tripDao.getTripsBetween(start, end);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("invalid query", e);
        } catch (Exception e) {
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public Trip findTripWithId(Long id) {
        try {
            return tripDao.findById(id);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("invalid key or key is null", e);
        } catch (Exception e) {
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public List<Excursion> findAllSuitableExcursions(Trip trip) {
        List<Excursion> allExcursions;
        try {
            allExcursions = excursionDao.findByDestination(trip.getDestination());
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("invalid query", e);
        } catch (Exception e) {
            throw new TravelAgencyServiceException(e);
        }
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
        List<Trip> allTrips;
        try {
            allTrips = tripDao.getTripsBetween(start, end);
        } catch (IllegalArgumentException e) {
            throw new TravelAgencyServiceException("invalid query", e);
        } catch (Exception e) {
            throw new TravelAgencyServiceException(e);
        }

        Collections.sort(allTrips);
        List<Trip> toRtn = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i >= allTrips.size()) {
                break;
            }

            Trip current = allTrips.get(i);

            if(trip.compareTo(current) >= 0) {
                n++;
                continue;
            }

            toRtn.add(allTrips.get(i));
        }

        return toRtn;
    }
}
