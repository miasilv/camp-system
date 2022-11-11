package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabinListTest {
    private CabinList cabins = CabinList.getInstance();
    private ArrayList<Cabin> cabinList = cabins.getCabins();

    @BeforeEach
    public void setUp() {
        // TODO wait for nat on this one
    }

    @AfterEach
    public void tearDown() {
        CabinList.getInstance().getCabins().clear();
        DataWriter.saveCabin();
    }

    @Test
    void testGetCabinUUIDFirstItem() {
        Cabin first = cabins.getCabin("uuid of the first camper");
        assertSame(first, cabinList.get(0));
    }

    @Test
    void testGetCabinUUIDSecondItem() {
        Cabin second = cabins.getCabin("uuid of second camper");
        assertSame(second, cabinList.get(1));
    }

    @Test
    void testGetCabinUUIDNull() {
        Cabin n = cabins.getCabin("null");
        assertSame(n, null);
    }

    @Test
    void testGetCabinUUIDInvalid() {
        Cabin invalid = cabins.getCabin("invalid uuid here");
        assertSame(invalid, null);
    }

    @Test
    void testGetCabinUUIDEmpty() {
        Cabin empty = cabins.getCabin("empty uuid");
        assertSame(empty, null);
    }
}
