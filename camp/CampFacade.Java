package camp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Mia Silver
 * A Camp Facade Object
 */
public abstract class CampFacade {
    private User user;
    private Camp camp;

    /**
     * Edits the Camp Information based on the type of information and the change you want to make.
     * @param type any of the instance variables in Camp
     * @param change the new information you want to put in
     */
    public void editCampInformation(String type, String change) {

    }
    
    /**
     * Gets the Camp Information based on the specific type.
     * @param type any of the instance variables in Camp (not Array Lists)
     * @return the string version of the instance variable
     */
    public String getCampInformation(String type) {
        return "null";
    }

    /**
     * Gets all Sessions in Camp.
     * @return an array list of sessions
     */
    public ArrayList<Session> getSessionList() {
        ArrayList<Session> list = new ArrayList<Session>();
        return list;
    }

    /**
     * Gets all FAQs in Camp.
     * @return an array list of FAQs
     */
    public ArrayList<FAQ> getFAQList() {
        ArrayList<FAQ> list = new ArrayList<FAQ>();
        return list;
    }

    /**
     * Edits the FAQ based on the type of information and the change you want to make.
     * @param type any of the instance variables in FAQ (not Array Lists)
     */
    public void editFAQ(String type, String change) {

    }

    /**
     * Gets all activites in Camp.
     * @return an array list of activites
     */
    public ArrayList<String> getActivityList() {
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }




    
    /**
     * Edits the Session Information based on the type of information and the change you want to make.
     * @param type any of the instance variables in Session (not Array Lists)
     * @param change the new information you want to put in
     */
    public void editSessionInformation(String type, String change) {

    }
    
    /**
     * Gets the Session Information based on the specific type.
     * @param type any of the instance variables in Session (not Array Lists)
     * @return the string version of the instance variable
     */
    public String getSessionInformation(String type) {
        return "null";
    }

    /**
     * Gets a list of Cabins
     * @return an array list of Cabins
     */
    public ArrayList<Cabin> getCabinList() {
        ArrayList<Cabin> list = new ArrayList<Cabin>();
        return list;
    }

    
    


    /**
     * Edits the Cabin Information based on the type of information and the change you want to make.
     * @param type any of the instance variables in Cabin (not Array Lists)
     * @param change the new information you want to put in
     */
    public void editCabinInformation(String type, String change) {

    }
    
    /**
     * Gets the Cabin Information based on the specific type.
     * @param type any of the instance variables in Cabin (not Array Lists)
     * @return the string version of the instance variable
     */
    public String getCabinInformation(String type) {
        return "null";
    }
    
    /**
     * Gets a list of Campers.
     * @return an array list of campers
     */
    public ArrayList<Camper> getCamperList() {
        ArrayList<Camper> list = new ArrayList<Camper>();
        return list;
    }
    
    /**
     * Gets a Schedule Hash.
     * @return a hash map schedule
     */
    public HashMap<Day, Schedule> getScheduleHash() {
        HashMap<Day, Schedule> hashMap = new HashMap<Day, Schedule>();
        return hashMap;
    }
    
    /**
     * Gets a schedule based on the day.
     * @param day the day of the schedule you want
     * @return the schedule of the given day
     */
    public Schedule getSchedule(Day day) {
        return getScheduleHash().get(day);
    }

   
    


    /**
     * Signs a user in to their portal with their email and password.
     * @param email the user's email
     * @param password the user's password
     */
    public void signIn(String email, String password) {
        
    }
    
    /**
     * Creates a new user by inputting name, email, and password.
     * @param name the name of the new user
     * @param email the email of the new user
     * @param password the password of the new user
     */
    public void createNewUser(String name, String email, String password) {

    }

    /**
     * Edits the User's Information based on the type of information and the change you want to make. 
     * @param type any instance variable of that user (no array lists)
     * @param change the new information you want to put in
     */
    public void editUserInformation(String type, String change) {
    
    }

    /**
     * Gets the User's Information based on the specific type.
     * @param type any of the instance variables in User (no array lists)
     * @return the string version of the instance variable
     */
    public String getUserInformation(String type) {
        return "null";
    }






    /**
     * Edits the Counselor's Information based on the type of information and the change you want to make. 
     * @param type any instance variable of that counselor (no array lists)
     * @param change the new information you want to put in
     */
    public void editCounselorInformation(String type, String change) {

    }
    
    /**
     * Gets the Cousnelor's Information based on the specific type.
     * @param type any of the instance variables in Counselor (no array lists)
     * @return the string version of the instance variable
     */
    public String getCounselorInformation(String type) {
        return "null";
    }

    /**
     * Edits the Guardian's Information based on the type of information and the change you want to make. 
     * @param type any instance variable of that Guardian (no array lists)
     * @param change the new information you want to put in
     */
    public void editGuardianInformation(String type, String change) {

    }
    
    /**
     * Gets the Guardian's Information based on the specific type.
     * @param type any of the instance variables in Guardian (no array lists)
     * @return the string version of the instance variable
     */
    public String getGuardianInformation(String type) {
        return "null";
    } 

    /**
     * Edits the Camper's Information based on the type of information and the change you want to make. 
     * @param type any instance variable of that camper (no array lists)
     * @param change the new information you want to put in
     */
    public void editCamperInformation(String type, String change) {

    }

    /**
     * Gets the Camper's Information based on the specific type.
     * @param type any of the instance variables in Camper (no array lists)
     * @return the string version of the instance variable
     */
    public String getCamperInformation(String type) {
        return "null";
    }

    



    /**
     * Gets a list of allergies.
     * @return an array list of allergies
     */
    public ArrayList<String> getAllergyList() {
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }

    /**
     * Gets a list of medications.
     * @return an array list of Medications
     */
    public ArrayList<Medication> getMedicationList() {
        ArrayList<Medication> list = new ArrayList<Medication>();
        return list;
    }

    /**
     * Edits the Camper's Medication Information based on the type of information and the change you want to make. 
     * @param type any instance variable of that medication (no array lists)
     * @param change the new information you want to put in
     */
    public void editMedicationInformation(String type, String Change) {

    }





    /**
     * Gets emergency contacts.
     * @return a emergency contacts object (hash map) 
     */
    public EmergencyContact getEmergencyContacts() {
        EmergencyContact ec = new EmergencyContact();
        return ec;
    }

    /**
     * Gets a specific contact based on relationship
     * @param relationship the emergency contact's relation to the camper/counselor
     * @return the contact information of the given relation
     */
    public Contact getContact(String relationship) {
        Contact contact = new Contact("a", "b", "c", "d", "e");
        return contact;
    }
    
    /**
     * Gets the Contact's Information based on the specific type.
     * @param type any of the instance variables in Contact (no array lists)
     * @return the string version of the instance variable
     */
    public String getContactInfo(String type) {
        return "null";
    }

    /**
     * Edits the Contact's Information based on the type of information and the change you want to make. 
     * @param type any instance variable of that contact (no array lists)
     * @param change the new information you want to put in
     */
    public void editContactInfo(String type, String change) {

    }
}