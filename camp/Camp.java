
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
    /**
     * constructor of camp
     */
    public Camp (){}
    //overloaded constructor for dataLoader
    public Camp(UUID id, String name, ArrayList<Session> sessions, double price, ArrayList<FAQ> faqs, double camperRatio, ArrayList<String> activities){
        this.id = id;
        this.name = name;
        this.sessions = sessions;
        this.pricePerSession= price;
        this.campersPerCounselor= camperRatio;
        this.FAQs = faqs;
        this.activities = activities;
    }

    public UUID getId() {
        return this.id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    /**
     * written by natalie
     * gets the camps uuid converted to a string
     * @return uuid to string
     */
    public String getCampID(){
        return getId().toString();
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

    public double getPrice() {
        return this.pricePerSession;
    }
    public boolean setPricePerSession(double pricePerSession) {
        if(pricePerSession >= 0){
            this.pricePerSession = pricePerSession;
            return true;
        }
        return false;
    }

    public double getRatio() {
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
    public void setFAQs(ArrayList<FAQ> FAQs) {
        this.FAQs = FAQs;
    }
    /**
     * written by natalie
     * gets an faq based on the index in the array list of faqs
     * @param index index in faqs
     * @return the faq at that index
     */
    public FAQ getFAQbyIndex(int index) {
        return this.FAQs.get(index);
    }
    /**
     * written by natalie
     * gets a string representation of faqs
     * @return faqs array list to string
     */
    public String getFAQStr() { 
        return FAQs.toString();
    }
    /**
     * a method to add a new FAQ to the list of FAQs
     * @param question the question being added
     * @param answer the answer being added
     * @return whether the FAQ was successfully added
     */
    public boolean addFAQ(String question, String answer){
        FAQs.add(new FAQ(question, answer));
        return true;
    }
    /**
     * a method to remove an FAQ from the FAQ list
     * @param index the index of the FAQ being removed
     * @return whether or not the FAQ was successfully removed
     */
    public boolean removeFAQ(int index) {
        FAQs.remove(index);
        return true;
    }


    public ArrayList<String> getActivities() {
        return this.activities;
    }
    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }
    /**
     * a method to add an activity
     * @param activity the activity being added
     * @return whether or not the activity was successfully added
     */
    public boolean addActivity(String activity){
        activities.add(activity);
        return true;
    }
    /**
     * a method to remove an activity
     * @param index the index of the activity being removed
     * @return whether or not the activity was successfully removed
     */
    public boolean removeActivity(int index) {
        activities.remove(index);
        return false;
    }

    /**
     * a method to add a session
     * @param sessionNumber the session's number
     * @param startDate the session's start date
     * @param endDate the session's end date
     * @return whether or not the session was successfully added
     */
    public boolean addSession(String theme, String sessionDescription, Date startDate, Date endDate){
        Session session = new Session(theme, sessionDescription, startDate, endDate);
        sessions.add(session);
        return true;
    }
    /**
     * method to get a session by theme
     * @param theme the theme of the desired session
     * @return returns the session, null if no such session exists
     */
    public Session getSession(String theme) {
        for(int i=0; i<sessions.size(); i++){
            if(sessions.get(i).getTheme().equalsIgnoreCase(theme))
                return sessions.get(i);
        }
        return null;
    }
    /**
     * method to remove a session
     * @param index the index of the session being removed
     * @return whether the session was successfully removed
     */
    public Session removeSession(int index) {
        return sessions.remove(index);
        
    }

    //****EDITED BY MIA*****
    /**
     * a method allowing the user to retrieve a session via search by index
     * @param index the index of the session being retrieved
     * @return the corresponding session
     */
    public Session getSession(int index){
        if(index > sessions.size() || index < 0) {
            return null;
        }
        return sessions.get(index);
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
    /**
     * determines which session a camper is in, calls method to update cabin hash on that session
     * @param camper the camper being updated
     * @return whether or not the cabin hash was updated successfully
     */
    public boolean updateCamperCabinHash(Camper camper){
        boolean isCamperEnrolled = false;
        for(int i=0; i<sessions.size(); i++){
            if (sessions.get(i).isCamperInSession(camper))
                isCamperEnrolled = true;
                break;
        }
        if(!isCamperEnrolled){
            return false;
        }
        sessions.get(0).updateCamperCabinHash(camper);
        return true;
    }
    /**
     * determines which session a counselor is in, calls method to update cabin hash on that session
     * @param counselor the counselor being updated
     * @return whether or not the cabin hash was updated successfully
     */
    public boolean updateCounselorCabinHash(Counselor counselor){
        boolean isCounselorEnrolled = false;
        for(int i=0; i<sessions.size(); i++){
            if (sessions.get(i).isCounselorInSession(counselor))
                isCounselorEnrolled = true;
                break;
        }
        if(!isCounselorEnrolled){
            return false;
        }
        sessions.get(0).updateCounselorCabinHash(counselor);
        return true;
    }

}

