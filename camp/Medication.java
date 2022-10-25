package camp;

public class Medication {
    private int dose;
    private String type;
    private String time;
    
    /**
     * Constrcutor for the medication class
     * @param dose Dose of the medication
     * @param type Type of medication
     * @param time Time of medication consumption
     */
    public Medication(int dose, String type, String time) {
        this.dose = dose;
        this.type = type;
        this.time = time;
    }
}
