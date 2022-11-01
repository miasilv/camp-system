package camp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
/**
 * an object representing a daily schedule
 * @author sara
 */
public class Schedule {
    private LinkedHashMap<String, String> schedule;
    private ArrayList<String> activities;
    private String[] times = {"8:00:", "9:00 - 9:45:", "10:00 - 11:45:", "12:00 - 12:45:", "1:00 - 2:45:", "3:00 - 3:45:", "4:00 - 5:45:", "6:00 - 6:45:", "7:00 - 8:45:", "10:00:"};
    /**
     * constructor of the daily schedule
     */
    public Schedule(){
        this.schedule = new LinkedHashMap<String, String>();
    }

    //data loading talk to natalie
    public Schedule(ArrayList<String> acts){
        this.activities = acts;
        LinkedHashMap<String, String> createdSchedule = new LinkedHashMap<String, String>();

        for(int i=0; i<activities.size(); i++){
            createdSchedule.put(times[i], activities.get(i));
        }
        this.schedule = createdSchedule;
    }

    /**
     * written by natalie
     * @return the array list of activities
     */
    public ArrayList<String> getActivites(){
        return this.activities;
    }
    /**
     * written by natalie
     * @return the schedule
     */
    public HashMap<String, String> getSchedule(){
        return this.schedule;
    }
    public void setSchedule(LinkedHashMap<String, String> schedule){
        this.schedule = schedule;
    }
    
    /**
     * a method to edit the schedule
     * @param time the time of the activity being editted
     * @param activity the activity being editted
     */
    public void editSchedule(String time, String activity){
        schedule.put(time, activity);
    }

    public String toString(){ 
        String writtenSchedule = "";
        for (String keyValue  : schedule.keySet()) {
            writtenSchedule += keyValue + " " + schedule.get(keyValue) + "\n";
        }
        return writtenSchedule + "\n";
    }

	public boolean remove(String time) {
		this.schedule.remove(time);
        return true;
	}

	public boolean add(String time, String activity) {
		this.schedule.put(time, activity);
        return true;
	}
}
