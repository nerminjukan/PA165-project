package fi.muni.cz.pa165.travelagency.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Radoslav Micko <445611>
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason="The resource already exists")
public class ResourceAlreadyExistingException extends RuntimeException {
    
} 
