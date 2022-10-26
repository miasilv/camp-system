package camp;

import java.util.ArrayList;
import java.util.UUID;

public class CamperList {
    private ArrayList<Camper> campers;
    private static CamperList camperList;
    
    private CamperList(){
        campers = DataLoader.loadCampers();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public static CamperList getInstance(){
        if (camperList == null){
            camperList = new CamperList();        
        }
        return camperList;
    }

    public ArrayList<Camper> getCampers(){
        return campers;
    }

    public Camper getCamper(UUID id) {
        for (int i = 0; i < campers.size(); i++) {
            if (campers.get(i).getID().equals(id)) {
                return campers.get(i);
            }
        }
        return null; // if unable to find it
    }

}