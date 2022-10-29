package camp;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Mia Silver
 * The Camp Driver (the front end of the system)
 */
public class CampDriver {
	SimpleDateFormat dateFormatter;
    private Scanner in;
	private ArrayList<String> options;
	private CampFacade facade;
	private User user;

	//Classes (and in some cases instance variables)
	private static final String CAMP = "camp";
	private static final String FAQ = "faq"; //also in camp
    private static final String SESSION = "session"; //also in camper and camp
    private static final String CABIN = "cabin"; //also in session, counselor, and camper
	private static final String SCHEDULE = "schedule"; //also in cabin
    private static final String USER = "user";
    private static final String COUNSELOR = "counselor"; //also in cabin
	private static final String GUARDIAN = "guardian"; 
    private static final String CAMPER = "camper"; //also in cabin and guardian
    private static final String MEDICATION = "medication"; //also in camper
    private static final String CONTACT = "contact"; //also in counselor and camper

	//camp instance variables
	private static final String NAME = "name"; //can also use for User, Camper, and Contact
    private static final String PRICE = "price"; //can also use for Guardian
    private static final String RATIO = "ratio";
	private static final String ACTIVITIES = "activities";

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String THEME = "theme";
	private static final String SESS_NUM = "sessNum"; //can also be used in Guardian
	private static final String START_DATE = "startD";
	private static final String END_DATE = "endD";

	//cabin instance variables
    private static final String MAX_AGE = "max age";
    private static final String MIN_AGE = "min age";
    private static final String NUM_BEDS = "number of beds";

	//user instance variables
	private static final String EMAIL = "email"; //can also be used for Contact
	private static final String PHONE = "phoneNum"; //can also be used for Contact
	private static final String PASSWORD = "password";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String BIRTHDAY = "birthday"; //can also be used for Camper
	private static final String ALLERGIES = "allergies"; //can also be used for Camper

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";

	//medication instance variables
    private static final String DOSE = "dose";
    private static final String TYPE = "type";
    private static final String TIME = "time";

	//edits for array lists
    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String EDIT = "edit";

    /**
	 * Constructs a new driver
	 */
	public CampDriver() {
        in = new Scanner(System.in); 
		options = new ArrayList<String>();
		facade = new CampFacade();
		dateFormatter = new SimpleDateFormat("mm/dd/yyyy");
    }


	//--------------------------------------------------------- Loops and display methods ----------------------------------------------------------
    /**
	 * Runs the driver and displays the camp home page
	 */
	public void runDriver() {
        clear();
        System.out.println("***** Welcome to the Camp Website! *****");

        while(true) {
			//updating options
			clearOptions();
			options.add("View Camp Information");
			if(user == null) {
				options.add("Sign in");
			}
			else {
				options.add("User Portal");
			}
			options.add("Quit");

			//displays choices and checks if the number is quit/return
			System.out.println("***** Home Screen *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}

			//switches between choices
			switch(choice) {
				case 0:
					displayCampInformation();
					break;
				case 1:
					if(user == null) {
						signIn();
					}
					else {
						if(user instanceof Director) {
							displayDirectorPortal();
						}
						if(user instanceof Guardian) {
							displayGuardianPortal();
						}
						if(user instanceof Counselor) {
							displayCounselorPortal();
						}						
					}
					break;
			}
        }
    }


	/**
	 * Displays the Camp Information
	 */
	private void displayCampInformation() {
		while(true) {
			//updating options
			facade.updateCamp();
			clearOptions();
			options.add("Name: " + facade.getCampString(NAME));
			options.add("Pricing: $" + facade.getCampDouble(PRICE) + " per session");
			options.add("Sessions Available");
			options.add("Campers per Counselor: " + facade.getCampInt(RATIO));
			options.add("FAQs"); 
			options.add("Activities Offered");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** Camp Information *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Name
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getCampString(NAME));
					String change = setStringInformation(NAME);
					if(!change.isEmpty()) {
						if(!facade.setCampString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Price
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + PRICE + ": " + facade.getCampDouble(PRICE));
					double doub = setDoubleInformation(PRICE);
					if(!(doub == -1)) {
						if(!facade.setCampDouble(PRICE, doub)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Session List
					displaySessionList();
					break;

				case 3: //Campers per Counselor
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + RATIO + ": " + facade.getCampDouble(RATIO));
					int num = setIntInformation(RATIO);
					if(!(num == -1)) {
						if(!facade.setCampInt(RATIO, num)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 4: //FAQ List
					displayFAQList();
					break;

				case 5: //activity list
					displayActivitiesList();
					break;
			}
		}
	}

	/**
	 * Displays an activity list (only exists in camp currently)
	 */
	private void displayActivitiesList() {
		ArrayList<String> activities = facade.getCampActivities();

		while(true) {
			//updating options
			clearOptions();
			for(int i = 0; i < activities.size(); i++) {
				options.add(activities.get(i));
			}
			options.add("Add a new Activity");
			options.add("Remove an existing Activity");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** Camp Activities *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			if(choice == options.size() - 3) { //the user wants to remove an Activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("Which activity do you want to delete?");
				int num = getNum();
				if(facade.removeCampActivity(num).isEmpty()) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
				}
				break;
			}
			
			if(choice == options.size() -4) { //the user wants to add an Activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("What activity do you want to add?");
				if(!facade.addCampActivity(in.nextLine())) {
					System.out.println("Something went wrong, unable to add");
					in.nextLine();
				}
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.print(facade.getCampActivities().get(choice));
				facade.getCampActivities().set(choice, setStringInformation(ACTIVITIES));
				break;
        	}
		}
	}

	/**
	 * Displays an FAQ list (only exists in camp currently)
	 */
	private void displayFAQList() {
		ArrayList<FAQ> faqs = facade.getCampFAQ();
		
		while(true) {
			//updating options
			clearOptions();
			for(int i = 0; i < faqs.size(); i++) {
				options.add(faqs.get(i).toString()); 
			}
			options.add("Add a new FAQ");
			options.add("Remove an existing FAQ");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			clear();
			System.out.println("***** FAQs *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove an FAQ
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("Which faq do you want to delete?");
				int num = getNum();
				if(facade.removeCampFAQ(num) == null) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
				}
				break;
			}

			if(choice == options.size() -4) { //the user wants to add an FAQ
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}
				createFAQ();
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing FAQ
				facade.updateFAQ(choice);
				displayFAQ();
				break;
        	}
		}
	}

