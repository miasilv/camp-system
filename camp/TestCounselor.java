
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

class TestCounselor {
    private Counselor counselor;


	@BeforeEach
	public void setup() throws ParseException {
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
		this.counselor = new Counselor(UUID.randomUUID(), "John Messy", "johnmessy@yahoo.com", "password","899003349", "hello my name is john messy", counselor1Relations, counselor1Contacts, birthday, counselor1Allergies, counselor1Themes);
	
	
	}
	
	@AfterEach
	public void tearDown() {
		this.counselor= null;
	}
	


	//testing counselor methods
	@Test
	void testCounslorAddBio() {
		counselor.addBio("boo hoo hoo");
		assertEquals("boo hoo hoo", counselor.getBio());
	}

	
	@Test
	void testCounselorAddAllergies() {
		counselor.addAllergies("pollen");
		assertEquals("pollen", counselor.getAllergies().get(1));
	}
	
	@Test
	void testCounselorRemoveAllergies() {
		counselor.removeAllergy("blueberries");
		assertEquals(null, counselor.getAllergies().get(0));
	}

    @Test
	void testCounselorAddAllergiesBoolean() {
		counselor.addAllergy("pollen");
		assertTrue(counselor.addAllergy("pollen"));
	}

    @Test
	void testCounselorRemoveAllergiesBoolean() {
		counselor.removeAllergy("blueberries");
		assertTrue(counselor.removeAllergy(0));
	}

    @Test
	void testCounselorRemoveEmergencyContact() {
		counselor.removeEmergencyContact("Friend");
		assertTrue(counselor.removeEmergencyContact("Friend"));
	}

    @Test
	void testCounselorAddEmergencyContact() {
		counselor.addEmergencyContact("friend", "booksky", "booksky@gmail.com", "8993345532", "12 trick or treat road");
		assertEquals("booksky", counselor.getEmergencyContacts().get("friend").getName());
	}

    @Test
	void testCounselorRemoveSession() {
		//counselor.removeSession(counselor.getSessionThemes().get(i));
        //assertTrue(counselor.removeSession(counselor.getSessionThemes().get(i)))
	}

    @Test
	void testCounselorAddSession() {
		//counselor.addSession(counselor.getSessionThemes());
        //assertTrue(counselor.addSession(counselor.getSessionThemes()));
	}



}