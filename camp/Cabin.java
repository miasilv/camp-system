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
    private double beds;
    private double maxAge;
    private double minAge;
    private ArrayList<String> daysStr;
    private ArrayList<Day> days;
    
    /**
     * constructor of cabin
     */
    public Cabin(){

        cabinID = new UUID(0, 0);
        campers = new ArrayList<Camper>();
        schedule = new HashMap<Day, Schedule>();
    }

    //overloaded constructor for dataloader
    public Cabin(ArrayList<Camper> campers, Counselor counselor, double beds, double maxAge, double minAge, ArrayList<Schedule> schedules, UUID id){
        this.campers = campers;
        this.counselor = counselor;
        this.beds = beds;
        this.maxAge= maxAge;
        this.minAge = minAge; 
        this.cabinID = id;
        this.daysStr = constructDaysStr();
        this.days = constructDays();
        this.schedule = createHash(schedules, days);
       
    }

    
    private ArrayList<Day> constructDays() {
        ArrayList<Day> days = new ArrayList<Day>();
        days.add(Day.MONDAY);
        days.add(Day.TUESDAY);
        days.add(Day.WEDNESDAY);
        days.add(Day.THURSDAY);
        days.add(Day.FRIDAY);
        days.add(Day.SATURDAY);
        days.add(Day.SUNDAY);

        return days;
    }
    private ArrayList<String> constructDaysStr() {
        ArrayList<String> daysStr = new ArrayList<String>();
        daysStr.add("Monday");
        daysStr.add("Tuesday");
        daysStr.add("Wednesday");
        daysStr.add("Thursday");
        daysStr.add("Friday");
        daysStr.add("Saturday");
        daysStr.add("Sunday");

        return daysStr;
    }

    public ArrayList<String> getDaysStr(){
        return this.daysStr;
    }

    public ArrayList<Day> getDays(){
        return this.days;
    }
    public String getDayStr(int index){
        return this.daysStr.get(index);
    }

    public Day getDays(int index){
        return this.days.get(index);
    }

    public static HashMap<Day, Schedule> createHash(ArrayList<Schedule> schedules2, ArrayList<Day> days) {
        HashMap<Day, Schedule> schedule = new HashMap<Day, Schedule>();

       for(int i = 0; i< days.size(); i++){
            schedule.put(days.get(i), schedules2.get(i));
       }
        return schedule;
    }

    public double getMinAge(){
        return minAge;
    }
    public double getMaxAge(){
        return maxAge;
    }
    public double getBeds(){
        return beds;
    }
    public void setBeds(int beds) {
        this.beds = beds;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public UUID getID() {
        return cabinID;
    }
    public String getCabinID() {
        return getID().toString();
        
    }

    public void setCabinID(UUID cabinID) {
        this.cabinID = cabinID;
    }
    /**
     * getter of the counselor
     * @return the counselor
     */
    public Counselor getCounselor(){
        return counselor;
    }
    public boolean setCounselor(Counselor counselor){
        if(counselor != null){
            this.counselor = counselor;
            return true;
        }
        return false;
     }
    /**
     * getter of the campers
     * @return the list of campers
     */
     public ArrayList<Camper> getCampers(){
        return campers;
    }
    public void setCampers(ArrayList<Camper> campers){
        this.campers = campers;
    }
    /**
     * method to add a camper to cabin
     * @param camper the camper being added
     */
    public void addCamper(Camper camper){
        campers.add(camper);
    }
    /**
     * method to remove a camper from cabin
     * @param camper the camper being removed
     */
    public void removeCamper(Camper camper){
        campers.remove(camper);
    }
    /**
     * method to get a camper
     * @param index the index of the camper to be retrieved
     * @return the camper
     */
    public Camper getCamper(int index){
        return campers.get(index);
    }
    public boolean hasCamper(Camper camper){
        for(int i=0; i<campers.size(); i++){
            if(campers.get(i).equals(camper))
                return true;
        }
        return false;
    }
    /**
     * a method to get the schedule of the cabin on a specific day
     * @param day the day of the schedule being grabbed
     * @return the schedule for that day
     */
    public ArrayList<String> getSchedule(Day day){
        return schedule.get(day).getActivites();
    }

    /**
     * a method to get the entire schedule for the cabin
     * @return the schedule for that cabin
     */
    public HashMap<Day, Schedule> getSchedule(){
        return this.schedule;
    }

    public void setSchedule(HashMap<Day, Schedule> schedule){
        this.schedule = schedule;
    }
    /**
     * method to determine whether the cabin has a counselor
     * @return whether the cabin has a counselor
     */
    public boolean hasCounselor(){
        if(counselor != null){
            return true;
        }
        return false;
    }
    public boolean hasCounselor(Counselor counselor){
        if(counselor != null && this.counselor.equals(counselor)){
            return true;
        }
        return false;
    }
    /**
     * method checking whether the cabin is full
     * @return if the cabin is full or not
     */
    public boolean isFull(){
        if(counselor != null && campers.size() == 8)
            return true;
        return false;
    }

    

    public String toString(){
        String workingString = "";
        workingString += cabinID + " \n";
        for (int i=0; i<campers.size(); i++){
            workingString += String.valueOf(campers.get(i)) + " ";
        }
        workingString += counselor + " \n";
        workingString += schedule.toString() + " \n";
        workingString += String.valueOf(beds) + " \n" + String.valueOf(minAge) + " \n" + String.valueOf(maxAge) + " \n";
        return workingString;
    }

}
