package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.util.List;

/**
 * The interface for the Excursion entity.
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */

public interface ExcursionDao {
       
    /**
     * The CREATE Excursion operation.
     * 
     * Persists the given Excursion to the database
     * 
     * @param e Excursion
     * 
     */
    void create(Excursion e);
    
    /**
     * The READ Excursion operation.
     * 
     * Finds the given Excursion from the database and returns it,
     * alowing the user to acces it's information.
     * 
     * @param id Excursion id
     * @return Excursion
     * 
     */
    Excursion findById(Long id);
    
    /**
     * The READ Excursion operation.
     * 
     * Finds the Excursions from the database based on the destination parameter
     * and returns them as a List.
     * 
     * @param destination Excursion destination
     * @return List<\Excursion>
     * 
     */
    List<Excursion> findByDestination(String destination);
    
    /**
     * The DELETE Excursion operation.
     * 
     * Deletes the Excursion from the database.
     * 
     * @param e Excursion
     * 
     */
    void delete(Excursion e);
    
    /**
     * The READ Excursion operation.
     * 
     * Finds all Excursions from the database and returns them
     * as a List.
     * 
     * @return List<\Excursion>
     * 
     */
    List<Excursion> findAll();
}