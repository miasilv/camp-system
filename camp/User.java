package camp;

import java.util.UUID;

public abstract class User {
    protected UUID id;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String password;

    /**
     * Constructor for the user class
     * @param name The name of the user
     * @param email The email of the user
     * @param password The password for the user
     */
    public User(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // methods all children should have

    // ----------------------- ACCESSOR METHODS ---------------------------------------

    /**
     * Returns the name of the user
     * @return The name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of the user
     * @return The email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the password of the user
     * @return The password of the user
     */
    public  String getPassword() {
        return password;
    }

    /**
     * Returns the phone number of the user
     * @return The phone number of the user
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the UUID of the user
     * @return The UUID of the user
     */
    public UUID getID() {
        return id;
    }

    // ----------------------- MUTATOR METHODS ---------------------------------------

    /**
     * Mutates the name of the user
     * @param name The name of the user to change to
     * @return true if change was successful
     */
    public boolean setName(String name) {
        if (name == null) {return false;}
        this.name = name;
        return true;
    }

    /**
     * Mutates the email of the user
     * @param email The email of the user to change to
     * @return true if the change was successful
     */
    public boolean setEmail(String email) {
        if (email == null) {return false;}
        this.email = email;
        return true;
    }

    /**
     * Mutates the password of the user
     * @param password The password of the user to change to
     * @return true if the change was successful
     */
    public boolean setPassword(String password) {
        if (password == null) {return false;}
        this.password = password;
        return true;
    }

    /**
     * Mutates the phone number of the user
     * @param phoneNumber The phone number of the user to change to
     * @return true if the change was successful
     */
    public boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {return false;}
        this.phoneNumber = phoneNumber;
        return true;
    }

    // honestly jic we print out the user itself
    public String toString() {
        return name + " " + email + " " + password + " " + phoneNumber;
    }
}