package camp;

import java.util.ArrayList;
import java.util.UUID;

public class CabinList {
    private ArrayList<Cabin> cabins;
    private static CabinList cabinList;
    
    private CabinList(){
        cabins = DataLoader.loadCabins();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public static CabinList getInstance(){
        if (cabinList == null){
            cabinList = new CabinList();        
        }
        return cabinList;
    }

    public ArrayList<Cabin> getCabins(){
        return cabins;
    }

    public Cabin getCabin(UUID id) {
        for (int i = 0; i < cabins.size(); i++) {
            if (cabins.get(i).getID().equals(id)) {
                return cabins.get(i);
            }
        }
        return null; // if unable to find it
    }

}