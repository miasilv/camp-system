package camp;
import org.junit.platform.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCampFacade {
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

        @BeforeEach
        public void setup() {
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

        @AfterEach
        public void tearDown() {
            CamperList.getInstance().getCampers().clear();
            DataWriter.saveCamp();
            CounselorList.getInstance().getCounselors().clear();
            DataWriter.saveCounselors();
            CabinList.getInstance().getCabins().clear();
            DataWriter.saveCabin();
            SessionList.getInstance().getSessions().clear();
            DataWriter.saveSessions();
            UserList.getInstance().getDirectors().clear();
            DataWriter.saveDirectors();
            UserList.getInstance().getGuardians().clear();
            DataWriter.saveGuardians();
            CampList.getInstance().getCamps().clear();
            DataWriter.saveCamp();
        }

        
}
