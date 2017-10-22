/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.cz.pa165.travelagency.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Excursion entity for the Travel Angecy project.
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */


@Entity
public class Excursion implements Serializable {
    
    /*
     * The ID of the Excursion.
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    /*
     * The date at which the Excursion is taking place.
     */
    @Temporal(TemporalType.DATE)
    private java.util.Date excursionDate;
    
    /*
     * The duration of the Excursion.
     */
    private Integer duration;
    
    /*
     * The description of the Excursion.
     */
    private String description;
    
    /*
     * The destination of the Excursion.
     */
    private String destination;
    
    
    /*
     * The price of the Excursion.
     */
    private BigDecimal price;

    /**
     * Sets the ID of the Excursion.
     *
     * @param id Excursion ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method returns Excursion ID.
     *
     * @return Excursion ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Method returns Excursion date.
     *
     * @return Excursion date
     */
    public Date getExcursionDate() {
        return excursionDate;
    }

    /**
     * Sets the date of the Excursion.
     *
     * @param excursionDate Excursion date
     */
    public void setExcursionDate(Date excursionDate) {
        this.excursionDate = excursionDate;
    }

    /**
     * Method returns Excursion duration.
     *
     * @return Excursion duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the Excursion.
     *
     * @param duration Excursion duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Method returns Excursion description.
     *
     * @return Excursion description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Excursion.
     *
     * @param description Excursion description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method returns Excursion destination.
     *
     * @return Excursion destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the Excursion.
     *
     * @param destination Excursion destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Method returns Excursion price.
     *
     * @return Excursion price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the Excursion.
     *
     * @param price Excursion price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    /**
     * Method returns Excursion hash code.
     *
     * @return Excursion hash code
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Method returns true if two Excursions are equal, false otherwise.
     * The ID field MUST BE SET.
     *
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trip)) {
            return false;
        }
        Excursion other = (Excursion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Method returns a string presentation of the Excursion.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "fi.muni.cz.pa165.travelagency.entity.Excursion[ id=" + id + " ]";
    }
    
}
