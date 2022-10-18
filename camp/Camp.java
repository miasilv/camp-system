import java.util.ArrayList;
import java.util.Date;
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
    private static Camp camp;
    /**
     * private constructor of camp
     * @param name name of camp
     * @param sessions the sessions of the camp
     */
    private Camp(String name, ArrayList<Session> sessions){
        this.name = name;
        this.sessions = sessions;
    }
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public Camp getInstance(){
        if (this.camp == null){
            camp = new Camp(name, sessions);            
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
        
    }
    /**
     * a method allowing the user to retrieve a session via search by keyword
     * @param keyword the word being used to search for the session
     * @return the corresponding session
     */
    public Session getSession(String keyword){
        return new Session(campersPerCounselor, null, null);
    }
    /**
     * a method to edit a particular session
     */
    public void editSession(){

    }
    /**
     * a method to save the sessions to a JSON file
     */
    public void saveSessions(){

    }
    /**
     * a method to add an activity
     * @param activity the activity being added
     */
    public void addActivity(String activity){

    }
    /**
     * a method getting the activities of a camp
     * @return the activities of a camp
     */
    public ArrayList<String> getActivities(){
        return this.activities;
    }
}
