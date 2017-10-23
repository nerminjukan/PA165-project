/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.muni.cz.pa165.travelagency.dao;

import fi.muni.cz.pa165.travelagency.entity.Trip;

import java.util.Date;
import java.util.List;

/**
 * @author Pavel Kotala, 437164
 */
public interface TripDao {
    /**
     * Persists given trip to database.
     * @param trip trip to persist
     */
    void create(Trip trip);

    /**
     * Finds and returns list of all trips from database.
     * @return list of all trips
     */
    List<Trip> findAll();

    /**
     * Finds and returns list of all trips with given name from database.
     * @param name name of the trips to be returned
     * @return list of all trips with given name
     */
    List<Trip> findByName(String name);

    /**
     * Finds and returns trip with given ID from database.
     * @param id ID of the trip to be returned
     * @return trip with given ID
     */
    Trip findById(Long id);

    /**
     * Removes given trip from database.
     * @param trip trip to be removed
     */
    void remove(Trip trip);

    /**
     * Finds and returns list of all trips that take place between given dates.
     * @param start earliest possible start of the trips to be returned
     * @param end latest possible end of the trips to be returned
     * @return list of all trips that take place between given dates
     */
    List<Trip> getTripsBetween(Date start, Date end);
}
