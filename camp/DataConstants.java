package camp;

/**
 * @author Natalie Crawford
 * the DataConstants Class
 */
public abstract class DataConstants {

    //cabin data constants
    protected static final String CABIN_FILE_NAME = "cabin.json";
    protected static final String CABIN_UUID = "id";
	protected static final String CABIN = "cabin";
	protected static final String CABIN_CAMPERS = "campers";
	protected static final String CABIN_COUNSELOR = "counselor";
	protected static final String CABIN_BEDS = "beds";
    protected static final String CABIN_MAX_AGE = "max age";
    protected static final String CABIN_MIN_AGE = "min age";
    protected static final String CABIN_SCHEDULE = "schedule";


    //camp data constants
    protected static final String CAMP_FILE_NAME = "camp.json";
    protected static final String CAMP_UUID = "id";
	protected static final String CAMP = "camp";
	protected static final String CAMP_NAME = "name";
	protected static final String CAMP_SESSIONS = "sessions";
	protected static final String CAMP_PRICE = "price";
    protected static final String CAMP_FAQS = "faqs";
    protected static final String CAMP_RATIO = "camperspercounselor";
    protected static final String CAMP_ACTIVITIES = "activities";

    //camper data constants
    protected static final String CAMPER_FILE_NAME = "camper.json";
    protected static final String CAMPER_UUID = "id";
	protected static final String CAMPER = "camper";
	protected static final String CAMPER_NAME = "name";
	protected static final String CAMPER_BIRTHDAY = "birthday";
	protected static final String CAMPER_MEDICATIONS = "medications";
    protected static final String CAMPER_ALLERGIES = "allergies";
    protected static final String CAMPER_SESSIONS = "sessions";
    protected static final String CAMPER_NOTES = "notes";
    protected static final String CAMPER_EMERGENCY_CONTACTS = "emergency contacts";

    //counselor data constants
    protected static final String COUNSELOR_FILE_NAME = "counselor.json";
    protected static final String COUNSELOR_UUID = "id";
	protected static final String COUNSELOR = "counselor";
	protected static final String COUNSELOR_NAME = "name";
    protected static final String COUNSELOR_EMAIL = "email";
    protected static final String COUNSELOR_PASSWORD = "password";
    protected static final String COUNSELOR_PHONE_NUMBER = "phonenumber";
    protected static final String COUNSELOR_BIO = "bio";
	protected static final String COUNSELOR_BIRTHDAY = "birthday";
    protected static final String COUNSELOR_ALLERGIES = "allergies";
    protected static final String COUNSELOR_EMERGENCY_CONTACTS = "emergency contacts";

    //director data constants
    protected static final String DIRECTOR_FILE_NAME = "director.json";
    protected static final String DIRECTOR_UUID = "id";
	protected static final String DIRECTOR = "director";
	protected static final String DIRECTOR_NAME = "name";
    protected static final String DIRECTOR_EMAIL = "email";
    protected static final String DIRECTOR_PASSWORD = "password";
    protected static final String DIRECTOR_PHONE_NUMBER = "phonenumber";

    //guardian data constants
    protected static final String GUARDIAN_FILE_NAME = "guardian.json";
    protected static final String GUARDIAN_UUID = "id";
	protected static final String GUARDIAN = "guardian";
	protected static final String GUARDIAN_NAME = "name";
    protected static final String GUARDIAN_EMAIL = "email";
    protected static final String GUARDIAN_PASSWORD = "password";
    protected static final String GUARDIAN_PHONE_NUMBER = "phonenumber";
    protected static final String GUARDIAN_CAMPERS = "campers";

    //emergency contact constants
    protected static final String EMERGENCY_NAME = "ename";
	protected static final String EMERGENCY_PHONE = "ephonenumber";
	protected static final String EMERGENCY_ADDRESS = "eaddress";
    protected static final String EMERGENCY_RELATIONSHIP = "erelationship";

    //medications constants
    protected static final String MEDICATION_TYPE = "type";
    protected static final String MEDICATION_DOSE = "does";
    protected static final String MEDICATION_TIME = "time";

    //schedule constants
    protected static final String SCHEDULE_DAY = "day";
    protected static final String SCHEDULE_SCHEDULE = "schedule";

    //session constants
    protected static final String SESSION_ID = "id";
    protected static final String SESSION_THEME = "theme";
    protected static final String SESSION_CABINS = "cabins";
    protected static final String SESSION_NUM = "sessionNumber";
    protected static final String SESSION_START = "start date";
    protected static final String SESSION_END = "end date";

    //faq constants
    protected static final String FAQ_QUESTION = "question";
    protected static final String FAQ_ANSWER = "answer";

}
