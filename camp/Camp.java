
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
    private int campersPerCounselor;
    private ArrayList<FAQ> FAQs;
    private ArrayList<String> activities;

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

    public int getCampersPerCounselor() {
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

    //overloaded for nat
    private Camp(UUID id, String name, ArrayList<Session> sessions, int price, ArrayList<FAQ> faqs, int camperRatio, ArrayList<String> activities){

    }
    public static Camp getInstance(UUID id, String name, ArrayList<Session> sessions, int price, ArrayList<FAQ> faqs, int camperRatio, ArrayList<String> activities){
        if (camp == null){
            camp = new Camp(id, name, sessions, price, faqs, camperRatio, activities);            
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

    //nat 
    public Cabin getCabinByUUID(UUID id){
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
