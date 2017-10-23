package fi.muni.cz.pa165.travelagency.entity;

import javax.validation.constraints.NotNull;
import com.sun.org.apache.xpath.internal.operations.String;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
@Entity
public class Address {

    /**
     * Id of address
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * Country of address
     */
    @NotNull
    private String country;

    /**
     * City of address
     */
    @NotNull
    private String city;

    /**
     * Postal code of address
     */
    @NotNull
    private String postalCode;

    /**
     * House number of address
     */
    @NotNull
    private String houseNumber;

    /**
     * Street of address
     */
    private String street;

    /**
     * Customer of address
     */
    @NotNull
    @ManyToOne(optional=false)
    private Customer customer;

    /**
     * Basic getter
     * @return Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Basic setter
     * @param id Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Basic getter
     * @return Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Basic setter
     * @param customer Customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Basic getter
     * @return Country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Basic setter
     * @param country Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Basic getter
     * @return City
     */
    public String getCity() {
        return city;
    }

    /**
     * Basic setter
     * @param city City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Basic getter
     * @return Postal Code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Basic setter
     * @param postalCode Postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Basic getter
     * @return House number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Basic setter
     * @param houseNumber House number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Basic getter
     * @return Street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Basic setter
     * @param street Street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Equals method
     * @param o Address object
     * @return True if equal, False otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!country.equals(address.country)) return false;
        if (!city.equals(address.city)) return false;
        if (!postalCode.equals(address.postalCode)) return false;
        if (!houseNumber.equals(address.houseNumber)) return false;
        if (street == null){
            if (address.getStreet() != null) return false;
        }else if (!street.equals(address.getStreet())) return false;
        return customer.equals(address.customer);

    }

    /**
     * Hashcode method
     * @return hash of Address
     */
    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + houseNumber.hashCode();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + customer.hashCode();
        return result;
    }
}
