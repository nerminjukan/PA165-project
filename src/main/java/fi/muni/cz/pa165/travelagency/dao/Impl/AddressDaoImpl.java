package fi.muni.cz.pa165.travelagency.dao.Impl;

import fi.muni.cz.pa165.travelagency.dao.AddressDao;
import fi.muni.cz.pa165.travelagency.entity.Address;
import fi.muni.cz.pa165.travelagency.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by martin on 23.10.2017.
 * @author Martin Sevcik <422365>
 */
public class AddressDaoImpl implements AddressDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Address address) {
        em.persist(address);
    }

    @Override
    public void update(Address address) {
        em.merge(address);
    }

    @Override
    public void remove(Address address) {
        em.remove(address);
    }

    @Override
    public List<Address> findAll() {
        return em.createQuery("select a from Address a", Address.class).getResultList();
    }

    @Override
    public List<Address> findAllByCustomer(Customer customer) {
        return em.createQuery("select a from Address a where a.customer = :customerId", Address.class)
                .setParameter("customerId", customer.getId()).getResultList();
    }
}
