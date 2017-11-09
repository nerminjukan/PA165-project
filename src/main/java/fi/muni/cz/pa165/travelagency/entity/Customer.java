package fi.muni.cz.pa165.travelagency.entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.util.Collections;

/**
 * Created by martin on 22.10.2017.
 * @author Martin Sevcik <422365>
 */
@Entity
public class Customer implements Serializable {

    /**
     * Non-parametric constructor
     */
    public Customer(){
        this.reservations = new HashSet<>();
    }

    /**
     * Id of customer
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * First name of customer
     */
    private String name;

    /**
     * Surname of customer
     */
    @NotNull
    private String surname;

    /**
     * PhoneNumber of customer
     */
    private String phoneNumber;

    /**
     * IdCard number of customer
     */
    @NotNull
    @Column(nullable = false, unique=true)
    private String idCardNumber;

    /**
     * Email of customer
     */
    @NotNull
    @Column(nullable = false, unique=true)
    private String email;

    /**
     * Birth date of customer
     */
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * Reservations of customer
     */
    @OneToMany(mappedBy="customer")
    private Set<Reservation> reservations;

    /**
     * Basic getter
     * @return Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Basic setter
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Basic getter
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Basic setter
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Basic getter
     * @return Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Basic setter
     * @param surname surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Basic getter
     * @return PhoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Basic setter
     * @param phoneNumber phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Basic getter
     * @return idCardNumber
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * Basic setter
     * @param idCardNumber idCardNumber
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    /**
     * Basic getter
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Basic setter
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Basic getter
     * @return birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Basic setter
     * @param birthDate birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Basic getter
     * @return Reservations
     */
    public Set<Reservation> getReservations() {
        return Collections.unmodifiableSet(reservations);
    }

    /**
     * Basic setter
     * @param reservations reservations
     */
    public void setReservation(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Adds single reservation to reservations
     * @param reservation Reservation
     */
    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    /**
     * Overridden Equals
     * @param o object
     * @return True if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return this.idCardNumber.equals(customer.getIdCardNumber());
    }

    /**
     * Overridden hashCode
     * @return hash of object
     */
    @Override
    public int hashCode() {
        return 31 * idCardNumber.hashCode();
    }
}
