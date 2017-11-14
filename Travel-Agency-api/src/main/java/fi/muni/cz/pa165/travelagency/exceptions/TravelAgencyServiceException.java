package fi.muni.cz.pa165.travelagency.exceptions;

/**
 * @author Radoslav Micko <445611>
 */
public class TravelAgencyServiceException extends RuntimeException {

    /**
     * Exception
     */
    public TravelAgencyServiceException() {
    }

    /**
     * Exception
     * @param message to show
     */
    public TravelAgencyServiceException(String message) {
        super(message);
    }

    /**
     * Exception
     * @param message to show
     * @param cause of exception
     */
    public TravelAgencyServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception
     * @param cause of exception
     */
    public TravelAgencyServiceException(Throwable cause) {
        super(cause);
    }
}
