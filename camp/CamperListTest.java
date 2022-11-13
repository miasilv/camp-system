package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CamperListTest {
    private CamperList campers = CamperList.getInstance();
    private ArrayList<Camper> camperList = campers.getCampers();

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

        camperList.clear();

        // imported from nat's dataloader tester
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
        UUID camper1UUID = UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11");
        camperList.add(new Camper(camper1UUID, "bob smith", birthday, camper1Meds, camper1Allergies,
                camper1Relations, camper1Contacts, camper1Themes));

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
        camper2Contacts
                .add(new Contact("Catherine Steen", "8803345578", "33 Lake Shore Drive", "drsteensoffice@gmail.com"));
        camper2Themes.add("cheetah girls");
        UUID camper2UUID = UUID.fromString("8e99955f-d23e-40a0-b693-231c42f41f09");
        camperList.add(new Camper(camper2UUID, "josie king", birthday, camper2Meds, camper2Allergies,
                camper2Relations, camper2Contacts, camper2Themes));

    }

    @AfterEach
    public void tearDown() {
        CamperList.getInstance().getCampers().clear();
        DataWriter.saveCampers();
    }

    @Test
    void testGetCamperUUIDFirstItem() {
        Camper first = campers.getCamper(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11"));
        assertSame(first, camperList.get(0));
    }

    @Test
    void testGetCamperUUIDSecondItem() {
        Camper second = campers.getCamper(UUID.fromString("8e99955f-d23e-40a0-b693-231c42f41f09"));
        assertSame(second, camperList.get(1));
    }

    @Test
    void testGetCamperUUIDBlank() {
        Camper blank = campers.getCamper(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        assertSame(blank, null);
    }
    
    @Test
    void testGetCamperUUIDName() {
        String Camper1Name = campers.getCamper(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11")).getName();
        assertSame(Camper1Name, "bob smith");
    }

    @Test
    void testGetCamperUUIDRelationships() {
        ArrayList<String> Camper1Relationships = campers.getCamper(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11")).getRelationships();
        assertSame(Camper1Relationships, camperList.get(0).getRelationships());
    }

    @Test
    void testGetCamperUUIDThemes() {
        String Camper1Theme = campers.getCamper(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11")).getSessionThemes().get(0);
        assertEquals(Camper1Theme, "hawaiian");
    }
}
