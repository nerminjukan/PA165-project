package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Reservation;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the {@link ReservationDao}. 
 * @author Radoslav Micko <445611>
 */
@Repository
public class ReservationDaoImpl implements ReservationDao {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void create(Reservation reservation) {
        em.persist(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        TypedQuery<Reservation> query = em.createQuery("SELECT q FROM Reservation q",
                Reservation.class);
        return query.getResultList();
    }

    @Override
    public List<Reservation> findByCustomer(Customer customer) {
        TypedQuery<Reservation> query = em.createQuery("Select o from Reservation o "
                + "where o.customer = :customerid",
                Reservation.class);
        query.setParameter("customerid", customer);
        return query.getResultList();
    }

    @Override
    public Reservation findById(Long id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public void remove(Reservation reservation) throws IllegalArgumentException {
        em.remove(reservation);
    }

    @Override
    public List<Reservation> getReservationsCreatedBetween(Date start, Date end) {
        TypedQuery<Reservation> query = em.createQuery("SELECT o FROM Reservation o "
                + "WHERE o.created BETWEEN :startDate AND :endDate ",Reservation.class);
        query.setParameter("startDate", start);
        query.setParameter("endDate", end);
        return query.getResultList();
    }
}
