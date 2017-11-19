package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.CustomerDao;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import org.dozer.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomerService implementation
 * @author Martin Sevcik <422365>
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private CustomerDao customerDao;

    @Override
    public void create(Customer customer) {
        customerDao.create(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public void remove(Customer customer) {
        customerDao.remove(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer findByReservation(Reservation reservation) {
        return customerDao.findByReservation(reservation);
    }

    @Override
    public Customer findByIdCardNumber(String idCardNumber) {
        return customerDao.findByIdCardNumber(idCardNumber);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerDao.findByEmail(email);
    }
}
