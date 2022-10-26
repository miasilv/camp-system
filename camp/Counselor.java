package camp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Counselor extends User {
    private String bio;
    private HashMap<String, Contact> emergencyContacts;
    private Date birthday;
    private ArrayList<String> allergies;

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
    public Counselor(UUID id, String name, String email, String password, String phoneNumber, String bio, ArrayList<String> relationships, ArrayList<Contact> contacts, Date birthday, ArrayList<String> allergies) {
        super(name, email, password, phoneNumber);
        this.birthday = birthday;
        this.bio = bio;
        this.id = id;
        this.allergies = allergies;
        this.emergencyContacts = createEmergencyContacts(relationships, contacts);
    }

    public static HashMap<String, Contact> createEmergencyContacts(ArrayList<String> relationships, ArrayList<Contact> contacts) {
        HashMap<String, Contact> emergencyContacts = new HashMap<String, Contact>();
        for (int i=0; i<contacts.size(); i++) {
            emergencyContacts.put(relationships.get(i), contacts.get(i));
        }
        return emergencyContacts;
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

    public String getBio() {
        return bio;
    }

    public HashMap<String, Contact> getEmergencyContacts() {
        return emergencyContacts;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
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

    /**
     * Method to sign the waiver for the counselor
     */
    public void SignWaiver() {

    }

    /**
     * Method to add the bio of the counselor
     */
    public void addBio() {

    }

    /**
     * Method to add allergies for the counselor to take of
     * @param allergy Allergy to take care of
     */
    public void addAllergies(String allergy) {

    }

    /**
     * Method to remove the allergy for the counselor to take care of
     * @param allergy Allergy to remove
     */
    public void removeAllergy(String allergy) {

    }

    /**
     * Method to edit the allergy a counselor has to take care of
     * @param index Index of the allergy of the counselor
     * @param allergy Allergy to replace with
     */
    public void editAllergy(int index, String allergy) {

    }

    public boolean setBio(String change) {
        this.bio = change;
        return true;
    }

    /**
     * Returns a string representation of the counselor
     */
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy"); 
        return id + " " + name + " " + email + " " + password + " " + phoneNumber + " " + bio + " " + emergencyContacts + " " + dateFormat.format(birthday) + " " + allergies;
    }

    public boolean setBirthday(Date change) {
        this.birthday = change;
        return true;
    }

    
}