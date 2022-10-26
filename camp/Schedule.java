package camp;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * an object representing a daily schedule
 * @author sara
 */
public class Schedule {
    private HashMap<Day, String> schedule;
    /**
     * constructor of the daily schedule
     */
    public Schedule(){
        this.schedule = new HashMap<Day, String>();
    }

    //data loading talk to natalie
    public Schedule(ArrayList<String> schedule){
        this.schedule = createHash(schedule);
    }

    
    private static HashMap<Day, String> createHash(ArrayList<String> inpschedule) {
        HashMap<Day, String> schedule = new HashMap<Day, String>();
        Day day = Day.MONDAY;
        for(int i = 0; i< inpschedule.size(); i++){
                schedule.put(day, inpschedule.get(i));
                if (day.equals(Day.MONDAY)){
                    day = Day.TUESDAY;
                }
                else if (day.equals(Day.TUESDAY)){
                    day = Day.WEDNESDAY;
                }
                else if (day.equals(Day.WEDNESDAY)){
                    day = Day.THURSDAY;
                }
                else if (day.equals(Day.THURSDAY)){
                    day = Day.FRIDAY;
                }
                else if (day.equals(Day.FRIDAY)){
                    day = Day.SATURDAY;
                }
                else if (day.equals(Day.SATURDAY)){
                    day = Day.SUNDAY;
                }
                else if (day.equals(Day.SATURDAY)){
                    day = Day.MONDAY;
                }

        }

        return schedule;
    }

    /**
     * getter of the schedule
     * @return the schedule
     */
    public HashMap<Day, String> getSchedule(){
        return this.schedule;
    }
    public void setSchedule(HashMap<Day, String> schedule){
        this.schedule = schedule;
    }
    /**
     * a method to edit the schedule
     * @param time the time of the activity being editted
     * @param activity the activity being editted
     */
    public void editSchedule(Day time, String activity){
        schedule.put(time, activity);
    }
    /**
     * NOTE: does not print in order yet, need to implement linked hash map for that
     */
    public String toString(){ //TODO make print in right order!!!
        String writtenSchedule = "";
        for (Day keyValue  : schedule.keySet()) {
            writtenSchedule += keyValue + schedule.get(keyValue) + "\n";
        }
        return writtenSchedule;
    }

	public String remove(String time) {
		return this.schedule.remove(time);
	}

	public boolean add(Day day, String activity) {
		this.schedule.put(day, activity);
        return true;
	}
}
