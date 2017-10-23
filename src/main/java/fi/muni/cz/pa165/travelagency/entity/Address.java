package fi.muni.cz.pa165.travelagency.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String country;

    @NotNull
    private String city;

    @NotNull
    private String postalCode;

    @NotNull
    private String houseNumber;

    private String street;

    @NotNull
    @ManyToOne(optional=false)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
