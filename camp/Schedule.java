package camp;

import java.util.HashMap;
/**
 * an object representing a daily schedule
 * @author sara
 */
public class Schedule {
    private HashMap<String, Activity> schedule;
    /**
     * constructor of the daily schedule
     */
    public Schedule(){
        schedule = new HashMap<String, Activity>();
    }
    /**
     * getter of the schedule
     * @return the schedule
     */
    public HashMap<String, Activity> getSchedule(){
        return this.schedule;
    }
    /**
     * a method to edit the schedule
     * @param time the time of the activity being editted
     * @param activity the activity being editted
     */
    public void editSchedule(String time, Activity activity){

    }
    public String toString(){
        return "";
    }
}
