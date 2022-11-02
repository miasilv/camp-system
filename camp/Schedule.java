package camp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
/**
 * an object representing a daily schedule
 * @author sara
 */
public class Schedule {
    private LinkedHashMap<String, String> schedule;
    private ArrayList<String> activities;
    private static ArrayList<String> allActivities;
    private ArrayList<String> toPickFrom;
    private String[] times = {"8:00:", "9:00 - 9:45:", "10:00 - 11:45:", "12:00 - 12:45:", "1:00 - 2:45:", "3:00 - 3:45:", "4:00 - 5:45:", "6:00 - 6:45:", "7:00 - 8:45:", "10:00:"};
    /**
     * constructor of the daily schedule
     */
    public Schedule(){
        LinkedHashMap<String, String> createdSchedule = new LinkedHashMap<String, String>();
        toPickFrom = new ArrayList<String>();
        activities = new ArrayList<String>();
        
        activities.add(allActivities.get(0));
        activities.add(allActivities.get(1));
        activities.add(getRandomActivity());
        activities.add(allActivities.get(2));
        activities.add(getRandomActivity());
        activities.add(allActivities.get(3));
        activities.add(getRandomActivity());
        activities.add(allActivities.get(4));
        activities.add(allActivities.get(5));
        activities.add(allActivities.get(6));
        
        for(int i = 0; i < times.length; i++) {
            createdSchedule.put(times[i], activities.get(i));
        }
        this.schedule = createdSchedule;
    }

    private String getRandomActivity() {
        Random rand = new Random();
        if(allActivities.size() <= 7) {
            return "";
        }
        for(int i = 7; i < allActivities.size(); i++) {
            toPickFrom.add(allActivities.get(i));
        }

        return toPickFrom.get(rand.nextInt(toPickFrom.size()));
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

    public static void setActivityList(ArrayList<String> acts) {
        allActivities = acts;
    }
}
