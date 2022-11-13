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

public class CounselorListTest {
    private CounselorList counselors = CounselorList.getInstance();
    private ArrayList<Counselor> counselorList = counselors.getCounselors();

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

        counselorList.clear();

        // sent in from nat's data loader test
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
        UUID counselor1UUID = UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11");
        counselorList.add(new Counselor(counselor1UUID, "John Messy", "j@gmail.com", "password", "899003349",
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
        counselor2Contacts.add(new Contact("bethany bahr", "9903345567", "12 Land Stone Street", "bethybahr@gmail.com"));
        counselor2Themes.add("cheetah girls");
        UUID counselor2UUID = UUID.fromString("8e99955f-d23e-40a0-b693-231c42f41f09");
        counselorList.add(new Counselor(counselor2UUID, "Mackenzie McIntyre", "m@gmail.com", "password",
                "1012334569", "hello my name is mackenzie mcintyre", counselor2Relations, counselor2Contacts, birthday,
                counselor2Allergies, counselor2Themes));
        
        DataWriter.saveCounselors();
    }

    @AfterEach
    public void tearDown() {
        CounselorList.getInstance().getCounselors().clear();
        DataWriter.saveCounselors();
    }

    // GET COUNSELOR (EMAIL) ------------------------------------------------

    @Test
    void testGetCounselorEmailFirstItem() {
        Counselor first = counselors.getCounselor("j@gmail.com"); // i'm sorry nat i changed the emails
        assertSame(first, counselorList.get(0));
    }

    @Test
    void testGetCounselorEmailSecondItem() {
        Counselor second = counselors.getCounselor("m@gmail.com");
        assertSame(second, counselorList.get(1));
    }

    @Test
    void testGetCounselorEmailNull() {
        Counselor n = counselors.getCounselor("null");
        assertSame(n, null);
    }

    @Test
    void testGetCounselorEmailInvalid() {
        Counselor invalid = counselors.getCounselor("invalid email string here");
        assertSame(invalid, null);
    }

    @Test
    void testGetCounselorEmailEmpty() {
        Counselor empty = counselors.getCounselor("");
        assertSame(empty, null);
    }

    @Test
    void testGetCounselorEmailWrongFormat() {
        Counselor wrongFormat = counselors.getCounselor("j@yahoo.com");
        assertSame(wrongFormat, null);
    }

    // GET COUNSELOR (UUID) ------------------------------------------------------

    @Test
    void testGetCounselorUUIDFirstItem() {
        Counselor first = counselors.getCounselor(UUID.fromString("24d02b77-3ce4-4765-b3a8-79e0cfe22a11"));
        assertSame(first, counselorList.get(0));
    }

    @Test
    void testGetCounselorUUIDSecondItem() {
        Counselor second = counselors.getCounselor(UUID.fromString("8e99955f-d23e-40a0-b693-231c42f41f09"));
        assertSame(second, counselorList.get(1));
    }

    @Test
    void testGetCounselorUUIDNull() {
        Counselor n = counselors.getCounselor(UUID.fromString(null));
        assertSame(n, null);
    }

    @Test
    void testGetCounselorUUIDInvalid() {
        Counselor invalid = counselors.getCounselor(UUID.fromString("invalid uuid"));
        assertSame(invalid, null);
    }

    @Test
    void testGetCounselorUUIDEmpty() {
        Counselor empty = counselors.getCounselor(UUID.fromString(""));
        assertSame(empty, null);
    }

    @Test
    void testGetCounselerUUIDBlank() {
        Counselor blank = counselors.getCounselor(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        assertSame(blank, null);
    }
}
