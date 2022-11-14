/**
 * @author Natalie Crawford
 */
package camp;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import javax.crypto.NullCipher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDataWriter {

	private CampList camps = CampList.getInstance();
	private ArrayList<Camp> campList = camps.getCamps();
	
	
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
	public void setup() {
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
	
	
    //testing director writing

	@Test
	void testWritingZeroDirectors() {
		directorList = DataLoader.loadDirector();
		assertEquals(0, directorList.size());
	}

	@Test
	void testWritingOneDirector() {
		directorList.add(new Director(UUID.randomUUID(), "bob wright", "bobwright88@yahoo.com", "password", "8045569988"));
		DataWriter.saveDirectors();
		assertEquals("bob wright", DataLoader.loadDirector().get(0).getName());
	}
	
	@Test
	void testWritingFiveDirectors() {
		directorList.add(new Director(UUID.randomUUID(), "wesley youin", "wesley8899@yahoo.com", "password", "8667895544"));
		directorList.add(new Director(UUID.randomUUID(), "tina wrote", "tinatwrote@yahoo.com", "password", "8876678855"));
		directorList.add(new Director(UUID.randomUUID(), "blake brewski", "bb99@yahoo.com", "password", "9003445665"));
		directorList.add(new Director(UUID.randomUUID(), "drew smith", "drewdrew@yahoo.com", "password", "8003445688"));
		directorList.add(new Director(UUID.randomUUID(), "bob wright", "bobwright88@yahoo.com", "password", "8045569988"));
		DataWriter.saveDirectors();
		assertEquals("bob wright", DataLoader.loadDirector().get(4).getName());
	}
	
	@Test
	void testWritingEmptyDirector() {
		directorList.add(new Director( UUID.fromString("00000000-0000-0000-0000-000000000000"), "", "", "", ""));
		DataWriter.saveDirectors();
		assertEquals("", DataLoader.loadDirector().get(0).getName());
	}
	
	@Test
	void testWritingNullDirector() {
		directorList.add(new Director( null, null, null, null, null));
		DataWriter.saveDirectors();
		assertEquals(null, DataLoader.loadDirector().get(0).getName());
	}

    //testing counselor writing
    @Test
	void testWritingZeroCounselors() {
		counselorList = DataLoader.loadCounselors();
		assertEquals(0, counselorList.size());
	}

	@Test
	void testWritingOneCounselor() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
	
		DataWriter.saveCounselors();
		assertEquals("John Messy", DataLoader.loadCounselors().get(0).getName());
	}
	
	@Test
	void testWritingFiveCounselors() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
		
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
		bday = "10/04/2002";  
		birthday = formatter.parse(bday); 
		counselor2Allergies.add("pollen");
		counselor2Relations.add("Friend");
		counselor2Contacts.add(new Contact("matt smith", "8893345567", "12 lake street", "mattsmith88@yahoo.com"));
		counselor2Themes.add("ninja warriors");
		counselorList.add(new Counselor(UUID.randomUUID(), "Kai Finger", "kaif88@yahoo.com", "password","8803442211", "hello my name is kai finger", counselor2Relations, counselor2Contacts, birthday, counselor2Allergies, counselor2Themes));
		
        ArrayList<String> counselor3Allergies = new ArrayList<String>();
		ArrayList<String> counselor3Relations = new ArrayList<String>();
		ArrayList<Contact> counselor3Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor3Themes = new ArrayList<String>();
		bday = "08/21/1999";  
		birthday = formatter.parse(bday); 
		counselor3Allergies.add("");
		counselor3Relations.add("Friend");
		counselor3Contacts.add(new Contact("Sara Cruz", "3345567789", "42 michigan st", "saracruz@gmail.com"));
		counselor3Themes.add("cars");
		counselorList.add(new Counselor(UUID.randomUUID(), "Sarah Bowers", "sarahbowers88@yahoo.com", "password","2234433345", "hello my name is sarah bowers", counselor3Relations, counselor3Contacts, birthday, counselor3Allergies, counselor3Themes));

        ArrayList<String> counselor4Allergies = new ArrayList<String>();
		ArrayList<String> counselor4Relations = new ArrayList<String>();
		ArrayList<Contact> counselor4Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor4Themes = new ArrayList<String>();
		bday = "01/26/2001";  
		birthday = formatter.parse(bday); 
		counselor4Allergies.add("dogs");
        counselor4Allergies.add("cats");
		counselor4Relations.add("Mom");
		counselor4Contacts.add(new Contact("Megan Kind", "3322245554", "134 Rock Stone Circle", "megankind@yahoo.com"));
		counselor4Themes.add("fruit mania");
		counselorList.add(new Counselor(UUID.randomUUID(), "Rebecca Kind", "rebeccakind@yahoo.com", "password","2334578800", "hello my name is rebecca kind", counselor4Relations, counselor4Contacts, birthday, counselor4Allergies, counselor4Themes));

        ArrayList<String> counselor5Allergies = new ArrayList<String>();
		ArrayList<String> counselor5Relations = new ArrayList<String>();
		ArrayList<Contact> counselor5Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor5Themes = new ArrayList<String>();
		bday = "03/04/1998";  
		birthday = formatter.parse(bday); 
		counselor5Allergies.add("dogs");
        counselor5Allergies.add("cats");
		counselor5Relations.add("Mom");
		counselor5Contacts.add(new Contact("Kathy Potter", "3334509898", "67 first street", "kathrynpotter@yahoo.com"));
		counselor5Themes.add("legos");
		counselorList.add(new Counselor(UUID.randomUUID(), "Jack Potter", "jackpotter@yahoo.com", "password","9003342234", "hello my name is jack potter", counselor5Relations, counselor5Contacts, birthday, counselor5Allergies, counselor5Themes));
        
        DataWriter.saveCounselors();
        assertEquals("Kai Finger", DataLoader.loadCounselors().get(1).getName());
	}
	
	@Test
	void testWritingEmptyCounselor() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
		
        ArrayList<String> counselorAllergies = new ArrayList<String>();
		ArrayList<String> counselorRelations = new ArrayList<String>();
		ArrayList<Contact> counselorContacts = new ArrayList<Contact>();
		ArrayList<String> counselorThemes = new ArrayList<String>();
        String bday = "";  
		Date birthday = formatter.parse(bday); 
		counselorList.add(new Counselor( UUID.fromString("00000000-0000-0000-0000-000000000000"), "", "", "", "", "", counselorRelations, counselorContacts, birthday , counselorAllergies, counselorThemes));
		DataWriter.saveCounselors();
		assertEquals("", DataLoader.loadCounselors().get(0).getName());
	}
	
	@Test
	void testWritingNullCounselor() {
		counselorList.add(new Counselor(null, null, null, null, null, null, null, null, null, null, null));
		DataWriter.saveCounselors();
		assertEquals(null, DataLoader.loadCounselors().get(0).getName());
	}


    //testing camper writing

	@Test
	void testWritingZeroCampers() {
		camperList = DataLoader.loadCampers();
		assertEquals(0, camperList.size());
	}

	@Test
	void testWritingOneCamper() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
		ArrayList<Medication> camper1Meds = new ArrayList<Medication>();
		ArrayList<String> camper1Allergies = new ArrayList<String>();
		ArrayList<String> camper1Relations = new ArrayList<String>();
		ArrayList<Contact> camper1Contacts = new ArrayList<Contact>();
		ArrayList<String> camper1Themes = new ArrayList<String>();
		
		String bday = "02/13/2011";  
		Date birthday = formatter.parse(bday); 
		camper1Meds.add(new Medication("one pill", "advil", "whenever he has a headache"));
		camper1Allergies.add("strawberries");
		camper1Relations.add("Father");
		camper1Contacts.add(new Contact("billy smith", "8034556688", "122 Rock Point Rd", "billysmith33@gmail.com"));
		camper1Themes.add("hawaiian");
		camperList.add(new Camper(UUID.randomUUID(), "bob smith", birthday,camper1Meds, camper1Allergies, camper1Relations, camper1Contacts, camper1Themes));
		
		DataWriter.saveCampers();
		assertEquals("bob smith", DataLoader.loadCampers().get(0).getName());
	}
	
	@Test
	void testWritingFiveCampers() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy"); 
		ArrayList<Medication> camper1Meds = new ArrayList<Medication>();
		ArrayList<String> camper1Allergies = new ArrayList<String>();
		ArrayList<String> camper1Relations = new ArrayList<String>();
		ArrayList<Contact> camper1Contacts = new ArrayList<Contact>();
		ArrayList<String> camper1Themes = new ArrayList<String>();
		
		String bday = "02/13/2014";  
		Date birthday = formatter.parse(bday); 
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
		camper2Themes.add("cars");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes));

		ArrayList<Medication> camper3Meds = new ArrayList<Medication>();
		ArrayList<String> camper3Allergies = new ArrayList<String>();
		ArrayList<String> camper3Relations = new ArrayList<String>();
		ArrayList<Contact> camper3Contacts = new ArrayList<Contact>();
		ArrayList<String> camper3Themes = new ArrayList<String>();

		bday = "02/22/2011";
		birthday = formatter.parse(bday); 
		camper3Meds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camper3Allergies.add("pollen");
		camper3Relations.add("Mom");
		camper3Contacts.add(new Contact("Catherine String", "9883345567", "44 Lake Shore Circle", "catstring@gmail.com"));
		camper3Themes.add("cheetah girls");
		camperList.add(new Camper(UUID.randomUUID(), "jackie string", birthday,camper3Meds, camper3Allergies, camper3Relations, camper3Contacts, camper3Themes));

        ArrayList<Medication> camper4Meds = new ArrayList<Medication>();
		ArrayList<String> camper4Allergies = new ArrayList<String>();
		ArrayList<String> camper4Relations = new ArrayList<String>();
		ArrayList<Contact> camper4Contacts = new ArrayList<Contact>();
		ArrayList<String> camper4Themes = new ArrayList<String>();

		bday = "12/25/2011";
		birthday = formatter.parse(bday); 
		camper4Meds.add(new Medication("one pill", "tylenol", "whenever in pain"));
		camper4Allergies.add("cats");
		camper4Relations.add("Dad");
		camper4Contacts.add(new Contact("Micheal Scott", "8883345578", "234 tin point circle", "michscott@gmail.com"));
		camper4Themes.add("fruit mania");
		camperList.add(new Camper(UUID.randomUUID(), "kennedy scott", birthday,camper4Meds, camper4Allergies, camper4Relations, camper4Contacts, camper4Themes));

        ArrayList<Medication> camper5Meds = new ArrayList<Medication>();
		ArrayList<String> camper5Allergies = new ArrayList<String>();
		ArrayList<String> camper5Relations = new ArrayList<String>();
		ArrayList<Contact> camper5Contacts = new ArrayList<Contact>();
		ArrayList<String> camper5Themes = new ArrayList<String>();

		bday = "05/26/2011";
		birthday = formatter.parse(bday); 
		camper5Meds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camper5Allergies.add("blueberries");
		camper5Relations.add("Mom");
		camper5Contacts.add(new Contact("Catherine Sams", "7783346661", "442 Red Brick Rd", "catsams@gmail.com"));
		camper5Themes.add("legos");
		camperList.add(new Camper(UUID.randomUUID(), "rose sams", birthday,camper5Meds, camper5Allergies, camper5Relations, camper5Contacts, camper5Themes));

        DataWriter.saveCampers();
		assertEquals("rose sams", DataLoader.loadCampers().get(4).getName());
	}
	
	@Test
	void testWritingEmptyCamper() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        ArrayList<Medication> camper1Meds = new ArrayList<Medication>();
		ArrayList<String> camper1Allergies = new ArrayList<String>();
		ArrayList<String> camper1Relations = new ArrayList<String>();
		ArrayList<Contact> camper1Contacts = new ArrayList<Contact>();
		ArrayList<String> camper1Themes = new ArrayList<String>();
        String bday = "";  
		Date birthday = formatter.parse(bday); 
		
		camperList.add(new Camper(UUID.fromString("00000000-0000-0000-0000-000000000000"), "", birthday, camper1Meds, camper1Allergies, camper1Relations, camper1Contacts, camper1Themes));
		DataWriter.saveCampers();
		assertEquals("", DataLoader.loadCampers().get(0).getName());
	}
	
	@Test
	void testWritingNullCamper() {
		camperList.add(new Camper(null, null, null, null, null, null, null, null));
		DataWriter.saveCampers();
		assertEquals(null, DataLoader.loadCampers().get(0).getName());
	}



    //testing guardian writing
    @Test
	void testWritingZeroGuardians() {
		guardianList = DataLoader.loadGuardians();
		assertEquals(0, guardianList.size());
	}

	@Test
	void testWritingOneGuardian() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
		ArrayList<Medication> camper1Meds = new ArrayList<Medication>();
		ArrayList<String> camper1Allergies = new ArrayList<String>();
		ArrayList<String> camper1Relations = new ArrayList<String>();
		ArrayList<Contact> camper1Contacts = new ArrayList<Contact>();
		ArrayList<String> camper1Themes = new ArrayList<String>();
		
		String bday = "02/13/2011";  
		Date birthday = formatter.parse(bday); 
		camper1Meds.add(new Medication("one pill", "advil", "whenever he has a headache"));
		camper1Allergies.add("strawberries");
		camper1Relations.add("Father");
		camper1Contacts.add(new Contact("billy smith", "8034556688", "122 Rock Point Rd", "billysmith33@gmail.com"));
		camper1Themes.add("hawaiian");
		camperList.add(new Camper(UUID.randomUUID(), "bob smith", birthday,camper1Meds, camper1Allergies, camper1Relations, camper1Contacts, camper1Themes));
		
		ArrayList<Camper> guardian1Campers = new ArrayList<Camper>();
		guardian1Campers.add(camperList.get(0));
		guardianList.add(new Guardian(UUID.randomUUID(), "Karen Smith", "karensmith@gmail.com", "password", "8034423366", guardian1Campers));
		
        
        DataWriter.saveGuardians();
		assertEquals("bob smith", DataLoader.loadGuardians().get(0).getCampers().get(0).getName());
	}
	
	@Test
	void testWritingFiveGuardians() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy"); 
		ArrayList<Medication> camper1Meds = new ArrayList<Medication>();
		ArrayList<String> camper1Allergies = new ArrayList<String>();
		ArrayList<String> camper1Relations = new ArrayList<String>();
		ArrayList<Contact> camper1Contacts = new ArrayList<Contact>();
		ArrayList<String> camper1Themes = new ArrayList<String>();
		
		String bday = "02/13/2014";  
		Date birthday = formatter.parse(bday); 
		camper1Meds.add(new Medication("one pill", "advil", "whenever he has a headache"));
		camper1Allergies.add("strawberries");
		camper1Relations.add("Father");
		camper1Contacts.add(new Contact("billy smith", "8034556688", "122 Rock Point Rd", "billysmith33@gmail.com"));
		camper1Themes.add("hawaiian");
		camperList.add(new Camper(UUID.randomUUID(), "bob smith", birthday,camper1Meds, camper1Allergies, camper1Relations, camper1Contacts, camper1Themes));
		
        ArrayList<Camper> guardian1Campers = new ArrayList<Camper>();
		guardian1Campers.add(camperList.get(0));
		guardianList.add(new Guardian(UUID.randomUUID(), "Karen Smith", "karensmith@gmail.com", "password", "8034423366", guardian1Campers));

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
		camper2Themes.add("cars");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes));

        ArrayList<Camper> guardian2Campers = new ArrayList<Camper>();
		guardian2Campers.add(camperList.get(1));
		guardianList.add(new Guardian(UUID.randomUUID(), "Matt King", "mattking@gmail.com", "password", "9993324456", guardian2Campers));

		ArrayList<Medication> camper3Meds = new ArrayList<Medication>();
		ArrayList<String> camper3Allergies = new ArrayList<String>();
		ArrayList<String> camper3Relations = new ArrayList<String>();
		ArrayList<Contact> camper3Contacts = new ArrayList<Contact>();
		ArrayList<String> camper3Themes = new ArrayList<String>();

		bday = "02/22/2011";
		birthday = formatter.parse(bday); 
		camper3Meds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camper3Allergies.add("pollen");
		camper3Relations.add("Mom");
		camper3Contacts.add(new Contact("Catherine String", "9883345567", "44 Lake Shore Circle", "catstring@gmail.com"));
		camper3Themes.add("cheetah girls");
		camperList.add(new Camper(UUID.randomUUID(), "jackie string", birthday,camper3Meds, camper3Allergies, camper3Relations, camper3Contacts, camper3Themes));

        ArrayList<Camper> guardian3Campers = new ArrayList<Camper>();
		guardian3Campers.add(camperList.get(2));
		guardianList.add(new Guardian(UUID.randomUUID(), "Cathering String", "catstring@gmail.com", "password", "9883345567", guardian3Campers));

        ArrayList<Medication> camper4Meds = new ArrayList<Medication>();
		ArrayList<String> camper4Allergies = new ArrayList<String>();
		ArrayList<String> camper4Relations = new ArrayList<String>();
		ArrayList<Contact> camper4Contacts = new ArrayList<Contact>();
		ArrayList<String> camper4Themes = new ArrayList<String>();

		bday = "12/25/2011";
		birthday = formatter.parse(bday); 
		camper4Meds.add(new Medication("one pill", "tylenol", "whenever in pain"));
		camper4Allergies.add("cats");
		camper4Relations.add("Dad");
		camper4Contacts.add(new Contact("Micheal Scott", "8883345578", "234 tin point circle", "michscott@gmail.com"));
		camper4Themes.add("fruit mania");
		camperList.add(new Camper(UUID.randomUUID(), "kennedy scott", birthday,camper4Meds, camper4Allergies, camper4Relations, camper4Contacts, camper4Themes));

        ArrayList<Camper> guardian4Campers = new ArrayList<Camper>();
		guardian4Campers.add(camperList.get(3));
		guardianList.add(new Guardian(UUID.randomUUID(), "Micheal Scott", "michscott@gmail.com", "password", "8883345578", guardian4Campers));

        ArrayList<Medication> camper5Meds = new ArrayList<Medication>();
		ArrayList<String> camper5Allergies = new ArrayList<String>();
		ArrayList<String> camper5Relations = new ArrayList<String>();
		ArrayList<Contact> camper5Contacts = new ArrayList<Contact>();
		ArrayList<String> camper5Themes = new ArrayList<String>();

		bday = "05/26/2011";
		birthday = formatter.parse(bday); 
		camper5Meds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camper5Allergies.add("blueberries");
		camper5Relations.add("Mom");
		camper5Contacts.add(new Contact("Catherine Sams", "7783346661", "442 Red Brick Rd", "catsams@gmail.com"));
		camper5Themes.add("legos");
		camperList.add(new Camper(UUID.randomUUID(), "rose sams", birthday,camper5Meds, camper5Allergies, camper5Relations, camper5Contacts, camper5Themes));

        ArrayList<Camper> guardian5Campers = new ArrayList<Camper>();
		guardian5Campers.add(camperList.get(4));
		guardianList.add(new Guardian(UUID.randomUUID(), "Catherine Sams", "catsams@gmail.com", "password", "7783346661", guardian5Campers));

        DataWriter.saveGuardians();
		assertEquals("rose sams", DataLoader.loadGuardians().get(4).getCampers().get(0).getName());
	}
	
	@Test
	void testWritingEmptyGuardian() throws ParseException {
        ArrayList<Camper> guardianCampers = new ArrayList<Camper>();
		guardianList.add(new Guardian(UUID.fromString("00000000-0000-0000-0000-000000000000"), "", "", "", "", guardianCampers));
        DataWriter.saveGuardians();
		assertEquals("", DataLoader.loadGuardians().get(0).getName());
	}
	
	@Test
	void testWritingNullGuardian() {
        ArrayList<Camper> guardianCampers = new ArrayList<Camper>();
		guardianList.add(new Guardian(null, null, null, null, null, guardianCampers));
        DataWriter.saveGuardians();
		assertEquals(null, DataLoader.loadGuardians().get(0).getName());
	}


    //testing cabin writer


    @Test
	void testWritingZeroCabins() {
		cabinList = DataLoader.loadCabins();
		assertEquals(0, cabinList.size());
	}

	@Test
	void testWritingOneCabin() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
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

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
		
        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		cabin1Campers.add(camperList.get(0));
			
		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
		DataWriter.saveCabin();
		assertEquals("bob smith", DataLoader.loadCabins().get(0).getCampers().get(0).getName());
	}
	
	@Test
	void testWritingTwoCabins() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
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

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
		
        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		cabin1Campers.add(camperList.get(0));
			
		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
        ArrayList<String> counselor2Allergies = new ArrayList<String>();
		ArrayList<String> counselor2Relations = new ArrayList<String>();
		ArrayList<Contact> counselor2Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor2Themes = new ArrayList<String>();
		bday = "10/04/2002";  
		birthday = formatter.parse(bday); 
		counselor2Allergies.add("pollen");
		counselor2Relations.add("Friend");
		counselor2Contacts.add(new Contact("matt smith", "8893345567", "12 lake street", "mattsmith88@yahoo.com"));
		counselor2Themes.add("ninja warriors");
		counselorList.add(new Counselor(UUID.randomUUID(), "Kai Finger", "kaif88@yahoo.com", "password","8803442211", "hello my name is kai finger", counselor2Relations, counselor2Contacts, birthday, counselor2Allergies, counselor2Themes));
		
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
		camper2Themes.add("cars");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes));

        ArrayList<Camper> cabin2Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin2Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin2Schedules = new ArrayList<Schedule>();
		
		cabin2Campers.add(camperList.get(1));
		
		for(int i = 0; i<7; i++){
			cabin2Schedules.add(new Schedule(campActivities, 1));
		}

		cabin2Counselors.add(counselorList.get(1));
		
		cabinList.add(new Cabin(cabin2Campers, cabin2Counselors, 9.0, 7.0, cabin2Schedules, UUID.randomUUID() ));
        DataWriter.saveCabin();
		assertEquals("Kai Finger", DataLoader.loadCabins().get(1).getCounselors().get(0).getName());
	

	}
	
	@Test
	void testWritingEmptyCabin() throws ParseException {
        ArrayList<Camper> cabin2Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin2Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin2Schedules = new ArrayList<Schedule>();
		
		
		cabinList.add(new Cabin(cabin2Campers, cabin2Counselors,  0.0, 0.0, cabin2Schedules, UUID.fromString("00000000-0000-0000-0000-000000000000")));
        DataWriter.saveCabin();
		assertEquals(0.0, DataLoader.loadCabins().get(0).getMaxAge());
	}
	
	@Test
	void testWritingNullCabin() {
		cabinList.add(new Cabin(null, null,0 , 0, null, null));
        DataWriter.saveCabin();
		assertEquals(null, DataLoader.loadCabins().get(0).getMaxAge());
	}


    //testing session writing
    @Test
	void testWritingZeroSessions() {
		sessionList = DataLoader.loadSessions();
		assertEquals(0, sessionList.size());
	}

	@Test
	void testWritingOneSession() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
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

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
		
        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		cabin1Campers.add(camperList.get(0));
			
		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
        ArrayList<Cabin> session1Cabins = new ArrayList<Cabin>();
		session1Cabins.add(cabinList.get(0));
		String start = "07/01/2023";
		Date startDate = formatter.parse(start);      
		String end = "07/14/2023";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "hawaiian", session1Cabins, "lets go girls", startDate, endDate));
		

		DataWriter.saveSessions();
		assertEquals("hawaiian", DataLoader.loadSessions().get(0).getTheme());
	}
	
	@Test
	void testWritingTwoSessions() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
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

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
		
        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		cabin1Campers.add(camperList.get(0));
			
		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
        ArrayList<Cabin> session1Cabins = new ArrayList<Cabin>();
		session1Cabins.add(cabinList.get(0));
		String start = "07/01/2023";
		Date startDate = formatter.parse(start);      
		String end = "07/14/2023";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "hawaiian", session1Cabins, "aloha", startDate, endDate));
		

        ArrayList<String> counselor2Allergies = new ArrayList<String>();
		ArrayList<String> counselor2Relations = new ArrayList<String>();
		ArrayList<Contact> counselor2Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor2Themes = new ArrayList<String>();
		bday = "10/04/2002";  
		birthday = formatter.parse(bday); 
		counselor2Allergies.add("pollen");
		counselor2Relations.add("Friend");
		counselor2Contacts.add(new Contact("matt smith", "8893345567", "12 lake street", "mattsmith88@yahoo.com"));
		counselor2Themes.add("ninja warriors");
		counselorList.add(new Counselor(UUID.randomUUID(), "Kai Finger", "kaif88@yahoo.com", "password","8803442211", "hello my name is kai finger", counselor2Relations, counselor2Contacts, birthday, counselor2Allergies, counselor2Themes));
		
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
		camper2Themes.add("cars");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes));

        ArrayList<Camper> cabin2Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin2Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin2Schedules = new ArrayList<Schedule>();
		
		cabin2Campers.add(camperList.get(1));
		
		for(int i = 0; i<7; i++){
			cabin2Schedules.add(new Schedule(campActivities, 1));
		}

		cabin2Counselors.add(counselorList.get(1));
		
		cabinList.add(new Cabin(cabin2Campers, cabin2Counselors, 9.0, 7.0, cabin2Schedules, UUID.randomUUID() ));
        
        
        ArrayList<Cabin> session2Cabins = new ArrayList<Cabin>();
		session2Cabins.add(cabinList.get(1));
		start = "07/01/2023";   
		startDate = formatter.parse(start);      
		end = "07/14/2023";
		endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "cars", session2Cabins, "zoom", startDate, endDate));
		

        DataWriter.saveSessions();
		assertEquals("cars", DataLoader.loadSessions().get(1).getTheme());
	

	}
	
	@Test
	void testWritingEmptySession() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
        ArrayList<Cabin> session2Cabins = new ArrayList<Cabin>();
		String start = "";   
		Date startDate = formatter.parse(start);      
		String end = "";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.fromString("00000000-0000-0000-0000-000000000000"), "", session2Cabins, "", startDate, endDate));
		DataWriter.saveSessions();
		assertEquals("", DataLoader.loadSessions().get(0).getTheme());
	}
	
	@Test
	void testWritingNullSession() {
		sessionList.add(new Session(null, null, null, null, null, null));
		DataWriter.saveSessions();
		assertEquals(null, DataLoader.loadSessions().get(0).getTheme());
	}


    //test camp writing
    @Test
	void testWritingZeroCamps() {
		campList = DataLoader.loadCamp();
		assertEquals(0, campList.size());
	}

	@Test
	void testWritingCampWithOneSession() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
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

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
		
        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		cabin1Campers.add(camperList.get(0));
			
		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
        ArrayList<Cabin> session1Cabins = new ArrayList<Cabin>();
		session1Cabins.add(cabinList.get(0));
		String start = "07/01/2023";
		Date startDate = formatter.parse(start);      
		String end = "07/14/2023";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "hawaiian", session1Cabins, "lets go girls", startDate, endDate));
		
        ArrayList<FAQ> faqs = new ArrayList<FAQ>();
        faqs.add(new FAQ("What is the price", "$500.50"));

		campList.add(new Camp(UUID.randomUUID(), "247",sessionList, 500.50, faqs,8.0,campActivities));
		
		DataWriter.saveCamp();
		assertEquals("247", DataLoader.loadCamp().get(0).getName());
	}
	
	@Test
	void testWritingCampwithTwoSessions() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
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

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");  
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
		
        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

		cabin1Campers.add(camperList.get(0));
			
		for(int i = 0; i<7; i++){
			cabin1Schedules.add(new Schedule(campActivities, 1));
		}

		cabin1Counselors.add(counselorList.get(0));
		cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID() ));
		
        ArrayList<Cabin> session1Cabins = new ArrayList<Cabin>();
		session1Cabins.add(cabinList.get(0));
		String start = "07/01/2023";
		Date startDate = formatter.parse(start);      
		String end = "07/14/2023";
		Date endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "hawaiian", session1Cabins, "aloha", startDate, endDate));
		

        ArrayList<String> counselor2Allergies = new ArrayList<String>();
		ArrayList<String> counselor2Relations = new ArrayList<String>();
		ArrayList<Contact> counselor2Contacts = new ArrayList<Contact>();
		ArrayList<String> counselor2Themes = new ArrayList<String>();
		bday = "10/04/2002";  
		birthday = formatter.parse(bday); 
		counselor2Allergies.add("pollen");
		counselor2Relations.add("Friend");
		counselor2Contacts.add(new Contact("matt smith", "8893345567", "12 lake street", "mattsmith88@yahoo.com"));
		counselor2Themes.add("ninja warriors");
		counselorList.add(new Counselor(UUID.randomUUID(), "Kai Finger", "kaif88@yahoo.com", "password","8803442211", "hello my name is kai finger", counselor2Relations, counselor2Contacts, birthday, counselor2Allergies, counselor2Themes));
		
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
		camper2Themes.add("cars");
		camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes));

        ArrayList<Camper> cabin2Campers = new ArrayList<Camper>();
		ArrayList<Counselor> cabin2Counselors = new ArrayList<Counselor>();
		ArrayList<Schedule> cabin2Schedules = new ArrayList<Schedule>();
		
		cabin2Campers.add(camperList.get(1));
		
		for(int i = 0; i<7; i++){
			cabin2Schedules.add(new Schedule(campActivities, 1));
		}

		cabin2Counselors.add(counselorList.get(1));
		
		cabinList.add(new Cabin(cabin2Campers, cabin2Counselors, 9.0, 7.0, cabin2Schedules, UUID.randomUUID() ));
        
        
        ArrayList<Cabin> session2Cabins = new ArrayList<Cabin>();
		session2Cabins.add(cabinList.get(1));
		start = "07/01/2023";   
		startDate = formatter.parse(start);      
		end = "07/14/2023";
		endDate = formatter.parse(end);     
		sessionList.add(new Session(UUID.randomUUID(), "cars", session2Cabins, "zoom", startDate, endDate));
		

        ArrayList<FAQ> faqs = new ArrayList<FAQ>();
        faqs.add(new FAQ("What is the price", "$500.50"));

		campList.add(new Camp(UUID.randomUUID(), "247",sessionList, 500.50, faqs,8.0,campActivities));
		
		DataWriter.saveCamp();
		assertEquals("247", DataLoader.loadCamp().get(0).getName());
	

	}
	
	@Test
	void testWritingEmptyCamp() throws ParseException {
        ArrayList<String> campActivities = new ArrayList<String>();
        ArrayList<FAQ> faqs = new ArrayList<FAQ>();
        
		campList.add(new Camp(UUID.fromString("00000000-0000-0000-0000-000000000000"), "",sessionList, 0.0, faqs,0.0,campActivities));
		
		DataWriter.saveCamp();
		assertEquals("", DataLoader.loadCamp().get(0).getName());
	
	}
	
	@Test
	void testWritingNullCamp() {
		campList.add(new Camp(null, null,null, 0, null,0,null));
		DataWriter.saveCamp();
		assertEquals(null, DataLoader.loadCamp().get(0).getName());
	}

	
}