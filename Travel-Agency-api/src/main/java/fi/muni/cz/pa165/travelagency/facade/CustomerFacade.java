package fi.muni.cz.pa165.travelagency.facade;

import fi.muni.cz.pa165.travelagency.dto.CustomerDTO;
import fi.muni.cz.pa165.travelagency.dto.ReservationDTO;

import java.util.List;

/**
 * Customer Facade class
 * @author Martin Sevcik <422365>
 */
public interface CustomerFacade {

    /**
     * Create operation for CustomerDao
     * @param customerDTO Customer
     */
    void create(CustomerDTO customerDTO);

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
     * @param customerDTO Customer
     */
    void remove(CustomerDTO customerDTO);

    /**
     * Updates Customer
     * @param customerDTO Customer
     */
    void update(CustomerDTO customerDTO);

    /**
     * Finds customers based on reservation
     * @param reservationDTO ReservationDTO
     * @return Customer
     */
    CustomerDTO findByReservation(ReservationDTO reservationDTO);
}
