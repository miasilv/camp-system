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
        return users.get(0); // this is a placeholder
    }

    public User getUser(UUID id) {
        return users.get(0);
    }

    public void editUser() {

    }   
    
    public void saveUsers() {
        
    }
}
