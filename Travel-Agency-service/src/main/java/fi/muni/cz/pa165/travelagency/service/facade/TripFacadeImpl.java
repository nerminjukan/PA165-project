package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.dto.ExcursionDTO;
import fi.muni.cz.pa165.travelagency.dto.TripCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.TripDTO;
import fi.muni.cz.pa165.travelagency.facade.TripFacade;
import fi.muni.cz.pa165.travelagency.service.BeanMappingService;
import fi.muni.cz.pa165.travelagency.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TripFacadeImpl implements TripFacade {

    @Autowired
    private TripService tripService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public Long createTrip(TripCreateDTO trip) {
        return null;
    }

    @Override
    public void addExcursion(Long tripId, Long excursionId) {

    }

    @Override
    public void addAllExcursions(Long tripId, List<Long> excursionIds) {

    }

    @Override
    public void removeExcursion(Long tripId, Long excursionId) {

    }

    @Override
    public void updateTrip(TripDTO trip) {

    }

    @Override
    public void deleteTrip(Long tripId) {

    }

    @Override
    public List<TripDTO> getAllTrips() {
        return null;
    }

    @Override
    public List<TripDTO> getTripsByName(String tripName) {
        return null;
    }

    @Override
    public List<TripDTO> getTripsBetween(Date start, Date end) {
        return null;
    }

    @Override
    public TripDTO getTripWithId(Long id) {
        return null;
    }

    @Override
    public List<ExcursionDTO> getAllSuitableExcursions(Long tripId) {
        return null;
    }

    @Override
    public List<TripDTO> getNextTrips(Long tripId, int n) {
        return null;
    }
}
