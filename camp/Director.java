package camp;

import java.util.UUID;

public class Director extends User {
    private UUID id;
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

    public String getDirectorID(){
        return getID().toString();
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return true;
    }

    public String toString() {
        return id + " " + name + " " + email + " " + password + " " + phoneNumber;
    }
}
