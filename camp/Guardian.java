package camp;

import java.util.ArrayList;
import java.util.UUID;

public class Guardian extends User {
    private ArrayList<Camper> campers;
    private int numOfSessions;
    private double price;
    private final static double pricePerSession = 500;

    /**
     * Constructor for the guardian class
     * @param name Name of the guardian
     * @param email Email of the guardian
     * @param password Password of the guardian
     */
    public Guardian(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
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
    
    // ----------------------------------ACCESSORS-------------------------------------------------------------

    /**
     * written by natalie
     * Accessor for the guardian ID in a string format
     * @return the id of the guardian in string format
     */
    public String getGuardianID(){
        return getID().toString();
    }

    /**
     * Accessor for the campers for the guardian
     * @return AL of campers
     */
    public ArrayList<Camper> getCampers(){
        return campers;
    }

    /**
     * Accessor for a specific camper from the guardian
     * @param index Index of the camper to grab
     * @return Camper at the index
     */
    public Camper getCamper(int index){
        return campers.get(index);
    }

    public int getTotalSessions() {
        return numOfSessions;
    }

    public double getPrice() {
        return price;
    }

    // ----------------------------------MISC-------------------------------------------------------------

    public String toString() {
        //return id + " " + name + " " + email + " " + password + " " + campers;
        return name;
    }

    /**
     * Removes a camper from the campers AL
     * @param index The index of the camper to remove
     * @return true if successful
     */
    public boolean removeCamper(int index) {
        campers.remove(index);
        return true;
    }

    /**
     * Adds a camper to the campers AL
     * @param camper The camper to add to the AL
     * @return true if successful
     */
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

    /**
     * Updates the price for the guardian based on the num of sessions and discounts
     * @return total price
     */
    private double updatePrice() {
        price =  numOfSessions * pricePerSession;
        discount();
        return price;
    }

    /**
     * Updates the total number of sessions for the guardian
     * @return true if successful
     */
    private boolean updateTotalSessions() {
        for (int i=0; i<campers.size(); i++) {
            numOfSessions += (campers.get(i).getNumOfSessions());
        }
        return true;
    }
}
