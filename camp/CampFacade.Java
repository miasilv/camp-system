import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Mia Silver
 * A Camp Facade object
 */
public class CampFacade {
    // ------------------------- CURRENT ARRAYLISTS/OBJECTS -----------------
    private UserList userList;
    private Camp camp; 
    private ArrayList<FAQ> currentFaqList;
    private FAQ currentFaq;
    private ArrayList<String> currentActivityList;
    private ArrayList<Session> currentSessionList;
    private Session currentSession;
    private ArrayList<Cabin> currentCabinList;
    private Cabin currentCabin;
    private User currentUser;
    private Director currentDirector;
    private Counselor currentCounselor;
    private Guardian currentGuardian;
    private ArrayList<Camper> currentCamperList;
    private ArrayList<Medication> currentMedicationList;
    private Medication currentMedication;
    private ArrayList<String> currentAllergyList;



    //------------- INSTANCE VARIABLES (NOT OBJECTS) ------------------------
    //camp instance variables
	private static final String NAME = "name"; //in User, Camper, and Contact
    private static final String PRICE = "price"; //in Guardian
    private static final String RATIO = "ratio";
	private static final String ACTIVITIES = "activities"; //(array list)

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String SESS_NUM = "sessNum"; //in Guardian
	private static final String START_DATE = "startD";
	private static final String END_DATE = "endD";

	//cabin instance variables
	private static final String SCHEDULE = "schedule"; //(hash map)

	//user instance variables
	private static final String EMAIL = "email"; //in Contact
	private static final String PHONE = "phoneNum"; //in Contact
	private static final String PASSWORD = "password";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String BIRTHDAY = "birthday"; //in Camper
	private static final String ALLERGIES = "allergies"; //in Camper (array list)

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";

    //medication instance variables
    private static final String DOSE = "dose";
    private static final String TYPE = "type";
    private static final String TIME = "time";

    public CampFacade() {
        camp.getInstance();
        initArrayLists();
    }

    private void initArrayLists() {
        currentActivityList = new ArrayList<String>();
        currentSessionList = new ArrayList<Session>();
        currentCabinList = new ArrayList<Cabin>();
        currentCamperList = new ArrayList<Camper>();
        currentMedicationList = new ArrayList<Medication>();
        currentAllergyList = new ArrayList<String>();
    }

    // ***************************** CAMP CLASS ***********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside camp
     */
    public void updateCamp() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current camp object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getCampString(String variableName) {
        if(variableName.equals(NAME)) {
            return camp.getName();
        }
        return null;
    }
    
    /**
     * Sets any string instance variable in the current camp object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCampString(String variableName, String change) {
        if(variableName.equals(NAME)) {
            return camp.setName(change);
        }
        return false;
    }

    /**
     * Gets any int instance variable in the current camp object
     * @param variableName the name of the int instance variable
     * @return the int value in the variableName, -1 if not found
     */
    public int getCampInt(String variableName) {
        if(variableName.equals(RATIO)) {
            return camp.getCampersPerCounselor();
        }
        return -1;
    }

    /**
     * Sets any int instance variable in the current camp object with a new value
     * @param variableName the name of the int instance variable being edited
     * @param change the new int to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCampInt(String variableName, int change) {
        if(variableName.equals(RATIO)) {
            return camp.setCampersPerCounselor(change);
        }
        return false;
    }

    /**
     * Gets any double instance variable in the current camp object
     * @param variableName the name of the double instance variable
     * @return the double value in the variableName, -1 if not found
     */
    public double getCampDouble(String variableName) {
        if(variableName.equals(PRICE)) {
            return camp.getPricePerSession();
        }
        return -1;
    }

    /**
     * Sets any double instance variable in the current camp object with a new value
     * @param variableName the name of the double instance variable being edited
     * @param change the new dobule to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCampDouble(String variableName, double change) {
        if(variableName.equals(PRICE)) {
            return camp.setPricePerSession(change);
        }
        return false;
    }

    // ----------------------------- ARRAY LISTS ----------------------------
    /**
     * Gets the current faq list, (which should be in camp object)
     * @return an arraylist of faqs
     */
    public ArrayList<FAQ> getCampFAQ() {
        return currentFaqList;
    }

    /**
     * Removes an faq from the current faq list (which should be in a camp object)
     * @param index the index of the faq to be removed
     * @return the removed faq object
     */
    public FAQ removeCampFAQ(int index) {
        return currentFaqList.remove(index);
    }

    /**
     * Adds an faq to the current faq list (which should be in a camp object)
     * @param question the question for the new faq object
     * @param answer the answer for the new faq object
     * @return true if successful, false if not successful
     */
    public boolean addCampFAQ(String question, String answer) {
        return currentFaqList.add(new FAQ(question, answer));
    }

    /**
     * Gets the current activity list, (which should be in camp object)
     * @return an arraylist of activities (strings)
     */
    public ArrayList<String> getCampActivities() {
        return currentActivityList;
    }
    
    /**
     * Removes an activity from the current activity list (which should be in a camp object)
     * @param index the index of the activity to be removed
     * @return the removed activity string
     */
    public String removeCampActivity(int index) {
        return currentActivityList.remove(index);
    }

