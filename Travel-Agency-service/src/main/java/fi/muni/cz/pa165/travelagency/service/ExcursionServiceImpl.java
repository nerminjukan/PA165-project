package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.ExcursionDao;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.exceptions.TravelAgencyServiceException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Excursion service Implementation for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@Service
public class ExcursionServiceImpl implements ExcursionService{
    
    @Autowired
    private ExcursionDao excursionDao;

    @Override
    public Excursion create(Excursion excursion) {
        try{
            excursionDao.create(excursion);
            return excursion;
        } catch (NullPointerException npe){
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException("Cannot create a new entiy.");
        }
        
    }

    @Override
    public Excursion findById(Long id) {
        try{
            return excursionDao.findById(id);
        } catch(NullPointerException npe){
            throw npe;
        } catch (IllegalArgumentException iax){
            throw new TravelAgencyServiceException("Not a valid key or null");
        }
        
    }

    @Override
    public List<Excursion> getAllExcursions() {
        try{
            return excursionDao.findAll();
        } catch (Exception e){
            throw new TravelAgencyServiceException("Invalid query.", e);
        }
        
    }

    @Override
    public List<Excursion> findByDestination(String destination) {
        try {
            return excursionDao.findByDestination(destination);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public void deleteExcursion(Excursion excursion) {
        try {
            excursionDao.delete(excursion);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public Excursion update(Excursion excursion) {
        try {
            return excursionDao.update(excursion);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public List<Excursion> findByPriceLowerThanOrEqual(Integer price) {
        try {
            List<Excursion> excursionsFound = new ArrayList<>();
            
            List<Excursion> findAll = excursionDao.findAll();
            
            BigDecimal priceBD = new BigDecimal(price);
            int res;
            for (Excursion exc : findAll) {
                res = exc.getPrice().compareTo(priceBD);
                if (res == 0 || res == -1) {
                    excursionsFound.add(exc);
                }
            }
            return excursionsFound;
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException(e);
        }
    }
    
    @Override
    public List<Excursion> findByPriceHigherThanOrEqual(Integer price) {
        try {
            List<Excursion> excursionsFound = new ArrayList<>();
            
            BigDecimal priceBD = new BigDecimal(price);
            int res;
            for (Excursion exc : excursionDao.findAll()) {
                res = exc.getPrice().compareTo(priceBD);
                if (res == 0 || res == 1) {
                    excursionsFound.add(exc);
                }
            }
            return excursionsFound;
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException(e);
        }
    }

    @Override
    public List<Excursion> findByDuration(Integer duration) {
        try {
            List<Excursion> excursionsFound = new ArrayList<>();
            
            for (Excursion exc : excursionDao.findAll()) {
                if (exc.getDuration() == duration) {
                    excursionsFound.add(exc);
                }
            }
            return excursionsFound;
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Exception e){
            throw new TravelAgencyServiceException(e);
        }
    }
    
}
