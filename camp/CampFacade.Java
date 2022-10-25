package camp;
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
    private HashMap<Day, Schedule> currentScheduleHash;
    private Schedule currentSchedule;
    
    private User currentUser; // the person using it
    private Director currentDirector;
    private Counselor currentCounselor;
    private Guardian currentGuardian;
    private ArrayList<Camper> currentCamperList;
    private Camper currentCamper;
    private ArrayList<Medication> currentMedicationList;
    private Medication currentMedication;
    private ArrayList<String> currentAllergyList;
    private Contact currentContact;
    private ArrayList<Cabin> currentSessionCabins;
    private ArrayList<Camper> currentCabinsCampers;
    private HashMap<Day, Schedule> currentCabinsSchedule;




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
        this.currentSessionList = this.camp.getSessions();
        this.currentFaqList = this.camp.getFAQs();
        this.currentActivityList = this.camp.getActivities();
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
        this.currentFaqList = this.camp.getFAQs();
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
            return currentFaq.setQuestion(change);
        }
        if(variableName.equals(ANSWER)) {
            return currentFaq.setAnswer(change);
        }
        return false;
    }

    // ------------------------------ ARRAY LISTS ---------------------------




    // ********************************** SESSION CLASS ***************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside session
     */
    public void updateSession(String keyword) {
        this.currentSession = this.camp.getSession(keyword);
        this.currentSessionCabins = this.currentSession.getCabins();
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
    public void updateCabin(int index) {
        this.currentCabin = this.currentSessionCabins.get(index);
        this.currentCabinsCampers = this.currentCabin.getCampers();
        this.currentCabinsSchedule = this.currentCabin.getSchedule();
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets the counselor for the current cabin
     * @return the counselor of the cabin
     */
    public Counselor getCabinCounselor() {
        return currentCabin.getCounselor();
    }
    
    /**
     * Sets the counselor for the current cabin
     * @param counselor the counselor to set as the new counselor
     * @return true if successful, false if not successful
     */
    public boolean setCabinCounselor(Counselor counselor) {
        return currentCabin.setCounselor(counselor);
    }

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current camper list, (which should be in a cabin object)
     * @return an arraylist of campers
     */
    public ArrayList<Camper> getCabinCamperList() {
        return currentCamperList;
    }

    /**
     * Removes a camper from the current camper list (which should be in a cabin object)
     * @param index the index of the camper to be removed
     * @return the removed camper object
     */
    public Camper removeCabinCamper(int index) {
        return currentCamperList.remove(index);
    }

    /**
     * Adds a camper to the current camper list (which should be in a cabin object)
     * @param camper the new camper object to add
     * @return true if successful, false if not successful
     */
    public boolean addCabinCamper(Camper camper) {
        //TODO check if the camper already exists in this list
        return currentCamperList.add(camper);
    }

    /**
     * Gets the current schedule hash (which should be in a cabin object)
     * @return a hash map of days by schedules
     */
    public HashMap<Day, Schedule> getCabinScheduleHash() {
        return currentScheduleHash;
    }

    /**
     * Removes a schedule from the current schedule hash (which should be in a cabin object)
     * @param day the day of the schedule to be removed
     * @return the removed schedule object
     */
    public Schedule removeCabinSchedule(Day day) {
        return currentScheduleHash.remove(day);
    }

    /**
     * Adds a schedule to the current schedule hash (which should be in a cabin object)
     * @param day the day that the new schedule should be linked to, must be linked to a null object
     * @param schedule the schedule being added to the day
     * @return true if successful, false if not successful
     */
    public boolean addCabinSchedule(Day day, Schedule schedule) {
        return currentScheduleHash.replace(day, null, schedule);
    }

    


    // ***************************** SCHEDULE CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside counselor
     */
    public void updateSchedule(Day day) {
        this.currentSchedule = this.currentCabinsSchedule.get(day);
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current schedule hash (which should be in a cabin object)
     * @return a hash map of days by schedules
     */
    public Schedule getSchedule() {
        return currentSchedule;
    }

    /**
     * Removes an activity from the current schedule (which should be in a schedule object)
     * @param day the time of the activity to be removed
     * @return the removed activity string
     */
    public String removeScheduleActivity(String time) {
        return currentSchedule.remove(time);
    }

    /**
     * Adds an activity to the current schedule (which should be in a schedule object)
     * @param time the time that the new activity should be linked to, must be linked to a null string
     * @param activity the activity being added to the day
     * @return true if successful, false if not successful
     */
    public boolean addScheduleActivity(String time, String activity) {
        return currentSchedule.add(time, activity);
    }




    // ***************************** USER CLASS ***********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside user 
     * MIGHT JUST BE SIGN IN? not entirely sure
     */
    public void updateUser() {
        // "i don't know entirely what that is"
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current user object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getUserString(String variableName) {
        if(variableName.equals(NAME)) {
            return currentUser.getName();
        }
        if(variableName.equals(EMAIL)) {
            return currentUser.getEmail();
        }
        if(variableName.equals(PHONE)) {
            return currentUser.getPhoneNumber();
        }
        if(variableName.equals(PASSWORD)) {
            return currentUser.getPassword();
        }
        return null;
    }
    
    /**
     * Sets any string instance variable in the current user object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setUserString(String variableName, String change) {
        if(variableName.equals(NAME)) {
            return currentUser.setName(change);
        }
        if(variableName.equals(EMAIL)) {
            return currentUser.setEmail(change);
        }
        if(variableName.equals(PHONE)) {
            return currentUser.setPhoneNumber(change);
        }
        if(variableName.equals(PASSWORD)) {
            return currentUser.setPassword(change);
        }
        return false;
    }

    // ------------------------------ ARRAY LISTS ---------------------------




    // ***************************** DIRECTOR CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside director
     */
    public void updateDirector() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    
    // ------------------------------ ARRAY LISTS ---------------------------




    // ***************************** COUNSELOR CLASS ****************************************** //DO SOMETHING ABOUT EMERGENCY CONTACTS, CABIN, AND SESSION
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside counselor
     */
    public void updateCounselor() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current counselor object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getCounselorString(String variableName) {
        if(variableName.equals(BIO)) {
            return currentCounselor.getBio();
        } 
        return null;
    }

    /**
     * Sets any string instance variable in the current counselor object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCounselorString(String variableName, String change) {
        if(variableName.equals(BIO)) {
            return currentCounselor.setBio(change);
        } 
        return false;
    }

    /**
     * Gets any date instance variable in the current counselor object
     * @param variableName the name of the date instance variable wanted
     * @return the date of the variableName, null if not found
     */
    public Date getCounselorDate(String variableName) {
        if(variableName.equals(BIRTHDAY)) {
            return currentCounselor.getBirthday();
        } 
        return null;
    }

    /**
     * Sets any string instance variable in the current counselor object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCounselorDate(String variableName, Date change) {
        if(variableName.equals(BIRTHDAY)) {
            return currentCounselor.setBirthday(change);
        } 
        return false;
    }

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current allergy list, (which should be in counselor object)
     * @return an arraylist of allergies (strings)
     */
    public ArrayList<String> getCounselorAllergyList() {
        return currentAllergyList;
    }

    /**
     * Removes an allergy from the current allergy list (which should be in a cousnelor object)
     * @param index the index of the cabin to be removed
     * @return the removed allergy string
     */
    public String removeCounselorAllergy(int index) {
        return currentAllergyList.remove(index);
    }

    /**
     * Adds an allergy to the current allergy list (which should be in a counselor object)
     * @param allergy the string of the new allergy
     * @return true if successful, false if not successful
     */
    public boolean addCousnelorAllergy(String allergy) {
        //TODO check if the allergy already exists in this list
        return currentAllergyList.add(allergy);
    }




    // ***************************** GUARDIAN CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside guardian
     */
    public void updateGuardian() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any int instance variable in the current guardian object
     * @param variableName the name of the int instance variable
     * @return the int value in the variableName, -1 if not found
     */
    public int getGuardianInt(String variableName) {
        if(variableName.equals(SESS_NUM)) {
            return currentGuardian.getTotalSessions();
        }
        return -1;
    }

    /**
     * Sets any int instance variable in the current guardian object with a new value
     * @param variableName the name of the int instance variable being edited
     * @param change the new int to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setGuardianInt(String variableName, int change) {
        if(variableName.equals(SESS_NUM)) {
            return currentGuardian.setTotalSessions(change);
        }
        return false;
    }

    /**
     * Gets any double instance variable in the current guardian object
     * @param variableName the name of the double instance variable
     * @return the double value in the variableName, -1 if not found
     */
    public double getGuardianDouble(String variableName) {
        if(variableName.equals(PRICE)) {
            return currentGuardian.getPrice();
        }
        return -1;
    }

    /**
     * Sets any double instance variable in the current guardian object with a new value
     * @param variableName the name of the double instance variable being edited
     * @param change the new dobule to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setGuardianDouble(String variableName, double change) {
        if(variableName.equals(PRICE)) {
            return currentGuardian.setPrice(change);
        }
        return false;
    }
    
    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current camper list, (which should be in a guardian object)
     * @return an arraylist of campers
     */
    public ArrayList<Camper> getGuardianCamperList() {
        return currentCamperList;
    }

    /**
     * Removes a camper from the current camper list (which should be in a guardian object)
     * @param index the index of the camper to be removed
     * @return the removed camper object
     */
    public Camper removeGuardianCamper(int index) {
        return currentCamperList.remove(index);
    }

    /**
     * Adds a camper to the current camper list (which should be in a guardian object)
     * @param camper the new camper object
     * @return true if successful, false if not successful
     */
    public boolean addGuardianCamper(Camper camper) {
        //TODO check if the camper already exists in this list
        return currentCamperList.add(camper);
    }




    // ***************************** CAMPER CLASS ********************************************* //DO SOMETHING ABOUT EMERGENCY CONTACTS, CABIN, AND SESSIONS
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside camper
     */
    public void updateCamper() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current camper object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getCamperString(String variableName) {
        if(variableName.equals(NAME)) {
            return currentCamper.getName();
        } 
        return null;
    }

    /**
     * Sets any string instance variable in the current camper object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCamperString(String variableName, String change) {
        if(variableName.equals(NAME)) {
            return currentCamper.setName(change);
        } 
        return false;
    }

    /**
     * Gets any date instance variable in the current camper object
     * @param variableName the name of the date instance variable wanted
     * @return the date of the variableName, null if not found
     */
    public Date getCamperDate(String variableName) {
        if(variableName.equals(BIRTHDAY)) {
            return currentCounselor.getBirthday();
        } 
        return null;
    }

    /**
     * Sets any string instance variable in the current camepr object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCamperDate(String variableName, Date change) {
        if(variableName.equals(BIRTHDAY)) {
            return currentCounselor.setBirthday(change);
        } 
        return false;
    }

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current allergy list, (which should be in camper object)
     * @return an arraylist of allergies (strings)
     */
    public ArrayList<String> getCamperAllergyList() {
        return currentAllergyList;
    }

    /**
     * Removes an allergy from the current allergy list (which should be in a camper object)
     * @param index the index of the cabin to be removed
     * @return the removed allergy string
     */
    public String removeCamperAllergy(int index) {
        return currentAllergyList.remove(index);
    }

    /**
     * Adds an allergy to the current allergy list (which should be in a camper object)
     * @param allergy the string of the new allergy
     * @return true if successful, false if not successful
     */
    public boolean addCamperAllergy(String allergy) {
        //TODO check if the allergy already exists in this list
        return currentAllergyList.add(allergy);
    }

    /**
     * Gets the current medication list, (which should be in camper object)
     * @return an arraylist of medications
     */
    public ArrayList<Medication> getCamperMedicationList() {
        return currentMedicationList;
    }

    /**
     * Removes a medication from the current medication list (which should be in a camper object)
     * @param index the index of the cabin to be removed
     * @return the removed medication object
     */
    public Medication removeCamperMedication(int index) {
        return currentMedicationList.remove(index);
    }

    /**
     * Adds an medication to the current medication list (which should be in a camper object)
     * @param allergy the string of the new medication
     * @return true if successful, false if not successful
     */
    public boolean addCamperMedication(int dose, String type, String time) {
        //TODO check if the allergy already exists in this list
        return currentAllergyList.add(new Medication(dose, type, time));
    }




    // ***************************** MEDICATION CLASS *****************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside  medication
     */
    public void updateMedication() {
        
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current medication object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getMedicationString(String variableName) {
        if(variableName.equals(TYPE)) {
            return currentMedication.getType();
        }
        if(variableName.equals(TIME)) {
            return currentMedication.getTime();
        }
        return null;
    }
    
    /**
     * Sets any string instance variable in the current medication object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setMedicationString(String variableName, String change) {
        if(variableName.equals(TYPE)) {
            return currentMedication.setType(change);
        }
        if(variableName.equals(TIME)) {
            return currentMedication.setTime(change);
        }
        return false;
    }

    /**
     * Gets any int instance variable in the current medication object
     * @param variableName the name of the int instance variable
     * @return the int value in the variableName, -1 if not found
     */
    public int getMedicationInt(String variableName) {
        if(variableName.equals(DOSE)) {
            return currentMedication.getDose();
        }
        return -1;
    }

    /**
     * Sets any int instance variable in the current medication object with a new value
     * @param variableName the name of the int instance variable being edited
     * @param change the new int to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setMedicationInt(String variableName, int change) {
        if(variableName.equals(DOSE)) {
            return currentMedication.setDose(change);
        }
        return false;
    }
    
    // ------------------------------ ARRAY LISTS ---------------------------



    // ***************************** EMERGENCY CONTACTS CLASS ********************************* //MAYBE NOT NECESSARY IF WE DECIDE WHAT TO DO
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
    /**
     * Gets any string instance variable in the current contact object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getContactString(String variableName) {
        if(variableName.equals(NAME)) {
            return currentContact.getName();
        }
        if(variableName.equals(EMAIL)) {
            return currentContact.getEmail();
        }
        if(variableName.equals(PHONE)) {
            return currentContact.getPhoneNumber();
        }
        return null;
    }
    
    /**
     * Sets any string instance variable in the current contact object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setContactString(String variableName, String change) {
        if(variableName.equals(NAME)) {
            return currentContact.setName(change);
        }
        if(variableName.equals(EMAIL)) {
            return currentContact.setEmail(change);
        }
        if(variableName.equals(PHONE)) {
            return currentContact.setPhoneNumber(change);
        }
        return false;
    }
    
    // ------------------------------ ARRAY LISTS ---------------------------


}
