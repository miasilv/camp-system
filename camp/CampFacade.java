package camp;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * @author Mia Silver
 * A Camp Facade object
 */
public class CampFacade {
    // ------------------------- CURRENT ARRAYLISTS/OBJECTS -----------------
    private UserList userList;
    private CampList camplist;
    private SessionList sessionList;
    private CabinList cabinList;
    private CamperList camperList;
    private CounselorList counselorList;


    private Camp camp; 
    private ArrayList<FAQ> currentFaqList;
    private FAQ currentFaq;
    private ArrayList<String> currentActivityList;
    private ArrayList<Session> currentCampSessionList;
    private Session currentSession;
    private ArrayList<Cabin> currentSessionCabinList;
    private Cabin currentCabin;
    private ArrayList<Camper> currentCabinCamperList;
    private ArrayList<Counselor> currentCabinCounselorList;
    private HashMap<Day, Schedule> currentScheduleHash;
    private Schedule currentSchedule;
    
    private User currentUser; // the person using it
    private Director currentDirector;
    private Counselor currentCounselor;
    private HashMap<String, Contact> currentContactHash;
    private HashMap<Session, Cabin> currentCabinHash;
    private ArrayList<String> currentCounselorAllergyList;
    private ArrayList<Session> currentCounselorSessions;
    private ArrayList<Cabin> currentCounselorCabins;
    private Guardian currentGuardian;
    private ArrayList<Camper> currentGuardianCamperList;
    private Camper currentCamper;
    private ArrayList<Session> currentCamperSessions;
    private ArrayList<Cabin> currentCamperCabins;
    private ArrayList<Medication> currentMedicationList;
    private Medication currentMedication;
    private ArrayList<String> currentCamperAllergyList;
    private Contact currentContact;

    //-------------------Classes (and in some cases instance variables)
	private static final String CAMP = "camp";
	private static final String FAQ = "faq"; //also in camp
    private static final String SESSION = "session"; //also in camper and camp
    private static final String CABIN = "cabin"; //also in session, counselor, and camper
	private static final String SCHEDULE = "schedule"; //also in cabin
    private static final String USER = "user";
    private static final String COUNSELOR = "counselor"; //also in cabin
	private static final String GUARDIAN = "guardian"; 
    private static final String CAMPER = "camper"; //also in cabin and guardian
    private static final String MEDICATION = "medication"; //also in camper
    private static final String CONTACT = "contact"; //also in counselor and camper


    //------------- INSTANCE VARIABLES (NOT OBJECTS) ------------------------
    //camp instance variables
	private static final String NAME = "name"; //can also use for User, Camper, and Contact
    private static final String PRICE = "price"; //can also use for Guardian
    private static final String RATIO = "campers per counselor";
	private static final String ACTIVITIES = "activitiy";

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String THEME = "session theme";
	private static final String SESS_DESCR = "session description"; 
	private static final String START_DATE = "start date";
	private static final String END_DATE = "enddate";

	//cabin instance variables
    private static final String VITALS = "cabin vitals information";
    private static final String MAX_AGE = "max age";
    private static final String MIN_AGE = "min age";

	//user instance variables
	private static final String EMAIL = "email"; //can also be used for Contact
	private static final String PHONE = "phone number"; //can also be used for Contact
	private static final String PASSWORD = "password";

	//guardian instance variables
	private static final String SESS_NUM = "total number of sessions";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String BIRTHDAY = "birthday"; //can also be used for Camper
	private static final String ALLERGIES = "allergy"; //can also be used for Camper

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";
    private static final String ADDRESS = "address";

	//medication instance variables
    private static final String DOSE = "dose";
    private static final String TYPE = "type";
    private static final String TIME = "time";

    public CampFacade() {
        camperList = CamperList.getInstance();
        counselorList = CounselorList.getInstance();
        cabinList = CabinList.getInstance();
        sessionList = SessionList.getInstance();
        userList = UserList.getInstance();
        camplist = CampList.getInstance();
        initArrayLists();
    }

    private void initArrayLists() {
        currentActivityList = new ArrayList<String>();
        currentCampSessionList = new ArrayList<Session>();
        currentSessionCabinList = new ArrayList<Cabin>();
        currentCabinCamperList = new ArrayList<Camper>();
        currentCabinCounselorList = new ArrayList<Counselor>();
        currentGuardianCamperList = new ArrayList<Camper>();
        currentMedicationList = new ArrayList<Medication>();
        currentCamperAllergyList = new ArrayList<String>();
        currentCamperSessions = new ArrayList<Session>();
        currentCamperCabins = new ArrayList<Cabin>();
        currentCounselorAllergyList = new ArrayList<String>();
        currentScheduleHash = new HashMap<Day, Schedule>();
        currentContactHash = new HashMap<String, Contact>();
        currentCabinHash = new HashMap<Session, Cabin>();
    }

