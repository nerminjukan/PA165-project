package fi.muni.cz.pa165.travelagency.dto;

/**
 * Representing user's dto object for authentication
 * @author Martin Sevcik <422365>
 */
public class UserAuthenticateDTO {

    /**
     * Representing id
     */
    private Long id;

    /**
     * Representing hash of password
     */
    private String passwordHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
