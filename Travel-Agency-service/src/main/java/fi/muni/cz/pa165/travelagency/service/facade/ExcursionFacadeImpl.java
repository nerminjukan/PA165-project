package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.dto.ExcursionCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.ExcursionDTO;
import fi.muni.cz.pa165.travelagency.dto.ExcursionUpdateDTO;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.facade.ExcursionFacade;
import fi.muni.cz.pa165.travelagency.service.BeanMappingService;
import fi.muni.cz.pa165.travelagency.service.ExcursionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Excursion Facade Implementation for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public class ExcursionFacadeImpl implements ExcursionFacade{
    
    @Autowired
    private ExcursionService excursionService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public Long create(ExcursionCreateDTO excursionDTO) {
        Excursion excursion = beanMappingService.mapTo(excursionDTO, Excursion.class);

        if (excursion != null) {
            throw new IllegalArgumentException();
        }

        excursionService.create(excursion);
        return excursion.getId();

    }

    @Override
    public List<ExcursionDTO> getAllExcursions() {
        return beanMappingService.mapTo(excursionService.getAllExcursions(), ExcursionDTO.class);
    }

    @Override
    public ExcursionDTO getByID(Long excursionId) {
        Excursion excursion = excursionService.findById(excursionId);
        return excursion == null ? null : beanMappingService.mapTo(excursion, ExcursionDTO.class);
    }

    @Override
    public void deleteExcursion(ExcursionDTO excursionDTO) {
        Excursion excursion = beanMappingService.mapTo(excursionDTO, Excursion.class);

        if (excursion != null) {
            throw new IllegalArgumentException();
        }

        excursionService.deleteExcursion(excursion);
    }

    @Override
    public void updateExcursion(ExcursionUpdateDTO excursionUpdate) {
        Excursion excursion = beanMappingService.mapTo(excursionUpdate, Excursion.class);

        if (excursion != null) {
            throw new IllegalArgumentException();
        }

        excursionService.updateExcursion(excursion);
    }
    
}