    public void save() {
        
        DataWriter.saveCampers();
        DataWriter.saveCounselors();
        DataWriter.saveCabin();
        DataWriter.saveDirectors();
        DataWriter.saveGuardians();
        DataWriter.saveSessions();
        DataWriter.saveCamp();
    }

    // ***************************** CAMP CLASS ***********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside camp
     */
    public void updateCamp() {
        //System.out.println("Size" + camplist.getCamps().size());
        this.camp = camplist.getCamps().get(0);
        this.currentCampSessionList = this.camp.getSessions();
        this.currentFaqList = this.camp.getFAQs();
        this.currentActivityList = this.camp.getActivities();

        //this is only for 
        this.currentSession = this.currentCampSessionList.get(0);
        this.currentSessionCabinList = this.currentSession.getCabins();
        this.currentCabin = this.currentSessionCabinList.get(0);
        this.currentScheduleHash = this.currentCabin.getSchedule();
        this.currentSchedule = this.currentScheduleHash.get(Day.MONDAY);
        this.currentSchedule.setActivityList(currentActivityList);
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
    public double getCampInt(String variableName) {
        if(variableName.equals(RATIO)) {
            return camp.getRatio();
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
            return camp.getPrice();
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
        return camp.getFAQs();
    }

    /**
     * Removes an faq from the current faq list (which should be in a camp object)
     * @param index the index of the faq to be removed
     * @return true if successful, false if not
     */
    public boolean removeCampFAQ(int index) {
        return camp.removeFAQ(index);
    }

    /**
     * Adds an faq to the current faq list (which should be in a camp object)
     * @param question the question for the new faq object
     * @param answer the answer for the new faq object
     * @return true if successful, false if not successful
     */
    public boolean addCampFAQ(String question, String answer) {
        return camp.addFAQ(question, answer);
    }

    /**
     * Gets the current activity list, (which should be in camp object)
     * @return an arraylist of activities (strings)
     */
    public ArrayList<String> getCampActivities() {
        return camp.getActivities();
    }
    
    /**
     * Removes an activity from the current activity list (which should be in a camp object)
     * @param index the index of the activity to be removed
     * @return true if successful, false if not
     */
    public boolean removeCampActivity(int index) {
        return camp.removeActivity(index);
    }

    /**
     * Adds an activity to the current activity list (which should be in a camp object)
     * @param activity the activity to be added to the list
     * @return true if successful, false if not successful
     */
    public boolean addCampActivity(String activity) {
        return camp.addActivity(activity);
    }

    /**
     * Gets the current session list, (which should be in camp object)
     * @return an arraylist of sessions
     */
    public ArrayList<Session> getCampSessions() {
        return camp.getSessions();
    }

    /**
     * Removes a session from the current session list (which should be in a camp object)
     * @param index the index of the session to be removed
     * @return true if successful, false if not
     */
    public boolean removeCampSession(int index) {
        Session session = camp.removeSession(index);
        return sessionList.getSessions().remove(session);
    }

    /**
     * Adds an activity to the current session list (which should be in a camp object)
     * @param sessionNumber the session number
     * @param startDate the start date of the session
     * @param endDate the end date of the session
     * @return true if successful, false if not successful
     */
    public boolean addCampSession(String theme, String sessionDescription, Date startDate, Date endDate) {
        Session session = new Session(theme, sessionDescription, startDate, endDate);
        boolean bool =  camp.addSession(session);
        sessionList.getSessions().add(session);
        return bool;
    }
    


    // ***************************** FAQ CLASS ************************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside faq
     */
    public void updateFAQ(int index) {
        this.currentFaq = currentFaqList.get(index);
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
    public boolean updateSession(int index) {
        this.currentSession = this.camp.getSession(index);
        for(int i = 0; i < sessionList.getSessions().size(); i++) {
            if(currentSession.equals(sessionList.getSessions().get(i))) {
                currentSession = sessionList.getSessions().get(i);
            }
        }
        this.currentSessionCabinList = this.currentSession.getCabins();
        return true;
    }
    
    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any string instance variable in the current session object
     * @param variableName the name of the string instance variable wanted
     * @return the string of the variableName, null if not found
     */
    public String getSessionString(String variableName) {
        if(variableName.equals(THEME)) {
            return currentSession.getTheme();
        }
        if(variableName.equals(SESS_DESCR)) {
            return currentSession.getDescription();
        }
        return null;
    }

    /**
     * Sets any string instance variable in the current session object with a new value
     * @param variableName the name of the string instance variable being edited
     * @param change the new string to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setSessionString(String variableName, String change) {
        if(variableName.equals(THEME)) {
            return currentSession.setTheme(change);
        }
        if(variableName.equals(SESS_DESCR)) {
            return currentSession.setDescription(change);
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
        return currentSession.getCabins();
    }

    /**
     * Removes a dabin from the current cabin list (which should be in a session object)
     * @param index the index of the cabin to be removed
     * @return true if successful, false if not
     */
    public boolean removeSessionCabin(int index) {
        Cabin cabin = currentSession.removeCabin(index);
        return cabinList.getCabins().remove(cabin);
    }

    /**
     * Adds a cabin to the current cabin list (which should be in a session object)
     * @param minAge the minimum age for the cabin
     * @param maxAge the maximum age for the cabin
     * @param bedNum the number of beds in the cabin
     * @return true if successful, false if not successful
     */
    public boolean addSessionCabin(int minAge, int maxAge) {        
        Cabin cabin = new Cabin(minAge, maxAge);
        boolean bool2 = currentSession.addCabin(cabin);
        cabinList.getCabins().add(cabin);
        return bool2;
    }

    



    // ***************************** CABIN CLASS **********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside cabin
     */
    public void updateCabin(int index) {
        this.currentCabin = currentSessionCabinList.get(index);
        for(int i = 0; i < cabinList.getCabins().size(); i++) {
            if(currentCabin.equals(cabinList.getCabins().get(i))) {
                currentCabin = cabinList.getCabins().get(i);
            }
        }
        this.currentCabinCamperList = this.currentCabin.getCampers();
        this.currentScheduleHash = this.currentCabin.getSchedule();
    }

    /**
     * updates the cabin object from a session-cabin hash
     * @param key the session theme for the cabin you're looking for
     */ 
    public boolean updateCabinHash(Session session) {
        this.currentCabin = this.currentCabinHash.get(session);
        for(int i = 0; i < cabinList.getCabins().size(); i++) {
            if(currentCabin.equals(cabinList.getCabins().get(i))) {
                this.currentCabin = cabinList.getCabins().get(i);
            }
        }
        if(this.currentCabin == null) {
            return false;
        }
        this.currentCabinCamperList = this.currentCabin.getCampers();
        this.currentCabinCounselorList = this.currentCabin.getCounselors();
        this.currentScheduleHash = this.currentCabin.getSchedule();
        return true;
    }
    
    /**
     * Returns all cabins in the camplist
     * @return an array list of cabins
     */
    public ArrayList<Cabin> getAllCabins() {
        return CabinList.getInstance().getCabins();
    }
    
    // ------------------------ INSTANCE VARIALBES --------------------------
    /**
     * Gets any String instance variable in the current cabin object
     * @param variableName the name of the string instance variable
     * @return the string value in the variableName, null if not found
     */
    public String getCabinString(String variableName) {
        if(variableName.equals(VITALS)) {
            return currentCabin.getVitals();
        }
        return null;
    }
    
    /**
     * Gets any int instance variable in the current cabin object
     * @param variableName the name of the int instance variable
     * @return the int value in the variableName, -1 if not found
     */
    public double getCabinInt(String variableName) {
        if(variableName.equals(MAX_AGE)) {
            return currentCabin.getMaxAge();
        }
        if(variableName.equals(MIN_AGE)) {
            return currentCabin.getMinAge();
        }
        return -1;
    }

    /**
     * Sets any int instance variable in the current session object with a new value
     * @param variableName the name of the int instance variable being edited
     * @param change the new int to place in the instance variable
     * @return true if successful, false if not successful
     */
    public boolean setCabinInt(String variableName, int change) {
        if(variableName.equals(MAX_AGE)) {
            return currentCabin.setMaxAge(change);
        }
        if(variableName.equals(MIN_AGE)) {
            return currentCabin.setMinAge(change);
        }
        return false;
    }
    
    /**
     * Gets the counselor for the current cabin
     * @return the counselor of the cabin
     */
    public ArrayList<Counselor> getCabinCounselor() {
        return currentCabin.getCounselors();
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
        return currentCabin.getCampers();
    }

    /**
     * Gets the current schedule hash (which should be in a cabin object)
     * @return a hash map of days by schedules
     */
    public HashMap<Day, Schedule> getCabinScheduleHash() {
        return currentCabin.getSchedule();
    }



    // ***************************** SCHEDULE CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside counselor
     */
    public void updateSchedule(Day day) {
        this.currentSchedule = this.currentScheduleHash.get(day);
        currentSchedule.setActivityList(camp.getActivities());
    }

    // ------------------------ INSTANCE VARIALBES --------------------------

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current schedule hash (which should be in a cabin object)
     * @return a hash map of days by schedules
     */
    public HashMap<String, String> getSchedule() {
        return currentSchedule.getSchedule();
    }

    /**
     * Removes an activity from the current schedule (which should be in a schedule object)
     * @param day the time of the activity to be removed
     * @return true if successful, false if not
     */
    public boolean removeScheduleActivity(String time) {
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
     */
    public boolean signIn(String email, String password) {
        while(true) {
            if((!(userList.getUser(email) == null) && userList.getUser(email).getPassword().equals(password))) {
                currentUser = userList.getUser(email);
                return true;
            }
            if(!(counselorList.getCounselor(email) == null) && counselorList.getCounselor(email).getPassword().equals(password)){
                currentUser = counselorList.getCounselor(email);
                return true;
            }
            return false;
        }
    }

    /**
     * Gets the current user
     * @return the current user
     */
    public User getUser() {
        return currentUser;
    }

    /**
     * Returns a list of all counselors
     * @return an array list of all counselors
     */
    public ArrayList<Counselor> getAllCounselors() {
        return counselorList.getCounselors();
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
        this.currentDirector = (Director)currentUser;
    }

    // ------------------------ INSTANCE VARIALBES --------------------------
    
    // ------------------------------ ARRAY LISTS ---------------------------




    // ***************************** COUNSELOR CLASS ******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside counselor
     */
    public boolean updateCounselor() {
        this.currentCounselor = (Counselor)currentUser;
        currentCounselorAllergyList = currentCounselor.getAllergies();
        currentContactHash = currentCounselor.getEmergencyContacts();
        currentCabinHash = currentCounselor.getCounselorCabinHash();

        currentCounselorSessions = camp.getCounselorsSessions(currentCounselor);
        currentCounselorCabins = new ArrayList<>();
        for(int i = 0; i < currentCounselorSessions.size(); i++) {
            Cabin cabin = currentCounselorSessions.get(i).findCounselor(currentCounselor);
            if(!(cabin == null)) {
                currentCounselorCabins.add(cabin);
            }
            else {
                currentCounselorSessions.remove(i);
            }
        }
        for(int i = 0; i < currentCounselorSessions.size(); i++) {
            currentCounselor.updateCounselorCabinHash(currentCounselorSessions.get(i), currentCounselorCabins.get(i));
        }
        return true;
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
        return currentCounselor.getAllergies();
    }

    /**
     * Removes an allergy from the current allergy list (which should be in a cousnelor object)
     * @param index the index of the cabin to be removed
     * @return true if successful, false if not
     */
    public boolean removeCounselorAllergy(int index) {
        return currentCounselor.removeAllergy(index);
    }

    /**
     * Adds an allergy to the current allergy list (which should be in a counselor object)
     * @param allergy the string of the new allergy
     * @return true if successful, false if not successful
     */
    public boolean addCounselorAllergy(String allergy) {
        return currentCounselor.addAllergy(allergy);
    }

    /**
     * Gets the current emergency contact hash (which should be in a counselor object)
     * @return a hash map of relationships by contact
     */
    public HashMap<String, Contact> getCounselorContactHash() {
        return currentCounselor.getEmergencyContacts();
    }

    /**
     * Removes a contact from the current contact hash (which should be in a counselor object)
     * @param day the relationship of the contact to be removed
     * @return true if successful, false if not
     */
    public boolean removeCounselorContact(String relationship) {
        return currentCounselor.removeEmergencyContact(relationship);
    }

    /**
     * Adds a contact to the current contact hash (which should be in a counselor object)
     * @param day the relationship that the new contact should be linked to, must be linked to a null object
     * @param schedule the contact being added to the relationship
     * @return true if successful, false if not successful
     */
    public boolean addCounselorContact(String relationship, String name, String email, String phone, String address) {
        return currentCounselor.addEmergencyContact(relationship, name, email, phone, address);
    }

    /**
     * Returns the array list of all the sessions the counselor is in
     * @return an array list of sessions
     */
    public ArrayList<Session> getCounselorSessions() {
        return currentCounselorSessions;
    }

    /**
     * Gets the current session,cabin hash (which should be in a counselor object)
     * @return a hash map of cabins by session
     */
    public HashMap<Session, Cabin> getCounselorCabinHash() {
        return currentCounselor.getCounselorCabinHash();
    }

    /**
     * Removes a session from the current session,cabin hash (which should be in a counselor object)
     * @param session the session to be removed
     * @return true if successful, false if not
     */
    public boolean removeCounselorSession(int index) {
        Session session = this.currentCounselorSessions.get(index);
        return(currentCounselor.removeSession(session) && currentSession.removeCounselor(currentCounselor));
    }

    /**
     * Adds a contact to the current contact hash (which should be in a counselor object)
     * @param session the session being added to the camper
     * @return true if successful, false if not successful
     */
    public boolean addCounselorSession(int sessionIndex, int cabinIndex) {
        Session session = camp.getSession(sessionIndex);
        System.out.println(session);
        Cabin cabin = session.placeCounselor(currentCounselor, cabinIndex);
        if(cabin == null) {
            return false;
        }
        return (currentCounselor.addSession(session, cabin) && currentSession.placeCounselor(currentCounselor, cabinIndex) != null);
    }



   
    // ***************************** GUARDIAN CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside guardian
     */
    public void updateGuardian() {
        this.currentGuardian = (Guardian)currentUser;
        this.currentGuardianCamperList = currentGuardian.getCampers();
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

    
    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current camper list, (which should be in a guardian object)
     * @return an arraylist of campers
     */
    public ArrayList<Camper> getGuardianCamperList() {
        return currentGuardian.getCampers();
    }

    /**
     * Removes a camper from the current camper list (which should be in a guardian object)
     * @param index the index of the camper to be removed
     * @return the removed camper object
     */
    public boolean removeGuardianCamper(int index) {
        Camper camper = currentGuardian.removeCamper(index);
        return camperList.getCampers().remove(camper);
    }

    /**
     * Adds a camper to the current camper list (which should be in a guardian object)
     * @param camper the new camper object
     * @return true if successful, false if not successful
     */
    public boolean addGuardianCamper(String name, Date birthday) {
        Camper camper = new Camper(name, birthday);
        boolean bool4 = currentGuardian.addCamper(camper);
        camperList.getCampers().add(camper);
        return bool4;
    }



    // ***************************** CAMPER CLASS *********************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside camper
     */
    public boolean updateCamper(String classFrom, int index) {
        if (classFrom.equals(GUARDIAN) && currentUser instanceof Guardian) {
            this.currentCamper = currentGuardian.getCamper(index);
        }
        else if (classFrom.equals(CABIN)) {
            this.currentCamper = currentCabin.getCamper(index);
        }
        else {
            return false;
        }

        for(int i =0; i < camperList.getCampers().size(); i++) {
            if(currentCamper.equals(camperList.getCampers().get(index))) {
                this.currentCamper = camperList.getCampers().get(index);
            }
        }


        currentContactHash = currentCamper.getCamperContactHash();
        currentMedicationList = currentCamper.getMedications();
        currentCamperAllergyList = currentCamper.getAllergies();
        currentCabinHash = currentCamper.getCamperCabinHash();

        currentCamperSessions = camp.getCampersSessions(currentCamper);
        currentCamperCabins = new ArrayList<>();
        for(int i = 0; i < currentCamperSessions.size(); i++) {
            Cabin cabin = currentCamperSessions.get(i).findCamper(currentCamper);
            if(!(cabin == null)) {
                currentCamperCabins.add(cabin);
            }
            else {
                currentCamperSessions.remove(i);
            }
        }
        for(int i = 0; i < currentCamperSessions.size(); i++) {
            currentCamper.addSession(currentCamperSessions.get(i), currentCamperCabins.get(i));
        }
        return true;
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
            return currentCamper.getBirthday();
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
            return currentCamper.setBirthday(change);
        } 
        return false;
    }

    // ------------------------------ ARRAY LISTS ---------------------------
    /**
     * Gets the current allergy list, (which should be in camper object)
     * @return an arraylist of allergies (strings)
     */
    public ArrayList<String> getCamperAllergyList() {
        return currentCamper.getAllergies();
    }

    /**
     * Removes an allergy from the current allergy list (which should be in a camper object)
     * @param index the index of the cabin to be removed
     * @return true if successful, false if not
     */
    public boolean removeCamperAllergy(int index) {
        return currentCamper.removeAllergy(index);
    }

    /**
     * Adds an allergy to the current allergy list (which should be in a camper object)
     * @param allergy the string of the new allergy
     * @return true if successful, false if not successful
     */
    public boolean addCamperAllergy(String allergy) {
        return currentCamper.addAllergy(allergy);
    }

    /**
     * Gets the current medication list, (which should be in camper object)
     * @return an arraylist of medications
     */
    public ArrayList<Medication> getCamperMedicationList() {
        return currentCamper.getMedications();
    }

    /**
     * Removes a medication from the current medication list (which should be in a camper object)
     * @param index the index of the cabin to be removed
     * @return true if successful, false if not
     */
    public boolean removeCamperMedication(int index) {
        return currentCamper.removeMedication(index);
    }

    /**
     * Adds an medication to the current medication list (which should be in a camper object)
     * @param dose string of the does for the new medication
     * @param type the type of medication 
     * @param time the time the new medication should be taken
     * @return true if successful, false if not successful
     */
    public boolean addCamperMedication(String dose, String type, String time) {
        return currentCamper.addMedication(new Medication(dose, type, time));
    }

    /**
     * Gets the current emergency contact hash (which should be in a camper object)
     * @return a hash map of relationships by contact
     */
    public HashMap<String, Contact> getCamperContactHash() {
        return currentCamper.getCamperContactHash();
    }

    /**
     * Removes a contact from the current contact hash (which should be in a camper object)
     * @param relationship the relationship of the contact to be removed
     * @return the removed contact object
     */
    public boolean removeCamperContact(String relationship) {
        return currentCamper.removeEmergencyContact(relationship);
    }

    /**
     * Adds a contact to the current contact hash (which should be in a camper object)
     * @param day the relationship that the new contact should be linked to, must be linked to a null object
     * @param schedule the contact being added to the relationship
     * @return true if successful, false if not successful
     */
    public boolean addCamperContact(String relationship, String name, String email, String phone, String address) {
        return currentCamper.addEmergencyContact(relationship, name, email, phone, address);
    }

    /**
     * Returns the array list of all the sessions the camper is in
     * @return an array list of sessions
     */
    public ArrayList<Session> getCamperSessions() {
        return currentCamperSessions;
    }

    /**
     * Gets the current session,cabin hash (which should be in a camper object)
     * @return a hash map of cabins by session
     */
    public HashMap<Session, Cabin> getCamperCabinHash() {
        return currentCamper.getCamperCabinHash();
    }

    /**
     * Removes a session from the current session,cabin hash (which should be in a camper object)
     * @param session the session to be removed
     * @return true if successful, false if not
     */
    public boolean removeCamperSession(int index) {
        Session session = this.currentCamperSessions.get(index);
        return(currentCamper.removeSession(session) && currentSession.removeCamper(currentCamper));
    }

    /**
     * Adds a contact to the current contact hash (which should be in a camper object)
     * @param session the session being added to the camper
     * @return true if successful, false if not successful
     */
    public boolean addCamperSession(int index) {
        Session session = camp.getSession(index);
        System.out.println(session);
        Cabin cabin = session.placeCamper(currentCamper);
        if(cabin == null) {
            System.out.println("place cabin doesn't work");
            return false;
        }
        return currentCamper.addSession(session, cabin);
    }






    // ***************************** MEDICATION CLASS *****************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside  medication
     */
    public void updateMedication(int index) {
        this.currentMedication = currentMedicationList.get(index);
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
        if(variableName.equals(DOSE)) {
            return currentMedication.getDose();
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
        if(variableName.equals(DOSE)) {
            return currentMedication.setDose(change);
        }
        return false;
    }
    
    // ------------------------------ ARRAY LISTS ---------------------------




    // ***************************** CONTACTS CLASS *******************************************
    /**
     * updates all the current classes/arraylists/hashmaps to be the ones inside contacts
     */
    public boolean updateContacts(String key) {
        if(currentContactHash.containsKey(key)) {
            this.currentContact = currentContactHash.get(key);
            return true;
        }
        return false;
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
        if(variableName.equals(ADDRESS)) {
            return currentContact.getAddress();
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
        if(variableName.equals(ADDRESS)) {
            return currentContact.setAddress(change);
        }
        return false;
    }
    
    // ------------------------------ ARRAY LISTS ---------------------------

}
