package camp;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * an object representing a camp session
 * @author sara
 */
public class Session {
    private UUID id;
    private ArrayList<Cabin> cabins;
    private int sessionNumber;
    private Date startDate;
    private Date endDate;
    private String theme;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ArrayList<Cabin> getCabins() {
        return this.cabins;
    }

    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }

    public int getSessionNumber() {
        return this.sessionNumber;
    }

    public boolean setSessionNumber(int sessionNumber) {
        if(sessionNumber >= 0){
            this.sessionNumber = sessionNumber;
            return true;
        }
        return false;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public boolean setStartDate(Date startDate) {
        if(startDate != null){
            this.startDate = startDate;
            return true;
        }
        return false;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public boolean setEndDate(Date endDate) {
        if(endDate != null){
            this.endDate = endDate;
            return true;
        }
        return false;
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
    
    //overloaded
    public Session (UUID id, String theme, ArrayList<Cabin> cabins, int sessionNumber, Date start, Date end){
        this.id = id;
        this.theme = theme;
        this.cabins = cabins;
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

    //talk to nat
    public Cabin getCabinByUUID(UUID id){
        return null;
    }

    public String toString(){
        String workingString = "";
        workingString += id + "\n";
        for(int i=0; i<cabins.size(); i++){
            workingString += cabins.get(i).toString() + "\n";
        }
        workingString += String.valueOf(sessionNumber) + "\n" + String.valueOf(startDate) + "\n" + String.valueOf(endDate) + "\n" + theme;
        return workingString;
    }
}
