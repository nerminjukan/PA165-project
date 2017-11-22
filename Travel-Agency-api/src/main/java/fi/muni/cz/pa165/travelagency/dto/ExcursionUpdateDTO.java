package fi.muni.cz.pa165.travelagency.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotNull;

/**
 * Update Excursion DTO for the Travel Angecy project.
 * 
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public class ExcursionUpdateDTO extends ExcursionDTO{
    
    @NotNull
    private Set<Long> tripsId = new HashSet<>();
    
    /**
     * Empty constructor.
     */
    public ExcursionUpdateDTO(){
        
    }
    
    /**
     * Constructor with two arguments.
     *
     * @param exc ExcursionDTO that provides data.
     * @param tripsId A set of Trips to be added to the ExcursionDTO.
     */
    public ExcursionUpdateDTO(ExcursionDTO exc, Set tripsId){
        super(exc);
        this.tripsId = tripsId;
    }

    public Set<Long> getTripsId() {
        return tripsId;
    }

    public void setTripsId(Set<Long> tripsId) {
        this.tripsId = tripsId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.tripsId);
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
        if (!(obj instanceof ExcursionUpdateDTO)) {
            return false;
        }
        final ExcursionUpdateDTO other = (ExcursionUpdateDTO) obj;
        if (!Objects.equals(this.tripsId, other.getTripsId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExcursionUpdateDTO{" + "tripsId=" + tripsId + '}';
    }
    
    
    
    
}
