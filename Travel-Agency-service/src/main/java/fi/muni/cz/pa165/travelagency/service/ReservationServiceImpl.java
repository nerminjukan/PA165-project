package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dao.ReservationDao;
import fi.muni.cz.pa165.travelagency.entity.Customer;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.enums.PaymentStateType;
import fi.muni.cz.pa165.travelagency.exceptions.TravelAgencyServiceException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Radoslav Micko <445611>
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;
    
    //@Autowired
    //private TripService tripService;;
    
    //OR calling method from TripDAO to get available spots.
    @Override
    public Reservation createReservation(Reservation reservation) {
        if (reservation.getReservedTrip().getAvailableSpots() == 0) {
            throw new TravelAgencyServiceException("Cannot create new "
                    + "reservation. There is no more free slot for this trip.");
        }
        reservationDao.create(reservation);
        return reservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationDao.update(reservation);
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservationDao.remove(reservation);
    }

    @Override
    public void addExcursionToReservation(Reservation reservation, Excursion excursion) {
        reservation = reservationDao.findById(reservation.getId());
        reservation.addReservedExcursion(excursion);
        reservationDao.update(reservation);
    }
    
    @Override
    public void addExcrusionsToReservation(Reservation reservation, List<Excursion> excursions) {
        reservation = reservationDao.findById(reservation.getId());
        reservation.addAllReservedExcursions(excursions);
        reservationDao.update(reservation);
    }
    

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationDao.findById(id);
    }

    @Override
    public List<Reservation> findByCustomer(Customer customer) {
        return reservationDao.findByCustomer(customer);
    }

    @Override
    public List<Reservation> findByTrip(Trip trip) {
        return reservationDao.findByTrip(trip);
    }

    @Override
    public BigDecimal getTotalPrice(Reservation reservation) {
        Reservation r = reservationDao.findById(reservation.getId());
        BigDecimal price = r.getReservedTrip().getPrice();
        for (Excursion e: r.getReservedExcursions()) {
            price.add(e.getPrice());
        }
        return price;
    }

    @Override
    public List<Reservation> getReservationsCreatedBetween(Date start, Date end) {
        return reservationDao.getReservationsCreatedBetween(start, end);
    }

    @Override
    public void setPaidState(Reservation reservation) {
        reservation = reservationDao.findById(reservation.getId());
        reservation.setPaymentState(PaymentStateType.Paid);
        reservationDao.update(reservation);
    }
    
    @Override
    public void setNotPaidState(Reservation reservation) {
        reservation = reservationDao.findById(reservation.getId());
        reservation.setPaymentState(PaymentStateType.NotPaid);
        reservationDao.update(reservation);
    } 
}
