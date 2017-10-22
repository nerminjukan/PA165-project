package fi.muni.cz.pa165.travelagency.dao.Impl;

import fi.muni.cz.pa165.travelagency.dao.CustomerDao;
import fi.muni.cz.pa165.travelagency.entity.Customer;

import java.util.Set;

/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void create(Customer customer) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Set<Customer> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Customer findById(Long id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Customer findBySurname(String surname) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void remove(Customer customer) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void update(Customer customer) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
