package fi.muni.cz.pa165.travelagency.dao.Impl;

import fi.muni.cz.pa165.travelagency.dao.TripDao;
import fi.muni.cz.pa165.travelagency.entity.Trip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * @author Pavel Kotala, 437164
 */
public class TripDaoImpl implements TripDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Trip trip) {
        em.persist(trip);
    }

    @Override
    public List<Trip> findAll() {
        TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t", Trip.class);
        return query.getResultList();
    }

    @Override
    public List<Trip> findByName(String name) {
        TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t WHERE t.name = :name", Trip.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Trip findById(Long id) {
        return em.find(Trip.class, id);
    }

    @Override
    public void remove(Trip trip) {
        em.remove(trip);
    }

    @Override
    public List<Trip> getTripsBetween(Date start, Date end) {
        TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t WHERE t.dateFrom BETWEEN :start AND :end AND " +
                "t.dateTo BETWEEN :start AND :end", Trip.class);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }
}
