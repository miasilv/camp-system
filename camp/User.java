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

    // abstract methods all children should have

    public abstract String getName();
    public abstract String getEmail();
    public abstract String getPassword();
    public abstract String getPhoneNumber();
    public abstract UUID getID();

    public abstract boolean setName(String name);
    public abstract boolean setEmail(String email);
    public abstract boolean setPassword(String password);
    public abstract boolean setPhoneNumber(String phoneNumber);

    /**
     * Method to add a phone number for a user
     * @param phoneNumber Phone number to add
     */
    public void changePhoneNumber(String phoneNumber) {

    }

    /**
     * Method to change the password of the user
     * @param password Password of the user
     */
    public void changePassword(String password) {

    }

    /**
     * Method to change the email of the user
     * @param email The email to change the user's to
     */
    public void changeEmail(String email) {

    }

    /**
     * Method to change the phone number of the user
     * @param phoneNumber Phone number of the user to change to
     */
    public void changePhone(String phoneNumber) {

    }

    /**
     * Method to delete the user
     */
    public void deleteUser() {
        
    }

    public String toString() {
        return name + " " + email + " " + password + " " + phoneNumber;
    }
}