import java.util.ArrayList;
import java.util.Date;

public class Counselor extends User{
    private String bio;
    private ArrayList<Cabin> cabins;
    private ArrayList<EmergencyContact> emergencyContacts;
    private Date birthday;
    private ArrayList<String> allergies;

    /**
     * Constructor for the counselor class
     * @param name Name of the counselor
     * @param email Email of the counselor
     * @param password Password of the counselor
     * @param birthday Birthday of the counselor
     */
    public Counselor(String name, String email, String password, Date birthday, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to sign the waiver for the counselor
     */
    public void SignWaiver() {

    }

    /**
     * Method to add the bio of the counselor
     */
    public void addBio() {

    }

    /**
     * Method to add allergies for the counselor to take of
     * @param allergy Allergy to take care of
     */
    public void addAllergies(String allergy) {

    }

    /**
     * Method to remove the allergy for the counselor to take care of
     * @param allergy Allergy to remove
     */
    public void removeAllergy(String allergy) {

    }

    /**
     * Method to edit the allergy a counselor has to take care of
     * @param index Index of the allergy of the counselor
     * @param allergy Allergy to replace with
     */
    public void editAllergy(int index, String allergy) {

    }

    /**
     * Returns a string representation of the counselor
     */
    public String toString() {
        return "";
    }
}