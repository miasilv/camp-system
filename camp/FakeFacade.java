import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/*
THIS CLASS IS SO UGLY AND SMELLY YOU SHOULD NEVER TOUCH IT OR USE IT, GROSS BABY"
- PORTIA PLANTE
*/

/**
 * @author Mia Silver
 * A Camp Facade Object
 */
public class FakeFacade {
    //array lists and objects
    private UserList userList;
    private Camp camp; 
    private ArrayList<FAQ> faqList;
    private FAQ faq;
    private ArrayList<String> activityList;
    private ArrayList<Session> sessionList;
    private Session session;
    private ArrayList<Cabin> cabinList;
    private Cabin cabin;
    private User user;
    //private Counselor counselor;
    //private Guardian guardian;
    //private Director director;
    private ArrayList<Camper> camperList;
    private ArrayList<Medication> medicationList;
    private Medication medication;
    private ArrayList<String> allergyList;

    //Strings for class
    private static final String CAMP = "camp";
	private static final String FAQ = "faq"; //also in camp (array list)
    private static final String SESSION = "session"; //also in camper and camp (array list)
    private static final String CABIN = "cabin"; //also in session, counselor, and camper (array list)
    private static final String USER = "user";
    private static final String DIRECTOR = "director";
    private static final String COUNSELOR = "counselor"; //also in cabin
    private static final String GUARDIAN = "guardian"; 
    private static final String CAMPER = "camper"; //also in cabin and guardian (array list)
    private static final String MEDICATION = "medication"; //also in camper (array list)
    private static final String EMERGENCY_CONTACT = "eContact"; //also in counselor and camper (hash map)

	//camp instance variables
	private static final String NAME = "name"; //can also use for User, Camper, and Contact
    private static final String PRICE = "price"; //can also use for Guardian
    private static final String RATIO = "ratio";
	private static final String ACTIVITIES = "activities"; //(array list)

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String SESS_NUM = "sessNum"; //can also be used in Guardian
	private static final String START_DATE = "startD";
	private static final String END_DATE = "endD";

	//cabin instance variables
	private static final String SCHEDULE = "schedule"; //can also use for schedule class (hash map)

	//user instance variables
	private static final String EMAIL = "email"; //can also be used for Contact
	private static final String PHONE = "phoneNum"; //can also be used for Contact
	private static final String PASSWORD = "password";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String BIRTHDAY = "birthday"; //can also be used for Camper
	private static final String ALLERGIES = "allergies"; //can also be used for Camper (array list)

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";

    //medication instance variables
    private static final String DOSE = "dose";
    private static final String TYPE = "type";
    private static final String TIME = "time";

	//edits for array lists
    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String EDIT = "edit";

    public FakeFacade() {
        //userList.getInstance();
        camp.getInstance();
    }

    public void editCampInformation(String variableName, String change) {
        if(variableName.equals(NAME)) {
           camp.setName(change);
        } 
        if(variableName.equals(SESSION)) { //array list
            //TODO
        }
        if(variableName.equals(PRICE)) {
            double price = Double.parseDouble(change);
            camp.setPricePerSession(price);
        }
        if(variableName.equals(RATIO)) {
            int ratio = Integer.parseInt(change);
            camp.setCampersPerCounselor(ratio);
        } 
        if(variableName.equals(FAQ)) { //array list
            //TODO
        }
        if(variableName.equals(ACTIVITIES)) { //array list
            //TODO
        }
    }

    /**
     * Edits a string instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the string instance variables in the given class
     * @param change the new information you want to put in
     * @param index if the information is in an array list, this is the index of the array list (-1 if not applicable)
     */
    public void editInformation(String className, String variableName, String change, int index) {
        if(className.equals(CAMP)) {
            if(variableName.equals(NAME)) {
                camp.setName(change);
            }
        }

        if(className.equals(FAQ)) {
            if(variableName.equals(QUESTION)) {
                faq.setQuestion(change);
            }
            if(variableName.equals(ANSWER)) {
                faq.setAnswer(change);
            }
        }

        if(className.equals(COUNSELOR) || className.equals(GUARDIAN) || className.equals(DIRECTOR)) {
            if(variableName.equals(NAME)) {
                user.setName(change);
            } 
            if(variableName.equals(EMAIL)) {
                user.setEmail(change);
            }
            if(variableName.equals(PHONE)) {
                user.setPhoneNumber(change);
            }
            if(variableName.equals(PASSWORD)) {
                user.setPassword(change);
            }
        }

        if(className.equals(COUNSELOR)) {
            if(variableName.equals(BIO)) {
                counselor.addBio();
            } 
        }

        if(className.equals(CAMPER)) {
            Camper camper = guardian.getCampers().get(index);
            if(variableName.equals(NAME)) {
                camper.setName();
            } 
        }

        if(className.equals(MEDICATION)) {

            if(variableName.equals(TYPE)) {
                //TODO
            }
            if(variableName.equals(TIME)) { 
                //TODO
            }
        }

        if(className.equals(EMERGENCY_CONTACT)) {
            if(variableName.equals(NAME)) {
                //TODO
            } 
            if(variableName.equals(PHONE)) {
                //TODO
            }
            if(variableName.equals(EMAIL)) {
                //TODO
            }
            if(variableName.equals(RELATIONSHIP)) {
                //TODO
            }
        }
        
    }

