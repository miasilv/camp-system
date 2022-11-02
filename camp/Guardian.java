package camp;

import java.util.ArrayList;
import java.util.UUID;

public class Guardian extends User {
    private ArrayList<Camper> campers;
    private int numOfSessions;
    private double price;
    private final static double pricePerSession = 500;
    private UUID id;

    /**
     * Constructor for the guardian class
     * @param name Name of the guardian
     * @param email Email of the guardian
     * @param password Password of the guardian
     */
    public Guardian(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.id= UUID.randomUUID();
        campers = new ArrayList<Camper>();
        updatePrice();
        updateTotalSessions();
        
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
        updatePrice();
        updateTotalSessions();
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
    
    /**
     * written by natalie
     * @return the id of the guardian in string format
     */
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

    public Camper getCamper(int index){
        return campers.get(index);
    }

    public String toString() {
        //return id + " " + name + " " + email + " " + password + " " + campers;
        return name;
    }

    public boolean removeCamper(int index) {
        campers.remove(index);
        return true;
    }

    public boolean addCamper(Camper camper) {
        campers.add(camper);
        return true;
    }

    /**
     * Method to discount the price of the camp
     */
    public void discount() {
        if (campers.size() > 1) {
            price *= 0.80;
        }
    }

    public int getTotalSessions() {
        return numOfSessions;
    }

    public double getPrice() {
        return price;
    }

    private double updatePrice() {
        price =  numOfSessions * pricePerSession;
        discount();
        return price;
    }

    private boolean updateTotalSessions() {
        for (int i=0; i<campers.size(); i++) {
            numOfSessions += (campers.get(i).getNumOfSessions());
        }
        return true;
    }
}
