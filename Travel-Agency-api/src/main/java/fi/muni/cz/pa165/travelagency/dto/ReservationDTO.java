package fi.muni.cz.pa165.travelagency.dto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotNull;

/**
 * DTO for Reservation entity.
 * 
 * @author Radoslav Micko <445611>
 */
public class ReservationDTO {
    
    @NotNull
    private Long id;
    
    @NotNull
    private Date created;
    
    @NotNull
    private TripDTO trip;
    
    private Set<ExcursionDTO> excursions = new HashSet<>();

    @NotNull
    private CustomerDTO customer;
    
    private BigDecimal totalPrice;

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public Set<ExcursionDTO> getExcursions() {
        return Collections.unmodifiableSet(excursions);
    }

    public void setExcursions(Set<ExcursionDTO> excursions) {
        this.excursions = excursions;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(created);
        result = prime * result + Objects.hashCode(trip);
        result = prime * result + Objects.hashCode(customer);
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
        if (!(object instanceof ReservationDTO)) {
            return false;
        }
        
        final ReservationDTO other = (ReservationDTO) object;
        if (!Objects.equals(this.getCreated(), other.getCreated())) {
            return false;
        }
        if (!Objects.equals(this.getTrip(), other.getTrip())) {
            return false;
        }
        if (!Objects.equals(this.getCustomer(), other.getCustomer())) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" + "id=" + id + ", created=" + created 
                + ", trip=" + trip + ", excursions=" + excursions 
                + ", customer=" + customer + ", totalPrice=" + totalPrice + '}';
    }
    
    
}
