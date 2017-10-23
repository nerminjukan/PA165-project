/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.cz.pa165.travelagency.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Pavel Kotala, 437164
 */
@Entity
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    private Date dateTo;

    private String destination;
    private int availableSpots;
    private Set<Excursion> excursions = new HashSet<>();
    @NotNull
    @Column(nullable = false)
    private String name;
    private BigDecimal price;

    /**
     * Returns date of start of the trip.
     * @return date of start of the trip
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets new date of start of the trip.
     * @param dateFrom new date of start of the trip
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * Returns date of end of the trip.
     * @return date of end of the trip
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * Sets new date of end of the trip.
     * @param dateTo new date of end of the trip
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * Returns destination of the trip.
     * @return destination of the trip
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets new destination of the trip
     * @param destination new destination of the trip
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returns number of available spots on the trip.
     * @return number of available spots on the trip
     */
    public int getAvailableSpots() {
        return availableSpots;
    }

    /**
     * Sets new number of available spots on the trip.
     * @param availableSpots new number of available spots on the trip
     */
    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    /**
     * Returns unmodifiable set of possible excursions for the trip.
     * @return unmodifiable set of possible excursions for the trip.
     */
    public Set<Excursion> getExcursions() {
        return Collections.unmodifiableSet(excursions);
    }

    /**
     * Adds given excursion to the set of excursions of this trip.
     * @param excursion excursion to be added
     */
    public void addExcursion(Excursion excursion) {
        this.excursions.add(excursion);
    }

    /**
     * Adds all excursions from the given collection to the set of excursions of this trip.
     * @param excursions collection of excursions to be added
     */
    public void addAllExcursions(Collection<Excursion> excursions) {
        this.excursions.addAll(excursions);
    }

    /**
     * Removes given excursion from the set of excursions of this trip.
     * @param excursion excursion to be removed
     */
    public void removeExcursion(Excursion excursion) {
        this.excursions.remove(excursion);
    }

    /**
     * Returns name of the trip.
     * @return name of the trip
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name of the trip.
     * @param name new name of the trip
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the trip.
     * @return the price of the trip
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets new price of the trip.
     * @param price the new price of the trip
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns the ID of the trip.
     * @return the ID of the trip
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new ID of the trip.
     * @param id new ID of the trip
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 37*hash + (name == null ? 0 : name.hashCode());
        hash = 37*hash + (dateTo == null ? 0 : dateTo.hashCode());
        hash = 37*hash + (dateFrom == null ? 0 : dateFrom.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip trip = (Trip) object;
        return ((this.name == null && trip.getName() == null) || (this.name != null && this.name.equals(trip.getName())) &&
                (this.dateFrom == null && trip.getDateFrom() == null) || (this.dateFrom != null && this.dateFrom.equals(trip.getDateFrom())) &&
                (this.dateTo == null && trip.getDateTo() == null) || (this.dateTo != null && this.dateTo.equals(trip.getDateTo())));
    }

    @Override
    public String toString() {
        return "fi.muni.cz.pa165.travelagency.entity.Trip[ id=" + id + " ]";
    }
    
}
