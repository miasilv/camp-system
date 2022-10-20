import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Mia Silver
 * A Camp Facade Object
 */
public class CampFacade {
    private UserList user;
    private Camp camp; 

    private static final String CAMP_INFORMATION = "CampI";
    private static final String SESSION_INFORMATION = "SessI";
    private static final String CABIN_INFORMATION = "CabI";
    private static final String USER_INFORMATION = "UserI";
    private static final String COUNSELOR_INFORMATION = "CounI";
    private static final String MEDICATION_INFORMATION = "MedI";
    private static final String CONTACT_INFORMATION = "ContI";
    private static final String GUARDIAN_INFORMATION = "GuardI";
    private static final String CAMPER_INFORMATION = "CamperI";

    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String RATIO = "ratio";

    public CampFacade() {
        user.getInstance();
        camp.getInstance();
    }

    /**
     * Edits a string instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the string instance variables in the given class
     * @param change the new information you want to put in
     */
    public void editInformation(String className, String varaibleName, String change) {

    }

    /**
     * Edits an int instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the int instance variables in the given class
     * @param change the new information you want to put in
     */
    public void editInformation(String className, String variableName, int change) {

    }

    /**
     * Edits a double instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the double instance variables in the given class
     * @param change the new information you want to put in
     */
    public void editInformation(String className, String variableName, double change) {

    }

    /**
     * Edits a Date instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the Date instance variables in the given class
     * @param change the new information you want to put in
     */
    public void editInformation(String className, String variableName, Date change) {

    }

    /**
     * Gets an instance variable's (not array lists or hash maps) information in a given class.
     * @param className the class that contains the information being returned 
     * @param type any of the instance variables in Camp (not array lists or hash maps)
     * @return the string version of the instance variable
     */
    public String getInformation(String className, String variableName) {
        return "null";
    }
    
    /**
     * Gets a list of sessions.
     * @param className the class that contains the list of sessions being returned
     * @return an array list of sessions
     */
    public ArrayList<Session> getSessionList(String className) {
        ArrayList<Session> list = new ArrayList<Session>();
        return list;
    }

    /**
     * Gets a list of FAQs.
     * @param className the class that contains the list of FAQs being returned;
     * @return an array list of FAQs
     */
    public ArrayList<FAQ> getFAQList(String className) {
        ArrayList<FAQ> list = new ArrayList<FAQ>();
        return list;
    }

    /**
     * Gets a list of activites.
     * @param className the class that contais the list of activities being returned.
     * @return an array list of activites
     */
    public ArrayList<String> getActivityList(String className) {
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }

    /**
     * Gets a list of Cabins
     * @param className the class that contains the list of cabins being returned
     * @return an array list of Cabins
     */
    public ArrayList<Cabin> getCabinList(String className) {
        ArrayList<Cabin> list = new ArrayList<Cabin>();
        return list;
    }
    
    /**
     * Gets a list of Campers.
     * @param className the class that contains the list of campers being returned
     * @return an array list of campers
     */
    public ArrayList<Camper> getCamperList(String className) {
        ArrayList<Camper> list = new ArrayList<Camper>();
        return list;
    }
    
    /**
     * Gets a Schedule Hash.
     * @param className the class that contains the scheudle hash map being returned
     * @return a hash map schedule
     */
    public HashMap<Day, Schedule> getScheduleHash(String className) {
        HashMap<Day, Schedule> hashMap = new HashMap<Day, Schedule>();
        return hashMap;
    }
    
    /**
     * Gets a schedule based on the day.
     * @param day the day of the schedule you want
     * @return the schedule of the given day
     */
    public Schedule getSchedule(Day day) {
        return getScheduleHash(CABIN_INFORMATION).get(day);
    }

    /**
     * Gets a list of allergies.
     * @param className the class that contains the allergy list being returned
     * @return an array list of allergies
     */
    public ArrayList<String> getAllergyList(String className) {
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }

    /**
     * Gets a list of medications.
     * @param className the class that contains the medication list being returned
     * @return an array list of Medications
     */
    public ArrayList<Medication> getMedicationList(String className) {
        ArrayList<Medication> list = new ArrayList<Medication>();
        return list;
    }

    /**
     * Gets emergency contacts.
     * @param className the class that contains the emergency contacts being returned
     * @return a emergency contacts object (hash map) 
     */
    public EmergencyContact getEmergencyContacts(String className) {
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
     * Signs a user in to their portal with their email and password.
     * @param email the user's email
     * @param password the user's password
     */
    public User signIn(String email, String password) {
        User user = new Director(email, email, password);
        return user;
    }
    
    /**
     * Creates a new user by inputting name, email, and password.
     * @param name the name of the new user
     * @param email the email of the new user
     * @param password the password of the new user
     */
    public void createNewUser(String name, String email, String password) {

    }
}