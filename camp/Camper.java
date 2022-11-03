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
    private HashMap<String, Contact> emergencyContacts;
    private HashMap<Session, Cabin> cabinHash;
    private ArrayList<String> sessionThemes;
    private ArrayList<String> relationships;
    private ArrayList<Contact> contacts;

    /**
     * Constructor for the camper class
     * @param name Name of the camper
     * @param birthday Birthday of the camper
     */
    public Camper(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
        this.camperID = UUID.randomUUID();
        dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
        medications = new ArrayList<Medication>();
        allergies = new ArrayList<String>();
        sessions = new ArrayList<Session>();
        emergencyContacts = new HashMap<String, Contact>();
        cabinHash = new HashMap<Session, Cabin>();
        sessionThemes = new ArrayList<String>();
        relationships = new ArrayList<String>();
        contacts = new ArrayList<Contact>();
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
    public Camper(UUID id, String name, Date birthday, ArrayList<Medication> medications, ArrayList<String> allergies, ArrayList<String> relationships, ArrayList<Contact> contacts, ArrayList<String> sessionThemes) {
        this.camperID = id;
        this.name = name;
        this.birthday = birthday;
        this.medications = medications;
        this.allergies = allergies;
        //this.sessions = sessions;
        this.emergencyContacts = createEmergencyContacts(relationships, contacts);
        dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
        this.cabinHash = new HashMap<Session, Cabin>();
        this.sessionThemes = sessionThemes;
        this.contacts = contacts;
        this.relationships = relationships;
    }

    //--------------------------ACCESSORS-------------------------------

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
    public ArrayList<String> getRelationships(){
        return this.relationships;
    }
    public ArrayList<Contact> getContacts(){
        return this.contacts;
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
    /**
     * written by natalie
     * @return a string format of allergies
     */
    public String getAllergiesStr(){
        return allergies.toString();
    }
    public ArrayList<Session> getSessions() {
        return sessions;
    }
    /**
     * written by natalie
     * @return the array list of themes for the camper
     */
    public ArrayList<String> getSessionThemes(){
        return sessionThemes;
    }
    /**
     * written by natalie
     * @return to string of session themes 
     */
    public String getSessionThemesStr(){
        return sessionThemes.toString();
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
    public HashMap<String, Contact> getCamperContactHash() {
        return emergencyContacts;
    }
    public HashMap<Session, Cabin> getCamperCabinHash() {
        return cabinHash;
    }
    public int getNumOfSessions() {
        return cabinHash.size();
    }
    public ArrayList<String> getCamperAllergyList() {
        return allergies;
    }

    public String allergiesToString() {
        String workingString = "";
        for(int i = 0; i < allergies.size(); i++) {
            workingString += allergies.get(i) + ",";
        }
        return workingString;
    }

    public String medicationToString() {
        String workingString = "";
        for(int i = 0; i < medications.size(); i++) {
            workingString += "\tType: " + medications.get(i).getType();
            workingString += "\n\tTime: " + medications.get(i).getTime();
            workingString += "\n\tDose: " + medications.get(i).getDose() + "\n";
        }
        return workingString;
    }

    //-------------------------------MUTATORS------------------------------

    public boolean setBirthday(Date date) {
        this.birthday = date;
        return true;
    }
    
    public boolean setName(String change) {
        this.name = change;
        return true;
    }

    //--------------------------------MISC-----------------------------------

    /**
     * written by natalie
     * creates a hash map for emergency contacts of the camper
     * 
     * @param relationships the relationships of the contacts
     * @param contacts      the contacts information
     * @return the list of emergency contacts
     */
    public static HashMap<String, Contact> createEmergencyContacts(ArrayList<String> relationships,
            ArrayList<Contact> contacts) {
        HashMap<String, Contact> emergencyContacts = new HashMap<String, Contact>();
        for (int i = 0; i < contacts.size(); i++) {
            emergencyContacts.put(relationships.get(i), contacts.get(i));
        }
        return emergencyContacts;
    }

    /**
     * Adds a medication for the camper
     * @param medication The medication to add
     * @return whether the medication was successfully added
     */
    public boolean addMedication(Medication medication) {
        medications.add(medication);
        return true;
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
     * @return whether the addition was successful
     */
    public boolean addAllergy(String allergy) {
        allergies.add(allergy);
        return true;
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
        return name; // just the name of the camper
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

    /**
     * Removes an allergy of the camper
     * @param index The index of the allergy to remove
     * @return true if successful
     */
    public boolean removeAllergy(int index) {
        allergies.remove(index);
        return true;
    }

    /**
     * Removes a medication from the camper
     * @param index The index of the medication to remove
     * @return true if successful
     */
    public boolean removeMedication(int index) {
        medications.remove(index);
        return true;
    }

    /**
     * Removes a session from the <session, cabin> hash
     * @param session The session to remove (key)
     * @return true if successful
     */
    public boolean removeSession(Session session) {
        return cabinHash.remove(session, cabinHash.get(session));
    }

    /**
     * Adds a session to the <session, cabin> hash
     * @param s The session (key) to add
     * @param c The cabin (val) to add
     * @return true if successful
     */
    public boolean addSession(Session s, Cabin c) {
        cabinHash.put(s, c);
        return true;
    }

    /**
     * Removes an emergency contact from the emergency contacts hash
     * @param relationship The relationship to remove (key)
     * @return true if successful
     */
    public boolean removeEmergencyContact(String relationship) {
        emergencyContacts.remove(relationship);
        return true;
    }

    /**
     * Adds an emergency contact
     * @return true if successful
     */
    public boolean addEmergencyContact(String relationship, String name2, String email, String phone, String address) {
        Contact nContact = new Contact(name2, phone, address, email);
        emergencyContacts.put(relationship, nContact);
        relationships.add(relationship);
        contacts.add(nContact);
        return true;
    }
}
