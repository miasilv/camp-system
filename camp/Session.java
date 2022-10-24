package camp;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * an object representing a camp session
 * @author sara
 */
public class Session {
    private ArrayList<Cabin> cabins;
    private int sessionNumber;
    private Date startDate;
    private Date endDate;
    /**
     * constructor of session
     * @param sessionNumber which session it is
     * @param startDate the date the session starts
     * @param endDate the date the session ends
     */
    public Session(int sessionNumber, Date startDate, Date endDate){
        this.sessionNumber = sessionNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    //overloaded
    public Session (UUID id, String theme, ArrayList<Cabin> cabins, int sessionNumber, Date start, Date end){

    }

    /**
     * a method to add a cabin
     * @param cabin the cabin to be added
     */
    public void addCabin(Cabin cabin){
        cabins.add(cabin);
    }
    /**
     * a method to remove a cabin
     * @param cabin the cabin to be removed
     */
    public void removeCabin(Cabin cabin){
        cabins.remove(cabin);
    }
    /**
     * a method to get a specific cabin
     * @param index index of the cabin to be retrieved
     * @return the cabin
     */
    public Cabin getCabin(int index){
        return cabins.get(index);
    }

    //talk to nat
    public Cabin getCabinByUUID(UUID id){
        return null;
    }
}
