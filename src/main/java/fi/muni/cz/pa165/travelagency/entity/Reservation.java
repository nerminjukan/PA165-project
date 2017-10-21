package fi.muni.cz.pa165.travelagency.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
        
    /*
    In Customer set atribute reservations to @OneToMany(mappedBy="customer")
    */
    /*@NotNull
    @ManyToOne(optional=false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    */
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
        //result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
        /*if (customer == null) {
            if (other.getCustomer() != null)
                return false;
        } else if (!customer.equals(other.getCustomer()))
            return false;*/
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", created=" + created + 
                ", reservedTrip=" + reservedTrip + ", customer=" + /*customer*/ + '}';
    }
}
