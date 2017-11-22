package fi.muni.cz.pa165.travelagency.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Create Excursion DTO for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public class ExcursionCreateDTO {
    
    /*
     * The TripsId set of the Excursion.
     */
    private Set<Long> tripsId = new HashSet<>();

    public Set<Long> getTripsId() {
        return tripsId;
    }

    public void setTripsId(Set<Long> tripsId) {
        this.tripsId = tripsId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.tripsId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ExcursionCreateDTO)) {
            return false;
        }
        final ExcursionCreateDTO other = (ExcursionCreateDTO) obj;
        if (!Objects.equals(this.tripsId, other.getTripsId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExcursionCreateDTO{" + "tripsId=" + tripsId + '}';
    }
    
    
    
}
