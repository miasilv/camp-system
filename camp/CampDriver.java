import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Mia Silver
 * The Camp Driver (the front end of the system)
 */
public class CampDriver {
    private Scanner in;
	private ArrayList<String> options;
	private CampFacade facade;
	private User user;

	//Classes
	private static final String CAMP_INFORMATION = "campI";
	private static final String FAQ_INFORMATION = "faqI";
    private static final String SESSION_INFORMATION = "sessI";
    private static final String CABIN_INFORMATION = "cabI";
    private static final String USER_INFORMATION = "userI";
    private static final String COUNSELOR_INFORMATION = "counI";
    private static final String MEDICATION_INFORMATION = "medI";
    private static final String CONTACT_INFORMATION = "contI";
    private static final String GUARDIAN_INFORMATION = "guardI";
    private static final String CAMPER_INFORMATION = "camperI";

	//camp instance variables
	private static final String NAME = "name"; //can also use for User, Camper, and Contact
	private static final String SESSIONS = "sessions"; //can also use for Camper
    private static final String PRICE = "price"; //can also use for Guardian
    private static final String RATIO = "ratio";
	private static final String FAQS = "faqs";
	private static final String ACTIVITIES = "activities";

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String CABINS = "cabins"; //can also use for Counselor and Camper
	private static final String SESS_NUM = "sessNum"; //can also be used in Guardian
	private static final String START_DATE = "startD";
	private static final String END_DATE = "endD";

	//cabin instance variables
	private static final String CAMPERS = "campers"; //can also use for Guardian
	private static final String COUNSELOR = "counselor";
	private static final String SCHEDULE = "schedule"; //can also use for schedule class

	//user instance variables
	private static final String EMAIL = "email"; //can also be used for Contact
	private static final String PHONE = "phoneNum"; //can also be used for Contact
	private static final String PASSWORD = "password";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String EMERGENCY_CONTACTS = "emergenCon"; //can also be used for Camper
	private static final String BIRTHDAY = "birthday"; //can also be used for Camper
	private static final String ALLERGIES = "allergies"; //can also be used for Camper

	//camper instance variables
	private static final String MEDICATION = "medication";

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";

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

			//displays choices and checks number
			System.out.println("***** Home Screen *****");
			int choice = getNum();
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
			clearOptions();
			options.add("Name: " + facade.getInformation(CAMP_INFORMATION, NAME));
			options.add("Pricing: $" + facade.getInformation(CAMP_INFORMATION, PRICE) + " per session");
			options.add("Sessions Available:\n" + facade.getSessionList(CAMP_INFORMATION));
			options.add("Campers per Counselor: " + facade.getInformation(CAMP_INFORMATION, RATIO));
			options.add("FAQs:\n" + facade.getFAQList(CAMP_INFORMATION)); 
			options.add("Activities Offered:\n" + facade.getActivityList(CAMP_INFORMATION));
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			clear();
			System.out.println("***** Camp Information *****");
			int choice = getNum();
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
				case 0:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editStringInformation(CAMP_INFORMATION, NAME);
					break;
				case 1:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editDoubleInformation(CAMP_INFORMATION, PRICE);
					break;
				case 2:
					if(!(user instanceof Director || user instanceof Counselor)) {
						System.out.println("You do not have permission to edit this.");
					}
					displaySessionInformation();
				case 3:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editIntInformation(CAMP_INFORMATION, RATIO);
					break;
				case 4:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					displayFAQ();
			}
		}
	}

	/**
	 * Displays an FAQ list
	 */
	private void displayFAQ() {
		ArrayList<FAQ> faqs = facade.getFAQList(CAMP_INFORMATION);
		
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
			int choice = getNum();
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
				if(!facade.removeArrayListObject(FAQS, CAMP_INFORMATION, choice)) {
					System.out.println("Something went wrong, unable to remove");
					break;
				}
			}
			if(choice == options.size() -4) { //the user wants to add an FAQ
				facade.addFAQ(FAQ_INFORMATION, createNewFAQ());
			}
			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing FAQ
				System.out.print("Do you want to edit the question or answer? (q/a)");
				if(in.nextLine().equalsIgnoreCase("q")) {
					editStringInformation(FAQ_INFORMATION, QUESTION);
				}
				else {
					editStringInformation(FAQ_INFORMATION, ANSWER);				
				}
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
	private FAQ createNewFAQ() {
		System.out.print("Please enter the question: ");
		String question = in.nextLine();
		System.out.print("Please enter the answer: ");
		String answer = in.nextLine();
		return new FAQ(question, answer);
	}
	
	//------------------------------------------- Methods that change an instance vairable/array list ----------------------------------------------
	/**
	 * Edits a class' String instance varaible.
	 * @param className the class in which the String instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editStringInformation(String className, String variableName) {
		System.out.println("Old" + variableName + ": " + facade.getInformation(className, variableName));
		System.out.print("Enter what you would like to change this to: ");
		String change = in.nextLine();		
		
		if(verify(change)) {
			facade.editInformation(className, variableName, change);
			System.out.println("New" + variableName + ": " + facade.getInformation(className, variableName));
			return;
		}
		System.out.println("The " + variableName + " will not be changed.");		
	}

	/**
	 * Edits a class' int instance varaible.
	 * @param className the class in which the int instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editIntInformation(String className, String variableName) {
		System.out.println("Old" + variableName + ": " + facade.getInformation(className, variableName));
		System.out.print("Enter what you would like to change this to: ");	
		
		int change = getNum();
		
		if(verify(Integer.toString(change))) {
			facade.editInformation(className, variableName, change);
			System.out.println("New" + variableName + ": " + facade.getInformation(className, variableName));
			return;
		}
		System.out.println("The " + variableName + " will not be changed.");		
	}

	/**
	 * Edits a class' double instance varaible.
	 * @param className the class in which the double instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editDoubleInformation(String className, String variableName) {
		System.out.println("Old" + variableName + ": " + facade.getInformation(className, variableName));
		System.out.print("Enter what you would like to change this to: ");	
		
		double change;
		try {
			change = Double.parseDouble(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return;
		}
		clear();
		
		if(verify(Double.toString(change))) {
			facade.editInformation(className, variableName, change);
			System.out.println("New" + variableName + ": " + facade.getInformation(className, variableName));
			return;
		}
		System.out.println("The " + variableName + " will not be changed.");		
	}

	/**
	 * Verifies that the input is what the user wants to change it to
	 * @param change the new input
	 * @return true if it is correct, false if it is not correct
	 */
	private boolean verify(String change) {
		System.out.println("You would like to change it to " + change);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
	
	private int editArrayList() {
		System.out.println("Would you like to add, remove, or edit this list?");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase(ADD)) {
			return 0;
		}
		else if(answer.equalsIgnoreCase(REMOVE)) {
			return 1;
		}
		else if(answer.equalsIgnoreCase(EDIT)) {
			return 2;
		}
		else {
			return -1;			
		}

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
	private int getNum() {
		for(int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
		System.out.print("Enter the number of the option you would like to see/edit: ");

		int num;
		try {
			num = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return -1;
		}

		if (num < 0 || num > options.size() - 1) {
			clear();
			System.out.println("Sorry, your option is not in the valid range.\n");
			return -1;
		}
		clear();
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
