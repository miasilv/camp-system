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
    }
    //overloaded
    public Session (UUID id, String theme, ArrayList<Cabin> cabins, String sessionDescription, Date start, Date end){
        this.id = id;
        this.theme = theme;
        this.sessionDescription = sessionDescription;
        this.startDate = start;
        this.endDate = end;
        this.cabins = cabins;
    }

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
        return cabins;
    }
    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }

    public Date getStartDate() {
        return this.startDate;
    }
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
    public boolean setDescription(String change) {
        this.sessionDescription = change;
        return true;
    }
    public String getDescription() {
        return this.sessionDescription;
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
    public String getSessionID(){
        return getID().toString();
    }

    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");  
        String workingString = "";
        workingString += "Session " + theme + ": " + dateFormat.format(startDate) + "-" + dateFormat.format(endDate) + "\n";
        return workingString;
    }

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
    public Cabin placeCounselor(Counselor counselor){
        for(int i=0; i<cabins.size(); i++){
            if(!cabins.get(i).hasCounselor()){
                cabins.get(i).setCounselor(counselor);
                return cabins.get(i);
            }
        }
        return null;
    }

    public boolean isCamperInSession(Camper camper){
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCamper(camper))
                return true;
        }
        return false;
    }
    public boolean isCounselorInSession(Counselor counselor){
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCounselor(counselor))
                return true;
        }
        return false;
    }

    public void updateCamperCabinHash(Camper camper) {
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCamper(camper))
                cabins.get(i).updateCampersCabinHashes(camper, this);
        }
    }
    public void updateCounselorCabinHash(Counselor counselor) {
        for(int i=0; i<cabins.size(); i++){
            if(cabins.get(i).hasCounselor(counselor))
                cabins.get(i).updateCounselorsCabinHashes(counselor, this);
        }
    }

    public void saveSession(){
        DataWriter.saveSession();
    }
}
