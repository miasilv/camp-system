import java.util.ArrayList;
import java.util.HashMap;
/**
 * an object representing a daily schedule
 * @author sara
 */
public class Schedule {
    private HashMap<String, String> schedule;
    /**
     * constructor of the daily schedule
     */
    public Schedule(){
        schedule = new HashMap<String, String>();
    }

    //data loading talk to natalie
    public Schedule(String day, ArrayList<String> scheudle){
        
    }

    
    /**
     * getter of the schedule
     * @return the schedule
     */
    public HashMap<String, String> getSchedule(){
        return this.schedule;
    }
    /**
     * a method to edit the schedule
     * @param time the time of the activity being editted
     * @param activity the activity being editted
     */
    public void editSchedule(String time, String activity){
        schedule.put(time, activity);
    }
    /**
     * NOTE: does not print in order yet, need to implement linked hash map for that
     */
    public String toString(){ //TODO make print in right order!!!
        String writtenSchedule = "";
        for (String keyValue  : schedule.keySet()) {
            writtenSchedule += keyValue + schedule.get(keyValue) + "\n";
        }
        return writtenSchedule;
    }
}
