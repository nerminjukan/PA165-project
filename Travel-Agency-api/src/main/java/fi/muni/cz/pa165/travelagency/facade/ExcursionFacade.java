package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.ExcursionCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.ExcursionDTO;
import fi.muni.cz.pa165.travelagency.dto.ExcursionUpdateDTO;
import java.util.List;


/**
 * Interface for Excursion facade for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public interface ExcursionFacade {
    
    /**
     * Create new Excursion.
     *
     * @param excursion ExcursionCreateDTO of new Excursion.
     * @return ID of newly created Excursion.
     */
    Long create(ExcursionCreateDTO excursion);
    
    /**
     * Get all Excursion.
     *
     * @return List of all ExcursionDTOs.
     */
    List<ExcursionDTO> getAllExcursions();
    
    /**
     * Get Excursion by specified ID.
     *
     * @param excursionId ID of requested Excursion.
     * @return ExcursionDTO with requested ID.
     */
    ExcursionDTO getByID(Long excursionId);
    
    /**
     * Delete Excursion with specified ID.
     *
     * @param excursionDTO ID of Excursion which should be removed.
     */
    void deleteExcursion(ExcursionDTO excursionDTO);
    
    /**
     * Update Excursion.
     *
     * @param excursionUpdate DTO of updated Excursion.
     */
    void updateExcursion(ExcursionUpdateDTO excursionUpdate);
    
}
