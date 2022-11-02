package camp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * @author natalie
 * camp list class
 */


public class CampList {
    private ArrayList<Camp> camps;
    private static CampList campList;

    /**
     * default constructor
     */
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

    /**
     * gets the array list of camps
     * @return camps
     */
    public ArrayList<Camp> getCamps() {
        return camps;
    }

    /**
     * gets the camp via uuid
     * @param id the specified uuid
     * @return the camp with that uuid
     */
    public Camp getCamp(UUID id) {
        for (int i=0; i < camps.size(); i++) {
            if (camps.get(i).getId().equals(id)) {
                return camps.get(i);
            }
        }
        return null; // if unable to find it
    }


}
