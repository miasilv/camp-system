package camp;

import java.util.UUID;

/**
 * Class of user that has ultimate power over the camp system
 */
public class Director extends User {
    private UUID id;

    // ----------------------------------CONSTRUCTORS-------------------------------------------------------------
    
    /**
     * Constructor for the director class
     * @param name Name of the director
     * @param email Email of the director
     * @param password Password of the director
     */
    public Director(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.id = UUID.randomUUID();
    }

    /**
     * OVERLOADED CONSTRUCTOR FOR THE JSON FILE!
     * @param id ID of the director
     * @param name Name of the director
     * @param email Email of the director
     * @param password Password of the director
     * @param phoneNumber Phone number of the director
     */
    public Director(UUID id, String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.id = id;
    }

    // ----------------------------------ACCESSORS-------------------------------------------------------------

    /**
     * written by natalie
     * Accesses the uuid of the director (string)
     * @return the uuid of the director in string format
     */
    public String getDirectorID(){
        return getID().toString();
    }

    // ----------------------------------MUTATORS-------------------------------------------------------------

    // ----------------------------------METHODS-------------------------------------------------------------

    public String toString() {
        //return id + " " + name + " " + email + " " + password + " " + phoneNumber;
        return name;
    }
}
