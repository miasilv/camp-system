package camp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Camper {
    private UUID camperID;
    private String name;
    private Date birthday;
    private ArrayList<Medication> medications;
    private ArrayList<String> allergies;
    private ArrayList<Session> sessions;
    private ArrayList<String> notes;
    private ArrayList<Cabin> cabins;
    private HashMap<String, Contact> emergencyContacts;

    /**
     * Constructor for the camper class
     * @param name Name of the camper
     * @param birthday Birthday of the camper
     */
    public Camper(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * OVERLOADED CONSTRUCTOR FOR THE JSON FILE!!
     * @param id ID of the camper
     * @param name Name of the camper
     * @param birthday Birthday of the camper
     * @param medications Medications of the camper
     * @param allergies Allergies of the camper
     * @param sessions Sessions of the camper
     * @param notes Notes of the camper
     * @param emergencyContacts Emergency contacts of the camper
     */
    public Camper(UUID id, String name, Date birthday, ArrayList<Medication> medications, ArrayList<String> allergies, ArrayList<Session> sessions, ArrayList<String> notes, ArrayList<String> relationships, ArrayList<Contact> contacts) {
        this.camperID = id;
        this.name = name;
        this.birthday = birthday;
        this.medications = medications;
        this.allergies = allergies;
        this.sessions = sessions;
        this.notes = notes;
        for (int i=0; i<relationships.size(); i++) {
            emergencyContacts.put(relationships.get(i), contacts.get(i));
        }
    }

    // getters because Nat needs them:

    public UUID getID() {
        return camperID;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public HashMap<String, Contact> getEmergencyContacts() {
        return emergencyContacts;
    }

    /**
     * Adds a medication for the camper
     * @param medication The medication to add
     */
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Removes a medication for the camper
     * @param medication The medication to remove
     */
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    /**
     * Edits a medication for the camper
     * @param index Index of the medication to edit
     * @param medication Medication to replace index with
     */
    public void editMedication(int index, Medication medication) {
        medications.set(index, medication);
    }
    
    /**
     * Adds an allergy for the camper
     * @param allergy The allergy to add
     */
    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    /**
     * Removes an allergy for the camper
     * @param allergy The allergy to remove
     */
    public void removeAllergy(String allergy) {
        allergies.remove(allergy);
    }

    /**
     * Edits an allergy of the camper
     * @param index Index of the allergy to edit
     * @param allergy Allergy to replace index allergy with
     */
    public void editAllergy(int index, String allergy) {
        allergies.set(index, allergy);
    }


    /**
     * Returns a string representation. Returns all instance variables
     */
    public String toString() {
        return camperID + " " + name + " " + birthday + " " + medications + " " + allergies + " " + sessions + " " + notes + " " + emergencyContacts;
    }

    /**
     * Adds an emergency contact to the camper
     * 
     * @param emergencyContact The emergency contact to add
     */
    public void addEmergencyContact(EmergencyContact emergencyContact) {

    }

    /**
     * Removes an emergency contact from the camper
     * 
     * @param emergencyContact The emergency contact to remove
     */
    public void removeEmergencyContact(EmergencyContact emergencyContact) {

    }

    /**
     * Edits an emergency contact of the camper
     * 
     * @param index            Index of the emergency contact to edit
     * @param emergencyContact The emergency contact to replace the index with
     */
    public void editEmergencyContact(int index, EmergencyContact emergencyContact) {

    }

}
