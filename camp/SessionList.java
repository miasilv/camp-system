package camp;

import java.util.ArrayList;
import java.util.UUID;

public class SessionList {
    private ArrayList<Session> sessions;
    private static SessionList sessionList;
    
    private SessionList(){
        sessions = DataLoader.loadSessions();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public static SessionList getInstance(){
        if (sessionList == null){
            sessionList = new SessionList();        
        }
        return sessionList;
    }

    public ArrayList<Session> getSessions(){
        return sessions;
    }

    public Session getSession(UUID id) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getID().equals(id)) {
                return sessions.get(i);
            }
        }
        return null; // if unable to find it
    }

}
