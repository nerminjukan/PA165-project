package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.dto.CustomerDTO;
import fi.muni.cz.pa165.travelagency.facade.CustomerFacade;
import fi.muni.cz.pa165.travelagency.service.CustomerService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Customer Facade impl class
 * @author Martin Sevcik <422365>
 */
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;


    @Override
    public void create(CustomerDTO customer) {
        throw new NotYetImplementedException();
    }

    @Override
    public List<CustomerDTO> findAll() {
        throw new NotYetImplementedException();
    }

    @Override
    public CustomerDTO findById(Long id) {
        throw new NotYetImplementedException();
    }

    @Override
    public void remove(CustomerDTO customer) {
        throw new NotYetImplementedException();
    }

    @Override
    public void update(CustomerDTO customer) {
        throw new NotYetImplementedException();
    }

    @Override
    public CustomerDTO findByReservation(CustomerDTO reservation) {
        throw new NotYetImplementedException();
    }
}