    /** Gets a string instance variable's information in a given class.
     * @param className the class that contains the information being returned 
     * @param type any of the string instance variables in Camp
     * @param index if the type is found in an array list, the index is the index of the object being edited, if not index = -1
     * @return the string instance variable
    */
    public String getStringInformation(String className, String variableName) {
        if(className.equals(CAMP)) {
            if(variableName.equals(NAME)) {
                return camp.getName();
            }
        }

        if(className.equals(FAQ)) {
            if(variableName.equals(QUESTION)) {
                return faq.getQuestion();
            }
            if(variableName.equals(ANSWER)) {
                return faq.getAnswer();
            }
        }

        if(className.equals(GUARDIAN) || className.equals(DIRECTOR) || className.equals(COUNSELOR)) {
            if(variableName.equals(NAME)) {
                return user.getName();
            } 
            if(variableName.equals(EMAIL)) {
                return user.getEmail();
            }
            if(variableName.equals(PHONE)) {
                return user.getPhoneNumber();
            }
            if(variableName.equals(PASSWORD)) {
                return user.getPassword();
            }
        }

        if(className.equals(COUNSELOR)) {
            if(variableName.equals(BIO)) {
                return counselor.getBio();
            } 
        }

        if(className.equals(CAMPER)) {
            if(variableName.equals(NAME)) {
                return camper.getName();
            } 
        }

        if(className.equals(MEDICATION)) {
            if(variableName.equals(TYPE)) {
                return medication.getType();
            }
            if(variableName.equals(TIME)) { 
                //TODO
            }
        }

        if(className.equals(EMERGENCY_CONTACT)) {
            if(variableName.equals(NAME)) {
                //TODO
            } 
            if(variableName.equals(PHONE)) {
                //TODO
            }
            if(variableName.equals(EMAIL)) {
                //TODO
            }
            if(variableName.equals(RELATIONSHIP)) {
                //TODO
            }
        }
        return "Not Found";
    }

    /**
     * Edits an int instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the int instance variables in the given class
     * @param change the new information you want to put in
     */
    public void editInformation(String className, String variableName, int change) {
        if(className.equals(CAMP)) {
            if(variableName.equals(RATIO)) {
                //TODO
            } 
        }

        if(className.equals(SESSION)) {
            if(variableName.equals(SESS_NUM)) {
                //TODO
            }
        }

        if(className.equals(GUARDIAN)) {
            if(variableName.equals(SESS_NUM)) {
                //TODO
            }
        }

        if(className.equals(MEDICATION)) {
            if(variableName.equals(DOSE)) {
                //TODO
            }
        }
    }

    /**
     * Edits a double instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the double instance variables in the given class
     * @param change the new information you want to put in
     */
    public void editInformation(String className, String variableName, double change) {
        if(className.equals(CAMP)) {
            if(variableName.equals(PRICE)) {
                //TODO
            }
        }

        if(className.equals(GUARDIAN)) {
            if(variableName.equals(PRICE)) { 
                //TODO
            }
        }

        
    }

    /**
     * Edits a Date instance variable in a given class.
     * @param className the class that contains the information being edited.
     * @param type any of the Date instance variables in the given class
     * @param change the new information you want to put in
     * @return true if successfully changed, false if not
     */
    public void editInformation(String className, String variableName, Date change) {
        if(className.equals(SESSION)) {
            if(variableName.equals(START_DATE)) {
                //TODO
            }
            if(variableName.equals(END_DATE)) {
                //TODO
            }
        }

        if(className.equals(COUNSELOR)) {
            if(variableName.equals(BIRTHDAY)) {
                //TODO
            }
        }

        if(className.equals(CAMPER)) {
            if(variableName.equals(BIRTHDAY)) {
                //TODO
            }
        }
    }

