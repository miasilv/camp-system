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

public class SessionListTest {
    private CampList camps = CampList.getInstance();
    private ArrayList<Camp> campList = camps.getCamps();
    private ArrayList<FAQ> faqs = new ArrayList<FAQ>();

    // private ArrayList<Session> campSessions = new ArrayList<Session>();

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
    public void setUp() throws ParseException {
        // written by nat, used to test the sessionList class

    /*
    Our sessions has a lot of dependencies, such we will also need to create 
    counselors, campers, and cabins to test this class's methods.
    */

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        camperList.clear();
        counselorList.clear();
        cabinList.clear();
        sessionList.clear();
        directorList.clear();
        guardianList.clear();
        campList.clear();

        campActivities.add("wake up");
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

        directorList
                .add(new Director(UUID.randomUUID(), "bob wright", "bobwright88@yahoo.com", "password", "8045569988"));

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
        counselorList.add(new Counselor(UUID.randomUUID(), "John Messy", "johnmessy@yahoo.com", "password", "899003349",
                "hello my name is john messy", counselor1Relations, counselor1Contacts, birthday, counselor1Allergies,
                counselor1Themes));

        ArrayList<String> counselor2Allergies = new ArrayList<String>();
        ArrayList<String> counselor2Relations = new ArrayList<String>();
        ArrayList<Contact> counselor2Contacts = new ArrayList<Contact>();
        ArrayList<String> counselor2Themes = new ArrayList<String>();

        bday = "05/28/2000";
        birthday = formatter.parse(bday);
        counselor2Allergies.add("pollen");
        counselor2Relations.add("Friend");
        counselor2Contacts
                .add(new Contact("bethany bahr", "9903345567", "12 Land Stone Street", "bethybahr@gmail.com"));
        counselor2Themes.add("cheetah girls");
        counselorList.add(new Counselor(UUID.randomUUID(), "Mackenzie McIntyre", "mackmack@yahoo.com", "password",
                "1012334569", "hello my name is mackenzie mcintyre", counselor2Relations, counselor2Contacts, birthday,
                counselor2Allergies, counselor2Themes));

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
        camperList.add(new Camper(UUID.randomUUID(), "bob smith", birthday, camper1Meds, camper1Allergies,
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
        camperList.add(new Camper(UUID.randomUUID(), "josie king", birthday, camper2Meds, camper2Allergies,
                camper2Relations, camper2Contacts, camper2Themes));

        /**
         * guardians
         */
        ArrayList<Camper> guardian1Campers = new ArrayList<Camper>();
        guardian1Campers.add(camperList.get(0));
        guardianList.add(new Guardian(UUID.randomUUID(), "Karen Smith", "karensmith@gmail.com", "password",
                "8034423366", guardian1Campers));

        ArrayList<Camper> guardian2Campers = new ArrayList<Camper>();

        guardian2Campers.add(camperList.get(1));
        guardianList.add(new Guardian(UUID.randomUUID(), "Matt King", "mattking@gmail.com", "password", "9993324456",
                guardian2Campers));

        /**
         * cabins
         */

        ArrayList<Camper> cabin1Campers = new ArrayList<Camper>();
        ArrayList<Counselor> cabin1Counselors = new ArrayList<Counselor>();
        ArrayList<Schedule> cabin1Schedules = new ArrayList<Schedule>();

        for (int i = 0; i < camperList.size(); i++) {
            if (i < camperList.size() / 2) {
                cabin1Campers.add(camperList.get(i));
            }
        }

        for (int i = 0; i < 7; i++) {
            cabin1Schedules.add(new Schedule(campActivities, 1));
        }

        cabin1Counselors.add(counselorList.get(0));

        cabinList.add(new Cabin(cabin1Campers, cabin1Counselors, 12.0, 10.0, cabin1Schedules, UUID.randomUUID()));

        ArrayList<Camper> cabin2Campers = new ArrayList<Camper>();
        ArrayList<Counselor> cabin2Counselors = new ArrayList<Counselor>();
        ArrayList<Schedule> cabin2Schedules = new ArrayList<Schedule>();

        for (int i = 0; i < camperList.size(); i++) {
            if (i >= camperList.size() / 2) {
                cabin2Campers.add(camperList.get(i));
            }
        }
        for (int i = 0; i < 7; i++) {
            cabin2Schedules.add(new Schedule(campActivities, 1));
        }

        cabin2Counselors.add(counselorList.get(0));

        cabinList.add(new Cabin(cabin2Campers, cabin2Counselors, 9.0, 7.0, cabin2Schedules, UUID.randomUUID()));

        /**
         * sessions
         */

        ArrayList<Cabin> session1Cabins = new ArrayList<Cabin>();
        session1Cabins.add(cabinList.get(0));
        String start = "07/01/2023";
        Date startDate = formatter.parse(start);
        String end = "07/14/2023";
        Date endDate = formatter.parse(end);
        UUID session1UUID = UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11");
        sessionList.add(
                new Session(session1UUID, "cheetah girls", session1Cabins, "lets go girls", startDate, endDate));

        ArrayList<Cabin> session2Cabins = new ArrayList<Cabin>();
        session2Cabins.add(cabinList.get(1));
        start = "07/01/2023";
        startDate = formatter.parse(start);
        end = "07/14/2023";
        endDate = formatter.parse(end);
        UUID session2UUID = UUID.fromString("8e99955f-d23e-40a0-b693-231c42f41f09");
        sessionList.add(new Session(session2UUID, "hawaiian", session2Cabins, "aloha", startDate, endDate));

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
    void testGetSessionUUIDFirstItem() {
        Session first = sessions.getSession(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11"));
        assertSame(first, sessionList.get(0));
    }

    @Test
    void testGetSessionUUIDSecondItem() {
        Session second = sessions.getSession(UUID.fromString("8e99955f-d23e-40a0-b693-231c42f41f09"));
        assertSame(second, sessionList.get(1));
    }

    @Test
    void testGetSessionUUIDBlank() {
        Session blank = sessions.getSession(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        assertSame(blank, null);
    }

    @Test
    void testGetSessionUUIDTheme() {
        String Session1Theme = sessions.getSession(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11")).getTheme();
        assertSame(Session1Theme, "cheetah girls");
    }

    @Test
    void testGetSessionUUIDCabins() {
        ArrayList<Cabin> Session1Cabins = sessions
                .getSession(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11")).getCabins();
        assertSame(Session1Cabins, sessionList.get(0).getCabins());
    }

    @Test
    void testGetSessionUUIDStartDate() {
        String Session1StartDate = sessions.getSession(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11"))
                .getStrStart();
        assertEquals(Session1StartDate, "07/01/2023");
    }
}
