import java.util.Scanner;

public class CampDriver {
    private Scanner in;

    public CampDriver() {
        in = new Scanner(System.in); 
    }

    public void runDriver() {

    }

    /**
	 * Clears the console
	 */
	private void clear() {
		System.out.print("\033[H\033[2J");
	}

    /**
	 * Gets a number from the user, used to get their option.
	 * @param size the size of the array holding the options
     * @return A number between 0 and size - 1 correspoinding to their option
	 */
	private int getNum(int size) {
		int num;

		try {
			num = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return -1;
		}
		clear();

		if (num < 0 || num > size - 1) {
			clear();
			System.out.println("Sorry, your option is not in the valid range.\n");
			return -1;
		}
		return num;
	}


    public static void main(String[] args) {
        CampDriver camp = new CampDriver();
        camp.runDriver();
    }
}
