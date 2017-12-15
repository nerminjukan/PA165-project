package fi.muni.cz.pa165.travelagency.dao.Impl;

import fi.muni.cz.pa165.travelagency.dao.UserDao;
import fi.muni.cz.pa165.travelagency.entity.User;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return em.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void remove(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public User update(User user) {
        return em.merge(user);
    }

    @Override
    public User findByReservation(Reservation reservation){
        if (reservation == null) {
            throw new IllegalArgumentException("reservation is null");
        }

        try {
            return em.createQuery("select u from User u join u.reservations r" +
                    " where r.id = :reservationId", User.class)
                    .setParameter("reservationId", reservation.getId()).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User findByIdCardNumber(String idCardNumber) {
        if (idCardNumber == null || idCardNumber.isEmpty()) {
            throw new IllegalArgumentException("idCardNumber is null or empty");
        }

        try{
            return em.createQuery("select u from User u where u.idCardNumber = :idCardNumber", User.class)
                    .setParameter("idCardNumber", idCardNumber).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("email is null or empty");
        }

        try {
            return em.createQuery("select u from User u where u.email = :email", User.class)
                    .setParameter("email", email).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
