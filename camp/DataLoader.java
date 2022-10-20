import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author Natalie Crawford
 * The DataLoader class
 */

public class DataLoader extends DataConstants {
    private ArrayList<User> users;
    private Camp camp;
    /**
     * get guardians, counselors, and directors
     * @return
     */
    public ArrayList<User> getAllUsers(){
    
        return users;

    }
    /**
     * 
     * @return
     */
    public Camp getCamp(){
        return camp;

    }

    public static ArrayList<Camper> loadCampers() {
        ArrayList<Camper> campers = new ArrayList<Camper>();

        return campers;
    }
    public static ArrayList<Director> loadDirector() {
		ArrayList<Director> directors = new ArrayList<Director>();
		
		try {
			FileReader reader = new FileReader(DIRECTOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray directorsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < directorsJSON.size(); i++) {
				JSONObject directorJSON = (JSONObject)directorsJSON.get(i);
				String name = (String)directorJSON.get(DIRECTOR_NAME);
				String email = (String)directorJSON.get(DIRECTOR_EMAIL);
                String password = (String)directorJSON.get(DIRECTOR_PASSWORD);
				String phoneNumber = (String)directorJSON.get(DIRECTOR_PHONE_NUMBER);

				
				directors.add(new Director(name, email, password, phoneNumber));
			}
			
			return directors;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

    public static ArrayList<Guardian> loadGuardians() {
		ArrayList<Guardian> guardians = new ArrayList<Guardian>();
		
		try {
			FileReader reader = new FileReader(GUARDIAN_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray guardiansJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < guardiansJSON.size(); i++) {
				JSONObject guardianJSON = (JSONObject)guardiansJSON.get(i);
				String name = (String)guardianJSON.get(GUARDIAN_NAME);
				String email = (String)guardianJSON.get(GUARDIAN_EMAIL);
                String password = (String)guardianJSON.get(GUARDIAN_PASSWORD);
				String phoneNumber = (String)guardianJSON.get(GUARDIAN_PHONE_NUMBER);
                UUID id = UUID.fromString((String)guardianJSON.get(GUARDIAN_UUID));
                JSONArray campersJSON = (JSONArray)guardianJSON.get(GUARDIAN_CAMPERS);

                //make arraylist of campers
                ArrayList<Camper> campers = new ArrayList<Camper>();
                for(int j = 0; j < campersJSON.size(); j++){
                    UUID camperID = UUID.fromString((String)campersJSON.get(j));
                    Camper camper = UserList.getInstance().getCamperByUUID(camperID);
                    campers.add(camper);
                }
				
				guardians.add(new Guardian(name, email, password, phoneNumber, id, campers));
			}
			
			return guardians;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
