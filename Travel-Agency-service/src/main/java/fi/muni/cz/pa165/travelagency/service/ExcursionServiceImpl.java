package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.ExcursionDao;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.util.List;
import org.dozer.inject.Inject;

/**
 * Excursion Service Implementation for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public class ExcursionServiceImpl implements ExcursionService{
    
    @Inject
    private ExcursionDao excursionDao;

    @Override
    public void create(Excursion excursion) {
        excursionDao.create(excursion);
    }

    @Override
    public Excursion findById(Long id) {
        return excursionDao.findById(id);
    }

    @Override
    public List<Excursion> getAllExcursions() {
        return excursionDao.findAll();
    }

    @Override
    public List<Excursion> findByDestination(String destination) {
        return excursionDao.findByDestination(destination);
    }

    @Override
    public void deleteExcursion(Excursion excursion) {
        excursionDao.delete(excursion);
    }

    @Override
    public void updateExcursion(Excursion excursion) {
        excursionDao.update(excursion);
    }
    
}
