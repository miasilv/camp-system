package camp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private double sessionNumber;
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

    public boolean setTheme(String theme) {
        this.theme = theme;
        return false;
    }

    public ArrayList<Cabin> getCabins() {
        return this.cabins;
    }

    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }

    public double getSessionNumber() {
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
    public Session(String theme, double sessionNumber, Date startDate, Date endDate){
        this.theme = theme;
        this.sessionNumber = sessionNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    //overloaded
    public Session (UUID id, String theme, double sessionNumber, Date start, Date end){
        this.id = id;
        this.theme = theme;
        this.sessionNumber = sessionNumber;
        this.startDate = start;
        this.endDate = end;
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
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).getID()==id)
                return cabins.get(i);
        }
        return null;
    }

    public UUID getID() {
        return id;
    }

    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");  
        String workingString = "";
        workingString += id + "\n";
        workingString += String.valueOf(sessionNumber) + "\n" + dateFormat.format(startDate) + "\n" + dateFormat.format(endDate) + "\n" + theme;
        return workingString;
    }
}
