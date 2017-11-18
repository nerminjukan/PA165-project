package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.CustomerDTO;

import java.util.List;

/**
 * Customer Facade class
 * @author Martin Sevcik <422365>
 */
public interface CustomerFacade {

    /**
     * Create operation for CustomerDao
     * @param customer Customer
     */
    void create(CustomerDTO customer);

    /**
     * Finds all Customers
     * @return Customer's list
     */
    List<CustomerDTO> findAll();

    /**
     * Finds specified customer
     * @param id id of customer
     * @return Customer
     */
    CustomerDTO findById(Long id);

    /**
     * Removes Customer
     * @param customer Customer
     */
    void remove(CustomerDTO customer);

    /**
     * Updates Customer
     * @param customer Customer
     */
    void update(CustomerDTO customer);

    /**
     * Finds customers based on reservation
     * @param reservation Reservation
     * @return Customer
     */
    CustomerDTO findByReservation(CustomerDTO reservation);
}