    /**
     * Adds an activity to the current activity list (which should be in a camp object)
     * @param activity the activity to be added to the list
     * @return true if successful, false if not successful
     */
    public boolean addCampActivity(String activity) {
        return currentActivityList.add(activity);
    }

    /**
     * Gets the current session list, (which should be in camp object)
     * @return an arraylist of sessions
     */
    public ArrayList<Session> getCampSessions() {
        return currentSessionList;
    }

    /**
     * Removes a session from the current session list (which should be in a camp object)
     * @param index the index of the session to be removed
     * @return the removed session object
     */
    public Session removeCampSession(int index) {
        return removeCampSession(index);
    }

    /**
     * Adds an activity to the current session list (which should be in a camp object)
     * @param sessionNumber the session number
     * @param startDate the start date of the session
     * @param endDate the end date of the session
     * @return true if successful, false if not successful
     */
    public boolean addCampSession(int sessionNumber, Date startDate, Date endDate) {
        //TODO check if session already exists by id/session number and don't create a new objects
        return currentSessionList.add(new Session(sessionNumber, startDate, endDate));
    }
    



    // ***************************** FAQ CLASS ************************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside faq
     */
    public void updateFAQ() {

    }   

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current camp object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getFAQString(String variableName) {
        if(variableName.equals(QUESTION)) {
            return currentFaq.getQuestion();
        }
        if(variableName.equals(ANSWER)) {
            return currentFaq.getAnswer();
        }
        return null;
    }

    /**
     * Sets any string instance variable in the current faq object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setFAQString(String variableName, String change) {
        if(variableName.equals(QUESTION)) {
            return currentFaq.setQuestion();
        }
        if(variableName.equals(ANSWER)) {
            return currentFaq.setAnswer();
        }
        return false;
    }



    // ********************************** SESSION CLASS ***************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside session
     */
    public void updateSession() {
        
    }
    
    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any int instance variable in the current session object
     * @param variableName the name of the int instance variable
     * @return the int value in the variableName, -1 if not found
     */
    public int getSessionInt(String variableName) {
        if(variableName.equals(SESS_NUM)) {
            return currentSession.getSessionNumber();
        }
        return -1;
    }

    /**
     * Sets any int instance variable in the current session object with a new value
     * @param variableName the name of the int instance variable being edited
     * @param change the new int to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setSessionInt(String variableName, int change) {
        if(variableName.equals(SESS_NUM)) {
            return currentSession.setSessionNumber(change);
        }
        return false;
    }

    /**
     * Gets any date instance variable in the current session object
     * @param variableName the name of the date instance variable
     * @return the date value in the variableName, null if not found
     */
    public Date getSessionDate(String variableName) {
        if(variableName.equals(START_DATE)) {
            return currentSession.getStartDate();
        }
        if(variableName.equals(END_DATE)) {
            return currentSession.getEndDate();
        }
        return null;
    }

    /**
     * Sets any date instance variable in the current session object with a new value
     * @param variableName the name of the date instance variable being edited
     * @param change the new date to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setSessionDate(String variableName, Date change) {
        if(variableName.equals(START_DATE)) {
            return currentSession.setStartDate(change);
        }
        if(variableName.equals(END_DATE)) {
            return currentSession.setEndDate(change);
        }
        return false;
    }

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current cabin list, (which should be in session object)
     * @return an arraylist of cabins
     */
    public ArrayList<Cabin> getSessionCabinList() {
        return currentCabinList;
    }

    /**
     * Removes a dabin from the current cabin list (which should be in a session object)
     * @param index the index of the cabin to be removed
     * @return the removed cabin object
     */
    public Cabin removeSessionCabin(int index) {
        return currentCabinList.remove(index);
    }

    /**
     * Adds a cabin to the current cabin list (which should be in a session object)
     * @param cabinNum the number of the new cabin
     * @return true if successful, false if not successful
     */
    public boolean addSessionCabin(int cabinNum) {
        //TODO check if the cabin already exists in this list
        return currentCabinList.add(new Cabin(cabinNum));
    }



    // ***************************** CABIN CLASS **********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside cabin
     */
    public void updateCabin() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** USER CLASS ***********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside user //MIGHT JUST BE SIGN IN? not entirely sure
     */
    public void updateUser() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** DIRECTOR CLASS ******************************************* //UNSURE IF WE NEED THIS ONE
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside director
     */
    public void updateDirector() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** COUNSELOR CLASS ******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside counselor
     */
    public void updateCounselor() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** GUARDIAN CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside guardian
     */
    public void updateGuardian() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** CAMPER CLASS *********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside camper
     */
    public void updateCamper() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------


    // ***************************** MEDICATION CLASS *****************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside  medication
     */
    public void updateMedication() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** EMERGENCY CONTACTS CLASS *********************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside emergency contacts
     */
    public void updateEmergencyContacts() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** CONTACTS CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside contacts
     */
    public void updateContacts() {
        
    }
    
    // ------------------------ INSTANCE VARIALBES --------------------------
    // ------------------------------ ARRAY LISTS ---------------------------


}
