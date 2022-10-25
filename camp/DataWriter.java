package camp;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * @author Natalie Crawford
 * The DataWriter class
 */
public class DataWriter extends DataConstants {
    public static boolean saveAllUsers(ArrayList<User> users){
        return true;
    }
    public static boolean saveCamp(Camp camp){
        return true;
    }



    public static void saveDirectors() {
		UserList users = UserList.getInstance();
		ArrayList<Director> directors = users.getDirectors();
		JSONArray jsonDirectors = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< directors.size(); i++) {
			jsonDirectors.add(getDirectorJSON(directors.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(DIRECTOR_FILE_NAME)) {
 
            file.write(jsonDirectors.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getDirectorJSON(Director director) {
		JSONObject directorDetails = new JSONObject();
		directorDetails.put(DIRECTOR_NAME, director.getName());
		directorDetails.put(DIRECTOR_EMAIL, director.getEmail());
        directorDetails.put(DIRECTOR_PASSWORD, director.getPassword());
        directorDetails.put(DIRECTOR_PHONE_NUMBER, director.getPhoneNumber());
        directorDetails.put(DIRECTOR_UUID, director.getID());
		
		
        return directorDetails;
	}

    public static void saveGuardians() {
		UserList users = UserList.getInstance();
		ArrayList<Guardian> guardians = users.getGuardians();
		JSONArray jsonGuardians = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< guardians.size(); i++) {
			jsonGuardians.add(getGuardianJSON(guardians.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(GUARDIAN_FILE_NAME)) {
 
            file.write(jsonGuardians.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getGuardianJSON(Guardian guardian) {
		JSONObject guardianDetails = new JSONObject();
		guardianDetails.put(GUARDIAN_NAME, guardian.getName());
		guardianDetails.put(GUARDIAN_EMAIL, guardian.getEmail());
        guardianDetails.put(GUARDIAN_PASSWORD, guardian.getPassword());
        guardianDetails.put(GUARDIAN_PHONE_NUMBER, guardian.getPhoneNumber());
        guardianDetails.put(DIRECTOR_UUID, guardian.getID());
        guardianDetails.put(GUARDIAN_CAMPERS, guardian.getCampers());
		
		
        return directorDetails;
	}
}
