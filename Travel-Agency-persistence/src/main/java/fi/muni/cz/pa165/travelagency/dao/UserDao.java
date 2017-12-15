package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.User;
import fi.muni.cz.pa165.travelagency.entity.Reservation;

import java.util.List;

/**
 * Created by martin on 22.10.2017.7
 * @author Martin Sevcik <422365>
 */
public interface UserDao {

    /**
     * Create operation for UserDao
     * @param user User
     */
    void create(User user);

    /**
     * Finds all users
     * @return User's list
     */
    List<User> findAll();

    /**
     * Finds specified user
     * @param id id of user
     * @return User
     */
    User findById(Long id);

    /**
     * Removes User
     * @param user User
     */
    void remove(User user);

    /**
     * Updates User
     * @param user User
     * @return user
     */
    User update(User user);

    /**
     * Finds users based on reservation
     * @param reservation Reservation
     * @return User
     */
    User findByReservation(Reservation reservation);

    /**
     * Finds User by id card number
     * @param idCardNumber id card number
     * @return User
     */
    User findByIdCardNumber(String idCardNumber);

    /**
     * Finds User by email
     * @param email email
     * @return User
     */
    User findByEmail(String email);
}
