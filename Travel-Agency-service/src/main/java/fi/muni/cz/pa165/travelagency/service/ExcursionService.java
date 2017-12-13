package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Excursion service for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@Service
public interface ExcursionService {
    
    /**
     * Add new Excursion into database.
     * 
     * @param excursion Excursion to be added.
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return Excursion that is created.
     */
    Excursion create(Excursion excursion);
    
    /**
     * Get Excursion with specific ID.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param id ID of Excursion to be found.
     * @return Excursion with provided ID.
     */
    Excursion findById(Long id);
    
    /**
     * Get all Excursions from database.
     * 
     * @throws TravelAgencyServiceException if some error occurs
     * @return List of Excursions.
     */
    List<Excursion> getAllExcursions();
    
    /**
     * Get Excursion with specific destination.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param destination Destination of Excursion to be found.
     * @return List of Excursions with specific destination.
     */
    List<Excursion> findByDestination(String destination);
    
    /**
     * Remove Excursion from database.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param excursion Excursion to be removed.
     */
    void deleteExcursion(Excursion excursion);
    
    /**
     * Update Excursion in database.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param excursion Excursion to be updated.
     * @return Excursion that is updated.
     */
    Excursion update(Excursion excursion);
    
    /**
     * Find Excursions in database whitch prices are lower than or equal to the argument.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param price Price value to be compared to.
     * @return Excursions list that fits the criteria.
     */
    List<Excursion> findByPriceLowerThanOrEqual(Integer price);
    
    /**
     * Find Excursions in database whitch prices are higher than or equal to the argument.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param price Price value to be compared to.
     * @return Excursions list that fits the criteria.
     */
    List<Excursion> findByPriceHigherThanOrEqual(Integer price);
    
    /**
     * Find Excursions in database whitch duration is equal to the argument.
     * 
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param duration Duration value to be compared to.
     * @return Excursions list that fits the criteria.
     */    
    List<Excursion> findByDuration(Integer duration);

}
