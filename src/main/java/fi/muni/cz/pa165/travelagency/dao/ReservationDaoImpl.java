package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Reservation;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Reservation> findByCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reservation findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Reservation reservation) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reservation> getReservationsCreatedBetween(Date start, Date end) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
