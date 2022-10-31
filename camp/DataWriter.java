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
    /**
     * the tester main method for datawriter
     * @param args
     */
    public static void main(String[] args) {
       saveSession();
    }

    /**
     * saves the director data to a new json file or updates the old json file
     */
    //save directors
    public static void saveDirectors() {
		UserList users = UserList.getInstance();
		ArrayList<Director> directors = users.getDirectors();
		JSONArray jsonDirectors = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< directors.size(); i++) {
			jsonDirectors.add(getDirectorJSON(directors.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + DIRECTOR_FILE_NAME)) {
 
            file.write(jsonDirectors.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json constants to different values
     * @param director the director that the json file being created off of
     * @return details relating to the json file that will be written in save directors
     */
	public static JSONObject getDirectorJSON(Director director) {
		JSONObject directorDetails = new JSONObject();
		directorDetails.put(DIRECTOR_NAME, director.getName());
		directorDetails.put(DIRECTOR_EMAIL, director.getEmail());
        directorDetails.put(DIRECTOR_PASSWORD, director.getPassword());
        directorDetails.put(DIRECTOR_PHONE_NUMBER, director.getPhoneNumber());
        directorDetails.put(DIRECTOR_UUID, director.getDirectorID());
		
		
        return directorDetails;
	}

    /**
     * saves the guardian data to a new json file or updates the old json file
     */
    //save guardians
    public static void saveGuardians() {
		UserList users = UserList.getInstance();
		ArrayList<Guardian> guardians = users.getGuardians();
		JSONArray jsonGuardians = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< guardians.size(); i++) {
			jsonGuardians.add(getGuardianJSON(guardians.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/tester.json")) {
 
            file.write(jsonGuardians.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json contstant to given values
     * @param guardian the guardian that the json file is written based on 
     * @return the details relating to the guardian that will be written in save guardians
     */
	public static JSONObject getGuardianJSON(Guardian guardian) {
		JSONObject guardianDetails = new JSONObject();
		guardianDetails.put(GUARDIAN_NAME, guardian.getName());
		guardianDetails.put(GUARDIAN_EMAIL, guardian.getEmail());
        guardianDetails.put(GUARDIAN_PASSWORD, guardian.getPassword());
        guardianDetails.put(GUARDIAN_PHONE_NUMBER, guardian.getPhoneNumber());
        guardianDetails.put(DIRECTOR_UUID, guardian.getGuardianID());
        
        JSONArray jsonCampers = new JSONArray();
        for(int i = 0; i< guardian.getCampers().size(); i++){
            jsonCampers.add(guardian.getCamper(i).getCamperID());
            //jsonCampers.add(getCamperJSON(guardian.getCamper(i)));
        }
		guardianDetails.put(GUARDIAN_CAMPERS, jsonCampers);
		
        return guardianDetails;
	}

    /**
     * saves the counselor data to a new json file or updates the old json file
     */
    //save counselors
    public static void saveCounselors() {
		UserList users = UserList.getInstance();
		ArrayList<Counselor> counselors = users.getCounselors();
		JSONArray jsonCounselors = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< counselors.size(); i++) {
			jsonCounselors.add(getCounselorJSON(counselors.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/tester.json")) {
 
            file.write(jsonCounselors.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json constants to given values
     * @param counselor the counselor that the json file is based on
     * @return the details relating to the counselor that will be written in save counselors
     */
	public static JSONObject getCounselorJSON(Counselor counselor) {
		JSONObject counselorDetails = new JSONObject();
		counselorDetails.put(COUNSELOR_NAME, counselor.getName());
		counselorDetails.put(COUNSELOR_EMAIL, counselor.getEmail());
        counselorDetails.put(COUNSELOR_PASSWORD, counselor.getPassword());
        counselorDetails.put(COUNSELOR_PHONE_NUMBER, counselor.getPhoneNumber());
        counselorDetails.put(COUNSELOR_UUID, counselor.getCounselorID());
        counselorDetails.put(COUNSELOR_BIO, counselor.getBio());
        counselorDetails.put(COUNSELOR_BIRTHDAY, counselor.getBirthdayStr());
        counselorDetails.put(COUNSELOR_ALLERGIES, counselor.getAllergiesStr());
		counselorDetails.put(COUNSELOR_EMERGENCY_CONTACTS, counselor.getEmergencyContactsStr());
    
		
        return counselorDetails;
	}

    /**
     * saves the camper data to a new json file or updates the old json file
     */
     //save campers
     public static void saveCampers() {
		CamperList campersL = CamperList.getInstance();
		ArrayList<Camper> campers = campersL.getCampers();
		JSONArray jsonCampers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< campers.size(); i++) {
			jsonCampers.add(getCamperJSON(campers.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + CAMPER_FILE_NAME)) {
 
            file.write(jsonCampers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json constants to given values
     * @param camper the camper that the json file is based on
     * @return the details realting to the camper that will be written in save campers
     */
	public static JSONObject getCamperJSON(Camper camper) {
		JSONObject camperDetails = new JSONObject();
		camperDetails.put(CAMPER_NAME, camper.getName());
		camperDetails.put(CAMPER_MEDICATIONS, camper.getMedicationsStr());
        camperDetails.put(CAMPER_NOTES, camper.getNotes());
        camperDetails.put(CAMPER_UUID, camper.getCamperID());
        camperDetails.put(CAMPER_BIRTHDAY, camper.getBirthdayStr());
        camperDetails.put(CAMPER_ALLERGIES, camper.getAllergiesStr());
		camperDetails.put(CAMPER_EMERGENCY_CONTACTS, camper.getEmergencyContactsStr());
		
        return camperDetails;
	}

    /**
     * saves the camp data to a new json file or updates the old json files
     */
    //save camp
    public static void saveCamp() {
		CampList camp = CampList.getInstance();
		ArrayList<Camp> camps = camp.getCamps();
		JSONArray jsonCamps = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< camps.size(); i++) {
			jsonCamps.add(getCampJSON(camps.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/tester.json")) {
            file.write(jsonCamps.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json constants to given values
     * @param camp the camp that the json file is based on
     * @return the details pertaining to camp that will be written in savecamp
     */
	public static JSONObject getCampJSON(Camp camp) {
		JSONObject campDetails = new JSONObject();
		campDetails.put(CAMP_NAME, camp.getName());
		campDetails.put(CAMP_ACTIVITIES, camp.getActivities());
        JSONArray jsonFaqs = new JSONArray();
        for(int i=0; i<camp.getFAQs().size(); i++){
            JSONObject faqDetails = new JSONObject();
            faqDetails.put(FAQ_QUESTION, camp.getFAQbyIndex(i).getQuestion() ) ;
            faqDetails.put(FAQ_ANSWER, camp.getFAQbyIndex(i).getAnswer()); 
            jsonFaqs.add(faqDetails);
        }

        campDetails.put(CAMP_FAQS, jsonFaqs);
        campDetails.put(CAMP_PRICE, camp.getPrice());
        campDetails.put(CAMP_UUID, camp.getCampID());
        campDetails.put(CAMP_RATIO, camp.getRatio());
        
        JSONArray jsonSessions = new JSONArray();
        for(int i = 0; i< camp.getSessions().size(); i++){
            jsonSessions.add(camp.getSession(i).getSessionID());
            //jsonSessions.add(getSessionJSON(camp.getSession(i)));
        }
		campDetails.put(CAMP_SESSIONS, jsonSessions);
        return campDetails;
	}

    /**
     * saves the cabin data to a new json file or modifies the old one
     */
    //save cabin
    public static void saveCabin() {
		CabinList camp = CabinList.getInstance();
		ArrayList<Cabin> cabins = camp.getCabins();
		JSONArray jsonCabins = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< cabins.size(); i++) {
			jsonCabins.add(getCabinJSON(cabins.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + CABIN_FILE_NAME)) {
 
            file.write(jsonCabins.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json constants to given values
     * @param cabin the cabin that the json file is based on
     * @return the details relating to the cabin that will be written in save cabin
     */
	public static JSONObject getCabinJSON(Cabin cabin) {
		JSONObject cabinDetails = new JSONObject();
		cabinDetails.put(CABIN_BEDS, cabin.getBeds());
		
        JSONArray jsonCampers = new JSONArray();
        for(int i = 0; i< cabin.getCampers().size(); i++){
            //jsonCampers.add(getCamperJSON(cabin.getCamper(i)));
            jsonCampers.add(cabin.getCamper(i).getCamperID());
        }        
        cabinDetails.put(CABIN_CAMPERS, jsonCampers);

        cabinDetails.put(CABIN_COUNSELOR, getCounselorJSON(cabin.getCounselor()));   

        cabinDetails.put(CABIN_MAX_AGE, cabin.getMaxAge());
        cabinDetails.put(CABIN_UUID, cabin.getCabinID());
        cabinDetails.put(CABIN_MIN_AGE, cabin.getMinAge());


        JSONArray scheduleArray = new JSONArray();
       
        for(int i = 0; i< cabin.getDays().size(); i++){

            JSONArray scheduleActivities = new JSONArray();
            JSONObject scheduleDetails = new JSONObject();
            scheduleActivities.add(cabin.getSchedule(cabin.getDays(i)));  
            
            scheduleDetails.put(SCHEDULE_DAY,cabin.getDayStr(i)) ;
            scheduleDetails.put(SCHEDULE_SCHEDULE, scheduleActivities); 
            scheduleArray.add(scheduleDetails);
        }
        cabinDetails.put(CABIN_SCHEDULE, scheduleArray);
        
        

        
		
        return cabinDetails;
	}

    /**
     * saves the session data to a new json file or changes the old one
     */
    //save session
    public static void saveSession() {
		SessionList sesh = SessionList.getInstance();
		ArrayList<Session> sessions = sesh.getSessions();
		JSONArray jsonSessions = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< sessions.size(); i++) {
			jsonSessions.add(getSessionJSON(sessions.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files"+ SESSION_FILE_NAME)) {
 
            file.write(jsonSessions.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    /**
     * assigns the json constants to given values
     * @param session the session that the json file is based on
     * @return the details pertaining to the session that will be written up in save session
     */
	public static JSONObject getSessionJSON(Session session) {
		JSONObject sessionDetails = new JSONObject();
		sessionDetails.put(SESSION_ID, session.getSessionID());
		sessionDetails.put(SESSION_THEME, session.getTheme());
        JSONArray jsonCabins = new JSONArray();
        for(int i = 0; i< session.getCabins().size(); i++){
            //jsonCabins.add(getCabinJSON(session.getCabin(i)));
            jsonCabins.add(session.getCabin(i).getCabinID());
        }        
        sessionDetails.put(SESSION_CABINS, jsonCabins);

        sessionDetails.put(SESSION_DESCRIPTION, session.getDescription());
        sessionDetails.put(SESSION_END, session.getStrEnd());
        sessionDetails.put(SESSION_START, session.getStrStart());
		
        return sessionDetails;
	}
}
