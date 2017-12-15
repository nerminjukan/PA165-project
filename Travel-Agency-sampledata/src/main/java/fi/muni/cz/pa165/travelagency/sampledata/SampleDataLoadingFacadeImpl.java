package fi.muni.cz.pa165.travelagency.sampledata;

import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.entity.Reservation;
import fi.muni.cz.pa165.travelagency.entity.Trip;
import fi.muni.cz.pa165.travelagency.entity.User;
import fi.muni.cz.pa165.travelagency.enums.PaymentStateType;
import fi.muni.cz.pa165.travelagency.enums.UserRoleType;
import fi.muni.cz.pa165.travelagency.service.ExcursionService;
import fi.muni.cz.pa165.travelagency.service.ReservationService;
import fi.muni.cz.pa165.travelagency.service.TripService;
import fi.muni.cz.pa165.travelagency.service.UserService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * SampleDataLoadingFacade implementation - data creation and insertion.
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade{
    
    final static Logger log = LoggerFactory.getLogger(SampleDataLoadingFacadeImpl.class);
    
    @Autowired
    private ExcursionService excursionService;
            
    @Autowired
    private TripService tripService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ReservationService reservationService;

    @Override
    @SuppressWarnings("unused")
    public void loadData() throws IOException {
        
        try {
            Set<Excursion> excursionSet = new HashSet();
            Set<Reservation> reservationSet = new HashSet();
            
            log.info("Loading data (Excursion)...");
            Excursion castle = excursion(date("05/6/2018"), 5, "Visiting the castle", "Paris",
                    bigDecimal(60));
            Excursion hill = excursion(date("11/6/2018"), 2, "Visiting the hill viewpoint", "Paris",
                    bigDecimal(25));
            Excursion lake = excursion(date("14/6/2018"), 1, "Visiting the lake", "Paris",
                    bigDecimal(30));
            Excursion museum = excursion(date("12/7/2018"), 1, "Visiting the museum", "Ljubljana",
                    bigDecimal(10));
            Excursion vineCellar = excursion(date("13/7/2018"), 1, "Visiting the vine cellar", "Ljubljana",
                    bigDecimal(25));
            Excursion spa = excursion(date("14/7/2018"), 4, "Visiting the spa", "Ljubljana",
                    bigDecimal(120));
            Excursion ossuary = excursion(date("30/9/2018"), 1, "Visiting the St. James' Ossuary", "Brno",
                    bigDecimal(10));
            Excursion brewery = excursion(date("01/10/2018"), 1, "Visiting the brewery", "Brno",
                    bigDecimal(15));
            Excursion zoo = excursion(date("02/10/2018"), 1, "Visiting the Zoo", "Brno",
                    bigDecimal(8));
            Excursion prague = excursion(date("03/10/2018"), 3, "Visiting Prague", "Prague",
                    bigDecimal(100));
            Excursion caves = excursion(date("06/10/2018"), 1, "Visiting the caves", "Brno",
                    bigDecimal(15));
            
            log.info("Loading data (Trip)...");
            Trip paris = trip(date("04/6/2018"), date("14/6/2018"), "Paris", 50, excursionSet,
                    "Paris", bigDecimal(2400));
            paris.addExcursion(castle);
            paris.addExcursion(hill);
            paris.addExcursion(lake);
            
            Trip ljubljana = trip(date("12/7/2018"), date("18/7/2018"), "Ljubljana", 30, excursionSet,
                    "Ljubljana", bigDecimal(250));
            ljubljana.addExcursion(museum);
            ljubljana.addExcursion(vineCellar);
            ljubljana.addExcursion(spa);
            
            Trip brno = trip(date("30/9/2018"), date("06/10/2018"), "Brno", 40, excursionSet,
                    "Brno", bigDecimal(400));
            brno.addExcursion(ossuary);
            brno.addExcursion(brewery);
            brno.addExcursion(zoo);
            brno.addExcursion(prague);
            brno.addExcursion(caves);
            
            log.info("Loading data (User)...");
            User helga = user("Helga", "Steinke", "000", "helga@user.com", "000000",
                reservationSet, date("26/1/1994"), "000000000", UserRoleType.CUSTOMER);
            User mark = user("Mark", "Smith", "001", "mark@user.com", "001001",
                reservationSet, date("11/5/1985"), "001001001", UserRoleType.CUSTOMER);
            User janez = user("Janez", "Novak", "010", "janez@user.com", "010010",
                reservationSet, date("26/2/1992"), "010010010", UserRoleType.CUSTOMER);
            User michal = user("Michal", "Rozycki", "011", "michal@user.com", "011011",
                reservationSet, date("06/9/1976"), "011011011", UserRoleType.CUSTOMER);
            User adminJakov = user("Jakov", "Boss", "100", "jakov@user.com", "100100",
                reservationSet, date("03/7/1974"), "100100100", UserRoleType.ADMINISTRATOR);
            User adminEva = user("Eva", "Boss", "101", "eva@user.com", "101101",
                reservationSet, date("17/11/1984"), "100100100", UserRoleType.ADMINISTRATOR);
            User pepa = user("Pepa", "Petak", "111", "pepa@user.com", "111111",
                reservationSet, date("03/9/1995"), "111111111", UserRoleType.CUSTOMER);
            
            log.info("Loading data (Reservation)...");
            Reservation markParis = reservation(paris, excursionSet, mark, date("10/12/2017"),
                PaymentStateType.Paid);
            mark.addReservation(markParis);
            Reservation pepaParis = reservation(paris, excursionSet, pepa, date("16/12/2017"),
                PaymentStateType.Paid);
            pepa.addReservation(pepaParis);
            Reservation helgaParis = reservation(paris, excursionSet, helga, date("15/12/2017"),
                PaymentStateType.Paid);
            helga.addReservation(helgaParis);
            Reservation janezLjubljana = reservation(ljubljana, excursionSet, janez, date("11/12/2017"),
                PaymentStateType.NotPaid);
            janez.addReservation(janezLjubljana);
            Reservation markLjubljana = reservation(ljubljana, excursionSet, mark, date("02/3/2017"),
                PaymentStateType.Paid);
            janez.addReservation(markLjubljana);
            Reservation helgaLjubljana = reservation(ljubljana, excursionSet, helga, date("08/3/2017"),
                PaymentStateType.NotPaid);
            helga.addReservation(helgaLjubljana);
            Reservation michalLjubljana = reservation(ljubljana, excursionSet, michal, date("10/3/2017"),
                PaymentStateType.Paid);
            michal.addReservation(michalLjubljana);
            Reservation markBrno = reservation(brno, excursionSet, mark, date("30/9/2017"),
                PaymentStateType.NotPaid);
            mark.addReservation(markBrno);
            Reservation pepaBrno = reservation(brno, excursionSet, pepa, date("29/9/2017"),
                PaymentStateType.Paid);
            pepa.addReservation(pepaBrno);
            Reservation michalBrno = reservation(brno, excursionSet, michal, date("30/9/2017"),
                PaymentStateType.NotPaid);
            michal.addReservation(michalBrno);
        
        } catch (ParseException ex) {
            log.info("Error parsing data. " + ex.toString());
        }
        
        
        
        
        
        
        
        
    }
    
    private Excursion excursion(Date date, int duration, String description,
            String destination, BigDecimal price){
        
        Excursion excursion = new Excursion();
        excursion.setDescription(description);
        excursion.setDestination(destination);
        excursion.setDuration(duration);
        excursion.setExcursionDate(date);
        excursion.setPrice(price);
        
        return excursion;
    }
    
    private Trip trip(Date dateFrom, Date dateTo, String destination, int AvailableTrips,
            Set<Excursion> excursions, String name, BigDecimal price){
        
        Trip trip = new Trip();
        trip.setAvailableSpots(AvailableTrips);
        trip.setDateFrom(dateFrom);
        trip.setDateTo(dateTo);
        trip.setDestination(destination);
        trip.setName(name);
        trip.setPrice(price);
        trip.addAllExcursions(excursions);
        
        return trip;
    }
    
    private Reservation reservation(Trip reservedTrip, Set<Excursion> excursions, User user,
            Date created, PaymentStateType paymentState){
        
        Reservation reservation = new Reservation();
        reservation.setCreated(created);
        reservation.setPaymentState(paymentState);
        reservation.setUser(user);
        reservation.setReservedTrip(reservedTrip);
        reservation.addAllReservedExcursions(excursions);
        
        return reservation;
    }
    
    private User user(String name, String surname, String IDCardNumber, String email,
            String phoneNumber, Set<Reservation> reservations, Date birthDate, String passHash,
            UserRoleType userType){
        
        User user = new User();
        user.setBirthDate(birthDate);
        user.setEmail(email);
        user.setIdCardNumber(IDCardNumber);
        user.setName(name);
        user.setPasswordHash(passHash);
        user.setPhoneNumber(phoneNumber);
        user.setReservation(reservations);
        user.setSurname(surname);
        user.setUserRoleType(userType);
        
        return user;
    }
    
    private Date date(String date) throws ParseException{
        Date parsedDate = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            parsedDate = sdf.parse(date);
        } catch (ParseException parseException) {
            log.info("Date could not be parsed correctly (check format).");
        }
        return parsedDate;
    }
    
    private BigDecimal bigDecimal(int transform){
        return BigDecimal.valueOf(transform);
    }
    
}
