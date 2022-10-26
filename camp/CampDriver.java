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
			options.add("Sign In");
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
					signIn();
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
			options.add("Sessions Available:\n" + facade.getCampSessions());
			options.add("Campers per Counselor: " + facade.getCampInt(RATIO));
			options.add("FAQs:\n" + facade.getCampFAQ()); 
			options.add("Activities Offered:\n" + facade.getCampActivities());
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
						break;
					}
					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getCampString(NAME));
					String change = setStringInformation(NAME);
					if(!change.isEmpty()) {
						if(!facade.setCampString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Price
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + PRICE + ": " + facade.getCampDouble(PRICE));
					double doub = setDoubleInformation(PRICE);
					if(!(doub == -1)) {
						if(!facade.setCampDouble(PRICE, doub)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 2: //Session List
					displaySessionInformation();
					break;

				case 3: //Campers per Counselor
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + RATIO + ": " + facade.getCampDouble(RATIO));
					int num = setIntInformation(RATIO);
					if(!(num == -1)) {
						if(!facade.setCampInt(RATIO, num)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;

				case 4: //FAQ List
					displayCampFAQ();
					break;

				case 5: //activity list
					displayCampActivities();
					break;
			}
		}
	}

	private void displayCampActivities() {
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
				System.out.println("Which activity do you want to delete?");
				int num = getNum();
				if(facade.removeCampActivity(num).isEmpty()) {
					System.out.println("Something went wrong, unable to remove");
				}
				break;
			}
			
			if(choice == options.size() -4) { //the user wants to add an Activity
				System.out.println("What activity do you want to add?");
				if(!facade.addCampActivity(in.nextLine())) {
					System.out.println("Something went wrong, unable to add");
				}
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing activity
				System.out.print(facade.getCampActivities().get(choice));
				String change = setStringInformation(ACTIVITIES);
				if(facade.removeCampActivity(choice).isEmpty() && !facade.addCampActivity(change)) {
					System.out.println("Something went wrong, unable to change");
				}
				break;
        	}
		}
	}

	/**
	 * Displays an FAQ list
	 */
	private void displayCampFAQ() {
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
				System.out.println("Which faq do you want to delete?");
				int num = getNum();
				if(facade.removeCampFAQ(num).equals(null)) {
					System.out.println("Something went wrong, unable to remove");
				}
				break;
			}

			if(choice == options.size() -4) { //the user wants to add an FAQ
				System.out.println("What is the question of the new faq?");
				String question = in.nextLine();
				System.out.println("What is the answer of the new faq?");
				String answer = in.nextLine();
				if(!facade.addCampFAQ(question, answer)) {
					System.out.println("Something went wrong, unable to add");
				}
				break;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing FAQ
				facade.updateFAQ(choice);
				String question = setStringInformation(QUESTION);
				String answer = setStringInformation(ANSWER);
				if(!facade.setFAQString(QUESTION, question) && !facade.setFAQString(ANSWER, answer)) {
					System.out.println("Something went wrong, unable to change");
				}
				break;
        	}
		}
	}

	/**
	 * Displays a Session
	 */
	private void displaySessionInformation() {
		//TODO
	}

	//------------------------------------------- Methods that deal with creating new objects/users -----------------------------------------------------
	/**
	 * Sign in display
	 */
	private void signIn() {
		clear();
		System.out.print("Enter your email: ");
		System.out.print("Enter your password: ");
	}

	/**
	 * Creates a new FAQ object
	 */
	private boolean createNewFAQ() {
		System.out.print("Please enter the question: ");
		String question = in.nextLine();
		System.out.print("Please enter the answer: ");
		String answer = in.nextLine();
		return facade.addFAQ(question, answer);
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
		Date date;
		String str = in.nextLine();
		try {
			date = new SimpleDateFormat("MM/dd/yyyy").parse(str);
		} catch (ParseException e) {
			System.out.println("Sorry " + str + " is not parsable");
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
	 * User entered integer
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
