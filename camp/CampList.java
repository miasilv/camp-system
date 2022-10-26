package camp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * an object representing a camp
 * @author sara
 */


public class CampList {
    private ArrayList<Camp> camps;
    private ArrayList<Cabin> cabins;
    private ArrayList<Session> sessions;
    private static CampList campList;

    private CampList(){
        sessions = DataLoader.loadSessions();
        cabins = DataLoader.loadCabins();
        camps = DataLoader.loadCamp();
        
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public static CampList getInstance(){
        if (campList == null){
            campList = new CampList();            
        }
        return campList;
    }

    public ArrayList<Camp> getCamps() {
        return camps;
    }

    public ArrayList<Cabin> getCabins() {
        return cabins;
    }
    public ArrayList<Session> getSessions(){
        return sessions;
    }

    public Camp getCamp(UUID id) {
        for (int i=0; i < camps.size(); i++) {
            if (camps.get(i).getId().equals(id)) {
                return camps.get(i);
            }
        }
        return null; // if unable to find it
    }

    public Cabin getCabin(UUID id) {
        for (int i = 0; i < cabins.size(); i++) {
            if (cabins.get(i).getID().equals(id)) {
                return cabins.get(i);
            }
        }
        return null; // if unable to find it
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
