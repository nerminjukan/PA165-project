package fi.muni.cz.pa165.travelagency.entity;

import fi.muni.cz.pa165.travelagency.enums.PaymentStateType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Radoslav Micko <445611>
 */
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @NotNull
    @OneToOne(optional=false)
    private Trip reservedTrip;
        
    //-------------------------------------------------------------------------
    //Names of tables for join table
    @ManyToMany
    @JoinTable(name="RESERVED_EXC",
            joinColumns = @JoinColumn(name = "Reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "Excursion_id"))
    private Set<Excursion> reservedExcursions;
    
    /*
    In Customer set atribute reservations to @OneToMany(mappedBy="customer")
    */
    @NotNull
    @ManyToOne(optional=false)
    private Customer customer;
    
    @Enumerated
    @NotNull
    private PaymentStateType paymentState = PaymentStateType.NotPaid;

    public PaymentStateType getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentStateType paymentState) {
        this.paymentState = paymentState;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Excursion> getReservedExcursions() {
        return reservedExcursions;
    }

    public void setReservedExcursions(Set<Excursion> reservedExcursions) {
        this.reservedExcursions = reservedExcursions;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    public Trip getReservedTrip() {
        return reservedTrip;
    }

    public void setReservedTrip(Trip reservedTrip) {
        this.reservedTrip = reservedTrip;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((reservedTrip == null) ? 0 : reservedTrip.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } 
        if (object == null) {
            return false;
        }    
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if (created == null) {
            if (other.getCreated() != null) {
                return false;
            }
        } else if (!created.equals(other.getCreated())) {
            return false;
        }
        if (reservedTrip == null) {
            if (other.getReservedTrip() != null) {
                return false;
            }
        } else if (!reservedTrip.equals(other.getReservedTrip())) {
            return false;
        }
        if (customer == null) {
            if (other.getCustomer() != null) {
                return false;
            }
        } else if (!customer.equals(other.getCustomer())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", created=" + created + 
                ", reservedTrip=" + reservedTrip + ", customer=" + customer + '}';
    }
}
