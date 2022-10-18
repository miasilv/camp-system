package camp;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
        // use DataReader here
    }

    public UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public void addUser(String name, String email, String password) {

    }

    public User getUser(String email) {

    }

    public User getUser(UUID id) {

    }

    public void editUser() {

    }   
    
    public void saveUsers() {
        
    }
}
