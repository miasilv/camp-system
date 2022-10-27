package camp;

import java.util.ArrayList;
import java.util.UUID;

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

    /**
     * Overloaded Constructor to read data in from the JSON file.
     * DIRECT PARAMS FROM JSON FILE!
     * @param id ID of the guardian
     * @param name Name of the guardian
     * @param email Email of the guardian
     * @param password Password of the guardian
     * @param phoneNumber Phone number of the guardian
     * @param campers Campers of the guardian
     */
    public Guardian(UUID id, String name, String email, String password, String phoneNumber, ArrayList<Camper> campers) {
        super(name, email, password, phoneNumber);
        this.id = id;
        this.campers = campers;
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
    
    public String getGuardianID(){
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

    public ArrayList<Camper> getCampers(){
        return campers;
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

    public String toString() {
        return id + " " + name + " " + email + " " + password + " " + campers;
    }

    public int getTotalSessions() {
        return numOfSessions;
    }

    public boolean setTotalSessions(int change) {
        this.numOfSessions = change;
        return true;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double change) {
        this.price = change;
        return true;
    }

    public Camper getCamper(int index) {
        return campers.get(index);
    }
}
