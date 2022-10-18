package camp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
/**
 * an object representing a cabin
 * @author sara
 */
public class Cabin {
    private UUID cabinID;
    private ArrayList<Camper> campers;
    private Counselor counselor;
    private HashMap<Day, Schedule> schedule;
    /**
     * constructor of cabin
     */
    public Cabin(){

        cabinID = new UUID(0, 0);
        campers = new ArrayList<Camper>();
        schedule = new HashMap<Day, Schedule>();
    }
    /**
     * method to add a counselor to the cabin
     * @param counselor the counselor being added
     */
    public void addCounselor(Counselor counselor){

    }
    /**
     * method to add a camper to cabin
     * @param camper the camper being added
     */
    public void addCamper(Camper camper){

    }
    /**
     * method to remove a camper from cabin
     * @param camper the camper being removed
     */
    public void removeCamper(Camper camper){

    }
    /**
     * a method to edit a camper in the cabin
     * @param index index of the camper being edited
     * @param camper the new camper
     */
    public void editCamper(int index, Camper camper){

    }
    /**
     * a method to get the schedule of the cabin on a specific day
     * @param day the day of the schedule being grabbed
     * @return the schedule for that day
     */
    public Schedule getSchedule(Day day){
        return schedule.get(day);
    }
    /**
     * getter of the counselor
     * @return the counselor
     */
    public Counselor getCounselor(){
        return counselor;
    }
    /**
     * getter of the campers
     * @return the list of campers
     */
    public ArrayList<Camper> getCampers(){
        return campers;
    }
    /**
     * method to determine whether the cabin has a counselor
     * @return whether the cabin has a counselor
     */
    private boolean hasCounselor(){
        return true;
    }
    /**
     * method checking whether the cabin is full
     * @return if the cabin is full or not
     */
    private boolean isFull(){
        return true;
    }
}
