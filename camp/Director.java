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
     * Accesses the name of the director
     * @return The name of the director
     */
    public String getName() {
        return name;
    }

    /**
     * Accesses the email of the director
     * @return The email of the director
     */
    public String getEmail() {
        return email;
    }

    /**
     * Accesses the password of the director
     * @return The password of the director
     */
    public String getPassword() {
        return password;
    }

    /**
     * Accesses the phone number of the director
     * @return The phone number of the director
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Accesses the uuid of the director
     * @return The uuid of the director
     */
    public UUID getID() {
        return id;
    }

    /**
     * written by natalie
     * Accesses the uuid of the director (string)
     * @return the uuid of the director in string format
     */
    public String getDirectorID(){
        return getID().toString();
    }

    // ----------------------------------MUTATORS-------------------------------------------------------------

    /**
     * Mutates the name of the director
     * @return true if successful
     */
    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    /**
     * Mutates the email of the director
     * @return true if successful
     */
    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    /**
     * Mutates the password of the director
     * @return true if successful
     */
    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }

    /**
     * Mutates the phone number of the director
     * @return true if successful
     */
    public boolean setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return true;
    }

    // ----------------------------------METHODS-------------------------------------------------------------

    public String toString() {
        //return id + " " + name + " " + email + " " + password + " " + phoneNumber;
        return name;
    }
}
