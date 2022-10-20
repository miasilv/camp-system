import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<Director> directors;
    private ArrayList<Counselor> counselors;
    private ArrayList<Guardian> guardians;
    private ArrayList<Camper> campers;
    private static UserList userList;

    private UserList() {
        // use DataReader here
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

    public void addUser(String name, String email, String password) {

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
