package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Address;
import fi.muni.cz.pa165.travelagency.entity.Customer;

import java.util.List;

/**
 * Created by martin on 23.10.2017.
 */
public interface AddressDao {
    public void create(Address address);
    public void update(Address address);
    public void remove(Address address);
    public List<Address> findAll();
    public List<Address> findAllByCustomer(Customer customer);
}
