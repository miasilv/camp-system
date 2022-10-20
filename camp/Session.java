import java.util.ArrayList;
import java.util.Date;
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
    /**
     * a method to add a cabin
     * @param cabin the cabin to be added
     */
    public void addCabin(Cabin cabin){

    }
    /**
     * a method to remove a cabin
     * @param cabin the cabin to be removed
     */
    public void removeCabin(Cabin cabin){

    }
    /**
     * a method to edit a cabin
     * @param index the index of the cabin to be editted
     * @param cabin the new cabin
     */
    public void editCabin(int index, Cabin cabin){

    }
}
