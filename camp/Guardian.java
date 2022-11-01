package camp;

import java.util.ArrayList;
import java.util.UUID;

public class Guardian extends User {
    private ArrayList<Camper> campers;
    private int numOfSessions;
    private double price;
    private double pricePerSession = 500;

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
     * Method to discount the price of the camp
     */
    public void discount() {
        //if multiple kids, discount
    }

    public Camper getCamper(int index){
        return campers.get(index);
    }

    public String toString() {
        //return id + " " + name + " " + email + " " + password + " " + campers;
        return name;
    }

    public int getTotalSessions() {
        return numOfSessions;
    }

    public double getPrice() {
        return price;
    }

    public boolean removeCamper(int index) {
        return false;
    }

    public boolean addCamper(Camper camper) {
        return false;
    }


    public double updatePrice() {
        return numOfSessions * pricePerSession;
    }

    public double getPricePerSession() {
        return pricePerSession; // figure out how to get pricepersession
    }

    public boolean updateTotalSessions() {
        return true;
    }
    // update total sessions
    /*
    loop through campers
    get how many sessions they have campers.getSession
    hasSession method in campe

    */
}
