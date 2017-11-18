package fi.muni.cz.pa165.travelagency.service.facade;

import fi.muni.cz.pa165.travelagency.dto.CustomerDTO;
import fi.muni.cz.pa165.travelagency.dto.ReservationDTO;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.facade.CustomerFacade;
import fi.muni.cz.pa165.travelagency.service.BeanMappingService;
import fi.muni.cz.pa165.travelagency.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Customer Facade impl class
 * @author Martin Sevcik <422365>
 */
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void create(CustomerDTO customerDTO) {
        Customer customer = beanMappingService.mapTo(customerDTO, Customer.class);

        if (customer != null) {
            throw new IllegalArgumentException();
        }

        customerService.create(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return beanMappingService.mapTo(customerService.findAll(), CustomerDTO.class);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerService.findById(id);
        return customer == null ? null : beanMappingService.mapTo(customer, CustomerDTO.class);
    }

    @Override
    public void remove(CustomerDTO customerDTO) {
        Customer customer = beanMappingService.mapTo(customerDTO, Customer.class);

        if (customer != null) {
            throw new IllegalArgumentException();
        }

        customerService.remove(customer);
    }

    @Override
    public void update(CustomerDTO customerDTO) {
        Customer customer = beanMappingService.mapTo(customerDTO, Customer.class);

        if (customer != null) {
            throw new IllegalArgumentException();
        }

        customerService.update(customer);
    }

    @Override
    public CustomerDTO findByReservation(ReservationDTO reservationDTO) {
        if (reservationDTO == null) {
            return null;
        }

        Reservation reservation = beanMappingService.mapTo(reservationDTO, Reservation.class);

        Customer customer = customerService.findByReservation(reservation);
        return customer == null ? null : beanMappingService.mapTo(customer, CustomerDTO.class);
    }
}
