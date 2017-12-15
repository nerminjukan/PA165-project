package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.User;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * User service interface
 * @author Martin Sevcik <422365>
 */
@Service
public interface UserService {
    /**
     * Create operation for UserDao
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @param user User
     * @param password unencrypted password
     */
    void registerUser(User user, String password);

    /**
     * Finds all Users
     * @throws TravelAgencyServiceException if some error occurs
     * @return User's list
     */
    List<User> findAll();

    /**
     * Finds specified user
     * @param id id of user
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return User
     */
    User findById(Long id);

    /**
     * Removes User
     * @param user User
     */
    void removeUser(User user);

    /**
     * Updates User
     * @param user User
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return user
     */
    User updateUser(User user);

    /**
     * Finds users based on reservation
     * @param reservation Reservation
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return User
     */
    User findByReservation(Reservation reservation);

    /**
     * Finds User by id card number
     * @param idCardNumber id card number
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return User
     */
    User findByIdCardNumber(String idCardNumber);

    /**
     * Finds User by email
     * @param email email
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return User
     */
    User findByEmail(String email);

    /**
     * Sums all users expenses
     * @param user User
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return total expenses
     */
    BigDecimal getTotalPriceUsersReservations(User user);

    /**
     * Changes user on reservation
     * @param user User
     * @param reservation Reservation
     * @throws NullPointerException when NullPointerException occurs
     * @throws TravelAgencyServiceException if some error occurs
     * @return User
     */
    User changeUserOnReservation(User user, Reservation reservation);

    /**
     * Tries to authenticate user
     * @param user user
     * @param password password hash
     * @return true if user is authenticated, false otherwise
     */
    boolean authenticate(User user, String password);

    /**
     * Determines whether user is admin
     * @param user user
     * @return true if user is admin, false otherwise
     */
    boolean isAdmin(User user);
}
