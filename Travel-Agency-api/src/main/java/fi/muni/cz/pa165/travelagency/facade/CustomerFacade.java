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
     * @param customerDTO CustomerDTO
     */
    void create(CustomerDTO customerDTO);

    /**
     * Finds all Customers
     * @return CustomerDTO's list
     */
    List<CustomerDTO> findAll();

    /**
     * Finds specified customer
     * @param id id of customer
     * @return CustomerDTO
     */
    CustomerDTO findById(Long id);

    /**
     * Removes Customer
     * @param customerDTO CustomerDTO
     */
    void remove(CustomerDTO customerDTO);

    /**
     * Updates Customer
     * @param customerDTO CustomerDTO
     */
    void update(CustomerDTO customerDTO);

    /**
     * Finds customers based on reservation
     * @param reservationDTO ReservationDTO
     * @return CustomerDTO
     */
    CustomerDTO findByReservation(ReservationDTO reservationDTO);

    /**
     * Finds Customer by id card number
     * @param idCardNumber id card number
     * @return CustomerDTO
     */
    CustomerDTO findByIdCardNumber(String idCardNumber);

    /**
     * Finds Customer by email
     * @param email email
     * @return CustomerDTO
     */
    CustomerDTO findByEmail(String email);
}
