/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.math.BigDecimal;

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
     * The UPDATE Excursion operation.
     * 
     * Updates the Excursion's date information in the database.
     * 
     * @param e Excursion
     * @param date new Excursion date
     * 
     */
    void updateDate(Excursion e, java.util.Date date);
    
    /**
     * The UPDATE Excursion operation.
     * 
     * Updates the Excursion's duration information in the database.
     * 
     * @param e Excursion
     * @param duration new Excursion duration
     * 
     */
    void updateDuration(Excursion e, int duration);
    
    /**
     * The UPDATE Excursion operation.
     * 
     * Updates the Excursion's description information in the database.
     * 
     * @param e Excursion
     * @param description  new Excursion description
     * 
     */
    void updateDescription(Excursion e, String description);
    
    /**
     * The UPDATE Excursion operation.
     * 
     * Updates the Excursion's destination information in the database.
     * 
     * @param e Excursion
     * @param destination new Excursion destination
     * 
     */
    void updateDestination(Excursion e, String destination);
    
    /**
     * The UPDATE Excursion operation.
     * 
     * Updates the Excursion's price information in the database.
     * 
     * @param e Excursion
     * @param price new Excursion price
     * 
     */
    void updatePrice(Excursion e, BigDecimal price);
    
    /**
     * The DELETE Excursion operation.
     * 
     * Deletes the Excursion from the database.
     * 
     * @param e Excursion
     * 
     */
    void delete(Excursion e);
}