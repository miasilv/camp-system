import java.util.UUID;

public abstract class User {
    protected UUID userID;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String password;

    public User(String name, String email, String password) {

    }

    public void addPhone(String phoneNumber) {

    }

    public void changePassword(String password) {

    }

    public void changeEmail(String email) {

    }

    public void changePhone(String phoneNumber) {

    }

    public void deleteUser() {
        
    }
}