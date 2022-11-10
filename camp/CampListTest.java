package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampListTest {
    private CampList camps = CampList.getInstance();
    private ArrayList<Camp> campList = camps.getCamps();

    @BeforeEach
    public void setUp() {
        // TODO wait for nat on this one
    }

    @AfterEach
    public void tearDown() {
        CampList.getInstance().getCamps().clear();
        DataWriter.saveCamp();
    }

    @Test
    void testGetCampUUIDFirstItem() {
        Camp first = camps.getCamp("uuid of the first camper");
        assertSame(first, campList.get(0));
    }

    @Test
    void testGetCampUUIDSecondItem() {
        Camp second = camps.getCamp("uuid of second camper");
        assertSame(second, campList.get(1));
    }

    @Test
    void testGetCampUUIDNull() {
        Camp n = camps.getCamp("null");
        assertSame(n, null);
    }

    @Test
    void testGetCampUUIDInvalid() {
        Camp invalid = camps.getCamp("invalid uuid here");
        assertSame(invalid, null);
    }

    @Test
    void testGetCampUUIDEmpty() {
        Camp empty = camps.getCamp("empty uuid");
        assertSame(empty, null);
    }
}
