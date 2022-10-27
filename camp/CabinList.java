package camp;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Natalie Crawford
 * the cabinlist class
 */

public class CabinList {
    private ArrayList<Cabin> cabins;
    private static CabinList cabinList;
    
    /**
     * default constructor that loads cabins
     */
    private CabinList(){
        cabins = DataLoader.loadCabins();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of cabin
     * @return the instance of cabin
     */
    public static CabinList getInstance(){
        if (cabinList == null){
            cabinList = new CabinList();        
        }
        return cabinList;
    }

    /**
     * gets the cabins
     * @return an array list of cabins
     */
    public ArrayList<Cabin> getCabins(){
        return cabins;
    }

    /**
     * gets cabin based on uuid
     * @param id uuid id for the cabin, unique
     * @return the cabin with that id if found in cabins
     */
    public Cabin getCabin(UUID id) {
        for (int i = 0; i < cabins.size(); i++) {
            if (cabins.get(i).getID().equals(id)) {
                return cabins.get(i);
            }
        }
        return null; // if unable to find it
    }

}