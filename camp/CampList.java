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
    private static CampList campList;

    private CampList(){
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

    
    public Camp getCamp(UUID id) {
        for (int i=0; i < camps.size(); i++) {
            if (camps.get(i).getId().equals(id)) {
                return camps.get(i);
            }
        }
        return null; // if unable to find it
    }


}
