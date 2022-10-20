import java.util.ArrayList;
import java.util.UUID;

public class Guardian {
    private ArrayList<Camper> campers;
    private int numOfSessions;
    private double price;

    /**
     * Constructor for the guardian class
     * @param name Name of the guardian
     * @param email Email of the guardian
     * @param password Password of the guardian
     */
    public Guardian(String name, String email, String password, String phonenumber) {
        super();
    }

    public Guardian(String name, String email, String password, String phonenumber, UUID id, ArrayList<Camper> campers) {
        super();
    }
    //overload constructor and have one with id in param and also arraylist of cmapers.

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
