import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<Director> directors;
    private ArrayList<Counselor> counselors;
    private ArrayList<Guardian> guardians;
    private ArrayList<Camper> campers;
    private static UserList userList;

    private UserList() {
        directors = DataLoader.loadDirector();
        campers = DataLoader.loadCampers();
        guardians = DataLoader.loadGuardians();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    // ACCESSORS AND MUTATORS!

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public ArrayList<Camper> getCampers() {
        return campers;
    }

    public ArrayList<Counselor> getCounselors() {
        return counselors;
    }

    public void addUser(String name, String email, String password, String phoneNumber) {

    }

    public User getUser(String email) {
        return users.get(0); // this is a placeholder
    }

    public User getUser(UUID id) {
        return users.get(0);
    }

    public Camper getCamperByUUID(UUID id){
        return null;
    }

    public Counselor getCounselorByUUID(UUID id){
        return null;
    }

    public void editUser() {

    }   
    
    public void saveUsers() {
        
    }
}
