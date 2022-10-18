package camp;

import java.util.UUID;
/**
 * an object representing an activity
 * @author sara
 */
public class Activity {
    private UUID activityID;
    private String activity;
    private String specialInstructions;
    private String location;
    /**
     * constructor of the activity
     * @param activity the activity name
     * @param specialInstructions instructions for the activity
     * @param location location of the activity
     */
    public Activity(String activity, String specialInstructions, String location){
        this.activity = activity;
        this.specialInstructions = specialInstructions;
        this.location = location;
    }
    public String toString(){
        return "";
    }
}
