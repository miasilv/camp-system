package camp;

import java.util.ArrayList;
import java.util.UUID;
/**
 * @author Natalie Crawford
 * the camper list class
 */

public class CamperList {
    private ArrayList<Camper> campers;
    private static CamperList camperList;
    
    /**
     * default constructor
     */
    private CamperList(){
        campers = DataLoader.loadCampers();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of camper
     * @return the instance of camper
     */
    public static CamperList getInstance(){
        if (camperList == null){
            camperList = new CamperList();        
        }
        return camperList;
    }

    /**
     * gets the array list of campers
     * @return campers
     */
    public ArrayList<Camper> getCampers(){
        return campers;
    }

    /**
     * accesses a camper via uuid
     * @param id the specific uuid
     * @return the camper with that uuid
     */
    public Camper getCamper(UUID id) {
        for (int i = 0; i < campers.size(); i++) {
            if (campers.get(i).getID().equals(id)) {
                return campers.get(i);
            }
        }
        return null; // if unable to find it
    }

}