    /**
     * Remove an object from any array list
     * @param className the class that this array list is found in
     * @param arrayList the name of the array list
     * @param index the index you are attempting to remove
     * @return true if successfully removed, false if not
     */
    public boolean removeArrayListObject(String className, String arrayList, int index) {
        if(arrayList.equals(SESSION)) {
            getSessionList(className);
            if(index >= sessionList.size()) {
                return false;
            }
            sessionList.remove(index);
            return true;
        }
        else if (arrayList.equals(FAQ)) {
            getFAQList(className);
            if(index >= faqList.size()) {
                return false;
            }
            faqList.remove(index);
            return true;
        }
        else if(arrayList.equals(ACTIVITIES)) {
            getActivityList(className);
            if(index >= activityList.size()) {
                return false;
            }
            activityList.remove(index);
            return true;
        }
        else if(arrayList.equals(CABIN)) {
            ArrayList<Cabin> list = getCabinList(className);
            if(index >= list.size()) {
                return false;
            }
            list.remove(index);
            return true;
        }
        else if(arrayList.equals(CAMPER)) {
            ArrayList<Camper> list = getCamperList(className);
            if(index >= list.size()) {
                return false;
            }
            list.remove(index);
            return true;
        }
        else if(arrayList.equals(ALLERGIES)) {
            ArrayList<String> list = getAllergyList(className);
            if(index >= list.size()) {
                return false;
            }
            list.remove(index);
            return true;
        }
        else if(arrayList.equals(MEDICATION)) {
            ArrayList<Medication> list = getMedicationList(className);
            if(index >= list.size()) {
                return false;
            }
            list.remove(index);
            return true;
        }
        return false;
    }



    /**
     * Gets an instance variable's (not array lists or hash maps) information in a given class.
     * @param className the class that contains the information being returned 
     * @param type any of the instance variables in Camp (not array lists or hash maps)
     * @param index if the type is found in an array list, the index is the index of the object being edited, if not index = -1
     * @return the string version of the instance variable
     */
    public String getInformation(String className, String variableName, int index) {
        if(className.equals(CAMP)) {
            if(variableName.equals(NAME)) {
                return camp.getName();
            } 
            if(variableName.equals(SESSION)) { //array list
                //TODO
            }
            if(variableName.equals(PRICE)) {
                return Double.toString(camp.getPricePerSession());
            }
            if(variableName.equals(RATIO)) {
                return Integer.toString(camp.getCampersPerCounselor());
            } 
            if(variableName.equals(FAQ)) { //array list
                //TODO
            }
            if(variableName.equals(ACTIVITIES)) { //array list
                //TODO
            }
        }

        if(className.equals(FAQ)) {
            ArrayList<FAQ> list = getFAQList(CAMP);
            if(variableName.equals(QUESTION)) {
                return list.get(index).getQuestion();
            }
            if(variableName.equals(ANSWER)) {
                return list.get(index).getAnswer();
            }
        }

        if(className.equals(SESSION)) {
            if(variableName.equals(CABIN)) { //array list
                //TODO
            } 
            if(variableName.equals(SESS_NUM)) {
                return list.get(index).getSessionNumber();
            }
            if(variableName.equals(START_DATE)) {
                //TODO
            }
            if(variableName.equals(END_DATE)) {
                //TODO
            }
        }

        if(className.equals(CABIN)) {
            
            if(variableName.equals(CAMPER)) { //array list
                //TODO
            } 
            if(variableName.equals(COUNSELOR)) {
                //TODO
            }
            if(variableName.equals(SCHEDULE)) {
                //TODO
            }
        }

        //TODO maybe schedule?

        if(className.equals(USER)) {
            if(variableName.equals(NAME)) {
                return user.getName();
            } 
            if(variableName.equals(EMAIL)) {
                return user.getEmail();
            }
            if(variableName.equals(PHONE)) {
                return user.getPhoneNumber();
            }
            if(variableName.equals(PASSWORD)) {
                return user.getPassword();
            }
        }

        if(className.equals(COUNSELOR)) {
            if(variableName.equals(BIO)) {
                return counselor.getBio();
            } 
            if(variableName.equals(BIRTHDAY)) {
                return counselor.getBirthday();
            }
            if(variableName.equals(ALLERGIES)) { //array list
                //TODO
            }
            if(variableName.equals(CABIN)) { //array list
                //TODO
            }
            if(variableName.equals(EMERGENCY_CONTACT)) { //array list
                //TODO
            }
        }

        if(className.equals(GUARDIAN)) {
            if(variableName.equals(CAMPER)) { //array list
                //TODO
            } 
            if(variableName.equals(SESS_NUM)) {
                //TODO
            }
            if(variableName.equals(PRICE)) { 
                //TODO
            }
        }

        if(className.equals(CAMPER)) {
            if(variableName.equals(NAME)) {
                return camper.getName();
            } 
            if(variableName.equals(BIRTHDAY)) {
                //TODO
            }
            if(variableName.equals(CABIN)) { //array list
                //TODO
            }
            if(variableName.equals(ALLERGIES)) { //array list
                //TODO
            }
            if(variableName.equals(MEDICATION)) { //array list
                //TODO
            }
            if(variableName.equals(EMERGENCY_CONTACT)) { //array list
                //TODO
            }
            if(variableName.equals(SESSION)) { //array list
                //TODO
            }
        }

        if(className.equals(MEDICATION)) {
            if(variableName.equals(DOSE)) {
                //getMedicationList(CAMPER).getDose();
            } 
            if(variableName.equals(TYPE)) {
                //TODO
            }
            if(variableName.equals(TIME)) { 
                //TODO
            }
        }

        //TODO Emergency Contacts?

        if(className.equals(EMERGENCY_CONTACT)) {
            if(variableName.equals(NAME)) {
                //TODO
            } 
            if(variableName.equals(PHONE)) {
                //TODO
            }
            if(variableName.equals(EMAIL)) {
                //TODO
            }
            if(variableName.equals(RELATIONSHIP)) {
                //TODO
            }
        }
        return "null";
    }
    
