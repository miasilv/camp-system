package camp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import java.util.Map;
import java.util.UUID;

public class Counselor extends User {
    private String bio;
    private HashMap<String, Contact> emergencyContacts;
    private Date birthday;
    private ArrayList<String> allergies;
    private HashMap<Session, Cabin> cabinHash;
    private ArrayList<String> sessionThemes;
    private ArrayList<String> relationships;
    private ArrayList<Contact> contacts;
    private UUID id;
    

    // ----------------------------------CONSTRUCTORS-------------------------------------------------------------

    /**
     * Constructor for the counselor class
     * Not touching this for now, but most data read through JSON
     * @param name Name of the counselor
     * @param email Email of the counselor
     * @param password Password of the counselor
     * @param birthday Birthday of the counselor
     */
    public Counselor(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.id = UUID.randomUUID();
        this.cabinHash = new HashMap<Session, Cabin>();
        this.bio = "";
    }

    /**
     * Constructor with the UUID and the Cabins for the JSON.
     * FOR THE JSON FILE!!!!!!
     * @param name Name of the counselor
     * @param email Email of the counselor
     * @param password Password of the counselor
     * @param birthday Birthday of the counselor
     * @param phoneNumber Phone Number of the counselor
     * @param id UUID of the counselor
     * @param bio Biography of the counselor
     * @param cabins Cabins of the counselor
     */
    public Counselor(UUID id, String name, String email, String password, String phoneNumber, String bio, ArrayList<String> relationships, ArrayList<Contact> contacts, Date birthday, ArrayList<String> allergies, ArrayList<String> sessionThemes) {
        super(name, email, password, phoneNumber);
        this.birthday = birthday;
        this.bio = bio;
        this.id = id;
        this.allergies = allergies;
        this.emergencyContacts = createEmergencyContacts(relationships, contacts);
        this.cabinHash = new HashMap<Session, Cabin>();
        this.sessionThemes = sessionThemes;
        this.contacts = contacts;
        this.relationships = relationships;
    }

    // ----------------------------------ACCESSORS-------------------------------------------------------------

    /**
     * written by natalie
     * @param relationships the key values in the hash
     * @param contacts the contact information for those key values
     * @return the hashmap of emergency contacts
     */
    public static HashMap<String, Contact> createEmergencyContacts(ArrayList<String> relationships, ArrayList<Contact> contacts) {
        HashMap<String, Contact> emergencyContacts = new HashMap<String, Contact>();
        for (int i=0; i<contacts.size(); i++) {
            emergencyContacts.put(relationships.get(i), contacts.get(i));
        }
        return emergencyContacts;
    }

    public ArrayList<String> getRelationships(){
        return this.relationships;
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }

    /**
     * written by natalie
     * @return a string representation 
     */
    public String getCounselorID(){
        return getID().toString();
    }

    public String getBio() {
        return bio;
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

    public Date getBirthday() {
        return birthday;
    }

    /**
     * written by natalie
     * @return the birthday in string format
     */
    public String getBirthdayStr() {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");  
        return dateFormat.format(birthday);
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    /**
     * written by natalie
     * @return the allergies in string format
     */
    public String getAllergiesStr(){
        return allergies.toString();
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

    /**
     * Returns the <session, cabin> hash of the counselor
     * @return The <session, cabin> hash
     */
    public HashMap<Session, Cabin> getCounselorCabinHash() {
        return cabinHash;
    }

    // ----------------------------------MUTATORS-------------------------------------------------------------

    public boolean setBio(String change) {
        this.bio = change;
        return true;
    }

    public boolean setBirthday(Date change) {
        this.birthday = change;
        return true;
    }

    // ----------------------------------MISC-------------------------------------------------------------

    /**
     * Method to add the bio of the counselor
     */
    public void addBio(String bio) {
        this.bio = bio;
    }

    /**
     * Method to add allergies for the counselor to take of
     * @param allergy Allergy to take care of
     */
    public void addAllergies(String allergy) {
        allergies.add(allergy);
    }

    /**
     * Method to remove the allergy for the counselor to take care of
     * @param allergy Allergy to remove
     */
    public void removeAllergy(String allergy) {
        allergies.remove(allergy);
    }

    /**
     * Method to change the allergy of a counselor
     * @param index Index of the allergy of the counselor
     * @param allergy Allergy to replace with
     */
    public void editAllergy(int index, String allergy) {
        allergies.set(index, allergy);
    }

    /**
     * Returns a string representation of the counselor
     */
    public String toString() {
        if(this.name.equals("")) {
            return "no counselor";
        }
        return name + ": " + bio;
    }

    /**
     * Method to calculate and return the age of the counselor
     * @return The age of the counselor (int)
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
     * This is because the LocalDate allows us to do operations on it
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
     * Adds in an item to the <session, cabin> hash
     * @param session Session to add in
     * @param cabin Cabin to add in
     */
    public void addCounselorCabinHash(Session session, Cabin cabin) {
        cabinHash.put(session, cabin);
    }

    /**
     * Removes an item from the <session, cabin> hash
     * @param session The session (key) to remove
     */
    public void removeCounselorCabinHash(Session session) {
        cabinHash.remove(session);
    }

    /**
     * Adds in an item to the <session, cabin> hash
     * @param session Session (key) to update to
     * @param cabin Cabin (value) to update to
     */
    public void updateCounselorCabinHash(Session session, Cabin cabin) {
        cabinHash.put(session, cabin);
    }

    /**
     * Removes an allergy from the allergies AL
     * @param index The index of the allergy to remove
     * @return true if successful
     */
    public boolean removeAllergy(int index) {
        allergies.remove(index);
        return true;
    }

    /**
     * Adds an allergy to the allergies AL
     * @param allergy The allergy to add
     * @return true if successful
     */
    public boolean addAllergy(String allergy) {
        allergies.add(allergy);
        return true;
    }

    /**
     * Removes an emergency contact from the <relation, contact> hash
     * @param relationship The relationship (key)
     * @return true if successful
     */
    public boolean removeEmergencyContact(String relationship) {
        emergencyContacts.remove(relationship);
        return true;
    }

    /**
     * Creates and adds in a contact to the emergency contact hash
     * @param relationship The relationship to the camper (key)
     * @param name2 Name of the contact
     * @param email Email of the contact
     * @param phone Phone of the contact
     * @param address Address of the contact
     * @return true if successful
     */
    public boolean addEmergencyContact(String relationship, String name2, String email, String phone, String address) {
        Contact nContact = new Contact(name2, phone, address, email);
        emergencyContacts.put(relationship, nContact);
        return true;
    }

    /**
     * Removes a session from the <session, cabin> hash
     * @param session The session (key) to remove
     * @return true if successful
     */
    public boolean removeSession(Session session) {
        return cabinHash.remove(session, cabinHash.get(session));
    }

    /**
     * Adds in a new session into the <session, cabin> hash
     * @param session The session (key) to add
     * @param cabin The cabin (val) to add
     * @return true if successful
     */
    public boolean addSession(Session session, Cabin cabin) {
        updateCounselorCabinHash(session, cabin);
        return true;
    }
}