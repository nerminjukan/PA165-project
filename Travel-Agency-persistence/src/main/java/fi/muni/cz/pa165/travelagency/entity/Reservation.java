package fi.muni.cz.pa165.travelagency.entity;

import fi.muni.cz.pa165.travelagency.enums.PaymentStateType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
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

    /**
     * Constructor
     */
    public Reservation() {
    }

    /**
     * Constructor
     * @param id specific id
     */
    public Reservation(Long id) {
        this.id = id;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @NotNull
    @OneToOne(optional=false)
    private Trip reservedTrip;
        
    @ManyToMany
    @JoinTable(name="RESERVED_EXC",
            joinColumns = @JoinColumn(name = "Reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "Excursion_id"))
    private Set<Excursion> reservedExcursions = new HashSet<>();
    
    @NotNull
    @ManyToOne(optional=false)
    private User user;
    
    @Enumerated
    @NotNull
    private PaymentStateType paymentState = PaymentStateType.NotPaid;

    public PaymentStateType getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentStateType paymentState) {
        this.paymentState = paymentState;
    }

    public User getUser() {
        return user;
    }

    public Set<Excursion> getReservedExcursions() {
        return Collections.unmodifiableSet(reservedExcursions);
    }
    
    /**
     * Add new reserved excursion into reservation.
     * 
     * @param excursion excursion to be added.
     */
    public void addReservedExcursion(Excursion excursion) {
        reservedExcursions.add(excursion);
    }
    
    /**
     * Remove reserved excursion from reservation.
     * 
     * @param excursion excursion to be removed
     */
    public void removeReservedExcursion(Excursion excursion) {
        reservedExcursions.remove(excursion);
    }

    /**
     * Add all excursions from given collection.
     * 
     * @param excursions collection of excursion to be added
     */
    public void addAllReservedExcursions(Collection<Excursion> excursions) {
        this.reservedExcursions.addAll(excursions);
    }
    
    public void setUser(User user) {
        this.user = user;
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
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        if (user == null) {
            if (other.getUser() != null) {
                return false;
            }
        } else if (!user.equals(other.getUser())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", created=" + created + 
                ", reservedTrip=" + reservedTrip + ", user=" + user + '}';
    }
}
