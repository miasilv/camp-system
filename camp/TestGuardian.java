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

class TestGuardian {
    private CamperList campers = CamperList.getInstance();
	private ArrayList<Camper> camperList = campers.getCampers();
	private UserList users = UserList.getInstance();
	private ArrayList<Guardian> guardianList = users.getGuardians();
    private Guardian guardian;

	@BeforeEach
	public void setup() throws ParseException {
        /**
		 * campers
		 */
		
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
		


		/**
		 * guardians
		 */
		ArrayList<Camper> guardian1Campers = new ArrayList<Camper>();
		guardian1Campers.add(camperList.get(0));
		guardian = new Guardian(UUID.randomUUID(), "Karen Smith", "karensmith@gmail.com", "password", "8034423366", guardian1Campers);
		
		
	
	}
	
	@AfterEach
	public void tearDown() {
		this.guardian= null;
        camperList.clear();
	}
	


	//testing guardian methods
	@Test
	void testGuardianAddCamper() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        ArrayList<Medication> camper2Meds = new ArrayList<Medication>();
		ArrayList<String> camper2Allergies = new ArrayList<String>();
		ArrayList<String> camper2Relations = new ArrayList<String>();
		ArrayList<Contact> camper2Contacts = new ArrayList<Contact>();
		ArrayList<String> camper2Themes = new ArrayList<String>();

		String bday = "06/14/2014";
		Date birthday = formatter.parse(bday); 
		camper2Meds.add(new Medication("one puff", "albuterol", "during asthma attacks"));
		camper2Allergies.add("pollen");
		camper2Allergies.add("peanuts");
		camper2Relations.add("Doctor");
		camper2Contacts.add(new Contact("Catherine Steen", "8803345578", "33 Lake Shore Drive", "drsteensoffice@gmail.com"));
		camper2Themes.add("cheetah girls");
		Camper camper = new Camper(UUID.randomUUID(), "josie king", birthday,camper2Meds, camper2Allergies, camper2Relations, camper2Contacts, camper2Themes);

		guardian.addCamper(camper);
		assertEquals("josie king", guardian.getCamper(1).getName());
	}

	
	@Test
	void testGuardianRemoveCamper() {
		guardian.removeCamper(0);
        assertEquals(0, guardian.getCampers().size());
	}
}