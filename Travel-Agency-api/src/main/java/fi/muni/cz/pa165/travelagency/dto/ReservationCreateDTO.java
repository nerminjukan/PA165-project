package fi.muni.cz.pa165.travelagency.dto;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotNull;

/**
 * DTO for creating Reservation entity.
 * 
 * @author Radoslav Micko <445611>
 */
public class ReservationCreateDTO {
    
    @NotNull
    private Long tripId;
    
    @NotNull
    private Long userId;
    
    @NotNull
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    private Set<Long> excursionsId = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Set<Long> getExcursionsId() {
        return Collections.unmodifiableSet(excursionsId);
    }

    public void setExcursionsId(Set<Long> excursionsId) {
        this.excursionsId = excursionsId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.tripId);
        hash = 97 * hash + Objects.hashCode(this.getUserId());
        hash = 97 * hash + Objects.hashCode(this.excursionsId);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ReservationCreateDTO)) {
            return false;
        }
        final ReservationCreateDTO other = (ReservationCreateDTO) object;
        if (!Objects.equals(this.getTripId(), other.getTripId())) {
            return false;
        }
        if (!Objects.equals(this.getUserId(), other.getUserId())) {
            return false;
        }
        if (!Objects.equals(this.getExcursionsId(), other.getExcursionsId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReservationCreateDTO{" + "tripId=" + tripId + ", userId="
                + userId + ", excursionsId=" + excursionsId + '}';
    }

    
    
    
    
    
}
