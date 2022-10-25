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
    private static CampList campList;

    private CampList(){
        camps = DataLoader.loadCamp();
        cabins = DataLoader.loadCabins();
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

    public Camp getCamp(UUID id) {
        for (int i=0; i < camps.size(); i++) {
            if (camps.get(i).getID().equals(id)) {
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
