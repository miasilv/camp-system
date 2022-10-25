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

    public ArrayList<Cabin> getCabins() {
        return this.cabins;
    }

    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }

    public int getSessionNumber() {
        return this.sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
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

    public Cabin getCabinByUUID(UUID id){
        return null;
    }
}
