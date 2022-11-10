package camp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {
    private UserList users = UserList.getInstance();
    private ArrayList<Director> directors = users.getDirectors();
    private ArrayList<Counselor> counselors = users.getCounselors();
    private ArrayList<Guardian> guardians = users.getGuardians();
    private ArrayList<Camper> campers = users.getCampers();

    @BeforeEach
    public void setUp() {
        // TODO wait for nat on this one
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getDirectors().clear();
        UserList.getInstance().getCounselors().clear();
        UserList.getInstance().getGuardians().clear();
        UserList.getInstance().getCampers().clear();

        DataWriter.saveDirectors();
        DataWriter.saveCounselors();
        DataWriter.saveGuardians();
        DataWriter.saveCampers();
    }

    // GET USER (EMAIL) ----------------------------------------------------

    // GET USER (ID) -------------------------------------------------------

    @Test
    void testGetUserUUIDFirstItem() {
        User first = users.getUser("uuid of the first camper");
        assertSame(first, userList.get(0));
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
