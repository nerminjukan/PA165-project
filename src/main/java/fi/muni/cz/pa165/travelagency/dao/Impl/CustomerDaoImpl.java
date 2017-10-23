package fi.muni.cz.pa165.travelagency.dao.Impl;

import fi.muni.cz.pa165.travelagency.dao.CustomerDao;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Customer customer) {
        em.persist(customer);
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return em.createQuery("select c from Customer c where c.id = :id", Customer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void remove(Customer customer) {
        em.remove(customer);
    }

    @Override
    public void update(Customer customer) {
        em.merge(customer);
    }

    @Override
    public Customer findByReservation(Reservation reservation){
        return em.createQuery("select c from Customer c join Reservation r on r.customer = c.id" +
                " where r.id = :reservationId", Customer.class)
                .setParameter("reservationId", reservation.getId()).getSingleResult();
    }
}
