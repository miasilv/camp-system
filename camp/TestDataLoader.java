/**
 * @author Natalie Crawford
 */

package camp;
import org.junit.platform.*;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

//import org.junit.platform.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestDataLoader {

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

	/**
	 * 
	 * for most of the other test classes, the before each and after each code was taken 
	 * from this one written by Natalie Crawford
	 * 
	 * 
	 * @throws ParseException
	 */
	@BeforeEach
	public void setup() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
	}
	
	@AfterEach
	public void tearDown() {
		CounselorList.getInstance().getCounselors().clear();
		CamperList.getInstance().getCampers().clear();
		CabinList.getInstance().getCabins().clear();
		SessionList.getInstance().getSessions().clear();
		UserList.getInstance().getGuardians().clear();
		UserList.getInstance().getDirectors().clear();
		CampList.getInstance().getCamps().clear();
		
		DataWriter.saveCampers();
		DataWriter.saveCounselors();
		DataWriter.saveCabin();
		DataWriter.saveSessions();
		DataWriter.saveDirectors();
		DataWriter.saveGuardians();
		DataWriter.saveCamp();
	}
	
	//testing director loading
	@Test
	void testGetDirectorsSize() {
		directorList = DataLoader.loadDirector();
		assertEquals(1, directorList.size());
	}

	
	@Test
	void testGetDirectorsSizeZero() {
		UserList.getInstance().getDirectors().clear();
		DataWriter.saveDirectors();
		assertEquals(0, directorList.size());
	}
	
	@Test
	void testGetDirectorName() {
		directorList = DataLoader.loadDirector();
		assertEquals("bob wright", directorList.get(0).getName());
	}

	@Test
	void testGetDirectorEmail(){
		directorList = DataLoader.loadDirector();
		assertEquals("bobwright88@yahoo.com", directorList.get(0).getEmail());
	}

	@Test
	void testGetDirectorPhone(){
		directorList = DataLoader.loadDirector();
		assertEquals("8045569988", directorList.get(0).getPhoneNumber());
	}
	
	@Test
	void testGetDirectorPassword(){
		directorList = DataLoader.loadDirector();
		assertEquals("password", directorList.get(0).getPassword());
	}


	//testing guardian loading
	@Test
	void testGetGuardiansSize() {
		guardianList = DataLoader.loadGuardians();
		assertEquals(2, guardianList.size());
	}

	
	@Test
	void testGetGuardiansSizeZero() {
		UserList.getInstance().getGuardians().clear();
		DataWriter.saveGuardians();
		assertEquals(0, guardianList.size());
	}
	
	@Test
	void testGetGuardianName() {
		guardianList = DataLoader.loadGuardians();
		assertEquals("Karen Smith", guardianList.get(0).getName());
	}

	@Test
	void testGetGuardianEmail(){
		guardianList = DataLoader.loadGuardians();
		assertEquals("karensmith@gmail.com", guardianList.get(0).getEmail());
	}

	@Test
	void testGetGuardianPhone(){
		guardianList = DataLoader.loadGuardians();
		assertEquals("8034423366", guardianList.get(0).getPhoneNumber());
	}
	
	@Test
	void testGetGuardianPassword(){
		guardianList = DataLoader.loadGuardians();
		assertEquals("password", guardianList.get(0).getPassword());
	}

	@Test
	void testGetGuardianCampers(){
		camperList = DataLoader.loadCampers();
		guardianList = DataLoader.loadGuardians();
		assertEquals("bob smith", guardianList.get(0).getCamper(0).getName());
	}



	//counselor testing
	@Test
	void testGetCounselorSize() {
		counselorList = DataLoader.loadCounselors();
		assertEquals(2, counselorList.size());
	}

	
	@Test
	void testGetCounselorsSizeZero() {
		CounselorList.getInstance().getCounselors().clear();
		DataWriter.saveCounselors();
		assertEquals(0, counselorList.size());
	}
	
	@Test
	void testGetCounselorName() {
		counselorList = DataLoader.loadCounselors();
		assertEquals("John Messy", counselorList.get(0).getName());
	}

	@Test
	void testGetCounselorNameWithoutCapitalization() {
		counselorList = DataLoader.loadCounselors();
		assertEquals("john messy", counselorList.get(0).getName());
	}

	@Test
	void testGetCounselorEmail(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("johnmessy@yahoo.com", counselorList.get(0).getEmail());
	}

	@Test
	void testGetCounselorPhone(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("899003349", counselorList.get(0).getPhoneNumber());
	}
	
	@Test
	void testGetCounselorPassword(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("password", counselorList.get(0).getPassword());
	}

	@Test 
	void testCounselorRelations(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("Friend", counselorList.get(0).getRelationships().get(0));
	}

	@Test 
	void testCounselorContacts(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("britney brock", counselorList.get(0).getContacts().get(0).getName());
	}

	@Test
	void testCounselorBirthday(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("04/22/2000", counselorList.get(0).getBirthdayStr());
	}

	@Test
	void testCounselorAllergies(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("blueberries", counselorList.get(0).getAllergies().get(0));
	}

	@Test
	void testCounselorThemes(){
		counselorList = DataLoader.loadCounselors();
		assertEquals("hawaiian", counselorList.get(0).getSessionThemes().get(0));
	}


	//test camper loading
	@Test
	void testGetCamperSize() {
		camperList = DataLoader.loadCampers();
		assertEquals(2, counselorList.size());
	}

	@Test
	void testGetCampersSizeZero() {
		CamperList.getInstance().getCampers().clear();
		DataWriter.saveCampers();
		assertEquals(0, camperList.size());
	}
	
	@Test
	void testGetCamperName() {
		camperList = DataLoader.loadCampers();
		assertEquals("bob smith", camperList.get(0).getName());
	}
	
	@Test 
	void testCamperRelations(){
		camperList = DataLoader.loadCampers();
		assertEquals("Father", camperList.get(0).getRelationships().get(0));
	}

	@Test 
	void testCamperContacts(){
		camperList = DataLoader.loadCampers();
		assertEquals("billy smith", camperList.get(0).getContacts().get(0).getName());
	}

	@Test 
	void testCamperMeds(){
		camperList = DataLoader.loadCampers();
		assertEquals("advil", camperList.get(0).getMedications().get(0).getType());
	}

	@Test
	void testCamperBirthday(){
		camperList = DataLoader.loadCampers();
		assertEquals("02/13/2011", camperList.get(0).getBirthdayStr());
	}

	@Test
	void testCamperAllergies(){
		camperList = DataLoader.loadCampers();
		assertEquals("strawberries", camperList.get(0).getAllergies().get(0));
	}

	@Test
	void testCamperThemes(){
		camperList = DataLoader.loadCampers();
		assertEquals("hawaiian", camperList.get(0).getSessionThemes().get(0));
	}


	//test cabin loading
	
	@Test
	void testGetCabinSize() {
		cabinList = DataLoader.loadCabins();
		assertEquals(2, cabinList.size());
	}

	@Test
	void testGetCabinSize0() {
		CabinList.getInstance().getCabins().clear();
		DataWriter.saveCabin();
		assertEquals(0, cabinList.size());
	}

	@Test
	void testGetCabinCampers(){
		cabinList = DataLoader.loadCabins();
		assertEquals("bob smith", cabinList.get(0).getCampers().get(0).getName());
	}


	@Test
	void testGetCabinCounselor(){
		cabinList = DataLoader.loadCabins();
		assertEquals("John Messy", cabinList.get(0).getCounselors().get(0).getName());
	}

	@Test
	void testGetCabinMinAge(){
		cabinList = DataLoader.loadCabins();
		assertEquals(10.0, cabinList.get(0).getMinAge());
	}

	@Test
	void testGetCabinMaxAge(){
		cabinList = DataLoader.loadCabins();
		assertEquals(12.0, cabinList.get(0).getMaxAge());
	}

	@Test
	void testGetCabinSchedule(){
		cabinList = DataLoader.loadCabins();
		assertEquals(7, cabinList.get(0).getSchedule().size());
	}


	//test session loading
	@Test
	void testGetSessionSize() {
		sessionList = DataLoader.loadSessions();
		assertEquals(2, sessionList.size());
	}

	@Test
	void testGetSessionSize0() {
		SessionList.getInstance().getSessions().clear();
		DataWriter.saveSessions();
		assertEquals(0, sessionList.size());
	}	

	@Test
	void testGetSessionTheme(){
		sessionList = DataLoader.loadSessions();
		assertEquals("cheetah girls", sessionList.get(0).getTheme());
	}

	@Test
	void testGetSessionCabins(){
		sessionList = DataLoader.loadSessions();
		assertEquals("bob smith", sessionList.get(0).getCabins().get(0).getCampers().get(0).getName());
	}

	@Test
	void testGetSessionDescription(){
		sessionList = DataLoader.loadSessions();
		assertEquals("lets go girls", sessionList.get(0).getDescription());
	}

	@Test
	void testGetSessionStartDate(){
		sessionList = DataLoader.loadSessions();
		assertEquals("07/01/2023", sessionList.get(0).getStrStart());
	}

	@Test
	void testGetSessionEndDate(){
		sessionList = DataLoader.loadSessions();
		assertEquals("07/14/2023", sessionList.get(0).getStrEnd());
	}


	//testing camp loader
	//"247",sessionList, 500.50, faqs,8.0,campActivities));
	@Test
	void testGetCampSize() {
		campList = DataLoader.loadCamp();
		assertEquals(1, campList.size());
	}

	@Test
	void testGetCampSize0() {
		CampList.getInstance().getCamps().clear();
		DataWriter.saveCamp();
		assertEquals(0, campList.size());
	}	

	@Test
	void testGetCampName() {
		campList = DataLoader.loadCamp();
		assertEquals("247", campList.get(0).getName());
	}

	@Test
	void testGetCampSessions() {
		campList = DataLoader.loadCamp();
		assertEquals("cheetah girls", campList.get(0).getSessions().get(0).getTheme());
	}
	
	@Test
	void testGetCampPrice() {
		campList = DataLoader.loadCamp();
		assertEquals(500.50, campList.get(0).getPrice());
	}

	@Test
	void testGetCampFAQ() {
		campList = DataLoader.loadCamp();
		assertEquals("$500.50", campList.get(0).getFAQs().get(0).getAnswer());
	}

	@Test
	void testGetCamperCounselorRatio() {
		campList = DataLoader.loadCamp();
		assertEquals(8.0, campList.get(0).getRatio());
	}

	@Test
	void testGetCampActivities() {
		campList = DataLoader.loadCamp();
		assertEquals("wake up", campList.get(0).getActivities().get(0));
	}

}