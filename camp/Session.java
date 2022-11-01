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
    private Date startDate;
    private Date endDate;
    private String theme;
    private String sessionDescription;
    SimpleDateFormat dateFormatter;

    /**
     * constructor of session
     * @param sessionNumber which session it is
     * @param startDate the date the session starts
     * @param endDate the date the session ends
     */
    public Session(String theme, String sessionDescription, Date startDate, Date endDate){
        this.id = new UUID(0, 0);
        this.theme = theme;
        this.sessionDescription = sessionDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
    }
    //overloaded
    public Session (UUID id, String theme, ArrayList<Cabin> cabins, String sessionDescription, Date start, Date end){
        this.id = id;
        this.theme = theme;
        this.sessionDescription = sessionDescription;
        this.startDate = start;
        this.endDate = end;
        this.cabins = cabins;
        dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
    }

    public UUID getID() {
        return this.id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    /**
     * written by natalie
     * @return a string representation of the id for data writer
     */
    public String getSessionID(){
        return getID().toString();
    }

    public String getTheme() {
        return this.theme;
    }
    public boolean setTheme(String theme) {
        this.theme = theme;
        return false;
    }

    public ArrayList<Cabin> getCabins() {
        return cabins;
    }
    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }
    /**
     * method to remove a cabin from a cabin list
     * @param index the index of the cabin being removed
     * @return whether or not the cabin was removed
     */
    public boolean removeCabin(int index) {
        cabins.remove(index);
        return true;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * written by natalie
     * @return a string format of the start date
     */
    public String getStrStart() {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");  
        return dateFormat.format(startDate);
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

    /**
     * written by natalie
     * @return a string format of the end date
     */
    public String getStrEnd() {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");  
        return dateFormat.format(endDate);
    }
    public boolean setEndDate(Date endDate) {
        if(endDate != null){
            this.endDate = endDate;
            return true;
        }
        return false;
    }
    public String getDescription() {
        return this.sessionDescription;
    }
    public boolean setDescription(String change) {
        this.sessionDescription = change;
        return true;
    }

    /**
     * a method to get a specific cabin
     * @param index index of the cabin to be retrieved
     * @return the cabin
     */
    public Cabin getCabin(int index){
        return cabins.get(index);
    }
    /**
     * a method to add a cabin
     * @param cabin the cabin to be added
     * @return 
     */
    public boolean addCabin(Cabin cabin){
        cabins.add(cabin);
        return true;
    }
    /**
     * a method to remove a cabin
     * @param cabin the cabin to be removed
     */
    public void removeCabin(Cabin cabin){
        cabins.remove(cabin);
    }

    //talk to nat
    public Cabin getCabinByUUID(UUID id){
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).getID()==id)
                return cabins.get(i);
        }
        return null;
    }

    public String toString(){  
        String workingString = "";
        workingString += theme + ": " + displayDate(startDate) + "-" + displayDate(endDate) + "\n";
        workingString += "\t" + sessionDescription;
        return workingString;
    }
    /**
     * a method to place a camper in a cabin based on age/if the cabin is full
     * @param camper the camper being placed
     * @return the cabin the camper was placed in, null if failed to do so
     */
    public Cabin placeCamper(Camper camper){
        for(int i=0; i<cabins.size(); i++){
            int minAge = (int) cabins.get(i).getMinAge();
            int maxAge = (int) cabins.get(i).getMaxAge();
            if((minAge <= camper.getAge() && camper.getAge() <= maxAge && !cabins.get(i).isFull())){
                cabins.get(i).addCamper(camper);
                return cabins.get(i);
            }
        }
        return null;
    }
    /**
     * a method to place a counselor in a cabin based on if the cabin has a counselor
     * @param counselor the counselor being placed
     * @return the cabin the counselor is placed in, null if failed to do so
     */
    public Cabin placeCounselor(Counselor counselor){
        for(int i=0; i<cabins.size(); i++){
            if(!cabins.get(i).hasCounselor()){
                cabins.get(i).setCounselor(counselor);
                return cabins.get(i);
            }
        }
        return null;
    }
    /**
     * checks if a camper is enrolled in a particular session
     * @param camper the camper being searched for
     * @return whether or not the camper is in the session
     */
    public boolean isCamperInSession(Camper camper){
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCamper(camper))
                return true;
        }
        return false;
    }
    /**
     * checks if a counselor is enrolled in a particular session
     * @param counselor the counselor being searched for
     * @return whether or not the counselor is in the session
     */
    public boolean isCounselorInSession(Counselor counselor){
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCounselor(counselor))
                return true;
        }
        return false;
    }
    /**
     * determines which cabin a camper is in, calls method to update that camper's cabin hash
     * @param camper the camper being updated
     */
    public void updateCamperCabinHash(Camper camper) {
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCamper(camper))
                cabins.get(i).updateCampersCabinHashes(camper, this);
        }
    }
    /**
     * determines which cabin a counselor is in, calls method to update that counselor's cabin hash
     * @param counselor the counselor being updated
     */
    public void updateCounselorCabinHash(Counselor counselor) {
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCounselor(counselor))
                cabins.get(i).updateCounselorsCabinHashes(counselor, this);
        }
    }
    
    /**
	 * Converts a date to a string
	 * @param date the date to be converted
	 * @return the string version of the date
	 */
	private String displayDate(Date date) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormatter.format(date);
	}
}