    /**
     * Gets a list of sessions and sets sessionList to those specific sessions
     * @param className the class that contains the list of sessions being returned
     * @return an array list of sessions
     */
    public ArrayList<Session> getSessionList(String className) {
        ArrayList<Session> sessionList = new ArrayList<Session>();
        if(className.equals(CAMPER)) {
            sessionList = camper.getSessions();
        }
        else if(className.equals(CAMP)) {
            sessionList = camp.getSessions();
        }
        else {
            return null;
        }
        return sessionList;        
    }
    
    /**
     * Adds a session to a list of sessions
     * @param className the class that contains the list of sessions being edited
     * @param session the session being added
     */
    public void addSession(String className, Session session) {
        getSessionList(className).add(session);
    }
    
    /**
     * Gets a list of FAQs.
     * @param className the class that contains the list of FAQs being returned;
     * @return an array list of FAQs
     */
    public ArrayList<FAQ> getFAQList(String className) {
        ArrayList<FAQ> faqList = new ArrayList<FAQ>();
        if(className.equals(CAMP)) {
            faqList = camp.getFAQs();
        }
        return faqList;
    }

    /**
     * Adds an FAQ to a list of FAQs
     * @param className the class that contains the list of FAQs being edited
     * @param faq the FAQ being added
     */
    public void addFAQ(String question, String answer) {
        Camp.getInstance().addFAQ(question, answer);
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
     * Adds an activity to a list of activities
     * @param className the class that contains the list of activities being edited
     * @param activity the activity being added
     */
    public void addActivity(String className, String activity) {

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
     * Adds a cabin to a list of cabins
     * @param className the class that contains the list of cabin being edited
     * @param cabin the cabin being added
     */
    public void addCabin(String className, Cabin cabin) {

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
     * Adds a camper to a list of campers
     * @param className the class that contains the list of campers being edited
     * @param camper the camepr being added
     */
    public void addCamper(String className, Camper camper) {

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
        return getScheduleHash(CABIN).get(day);
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
     * Adds an allergy to a list of allergies
     * @param className the class that contains the list of allergies being edited
     * @param allergy the allergy being added
     */
    public void addAllergy(String className, String allergy) {

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
     * Adds a medication to a list of medications
     * @param className the class that contains the list of medication being edited
     * @param medication the medication being added
     */
    public void addMedication(String className, Medication medication) {

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
        Contact contact = new Contact("a", "b", "c", "d");
        return contact;
    }

    /**
     * Signs a user in to their portal with their email and password.
     * @param email the user's email
     * @param password the user's password
     */
    public User signIn(String email, String password) {
        user = userList.getUser(email);
        if(user == null) {
            return null;
        }
        if(user.getPassword().equals(password)) {
            return user;
        }
        return null;
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