	/**
	 * Displays an FAQ
	 */
	private void displayFAQ() {
		while(true) {
			clearOptions();
			options.add("Question: " + facade.getFAQString(QUESTION));
			options.add("Answer: " + facade.getFAQString(ANSWER));
			options.add("Return");
			options.add("Quit");

			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //Question
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + QUESTION + ": " + facade.getCampString(QUESTION));
					String change = setStringInformation(QUESTION);
					if(!change.isEmpty()) {
						if(!facade.setFAQString(QUESTION, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Answer
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + ANSWER + ": " + facade.getCampString(ANSWER));
					String change2 = setStringInformation(ANSWER);
					if(!change2.isEmpty()) {
						if(!facade.setFAQString(ANSWER, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
			}
		}
	}

	/**
	 * Displays the session list found in camp
	 */
	private void displaySessionList() {
		while(true) {
			clearOptions();
			for(int i = 0; i < facade.getCampSessions().size(); i++) {
				options.add(facade.getCampSessions().get(i).toString());
			}

			options.add("Add a new Session");
			options.add("Remove an existing Session");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			clear();
			System.out.println("***** Sessions *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a Session
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("Which session do you want to delete?");
				int num = getNum();
				if(facade.removeCampSession(num) == null) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					break;
				}
				System.out.println("Removed session");
				break;
			}

			if(choice == options.size() -4) { //the user wants to add a Session
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to view/edit this.");
					in.nextLine();
					break;
				}
				createSession();
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing Session
				facade.updateSession(choice);
				displaySessionInformation();
				break;
        	}
		}
	}

	private void displaySessionInformation() {
		while(true) {			
			//updating options
			clearOptions();
			options.add("Theme: " + facade.getSessionString(THEME));
			options.add("Session Number" + facade.getSessionInt(SESS_NUM));
			options.add("Start Date:" + facade.getSessionDate(START_DATE));
			options.add("End Date: " + facade.getSessionDate(END_DATE));
			options.add("Cabins"); 
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** Session Information *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Theme
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + THEME + ": " + facade.getCampString(THEME));
					String change = setStringInformation(THEME);
					if(!change.isEmpty()) {
						if(!facade.setSessionString(THEME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Session Number
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + SESS_NUM + ": " + facade.getCampDouble(SESS_NUM));
					int num = setIntInformation(SESS_NUM);
					if(!(num == -1)) {
						if(!facade.setSessionInt(SESS_NUM, num)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 2: //Start Date
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + START_DATE + ": " + facade.getSessionDate(START_DATE));
					Date date = setDateInformation(START_DATE);
					if(!(date == null)) {
						if(!facade.setSessionDate(START_DATE, date)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;

				case 3: //End Date
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + END_DATE + ": " + facade.getSessionDate(END_DATE));
					Date date2 = setDateInformation(END_DATE);
					if(!(date2 == null)) {
						if(!facade.setSessionDate(END_DATE, date2)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;

				case 4: //Cabin List
					displayCabinList();
					break;

			}
		}
	}

	private void displayCabinList() {
		ArrayList<Cabin> cabins = facade.getSessionCabinList();
		
		while(true) {
			//updating options
			clearOptions();
			for(int i = 0; i < cabins.size(); i++) {
				options.add(cabins.get(i).toString()); 
			}
			options.add("Add a new Cabin");
			options.add("Remove an existing Cabin");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			clear();
			System.out.println("***** Cabins *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a Cabin
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("Which cabin do you want to delete?");
				int num = getNum();
				if(facade.removeSessionCabin(num) == null) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
				}
				break;
			}

			if(choice == options.size() -4) { //the user wants to add an FAQ
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}
				createCabin();
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing cabin
				facade.updateFAQ(choice);
				displayCabinInformation();
				break;
        	}
		}
	}

	private void displayCabinInformation() {
		while(true) {
			clearOptions();
			options.add("Miumum age: " + facade.getCabinInt(MIN_AGE));
			options.add("Maximum age: " + facade.getCabinInt(MAX_AGE));
			options.add("Number of beds: " + facade.getCabinInt(NUM_BEDS));
			options.add("Counselor: " + facade.getCabinCounselor());
			options.add("Campers");
			options.add("Schedule");
			options.add("Return");
			options.add("Quit");

			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //min age
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + MIN_AGE + ": " + facade.getCabinInt(MIN_AGE));
					int num = setIntInformation(MIN_AGE);
					if(num == -1) {
						if(!facade.setCabinInt(MIN_AGE, num)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //max age
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + MAX_AGE + ": " + facade.getCabinInt(MAX_AGE));
					int num2 = setIntInformation(MAX_AGE);
					if(num2 == -1) {
						if(!facade.setCabinInt(MAX_AGE, num2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 2: //bed numbers
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + NUM_BEDS + ": " + facade.getCabinInt(NUM_BEDS));
					int num3 = setIntInformation(NUM_BEDS);
					if(num3 == -1) {
						if(!facade.setCabinInt(NUM_BEDS, num3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 3: //counselor				
					clear();
					System.out.println(facade.getCabinCounselor().toString());

					if(user instanceof Director) {
						System.out.println("would you like to change the counselor? (y/n)");
						if(in.nextLine().equalsIgnoreCase("y")) {
							ArrayList<Counselor> counselors = facade.getAllCounselors();
							for(int i = 0; i < counselors.size(); i++) {
								System.out.print((i + 1) + ": " + counselors.get(i) + " ");
							}
							System.out.println("\nWhich Cousnelor are you putting into this cabin?");
							int choice2 = getNum();
							facade.setCabinCounselor(counselors.get(choice2));
						}
					}
					break;
				
				case 4: //campers
					displayCamperList(CABIN);
					break;

				case 5: //schedule
					displayScheduleDays();
					break;
			}
		}
	}

	private void displayScheduleDays() {
		while(true) {
			clearOptions();
			options.add("Monday");
			options.add("Tuesday");
			options.add("Wednesday");
			options.add("Thursday");
			options.add("Friday");
			options.add("Saturday");
			options.add("Sunday");
			
			clear();			
			int choice3 = getChoice();
			
			switch(choice3) {
				case 0:
					displaySchedule(Day.MONDAY);
					break;
				
				case 1:
					displaySchedule(Day.TUESDAY);
					break;
				
				case 2:
					displaySchedule(Day.WEDNESDAY);
					break;
				
				case 3:
					displaySchedule(Day.THURSDAY);
					break;
				
				case 4:
					displaySchedule(Day.FRIDAY);
					break;
				
				case 5:
					displaySchedule(Day.SATURDAY);
					break;
				
				case 6:
					displaySchedule(Day.SUNDAY);
					break;
			}

		}
	}

	private void displaySchedule(Day day) {
		facade.updateSchedule(day);
		//TODO
	}


	private void displayDirectorPortal() {
		while(true) {
			//updating options
			facade.updateDirector();
			clearOptions();
			options.add("Name: " + facade.getUserString(NAME));
			options.add("Email: " + facade.getUserString(EMAIL));
			options.add("Phone: " + facade.getUserString(PHONE));
			options.add("Password: " + facade.getUserString(PASSWORD));			
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** User Portal (Director) *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Name					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getUserString(NAME));
					String change = setStringInformation(NAME);
					if(!change.isEmpty()) {
						if(!facade.setCampString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Email				
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getUserString(EMAIL));
					String change2 = setStringInformation(EMAIL);
					if(!(change2 == null)) {
						if(!facade.setUserString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Phone
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getUserString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3 == null)) {
						if(!facade.setUserString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //password
					clear();
					System.out.println("Old " + PASSWORD + ": " + facade.getUserString(PASSWORD));
					String change4 = setStringInformation(PASSWORD);
					if(!(change4 == null)) {
						if(!facade.setUserString(PASSWORD, change4)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
			}	
		}
	}

	private void displayCounselorPortal() {
		while(true) {
			//updating options
			facade.updateCounselor(USER);
			clearOptions();
			options.add("Name: " + facade.getUserString(NAME));
			options.add("Email: " + facade.getUserString(EMAIL));
			options.add("Phone: " + facade.getUserString(PHONE));
			options.add("Password: " + facade.getUserString(PASSWORD));
			options.add("Bio: " + facade.getCounselorString(BIO));
			options.add("Birthday: " + facade.getCounselorDate(BIRTHDAY));
			options.add("Allergies");
			options.add("Sessions");
			options.add("Emergency Contacts");			
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** User Portal (Counselor) *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Name					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getUserString(NAME));
					String change = setStringInformation(NAME);
					if(!change.isEmpty()) {
						if(!facade.setCampString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Email				
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getUserString(EMAIL));
					String change2 = setStringInformation(EMAIL);
					if(!(change2 == null)) {
						if(!facade.setUserString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Phone
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getUserString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3 == null)) {
						if(!facade.setUserString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //password
					clear();
					System.out.println("Old " + PASSWORD + ": " + facade.getUserString(PASSWORD));
					String change4 = setStringInformation(PASSWORD);
					if(!(change4 == null)) {
						if(!facade.setUserString(PASSWORD, change4)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 4: //bio
					clear();
					System.out.println("Old " + BIO + ": " + facade.getCounselorString(BIO));
					String change5 = setStringInformation(BIO);
					if(!(change5 == null)) {
						if(!facade.setCounselorString(BIO, change5)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 5: //birthday
					clear();
					System.out.println("Old " + BIRTHDAY + ": " + facade.getCounselorDate(BIRTHDAY));
					Date date = setDateInformation(BIRTHDAY);
					if(!(date == null)) {
						if(!facade.setCounselorDate(BIRTHDAY, date)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;
				
				case 6: //Allergies
					displayAllergyList(COUNSELOR);
					break;

				case 7: //sessionns
					displaySessionHash(COUNSELOR);
					break;
				
				case 8: //emergency contacts
					displayEmergencyContactHash(COUNSELOR);
					break;
			}
		}
	}

	private void displaySessionHash(String classFrom) {
	
	}


	private void displayGuardianPortal() {
		while(true) {
			//updating options
			facade.updateGuardian();
			clearOptions();
			options.add("Name: " + facade.getUserString(NAME));
			options.add("Email: " + facade.getUserString(EMAIL));
			options.add("Phone: " + facade.getUserString(PHONE)); //doesn't get the phone number for some reason?
			options.add("Password: " + facade.getUserString(PASSWORD));
			options.add("Total Number of Sessions Signed Up for: " + facade.getGuardianInt(SESS_NUM));
			options.add("Price for your children(s)' sessions: $" + facade.getGuardianDouble(PRICE));
			options.add("Camper(s) Profile");	
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** User Portal (Guardian) *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Name					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getUserString(NAME));
					String change = setStringInformation(NAME);
					if(!change.isEmpty()) {
						if(!facade.setCampString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Email				
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getUserString(EMAIL));
					String change2 = setStringInformation(EMAIL);
					if(!(change2 == null)) {
						if(!facade.setUserString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Phone
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getUserString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3 == null)) {
						if(!facade.setUserString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //password
					clear();
					System.out.println("Old " + PASSWORD + ": " + facade.getUserString(PASSWORD));
					String change4 = setStringInformation(PASSWORD);
					if(!(change4 == null)) {
						if(!facade.setUserString(PASSWORD, change4)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 4:
					System.out.println("There is no way to edit this");
					break;

				case 5: //price
					System.out.println("There is no way to edit this");
					break;

				case 6:
					displayCamperList(GUARDIAN);
					break;
			}
		}
	}

	private void displayCamperList(String classFrom) {
		ArrayList<Camper> campers = new ArrayList<Camper>();
		
		if(classFrom.equals(GUARDIAN)) {
			campers = facade.getGuardianCamperList();
		}
		else if(classFrom.equals(CABIN)) {
			campers = facade.getCabinCamperList();
		}
		else {
			System.out.println("Something went wrong");
			return;
		}
		
		while(true) {
			//updating options
			clearOptions();
			for(int i = 0; i < campers.size(); i++) {
				options.add(campers.get(i).toString()); 
			}
			options.add("Add a new Camper");
			options.add("Remove an existing Camper");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			clear();
			System.out.println("***** Campers *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a Camper
				if(!(user instanceof Guardian)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("Which camper do you want to delete?");
				int num = getNum();
				if(facade.removeGuardianCamper(num) == null) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
				}
				break;
			}

			if(choice == options.size() -4) { //the user wants to add a Camper
				if(!(user instanceof Guardian)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}
				createCamper();
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing Camper
				facade.updateCamper(classFrom, choice);
				displayCamperProfile();
				break;
        	}
		}
	}


	private void displayCamperProfile() {
		while(true) {
			clearOptions();
			options.add("Name: " + facade.getCamperString(NAME));
			options.add("Birthday: " + facade.getCamperDate(BIRTHDAY));
			options.add("Medications");
			options.add("Allergies");
			options.add("Sessions");
			options.add("Emergency Contacts");
			options.add("Return");
			options.add("Quit");

			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //Name
					if(!(user instanceof Guardian)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + NAME + ": " + facade.getCamperString(NAME));
					String change = setStringInformation(NAME);
					if(change == null) {
						if(!facade.setCamperString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Birthday
					if(!(user instanceof Guardian)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + BIRTHDAY + ": " + facade.getCamperDate(BIRTHDAY));
					Date date = setDateInformation(BIRTHDAY);
					if(date == null) {
						if(!facade.setCamperDate(BIRTHDAY, date)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 2: //Medications
					displayMedicationList();
					break;

				case 3: //allergies
					displayAllergyList(CAMPER);
					break;

				case 4: //Sessions
					displaySessionHash(CAMPER);

				case 5: //Emergency Contacts
					displayEmergencyContactHash(CAMPER);
					
			}
		}
	}

	private void displayMedicationList() {
		
	}

	private void displayAllergyList(String classFrom) {
		ArrayList<String> allergies = new ArrayList<String>();
		if(classFrom.equals(CAMPER)) {
			allergies = facade.getCamperAllergyList();
		}
		else if (classFrom.equals(COUNSELOR)) {
			allergies = facade.getCounselorAllergyList();
		}
		else {
			System.out.println("Something went wrong)");
			return;
		}

		while(true) {
			//updating options
			clearOptions();
			for(int i = 0; i < allergies.size(); i++) {
				options.add(allergies.get(i));
			}
			options.add("Add a new Allergy");
			options.add("Remove an existing Allergy");
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number is quit/return
			clear();
			System.out.println("***** Camp Allergies *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			if(choice == options.size() - 3) { //the user wants to remove an Allergy
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) || !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("Which allergy do you want to delete?");
				int num = getNum();
				if(user instanceof Guardian && facade.removeCamperAllergy(num) == null) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					break;
				}
				if(user instanceof Counselor && facade.removeCounselorAllergy(num) == null) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					break;
				}
				break;
			}
			
			if(choice == options.size() -4) { //the user wants to add an Activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				System.out.println("What activity do you want to add?");
				if(!facade.addCampActivity(in.nextLine())) {
					System.out.println("Something went wrong, unable to add");
					in.nextLine();
				}
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing activity
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) || !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					break;
				}

				if(user instanceof Guardian) {
					System.out.println(facade.getCamperAllergyList().get(choice));
					facade.getCamperAllergyList().set(choice, setStringInformation(ALLERGIES));
				}
				else if(user instanceof Counselor) {
					System.out.println(facade.getCounselorAllergyList().get(choice));
					facade.getCounselorAllergyList().set(choice, setStringInformation(ALLERGIES));
				}
				else {
					System.out.println("Something went wrong");
				}
				break;
        	}
		}
	}

	private void displayEmergencyContactHash(String classFrom) {
		
	}


	//------------------------------------------- Methods that deal with creating new objects/users -----------------------------------------------------
	private void signIn() {
		clear();
		System.out.print("Enter your email: ");
		String email = in.nextLine();
		System.out.print("Enter your password: ");
		String password = in.nextLine();

		if(facade.signIn(email, password)) {
			user = facade.getUser();
			System.out.println("Successfully signed in");
			return;
		}
		System.out.println("Could not sign you in");
		return;
	}

	private void createFAQ() {
		System.out.println("What is the question of the new faq?");
		String question = in.nextLine();
		System.out.println("What is the answer of the new faq?");
		String answer = in.nextLine();
		if(!facade.addCampFAQ(question, answer)) {
			System.out.println("Something went wrong, unable to add");
			in.nextLine();
		}
	}

	private void createSession() {
		System.out.println("What would you like the theme to be?");
		String theme = in.nextLine();
		System.out.println("What would you like the session number to be?");
		double sessionNumber = (double)getNum();
		System.out.println("What would you like the start date to be?");
		Date startDate = getDate(in.nextLine());
		System.out.println("What would you like the end date to be?");
		Date endDate = getDate(in.nextLine());
		if(!facade.addCampSession(theme, sessionNumber, startDate, endDate)) {
			System.out.println("Something went wrong, unable to add");
			in.nextLine();
			return;
		}
	}
	
	private void createCabin() {
		//TODO
	}

	private void createCamper() {
		//TODO
	}

	//------------------------------------------- Methods that change an instance variable/array list ----------------------------------------------
	/**
	 * User inputs a new string to replace a string variable and verifies the change
	 * @param variableName the instance variable being edited
	 * @return the new string to input into the variableName, null if not verified
	 */
	private String setStringInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		String change = in.nextLine();	
		
		System.out.println("You would like to change it to " + change);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return change;
		}
		System.out.println("The " + variableName + " will not be changed");
		return null;	
	}

	/**
	 * User inputs a new int to replace an int variable and verifies the change
	 * @param type the instance variable being edited
	 * @return the new int to input into the variableName, -1 if not a valid int/not verified
	 */
	private int setIntInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		int num = getNum();
		
		System.out.println("You would like to change it to " + num);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return num;
		}
		System.out.println("The " + variableName + " will not be changed.");
		return -1;		
	}

	/**
	 * User inputs a new double to replace a double variable and verifies the change
	 * @param type the instance variable being edited
	 * @return the new double to input into the variableName, -1 if not a valid double/ not verified
	 */
	private double setDoubleInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		double doub;
		try {
			doub = Double.parseDouble(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return -1;
		}
		
		System.out.println("You would like to change it to " + doub);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return doub;
		}
		System.out.println("The " + variableName + " will not be changed.");
		return -1;		
	}

	/**
	 * User inputs a new date to replace a date variable and verifies the change
	 * @param type the instance variable being edited
	 * @return the new date to input into the variableName, null if not valid
	 */
	private Date setDateInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		Date date = getDate(in.nextLine());
		if(date == null) {
			System.out.println("Something went wrong");
			return null;
		}
		System.out.println("You would like to change it to " + date);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return date;
		}
		System.out.println("The " + variableName + " will not be changed.");
		return null;
	}

	//------------------------------------- Methods that deal with the array list, options, and the console ----------------------------------------------
	/**
	 * Clears the array list
	 */
	private void clearOptions() {
		options.clear();
	}

	/**
	 * Displays the options, and gets the user's input
	 * @return the user's choice
	 */
	private int getChoice() {
		for(int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
		System.out.print("Enter the number of the option you would like to see/edit: ");

		int num = getNum();

		if (num < 0 || num > options.size() - 1) {
			clear();
			System.out.println("Sorry, your option is not in the valid range.\n");
			return -1;
		}
		clear();
		return num;
	}

	/**
	 * User entered int
	 */
	private int getNum() {
		int num;
		try {
			num = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return -1;
		}
		return num;
	}

	/**
	 * User entered Date
	 */
	private Date getDate(String date) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			System.out.println("Sorry " + date + " is not parsable");
			return null;
		}
	}

    /**
	 * Clears the console
	 */
	private void clear() {
		System.out.print("\033[H\033[2J");
	}

    public static void main(String[] args) {
        CampDriver camp = new CampDriver();
        camp.runDriver();
    }
}
