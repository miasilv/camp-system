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
    private String[] times = {"8:00:", "9:00 - 9:45:", "10:00 - 11:45:", "12:00 - 12:45:", "1:00 - 2:45:", "3:00 - 3:45:", "4:00 - 5:45:", "6:00 - 6:45:", "7:00 - 8:45:", "10:00:"};
    /**
     * constructor of the daily schedule
     */
    public Schedule(){
        LinkedHashMap<String, String> createdSchedule = new LinkedHashMap<String, String>();
        createdSchedule.put(times[0], allActivities.get(0));
        createdSchedule.put(times[1], allActivities.get(1));
        createdSchedule.put(times[3], allActivities.get(2));
        createdSchedule.put(times[5], allActivities.get(3));
        createdSchedule.put(times[7], allActivities.get(4));
        createdSchedule.put(times[8], allActivities.get(5));
        createdSchedule.put(times[9], allActivities.get(6));

        createdSchedule.put(times[2], getRandomActivity());
        createdSchedule.put(times[4], getRandomActivity());
        createdSchedule.put(times[6], getRandomActivity());

        this.schedule = createdSchedule;
    }

    private String getRandomActivity() {
        Random rand = new Random();
        if(allActivities.size() <= 7) {
            return "";
        }
        String activity = allActivities.get(rand.nextInt(7, allActivities.size()));
        while(activity.equals(times[2]) || activity.equals(times[4]) || activity.equals(times[6])) {
            activity = allActivities.get(rand.nextInt(7, allActivities.size()));
        }
        return activity;
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
