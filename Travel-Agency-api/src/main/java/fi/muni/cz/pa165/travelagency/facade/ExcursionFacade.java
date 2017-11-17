/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.ExcursionCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.ExcursionDTO;
import fi.muni.cz.pa165.travelagency.dto.ExcursionUpdateDTO;
import java.util.List;


/**
 *
 * @author root
 */
public interface ExcursionFacade {
    
    /**
     *
     * @param e *CHANGE ME*
     * @return *CHANGE ME*
     */
    int createExcursion(ExcursionCreateDTO e);
    
    /**
     *
     * @return *CHANGE ME*
     */
    List<ExcursionDTO> getAllExcursions();
    
    /**
     *
     * @param excursion *CHANGE ME*
     * @return *CHANGE ME*
     */
    ExcursionDTO getExcursionByID(Long excursion);
    
    /**
     *
     * @param excursionId *CHANGE ME*
     */
    void deleteExcursion(Long excursionId);
    
    /**
     *
     * @param e *CHANGE ME*
     */
    void updateExcursion(ExcursionUpdateDTO e);
    
}
