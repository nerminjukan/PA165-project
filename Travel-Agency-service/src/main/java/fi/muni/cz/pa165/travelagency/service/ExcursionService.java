package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.util.List;

/**
 * Excursion Service for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public interface ExcursionService {
    
    /**
     * Add new Excursion into database.
     * 
     * @param excursion Excursion to be added.
     */
    void create(Excursion excursion);
    
    /**
     * Get Excursion with specific ID.
     * 
     * @param id ID of Excursion to be found.
     * @return Excursion with provided ID.
     */
    Excursion findById(Long id);
    
    /**
     * Get all Excursions from database.
     * 
     * @return List of Excursions.
     */
    List<Excursion> getAllExcursions();
    
    /**
     * Get Excursion with specific destination.
     * 
     * @param destination Destination of Excursion to be found.
     * @return List of Excursions with specific destination.
     */
    List<Excursion> findByDestination(String destination);
    
    /**
     * Remove Excursion from database.
     * 
     * @param excursion Excursion to be removed.
     */
    void deleteExcursion(Excursion excursion);
    
    /**
     * Update Excursion in database.
     * 
     * @param excursion Excursion to be updated.
     */
    void updateExcursion(Excursion excursion);
}
