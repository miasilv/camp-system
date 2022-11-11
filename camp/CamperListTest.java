package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CamperListTest {
    private CamperList campers = CamperList.getInstance();
    private ArrayList<Camper> camperList = campers.getCampers();

    @BeforeEach
    public void setUp() {
        //TODO wait for nat on this one
    }

    @AfterEach
    public void tearDown() {
        CamperList.getInstance().getCampers().clear();
        DataWriter.saveCampers();
    }

    @Test
    void testGetCamperUUIDFirstItem() {
        Camper first = campers.getCamper("uuid of the first camper");
        assertSame(first, camperList.get(0));
    }

    @Test
    void testGetCamperUUIDSecondItem() {
        Camper second = campers.getCamper("uuid of second camper");
        assertSame(second, camperList.get(1));
    }

    @Test
    void testGetCamperUUIDNull() {
        Camper n = campers.getCamper("null");
        assertSame(n, null);
    }

    @Test
    void testGetCamperUUIDInvalid() {
        Camper invalid = campers.getCamper("invalid uuid here");
        assertSame(invalid, null);
    }

    @Test
    void testGetCamperUUIDEmpty() {
        Camper empty = campers.getCamper("empty uuid");
        assertSame(empty, null);
    }
}
