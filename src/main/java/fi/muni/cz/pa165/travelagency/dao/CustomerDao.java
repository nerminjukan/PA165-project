package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Customer;

import java.util.Set;

/**
 * Created by martin on 22.10.2017.7
 * @author Martin Sevcik <422365>
 */
public interface CustomerDao {
    public void create(Customer customer);
    public Set<Customer> findAll();
    public Customer findById(Long id);
    public Customer findBySurname(String surname);
    public void remove(Customer customer);
    public void update(Customer customer);
}
