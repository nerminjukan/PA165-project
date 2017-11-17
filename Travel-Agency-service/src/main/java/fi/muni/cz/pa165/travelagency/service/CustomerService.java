package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Customer service interface
 * @author Martin Sevcik <422365>
 */
@Service
public interface CustomerService {
    /**
     * Create operation for CustomerDao
     * @param customer Customer
     */
    void create(Customer customer);

    /**
     * Finds all Customers
     * @return Customer's list
     */
    List<Customer> findAll();

    /**
     * Finds specified customer
     * @param id id of customer
     * @return Customer
     */
    Customer findById(Long id);

    /**
     * Removes Customer
     * @param customer Customer
     */
    void remove(Customer customer);

    /**
     * Updates Customer
     * @param customer Customer
     */
    void update(Customer customer);

    /**
     * Finds customers based on reservation
     * @param reservation Reservation
     * @return Customer
     */
    Customer findByReservation(Reservation reservation);
}
