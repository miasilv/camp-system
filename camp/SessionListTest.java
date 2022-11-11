package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SessionListTest {
    private SessionList sessions = SessionList.getInstance();
    private ArrayList<Session> sessionList = sessions.getSessions();

    @BeforeEach
    public void setUp() {
        // TODO wait for nat on this one
    }

    @AfterEach
    public void tearDown() {
        SessionList.getInstance().getSessions().clear();
        DataWriter.saveSessions();
    }

    @Test
    void testGetSessionUUIDFirstItem() {
        Session first = sessions.getSession("uuid of the first camper");
        assertSame(first, sessionList.get(0));
    }

    @Test
    void testGetSessionUUIDSecondItem() {
        Session second = sessions.getSession("uuid of second camper");
        assertSame(second, sessionList.get(1));
    }

    @Test
    void testGetSessionUUIDNull() {
        Session n = sessions.getSession("null");
        assertSame(n, null);
    }

    @Test
    void testGetSessionUUIDInvalid() {
        Session invalid = sessions.getSession("invalid uuid here");
        assertSame(invalid, null);
    }

    @Test
    void testGetSessionUUIDEmpty() {
        Session empty = sessions.getSession("empty uuid");
        assertSame(empty, null);
    }
}
