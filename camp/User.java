package camp;

import java.util.UUID;

public class User {
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

    // --------------------ACCESSORS---------------------------------

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public UUID getID() {
        return id;
    }

    // --------------------MUTATORS---------------------------------

    public boolean setName(String name) {
        if (name == null) {return false;}
        else {
            this.name = name; 
            return true;
        }
    }
    public boolean setEmail(String email) {
        if (email == null) {return false;} 
        else {
            this.email = email;
            return true;
        }
    }
    public boolean setPassword(String password) {
        if (password == null) {return false;}
        else {
            this.password = password;
            return true;
        }
    }
    public boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {return false;}
        else {
            this.phoneNumber = phoneNumber;
            return true;
        }
    }

    // --------------------MISC---------------------------------

    public String toString() {
        return name + " " + email + " " + password + " " + phoneNumber;
    }
}