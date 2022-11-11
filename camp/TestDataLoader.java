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
	private ArrayList<String> counselorAllergies = new ArrayList<String>();
	private ArrayList<String> counselorRelations = new ArrayList<String>();
	private ArrayList<Contact> counselorContacts = new ArrayList<Contact>();
	private ArrayList<String> counselorThemes = new ArrayList<String>();


	private CamperList campers = CamperList.getInstance();
	private ArrayList<Camper> camperList = campers.getCampers();
	private ArrayList<Medication> camperMeds = new ArrayList<Medication>();
	private ArrayList<String> camperAllergies = new ArrayList<String>();
	private ArrayList<String> camperRelations = new ArrayList<String>();
	private ArrayList<Contact> camperContacts = new ArrayList<Contact>();
	private ArrayList<String> camperThemes = new ArrayList<String>();

	private SessionList sessions = SessionList.getInstance();
	private ArrayList<Session> sessionList = sessions.getSessions();
	private ArrayList<Cabin> sessionCabins = new ArrayList<Cabin>();
	
	private CabinList cabins = CabinList.getInstance();
	private ArrayList<Cabin> cabinList = cabins.getCabins();
	private ArrayList<Camper> cabinCampers = new ArrayList<Camper>();
	private ArrayList<Counselor> cabinCounselors = new ArrayList<Counselor>();
	private ArrayList<Schedule> cabinSchedules = new ArrayList<Schedule>();

	private UserList users = UserList.getInstance();
	private ArrayList<Director> directorList = users.getDirectors();
	private ArrayList<Guardian> guardianList = users.getGuardians();
	private ArrayList<Camper> guardianCampers = new ArrayList<Camper>();

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
		

		String bday = "04/22/2000";  
		Date birthday = formatter.parse(bday); 
		counselorAllergies.add("blueberries");
		counselorRelations.add("Friend");
		counselorContacts.add(new Contact("britney brock", "9903342233", "44 East Erie Street", "bb009@yahoo.com"));
		counselorThemes.add("hawaiian");
		counselorList.add(new Counselor(UUID.randomUUID(), "John Messy", "johnmessy@yahoo.com", "password","899003349", "hello my name is john messy", counselorRelations, counselorContacts, birthday, counselorAllergies, counselorThemes));
	
		counselorAllergies.clear();
		counselorContacts.clear();
		counselorRelations.clear();
		counselorThemes.clear();

		bday = "05/28/2000";  
		birthday = formatter.parse(bday); 
		counselorAllergies.add("pollen");
		counselorRelations.add("Friend");
		counselorContacts.add(new Contact("bethany bahr", "9903345567", "12 Land Stone Street", "bethybahr@gmail.com"));
		counselorThemes.add("cheetah girls");
		counselorList.add(new Counselor(UUID.randomUUID(), "Mackenzie McIntyre", "mackmack@yahoo.com", "password","1012334569", "hello my name is mackenzie mcintyre", counselorRelations, counselorContacts, birthday, counselorAllergies, counselorThemes));
		
		

		/**
		 * campers
		 */
		

		bday = "02/13/2011";  
		birthday = formatter.parse(bday); 
		camperMeds.add(new Medication("one pill", "advil", "whenever he has a headache"));
		camperAllergies.add("strawberries");
		camperRelations.add("Father");
		camperContacts.add(new Contact("billy smith", "8034556688", "122 Rock Point Rd", "billysmith33@gmail.com"));
		camperThemes.add("hawaiian");
		camperList.add(new Camper(UUID.randomUUID(), "bob smith", birthday,camperMeds, camperAllergies, camperRelations, camperContacts, camperThemes));
		
		camperMeds.clear();
		camperAllergies.clear();
		camperRelations.clear();
		camperContacts.clear();
		camperThemes.clear();

		bday = "06/14/2014";
		birthday = formatter.parse(bday); 
		camperMeds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camperAllergies.add("pollen");
		camperAllergies.add("peanuts");
		camperRelations.add("Doctor");
		camperContacts.add(new Contact("Catherine Steen", "8803345578", "33 Lake Shore Drive", "drsteensoffice@gmail.com"));
		camperThemes.add("cheetah girls");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camperMeds, camperAllergies, camperRelations, camperContacts, camperThemes));

		

		/**
		 * guardians
		 */
		

		for(int i = 0; i<camperList.size(); i++){
			if(i<camperList.size()/2){
				guardianCampers.add(camperList.get(i));
				continue;
			}
		}
		guardianList.add(new Guardian(UUID.randomUUID(), "Karen Smith", "karensmith@gmail.com", "password", "8034423366", guardianCampers));
		
		guardianCampers.clear();
		
		for(int i = 0; i<camperList.size(); i++){
			if(i>=camperList.size()/2){
				guardianCampers.add(camperList.get(i));
			}
		}
		guardianList.add(new Guardian(UUID.randomUUID(), "Matt King", "mattking@gmail.com", "password", "9993324456", guardianCampers));

		
		
		/**
		 * cabins
		 */
		

		for(int i = 0; i<camperList.size(); i++){
			if(i<camperList.size()/2){
				cabinCampers.add(camperList.get(i));
			}
		}

		for(int i = 0; i<7; i++){
			cabinSchedules.add(new Schedule(campActivities, 1));
		}

		cabinCounselors.add(counselorList.get(0));
		
		cabinList.add(new Cabin(cabinCampers, cabinCounselors, 12.0, 10.0, cabinSchedules, UUID.randomUUID() ));
		
		cabinCampers.clear();
		cabinCounselors.clear();
		cabinSchedules.clear();
		
		for(int i = 0; i<camperList.size(); i++){
			if(i>=camperList.size()/2){
				cabinCampers.add(camperList.get(i));
			}
		}
		for(int i = 0; i<7; i++){
			cabinSchedules.add(new Schedule(campActivities, 1));
		}

		cabinCounselors.add(counselorList.get(0));
		
		cabinList.add(new Cabin(cabinCampers, cabinCounselors, 9.0, 7.0, cabinSchedules, UUID.randomUUID() ));

		

		/**
		 * sessions
		 */
		

		sessionCabins.add(cabinList.get(0));
		String start = "07/01/2023";
		Date startDate = formatter.parse(start);      
		String end = "07/14/2023";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "cheetah girls", sessionCabins, "lets go girls", startDate, endDate));
		
		sessionCabins.clear();
		
		sessionCabins.add(cabinList.get(1));
		start = "07/01/2023";   
		startDate = formatter.parse(start);      
		end = "07/14/2023";
		endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "hawaiian", sessionCabins, "aloha", startDate, endDate));
		
		
		
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
	
	
	@Test
	void testGetDirectorsSize() {
		directorList = DataLoader.loadDirector();
		assertEquals(1, directorList.size());
	}

	/* 
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
	*/
}