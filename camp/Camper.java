import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Camper {
    private UUID camperID;
    private String name;
    private Date birthday;
    private ArrayList<Medication> medicaitons;
    private ArrayList<String> allergies;
    private ArrayList<Session> sessions;
    private String notes;
    private ArrayList<Cabin> cabins;
    private ArrayList<EmergencyContact> emergencyContacts;

    /**
     * Constructor for the camper class
     * @param name Name of the camper
     * @param birthday Birthday of the camper
     */
    public Camper(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Camper(String name, Date birthday, ArrayList<Medication> medications, ArrayList<String> allergies, ArrayList<Session> sessions, ArrayList<String> notes, ArrayList<EmergencyContact> contacts, UUID id) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * Adds a medication for the camper
     * @param medication The medication to add
     */
    public void addMedication(Medication medication) {

    }

    /**
     * Removes a medication for the camper
     * @param medication The medication to remove
     */
    public void removeMedication(Medication medication) {

    }

    /**
     * Edits a medication for the camper
     * @param index Index of the medication to edit
     * @param medication Medication to replace index with
     */
    public void editMedication(int index, Medication medication) {

    }
    
    /**
     * Adds an allergy for the camper
     * @param allergy The allergy to add
     */
    public void addAllergy(String allergy) {

    }

    /**
     * Removes an allergy for the camper
     * @param allergy The allergy to remove
     */
    public void removeAllergy(String allergy) {

    }

    /**
     * Edits an allergy of the camper
     * @param index Index of the allergy to edit
     * @param allergy Allergy to replace index allergy with
     */
    public void editAllergy(int index, String allergy) {

    }

    /**
     * Adds an emergency contact to the camper
     * @param emergencyContact The emergency contact to add
     */
    public void addEmergencyContact(EmergencyContact emergencyContact) {

    }

    /**
     * Removes an emergency contact from the camper
     * @param emergencyContact The emergency contact to remove
     */
    public void removeEmergencyContact(EmergencyContact emergencyContact) {

    }
    
    /**
     * Edits an emergency contact of the camper
     * @param index Index of the emergency contact to edit
     * @param emergencyContact The emergency contact to replace the index with
     */
    public void editEmergencyContact(int index, EmergencyContact emergencyContact) {

    }

    /**
     * Returns a string representation. DO YOU REALLY NEED TO KNOW THIS??
     */
    public String toString() {
        return "";
    }
}
