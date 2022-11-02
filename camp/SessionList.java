package camp;

/**
 * @author Natalie Crawford
 * session list class
 * 
 */
import java.util.ArrayList;
import java.util.UUID;

public class SessionList {
    private ArrayList<Session> sessions;
    private static SessionList sessionList;
    
    /**
     * default constructor
     */
    private SessionList(){
        sessions = DataLoader.loadSessions();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of session
     * @return the instance of session
     */
    public static SessionList getInstance(){
        if (sessionList == null){
            sessionList = new SessionList();        
        }
        return sessionList;
    }

    /**
     * returns the sessions list
     * @return sessions
     */
    public ArrayList<Session> getSessions(){
        return sessions;
    }

    /**
     * accesses a session based on UUID
     * @param id the UUID were looking for
     * @return the session with that id
     */
    public Session getSession(UUID id) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getID().equals(id)) {
                return sessions.get(i);
            }
        }
        return null; // if unable to find it
    }

}
