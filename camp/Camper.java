package camp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Camper {
    SimpleDateFormat dateFormatter;
    private UUID camperID;
    private String name;
    private Date birthday;
    private ArrayList<Medication> medications;
    private ArrayList<String> allergies;
    private ArrayList<Session> sessions;
    private ArrayList<String> notes;
    private HashMap<String, Contact> emergencyContacts;

    private HashMap<Session, Cabin> cabinHash; // i have no idea why camper has a cabin hash?

    /**
     * Constructor for the camper class
     * @param name Name of the camper
     * @param birthday Birthday of the camper
     */
    public Camper(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
        dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
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
    public Camper(UUID id, String name, Date birthday, ArrayList<Medication> medications, ArrayList<String> allergies, ArrayList<String> notes, ArrayList<String> relationships, ArrayList<Contact> contacts) {
        this.camperID = id;
        this.name = name;
        this.birthday = birthday;
        this.medications = medications;
        this.allergies = allergies;
        //this.sessions = sessions;
        this.notes = notes;
        this.emergencyContacts = createEmergencyContacts(relationships, contacts);
        dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
    }

    // getters because Nat needs them:

    public static HashMap<String, Contact> createEmergencyContacts(ArrayList<String> relationships, ArrayList<Contact> contacts) {
        HashMap<String, Contact> emergencyContacts = new HashMap<String, Contact>();
        for (int i=0; i<contacts.size(); i++) {
            emergencyContacts.put(relationships.get(i), contacts.get(i));
        }
        return emergencyContacts;
    }

    public UUID getID() {
        return camperID;
    }

    /**
     * written by natalie
     * gets a string representation of the campers uuid
     * @return uuid to string
     */
    public String getCamperID(){
        return getID().toString();
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    /**
     * written by natalie
     * gets a string representation of the campers birthdy 
     * @return a string format of a date
     */
    public String getBirthdayStr() {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");  
        return dateFormat.format(birthday);
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * written by natalie
     * gets a string representation of medications for camper
     * @return medications to string
     */
    public String getMedicationsStr(){
        return medications.toString();
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public String getAllergiesStr(){
        return allergies.toString();
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    //****EDITED BY MIA*****
    /**
     * a method allowing the user to retrieve a session via search by index
     * @param index the index of the session being retrieved
     * @return the corresponding session
     */
    public Session getSession(int index){
        if(index > sessions.size()) {
            return null;
        }
        return sessions.get(index);
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public HashMap<String, Contact> getEmergencyContacts() {
        return emergencyContacts;
    }


    public String getEmergencyContactsStr() {
        String writtenSchedule = "";
        for (String keyValue  : emergencyContacts.keySet()) {
            writtenSchedule += keyValue + emergencyContacts.get(keyValue) + "\n";
        }
        return writtenSchedule + "\n";
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
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy"); 
        return camperID + " " + name + " " + dateFormat.format(birthday) + " " + medications + " " + allergies + " " + sessions + " " + notes + " " + emergencyContacts;
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

    public boolean setName(String change) {
        this.name = change;
        return true;
    }

    public HashMap<String, Contact> getCamperContactHash() {
        return emergencyContacts;
    }

    public ArrayList<String> getCamperAllergyList() {
        return allergies;
    }

    /**
     * Method to calculate and return the age of the camper
     * @return The age of the camper (int)
     */
    public int getAge() {
        // convert Date birthday to localDate birthday
        LocalDate localBirthday = convertToLocalDateViaInstant(birthday);
        // convert to get age with local dates
        LocalDate curDate = LocalDate.now();
        return calculateAge(localBirthday, curDate);
    }

    /**
     * Method to convert Date object to LocalDate object
     * @param dateToConvert Date object to convert
     * @return LocalDate object
     */
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * Calculates the time in the period from one LocalDate to another LocalDate
     * @param birthDate The LocalDate of a birthday
     * @param todayDate The LocalDate of today
     * @return The time in the period from
     */
    public int calculateAge(LocalDate birthDate, LocalDate todayDate) {
        if ((birthDate != null) && (todayDate != null)) {
            return Period.between(birthDate, todayDate).getYears();
        } else {
            return 0;
        }
    }

    public void addCounselorCabinHash(Session session, Cabin cabin) {
        cabinHash.put(session, cabin);
    }

    public HashMap<Session, Cabin> getCounselorCabinHash() {
        return cabinHash;
    }

    public void removeCounselorCabinHash(Session session) {
        cabinHash.remove(session);
    }
}
