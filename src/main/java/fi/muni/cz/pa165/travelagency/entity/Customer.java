package fi.muni.cz.pa165.travelagency.entity;

import com.sun.istack.internal.NotNull;
import java.util.Date;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    private String surname;

    private String phoneNumber;

    @NotNull
    private String IdCardNumber;

    @NotNull
    private String email;

    @NotNull
    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    @NotNull
    private Date birthDate;

    @OneToMany(mappedBy="customer")
    private Set<Reservation> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNumber() {
        return IdCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        IdCardNumber = idCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> address) {
        this.addresses = addresses;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservation(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
