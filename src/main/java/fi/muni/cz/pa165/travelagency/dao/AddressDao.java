package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Address;
import fi.muni.cz.pa165.travelagency.entity.Customer;

import java.util.List;

/**
 * Created by martin on 23.10.2017.
 * @author Martin Sevcik <422365>
 */
public interface AddressDao {

    /**
     * Create operation for AddressDao
     * @param address Address
     */
    void create(Address address);

    /**
     * Updates address
     * @param address Address
     */
    void update(Address address);

    /**
     * Removes Address
     * @param address Address
     */
    void remove(Address address);

    /**
     * Finds all Addresses
     * @return Address list
     */
    List<Address> findAll();

    /**
     * Finds all addresses specified by customer
     * @param customer Customer
     * @return Address list
     */
    List<Address> findAllByCustomer(Customer customer);
}
