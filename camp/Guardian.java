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
    
    //------------------------ACCESSORS!--------------------------------
    public UUID getID(){
        return this.id;
    }
    /**
     * written by natalie
     * @return the id of the guardian in string format
     */
    public String getGuardianID(){
        return getID().toString();
    }
    public ArrayList<Camper> getCampers(){
        return campers;
    }
    public Camper getCamper(int index){
        return campers.get(index);
    }
    public int getTotalSessions() {
        return numOfSessions;
    }
    public double getPrice() {
        return price;
    }

    // ------------------------MUTATORS!--------------------------------

    // ------------------------MISC!--------------------------------

    public String toString() {
        //return id + " " + name + " " + email + " " + password + " " + campers;
        return name;
    }

    /**
     * Removes a camper from the guardian's campers
     * @param index The index of the camper to remove
     * @return The removed camper
     */
    public Camper removeCamper(int index) {
        Camper rCamper = campers.get(index);
        campers.remove(index);
        return rCamper;
    }

    /**
     * Adds a camper to the guardian's campers
     * @param camper The camper to add
     * @return true if successful
     */
    public boolean addCamper(Camper camper) {
        campers.add(camper);
        return true;
    }

    /**
     * Method to discount the price of the camp
     * If there's more than one camper, 20% off the total price
     */
    public void discount() {
        if (campers.size() > 1) {
            price *= 0.80;
        }
    }

    /**
     * Updates the price for the guardian 
     * @return The price for the guardian
     */
    private double updatePrice() {
        price =  numOfSessions * pricePerSession;
        discount();
        return price;
    }

    /**
     * Updates the total number of sessions based on the size of campers
     * @return true if successful
     */
    private boolean updateTotalSessions() {
        for (int i=0; i<campers.size(); i++) {
            numOfSessions += (campers.get(i).getNumOfSessions());
        }
        return true;
    }
}
