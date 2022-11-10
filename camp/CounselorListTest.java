package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounselorListTest {
    private CounselorList counselors = CounselorList.getInstance();
    private ArrayList<Counselor> counselorList = counselors.getCounselors();

    @BeforeEach
    public void setUp() {
        counselorList.clear();
        counselorList.add(new Counselor("Sydney", "s@gmail.com", "password","803-454-3344"));
        counselorList.add(new Counselor("John", "j@gmail.com", "password","803-333-3544"));
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
        Counselor first = counselors.getCounselor("s@gmail.com");
        assertSame(first, counselorList.get(0));
    }

    @Test
    void testGetCounselorEmailSecondItem() {
        Counselor second = counselors.getCounselor("");
        assertSame(second, counselorList.get(1));
    }

    @Test
    void testGetCounselorEmailNull() {
        Counselor n = counselors.getCounselor("null");
        assertSame(n, null);
    }

    @Test
    void testGetCounselorEmailInvalid() {
        Counselor invalid = counselors.getCounselor("invalid email here");
        assertSame(invalid, null);
    }

    @Test
    void testGetCounselorEmailEmpty() {
        Counselor empty = counselors.getCounselor("");
        assertSame(empty, null);
    }

    // GET COUNSELOR (UUID) ------------------------------------------------------

    @Test
    void testGetCounselorUUIDFirstItem() {
        Counselor first = counselors.getCounselor("uuid of the first couns");
        assertSame(first, counselorList.get(0));
    }

    @Test
    void testGetCounselorUUIDSecondItem() {
        Counselor second = counselors.getCounselor("uuid of second couns");
        assertSame(second, counselorList.get(1));
    }

    @Test
    void testGetCounselorUUIDNull() {
        Counselor n = counselors.getCounselor("null");
        assertSame(n, null);
    }

    @Test
    void testGetCounselorUUIDInvalid() {
        Counselor invalid = counselors.getCounselor("invalid uuid here");
        assertSame(invalid, null);
    }

    @Test
    void testGetCounselorUUIDEmpty() {
        Counselor empty = counselors.getCounselor("empty uuid");
        assertSame(empty, null);
    }
}
