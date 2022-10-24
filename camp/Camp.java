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
    private int campersPerCounselor;
    private ArrayList<FAQ> FAQs;
    private ArrayList<String> activities;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
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

    public void setPricePerSession(double pricePerSession) {
        this.pricePerSession = pricePerSession;
    }

    public int getCampersPerCounselor() {
        return this.campersPerCounselor;
    }

    public void setCampersPerCounselor(int campersPerCounselor) {
        this.campersPerCounselor = campersPerCounselor;
    }

    public ArrayList<FAQ> getFAQs() {
        return this.FAQs;
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

    private static Camp camp;

    private Camp(){
        
    }
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public static Camp getInstance(){
        if (camp == null){
            camp = new Camp();            
        }
        return camp;
    }
    /**
     * a method to add a session
     * @param sessionNumber the session's number
     * @param startDate the session's start date
     * @param endDate the session's end date
     */
    public void addSession(int sessionNumber, Date startDate, Date endDate){
        Session session = new Session(sessionNumber, startDate, endDate);
        sessions.add(session);
    }
    /**
     * a method allowing the user to retrieve a session via search by keyword
     * @param keyword the word being used to search for the session
     * @return the corresponding session
     */
    public Session getSession(String keyword){
        return new Session(campersPerCounselor, null, null);
    }

    //nat
    public Session getSessionByUUID(UUID id){
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
}
