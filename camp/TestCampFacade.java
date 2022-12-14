/**
 * Tested by Mia Silver
 */

package camp;
import org.junit.platform.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCampFacade {
    private CampFacade facade;
	private SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
	private Camp camp;  

    private CampList camps = CampList.getInstance();
	private ArrayList<Camp> campList = camps.getCamps();
	private ArrayList<FAQ> faqs = new ArrayList<FAQ>();
	
	//private ArrayList<Session> campSessions = new ArrayList<Session>();
	
	private ArrayList<String> campActivities = new ArrayList<String>();
	private ArrayList<Cabin> campCabins = new ArrayList<Cabin>();

	private CounselorList counselors = CounselorList.getInstance();
	private ArrayList<Counselor> counselorList = counselors.getCounselors();


	private CamperList campers = CamperList.getInstance();
	private ArrayList<Camper> camperList = campers.getCampers();
	

	private SessionList sessions = SessionList.getInstance();
	private ArrayList<Session> sessionList = sessions.getSessions();
	
	private CabinList cabins = CabinList.getInstance();
	private ArrayList<Cabin> cabinList = cabins.getCabins();
	

	private UserList users = UserList.getInstance();
	private ArrayList<Director> directorList = users.getDirectors();
	private ArrayList<Guardian> guardianList = users.getGuardians();


	@BeforeEach
	public void setup() throws ParseException {
		camperList.clear();
		counselorList.clear();
		cabinList.clear();
		sessionList.clear();
		directorList.clear();
		guardianList.clear();
		campList.clear();



		campActivities.add("wake up" );
        campActivities.add("breakfast at the mess hall");
		campActivities.add("lunch at the mess hall");
		campActivities.add("snack/rest time at cabin");
		campActivities.add("dinner at the mess hall");
        campActivities.add("campfire songs at firepit");
        campActivities.add("lights out");
        campActivities.add("ziplining at zipline track");
        campActivities.add("swimming in lake");
        campActivities.add("running on the field");
        campActivities.add("gaga ball at the gaga ball pit");
        campActivities.add("soccer on the field");
        campActivities.add("kayaking in the lake");
        campActivities.add("bracelet making in the mess hall");
        campActivities.add("arts and crafts at craft building");
        campActivities.add("painting at the craft building");
        campActivities.add("archery at the archery range");
        campActivities.add("tie dying at the craft building");
        campActivities.add("singing at the mess hall");


		/**
		 * director
		 */


		directorList.add(new Director(UUID.randomUUID(), "bob wright", "bobwright88@yahoo.com", "password", "8045569988"));
		
		

		/**
		 * counselor
		 */
		
		ArrayList<String> counselor1Allergies = new ArrayList<String>();
		ArrayList<String> counselor1Relations = new ArrayList<String>();
		ArrayList<Contact> counselor1Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor1Themes = new ArrayList<String>();
		String bday = "04/22/2000";  
		Date birthday = formatter.parse(bday); 
		counselor1Allergies.add("blueberries");
		counselor1Relations.add("Friend");
		counselor1Contacts.add(new Contact("britney brock", "9903342233", "44 East Erie Street", "bb009@yahoo.com"));
		counselor1Themes.add("hawaiian");
		counselorList.add(new Counselor(UUID.randomUUID(), "John Messy", "johnmessy@yahoo.com", "password","899003349", "hello my name is john messy", counselor1Relations, counselor1Contacts, birthday, counselor1Allergies, counselor1Themes));
	
		ArrayList<String> counselor2Allergies = new ArrayList<String>();
		ArrayList<String> counselor2Relations = new ArrayList<String>();
		ArrayList<Contact> counselor2Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor2Themes = new ArrayList<String>();

		bday = "05/28/2000";  
		birthday = formatter.parse(bday); 
		counselor2Allergies.add("pollen");
		counselor2Relations.add("Friend");
		counselor2Contacts.add(new Contact("bethany bahr", "9903345567", "12 Land Stone Street", "bethybahr@gmail.com"));
		counselor2Themes.add("cheetah girls");
		counselorList.add(new Counselor(UUID.randomUUID(), "Mackenzie McIntyre", "mackmack@yahoo.com", "password","1012334569", "hello my name is mackenzie mcintyre", counselor2Relations, counselor2Contacts, birthday, counselor2Allergies, counselor2Themes));
		
		

		/**
		 * campers
		 */
		

		ArrayList<Medication> camper1Meds = new ArrayList<Medication>();
		ArrayList<String> camper1Allergies = new ArrayList<String>();
		ArrayList<String> camper1Relations = new ArrayList<String>();
		ArrayList<Contact> camper1Contacts = new ArrayList<Contact>();
		ArrayList<String> camper1Themes = new ArrayList<String>();
		
		bday = "02/13/2011";  
		birthday = formatter.parse(bday); 
		camper1Meds.add(new Medication("one pill", "advil", "whenever he has a headache"));
		camper1Allergies.add("strawberries");
		camper1Relations.add("Father");
		camper1Contacts.add(new Contact("billy smith", "8034556688", "122 Rock Point Rd", "billysmith33@gmail.com"));
		camper1Themes.add("hawaiian");
		camperList.add(new Camper(UUID.randomUUID(), "bob smith", birthday,camper1Meds, camper1Allergies, camper1Relations, camper1Contacts, camper1Themes));
		
		ArrayList<Medication> camper2Meds = new ArrayList<Medication>();
		ArrayList<String> camper2Allergies = new ArrayList<String>();
		ArrayList<String> camper2Relations = new ArrayList<String>();
		ArrayList<Contact> camper2Contacts = new ArrayList<Contact>();
		ArrayList<String> camper2Themes = new ArrayList<String>();

		bday = "06/14/2014";
		birthday = formatter.parse(bday); 
		camper2Meds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camper2Allergies.add("pollen");
		camper2Allergies.add("peanuts");
		camper2Relations.add("Doctor");
		camper2Contacts.add(new Contact("Catherine Steen", "8803345578", "33 Lake Shore Drive", "drsteensoffice@gmail.com"));
		camper2Themes.add("cheetah girls");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes));

		

		/**
		 * guardians
		 */
		ArrayList<Camper> guardian1Campers = new ArrayList<Camper>();
		guardian1Campers.add(camperList.get(0));
		guardianList.add(new Guardian(UUID.randomUUID(), "Karen Smith", "karensmith@gmail.com", "password", "8034423366", guardian1Campers));
		
		ArrayList<Camper> guardian2Campers = new ArrayList<Camper>();
		
		guardian2Campers.add(camperList.get(1));
		guardianList.add(new Guardian(UUID.randomUUID(), "Matt King", "mattking@gmail.com", "password", "9993324456", guardian2Campers));

		
		
		/**
		 * cabins
		 */
		
		ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		for(int i = 0; i<camperList.size(); i++){
			if(i<camperList.size()/2){
				cabin1Campers.add(camperList.get(i));
			}
		}

		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
		ArrayList<Camper> cabin2Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin2Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin2Schedules = new ArrayList<Schedule>();
		
		for(int i = 0; i<camperList.size(); i++){
			if(i>=camperList.size()/2){
				cabin2Campers.add(camperList.get(i));
			}
		}
		for(int i = 0; i<7; i++){
			cabin2Schedules.add(new Schedule(campActivities, 1));
		}

		cabin2Counselors.add(counselorList.get(0));
		
		cabinList.add(new Cabin(cabin2Campers, cabin2Counselors, 9.0, 7.0, cabin2Schedules, UUID.randomUUID() ));

		

		/**
		 * sessions
		 */
		

		ArrayList<Cabin> session1Cabins = new ArrayList<Cabin>();
		session1Cabins.add(cabinList.get(0));
		session1Cabins.add(cabinList.get(1));
		String start = "07/01/2023";
		Date startDate = formatter.parse(start);      
		String end = "07/14/2023";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "cheetah girls", session1Cabins, "lets go girls", startDate, endDate));
		
		ArrayList<Cabin> session2Cabins = new ArrayList<Cabin>();
		session2Cabins.add(cabinList.get(1));
		start = "07/01/2023";   
		startDate = formatter.parse(start);      
		end = "07/14/2023";
		endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "hawaiian", session2Cabins, "aloha", startDate, endDate));
		
		
		
		/**
		 * camp
		 */
		

		faqs.add(new FAQ("What is the price", "$500.50"));

		campList.add(new Camp(UUID.randomUUID(), "247",sessionList, 500.50, faqs,8.0,campActivities));
		
		DataWriter.saveCampers();
		DataWriter.saveCounselors();
		DataWriter.saveCabin();
		DataWriter.saveSessions();
		DataWriter.saveDirectors();
		DataWriter.saveGuardians();
		DataWriter.saveCamp();

        facade = new CampFacade();
		camp = camps.getCamps().get(0);
		facade.updateCamp();
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

   //------------------------------------------------- TESTING SIGN IN'S ----------------------------
    @Test
    public void testValidCounselorSignIn() {
        String email = counselors.getCounselors().get(0).getEmail();
        String password = counselors.getCounselor(email).getPassword();
        boolean signedIn = facade.signIn(email, password);
        assertTrue(signedIn);
    }

    @Test
    public void testInvalidPasswordCounselorSignIn() {
        String email = counselors.getCounselors().get(0).getEmail();
        boolean signedIn = facade.signIn(email, "notapassword");
        assertFalse(signedIn);
    }

    @Test
    public void testInvalidEmailCounselorSignIn() {
        boolean signedIn = facade.signIn("notanemail", "notapassword");
        assertFalse(signedIn);
    }

    @Test
    public void testValidGuardianSignIn() {
        String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        boolean signedIn = facade.signIn(email, password);
        assertTrue(signedIn);
    }

    @Test
    public void testInvalidPasswordGuardianSignIn() {
        String email = users.getGuardians().get(0).getEmail();
        boolean signedIn = facade.signIn(email, "notapassword");
        assertFalse(signedIn);
    }

    @Test
    public void testInvalidEmailGuardianSignIn() {
        boolean signedIn = facade.signIn("notanemail", "notapassword");
        assertFalse(signedIn);
    }

    @Test
    public void testValidDirectorSignIn() {
        String email = users.getDirectors().get(0).getEmail();
        String password = users.getDirector(email).getPassword();
        boolean signedIn = facade.signIn(email, password);
        assertTrue(signedIn);
    }

    @Test
    public void testInvalidPasswordDirectorSignIn() {
        String email = users.getDirectors().get(0).getEmail();
        boolean signedIn = facade.signIn(email, "notapassword");
        assertFalse(signedIn);
    }

    @Test
    public void testInvalidEmailDirectorSignIn() {
        boolean signedIn = facade.signIn("notanemail", "notapassword");
        assertFalse(signedIn);
    }

	//-------------------------- Adding and removing a session from camp --------------------------
    @Test
    public void testValidAddCampSession() throws ParseException {
        String start = "07/21/2023";   
		Date startDate = formatter.parse(start);      
		String end = "07/28/2023";
		Date endDate = formatter.parse(end); 
        boolean added = facade.addCampSession("Rainbows", "Colorful Magic", startDate, endDate);
        assertTrue(added);
    }

	@Test
	public void testInvalidAddCampSession() throws ParseException {
		String start = "07/21/2023";   
		Date startDate = formatter.parse(start);      
		String end = "07/28/2023";
		Date endDate = formatter.parse(end); 
        boolean added = facade.addCampSession("Rainbows", "Colorful Magic", endDate, startDate);
        assertFalse(added);
	}

    @Test
    public void testSaveAddedCampSession() throws ParseException {
        String start = "07/21/2023";   
		Date startDate = formatter.parse(start);      
		String end = "07/28/2023";
		Date endDate = formatter.parse(end); 
        facade.addCampSession("Rainbows", "Colorful Magic", startDate, endDate);
        facade.save();
		facade = new CampFacade();
		assertEquals("Rainbows", camps.getCamps().get(0).getSession("Rainbows").getTheme());
    }

	@Test
	public void testValidRemoveCampSession() {
		boolean removed = facade.removeCampSession(0);
		assertTrue(removed);
	}

	@Test
	public void testInvalidRemoveCampSession() {
		boolean removed = facade.removeCampSession(sessions.getSessions().size() + 1);
		assertFalse(removed);
	}

	@Test
	public void testSaveRemovedCampSession() {
		int ogSize = facade.getCampSessions().size();
		facade.removeCampSession(0);
		facade.save();
		facade = new CampFacade();
		facade.updateCamp();
		assertNotEquals(ogSize, facade.getCampSessions().size());
	}

	//-------------------------- Adding and removing a cabin from session --------------------------
	@Test
	public void testValidAddSessionCabin() {
		facade.updateSession(0);
		boolean added = facade.addSessionCabin(18, 19);
		assertTrue(added);
	}

	@Test
	public void testInvalidAddSessionCabin() {
		facade.updateSession(0);
		boolean added = facade.addSessionCabin(19, 18);
		assertFalse(added);
	}

	@Test
	public void testSaveAddedSessionCabin() {
		facade.updateSession(0);
		facade.addSessionCabin(18, 19);
		facade.save();
		facade = new CampFacade();
		facade.updateCamp();
		boolean saved = false;
		for(int i = 0; i < cabinList.size(); i++) {
			if(cabinList.get(i).getMinAge() == 18) {
				saved = true;
			}
		}
		assertTrue(saved);
	}

	@Test
	public void testValidRemoveSessionCabin() {
		facade.updateSession(0);
		boolean removed = facade.removeSessionCabin(0);
		assertTrue(removed);
	}

	@Test
	public void testInvalidRemoveSessionCabin() {
		facade.updateSession(0);
		boolean removed = facade.removeSessionCabin(facade.getSessionCabinList().size() + 1);
		assertFalse(removed);
	}

	@Test
	public void testSaveRemovedSessionCabin() {
		facade.updateSession(0);
		int ogSize = facade.getSessionCabinList().size();
		facade.removeSessionCabin(0);
		facade.save();
		facade = new CampFacade();
		facade.updateCamp();
		facade.updateSession(0);
		assertNotEquals(ogSize, facade.getSessionCabinList().size());
	}

	//-------------------------- Adding and removing a camper from guardian --------------------------
	@Test
	public void testValidAddCamper() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2007";
		Date bDate = formatter.parse(bday); 
		boolean added = facade.addGuardianCamper("Bob Jones", bDate);
		assertTrue(added);
	}

	@Test
	public void testInvalidAddCamper() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/1996";
		Date bDate = formatter.parse(bday); 
		boolean added = facade.addGuardianCamper(null, bDate);
		assertFalse(added);
	}

	@Test
	public void testSaveAddCamper() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2007";
		Date bDate = formatter.parse(bday); 
		facade.addGuardianCamper("Bob Jones", bDate);
		
		facade.save();
		
		facade = new CampFacade();
		facade.updateCamp();
        facade.signIn(email, password);
		facade.updateGuardian();
		boolean saved = false;
		for(int i = 0; i < facade.getGuardianCamperList().size(); i++) {
			if(facade.getGuardianCamperList().get(i).getName().equals("Bob Jones")) {
				saved = true;
			}
		}
		assertTrue(saved);
	}

	@Test
	public void testValidRemoveCamper() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		boolean removed = facade.removeGuardianCamper(0);
		assertTrue(removed);
	}

	@Test
	public void testInvalidRemoveCamper() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		boolean removed = facade.removeGuardianCamper(facade.getGuardianCamperList().size() + 1);
		assertFalse(removed);
	}

	@Test
	public void testSaveRemovedCamper() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		int ogSize = facade.getGuardianCamperList().size();
		facade.removeGuardianCamper(0);
		assertNotEquals(ogSize, facade.getGuardianCamperList().size());
	}

	//-------------------------- Adding and removing a camper to a session --------------------------
	@Test
	public void testValidAddCamperSessioninCamper() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2011";
		Date bDate = formatter.parse(bday); 
		facade.addGuardianCamper("Bob Jones", bDate);
		int index = -1;
		for(int i = 0; i < facade.getGuardianCamperList().size(); i++) {
			if(facade.getGuardianCamperList().get(i).getName().equals("Bob Jones")) {
				index = i;
				facade.updateCamper("guardian", index);
			}
		}
		facade.addCamperSession(0);
		facade.updateCamper("guardian", index);
		facade.updateCabinHash(facade.getCampSessions().get(0));
		boolean inCamper = false;
		if(facade.getCamperSessions().contains(facade.getCampSessions().get(0))) {
			inCamper = true;
		}
		assertTrue(inCamper);
	}

	@Test
	public void testValidAddCamperSessioninCabin() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2011";
		Date bDate = formatter.parse(bday); 
		facade.addGuardianCamper("Bob Jones", bDate);
		int index = -1;
		for(int i = 0; i < facade.getGuardianCamperList().size(); i++) {
			if(facade.getGuardianCamperList().get(i).getName().equals("Bob Jones")) {
				index = i;
				facade.updateCamper("guardian", index);
			}
		}
		facade.addCamperSession(0);
		facade.updateCamper("guardian", index);
		boolean inCabin = false;
		if(facade.getCampSessions().get(0).getCabin(1).hasCamper(facade.getGuardianCamperList().get(index))) {
			inCabin = true;
		}
		assertTrue(inCabin);
	}

	@Test
	public void testInvalidAddCamperSession() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2007";
		Date bDate = formatter.parse(bday); 
		facade.addGuardianCamper("Bob Jones", bDate);
		for(int i = 0; i < facade.getGuardianCamperList().size(); i++) {
			if(facade.getGuardianCamperList().get(i).getName().equals("Bob Jones")) {
				facade.updateCamper("guardian", i);
			}
		}
		facade.addCamperSession(0);
		boolean inCamper = false;
		if(facade.getCamperSessions().contains(facade.getCampSessions().get(0))) {
			inCamper = true;
		}
		assertFalse(inCamper);
	}

	@Test
	public void testSaveAddCamperSessioninCamper() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2011";
		Date bDate = formatter.parse(bday); 
		facade.addGuardianCamper("Bob Jones", bDate);
		int index = -1;
		for(int i = 0; i < facade.getGuardianCamperList().size(); i++) {
			if(facade.getGuardianCamperList().get(i).getName().equals("Bob Jones")) {
				index = i;
				facade.updateCamper("guardian", index);
			}
		}
		facade.addCamperSession(0);
		facade.updateCabinHash(facade.getCampSessions().get(0));
		facade.save();
		facade = new CampFacade();
		facade.updateCamp();
		facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", index);
		boolean inCamper = false;
		if(facade.getCamperSessions().contains(facade.getCampSessions().get(0))) {
			inCamper = true;
		}
		assertTrue(inCamper);
	}

	@Test
	public void testSaveAddCamperSessioninCabin() throws ParseException {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		String bday = "07/28/2011";
		Date bDate = formatter.parse(bday); 
		facade.addGuardianCamper("Bob Jones", bDate);
		int index = -1;
		for(int i = 0; i < facade.getGuardianCamperList().size(); i++) {
			if(facade.getGuardianCamperList().get(i).getName().equals("Bob Jones")) {
				index = i;
				facade.updateCamper("guardian", index);
			}
		}
		facade.addCamperSession(0);
		facade.updateCabinHash(facade.getCampSessions().get(0));
		facade.save();
		facade = new CampFacade();
		facade.updateCamp();
		facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", index);
		boolean inCabin = false;
		if(facade.getCampSessions().get(0).getCabin(1).hasCamper(facade.getGuardianCamperList().get(index))) {
			inCabin = true;
		}
		assertTrue(inCabin);
	}
	
	//-------------------------- Adding and removing a contact to a camper --------------------------
	@Test
	public void testValidAddCamperEmergencyContact() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		boolean added = facade.addCamperContact("mother", "name", "email", "phone number", "address");
		assertTrue(added);
	}

	@Test
	public void testInvalidAddCamperEmergencyContact() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		boolean added = facade.addCamperContact(null, "name", "email", "phone number", "address");
		assertFalse(added);
	}

	@Test
	public void testSaveAddCamperEmergencyContact() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		facade.addCamperContact("mother", "name", "email", "phone number", "address");
		facade.save();
		facade = new CampFacade();
		facade.updateCamp();
		facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		assertTrue((facade.getCamperContactHash().get("mother")) != null);
	}

	@Test
	public void testValidRemoveCamperEmergencyContact() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		boolean removed = facade.removeCamperContact("father");
		assertTrue(removed);
	}

	@Test
	public void testInvalidRemoveCamperEmergencyContact() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		boolean removed = facade.removeCamperContact("mother");
		assertFalse(removed);
	}

	@Test
	public void testSaveRemoveCamperEmergencyContact() {
		String email = users.getGuardians().get(0).getEmail();
        String password = users.getGuardian(email).getPassword();
        facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		facade.removeCamperContact("father");
		facade.save();
		facade.updateCamp();
		facade.signIn(email, password);
		facade.updateGuardian();
		facade.updateCamper("guardian", 0);
		assertTrue((facade.getCamperContactHash().get("father")) == null);
	}

	
}
