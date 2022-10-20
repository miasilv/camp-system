import java.util.ArrayList;

public class Guardian extends User {
    private ArrayList<Camper> campers;
    private int numOfSessions;
    private double price;

    /**
     * Constructor for the guardian class
     * @param name Name of the guardian
     * @param email Email of the guardian
     * @param password Password of the guardian
     */
    public Guardian(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to register a camper
     */
    public void registerCamper() {

    }

    /**
     * Method to unregister a camper
     */
    public void unregisterCamper() {

    }

    /**
     * Method to add a session for a camper
     * @param camper Camper of the guardian to add session to
     * @param session The session to add the camper to
     */
    public void addSession(Camper camper, Session session) {

    }

    /**
     * Method to discount the price of the camp
     */
    public void discount() {

    }

    /**
     * Method to sign the waiver for the child
     */
    public void signWaiver() {

    }
}
