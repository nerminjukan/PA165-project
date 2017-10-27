package fi.muni.cz.pa165.travelagency.dao.Impl;

import fi.muni.cz.pa165.travelagency.dao.ExcursionDao;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 * An implementation of the Excursion interface.
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@Repository
public class ExcursionDaoImpl implements ExcursionDao{

    
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
    public void delete(Excursion e) {
        em.remove(e);
    }

    @Override
    public List<Excursion> findByDestination(String destination) {
        TypedQuery<Excursion> query = em.createQuery("Select e from Excursion e "
                + "where e.destination = :destinationName",
                Excursion.class);
        query.setParameter("destinationName", destination);
        return query.getResultList();
    }

    @Override
    public List<Excursion> findAll() {
        TypedQuery<Excursion> query = em.createQuery("Select e from Excursion e",
                Excursion.class);
        return query.getResultList();
    }
    
}
