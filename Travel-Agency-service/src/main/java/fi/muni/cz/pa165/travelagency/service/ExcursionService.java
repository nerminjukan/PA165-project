package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.util.List;

/**
 * @author *CHANGE ME*
 */
public interface ExcursionService {
    
    /**
     * 
     * @param e *CHANGE ME*
     * @return *CHANGE ME*
     */
    Excursion create(Excursion e);
    
    /**
     * 
     * @param id *CHANGE ME*
     * @return *CHANGE ME*
     */
    Excursion findById(Long id);
    
    /**
     * 
     * @return *CHANGE ME*
     */
    List<Excursion> getAllExcursions();
    
    /**
     * 
     * @param destination *CHANGE ME*
     * @return *CHANGE ME*
     */
    List<Excursion> findByDestination(String destination);
    
    /**
     * 
     * @param e *CHANGE ME*
     */
    void deleteExcursion(Excursion e);
    
    /**
     * 
     * @param e *CHANGE ME*
     */
    void updateExcursion(Excursion e);
}
