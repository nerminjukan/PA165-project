/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */

public class ExcursionDaoImp implements ExcursionDao{

    
    @PersistenceContext
    private EntityManager em;
    
    
    
    @Override
    public void create(Excursion e) {
        em.persist(e);
    }

    @Override
    public Excursion findById(Long id) {
        return em.find(Excursion.class, id);
    }

    @Override
    public void updateDate(Excursion e, Date date) {
        Excursion toUpdate = findById(e.getId());
        toUpdate.setExcursionDate(date);
        em.persist(toUpdate);
    }

    @Override
    public void updateDuration(Excursion e, int duration) {
        Excursion toUpdate = findById(e.getId());
        toUpdate.setDuration(duration);
        em.persist(toUpdate);

    }

    @Override
    public void updateDescription(Excursion e, String description) {
        Excursion toUpdate = findById(e.getId());
        toUpdate.setDescription(description);
        em.persist(toUpdate);
    }

    @Override
    public void updateDestination(Excursion e, String destination) {
        Excursion toUpdate = findById(e.getId());
        toUpdate.setDestination(destination);
        em.persist(toUpdate);
    }

    @Override
    public void updatePrice(Excursion e, BigDecimal price) {
        Excursion toUpdate = findById(e.getId());
        toUpdate.setPrice(price);
        em.persist(toUpdate);
    }
    
    @Override
    public void delete(Excursion e) {
        em.remove(e);
    }
    
}
