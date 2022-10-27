
package camp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * an object representing a camp
 * @author sara
 */
public class Camp {
    private String name;
    private ArrayList<Session> sessions;
    private double pricePerSession;
    private double campersPerCounselor;
    private ArrayList<FAQ> FAQs;
    private ArrayList<String> activities;
    private UUID id;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Camp (){}
    public Camp(UUID id, String name, ArrayList<Session> sessions, double price, ArrayList<FAQ> faqs, double camperRatio, ArrayList<String> activities){
        this.id = id;
        this.name = name;
        this.sessions = sessions;
        this.pricePerSession= price;
        this.campersPerCounselor= camperRatio;
        this.FAQs = faqs;
        this.activities = activities;
    }

    public String getName() {
        return this.name;
    }
    public boolean setName(String name) {
        if(name != null){
            this.name = name;
            return true;
        }
        return false;
    }

    public ArrayList<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public double getPricePerSession() {
        return this.pricePerSession;
    }

    public boolean setPricePerSession(double pricePerSession) {
        if(pricePerSession >= 0){
            this.pricePerSession = pricePerSession;
            return true;
        }
        return false;
    }

    public double getCampersPerCounselor() {
        return this.campersPerCounselor;
    }

    public boolean setCampersPerCounselor(int campersPerCounselor) {
        if(campersPerCounselor >= 1){
            this.campersPerCounselor = campersPerCounselor;
            return true;
        }
        return false;
    }

    public ArrayList<FAQ> getFAQs() {
        return this.FAQs;
    }

    public void addFAQ(String question, String answer){
        FAQs.add(new FAQ(question, answer));
    }

    public void setFAQs(ArrayList<FAQ> FAQs) {
        this.FAQs = FAQs;
    }
    /**
     * a method getting the activities of a camp
     * @return the activities of a camp
     */
    public ArrayList<String> getActivities() {
        return this.activities;
    }

    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }



    /**
     * a method to add a session
     * @param sessionNumber the session's number
     * @param startDate the session's start date
     * @param endDate the session's end date
     */
    public void addSession(String theme, int sessionNumber, Date startDate, Date endDate){
        Session session = new Session(theme, sessionNumber, startDate, endDate);
        sessions.add(session);
    }
    
    //****EDITED BY MIA*****
    /**
     * a method allowing the user to retrieve a session via search by index
     * @param index the index of the session being retrieved
     * @return the corresponding session
     */
    public Session getSession(int index){
        if(index > sessions.size()) {
            return null;
        }
        return sessions.get(index);
    }

    //nat
    public Session getSessionByUUID(UUID id){
        for(int i=0; i<sessions.size(); i++){
            if(sessions.get(i).getId() == id)
                return sessions.get(i);
        }
        return null;
    }

    //nat 
    public Cabin getCabinByUUID(UUID id){
        for(int i=0; i<sessions.size(); i++){
            sessions.get(i).getCabinByUUID(id);
        }
        return null;
    }

    /**
     * a method to save the sessions to a JSON file
     */
    //TODO how to save session?
    public void saveSessions(){

    }
    /**
     * a method to add an activity
     * @param activity the activity being added
     */
    public void addActivity(String activity){
        activities.add(activity);
    }

    public double getPrice(){
        return pricePerSession;
    }

    public double getRatio(){
        return campersPerCounselor;
    }

    public String getCampID(){
        return getId().toString();
    }
    

    public String toString(){
        String workingString = "";
        workingString += "id: " + id.toString() + "\n";
        workingString += "camp name: " +name + "\n";
        for(int i=0; i<sessions.size(); i++){
            workingString += sessions.get(i).toString() + "\n";
        }
        workingString += String.valueOf(pricePerSession) + "\n";
        for(int i=0; i<FAQs.size(); i++){
            workingString += FAQs.get(i).getQuestion() + " " + FAQs.get(i).getAnswer() + "\n";
        }
        workingString += String.valueOf(campersPerCounselor) + "\n";
        for(int i=0; i<activities.size(); i++){
            workingString += activities.get(i) + " ";
        }
        workingString += "\n";
        return workingString;
    }
}

