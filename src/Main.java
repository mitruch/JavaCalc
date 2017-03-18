import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * 
 * @author Katarzyna Mitrus
 * 
 * Java programming exercises. 
 * Implementation of simple calculator 
 * witch reads parameters from file and from user.
 * 
 */
public class Main {
	/**
	 * Show menu and navigate it.
	 */
	public static void showMenu() {
		
		/**
		 * 
		 */
		Scanner keyboard = new Scanner(System.in);
		String choice;
		boolean isEnd = true;
		
		System.out.println("MENU");
		System.out.println("Choose 's' to start enter numbers");
		System.out.println("Choose 'l' to load from file");
		System.out.println("Choose 'e' to exit");
	
		do {
			choice = keyboard.nextLine();
			switch (choice) {
				case "s" : {
					 Calculator calc = new Calculator();
					 String operation;
					 do {
						 System.out.println("Write what You need to calculate or 'end' to see menu:  ");
						 operation = keyboard.nextLine();
						 if(!operation.equals("end")){
							 calc.calculate(operation);
						 }
					  } while (!operation.endsWith("end"));
					showMenu();
					keyboard.close();
					isEnd = true;
					break;
				} 
				case "l" : {
					String fileName;
					Readable readingCalc = new Calculator();
					System.out.println("Fill in name of file: ");
					fileName = keyboard.nextLine();
					try {
						readingCalc.readFromFile(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					showMenu();
					keyboard.close();
					isEnd = true;
					break;
				}
				case "e" : {
					System.out.println("...Exit");
					isEnd = true;
					keyboard.close();
					break;
				}
				default : {
				System.out.println("This option is undefined");
				isEnd = false;
				break;
				}
			}
	
		} while (!isEnd);
	}
	
	/**
	 * The main method where menu is shown.
	 * 
	 * @param args	the command line arguments
	 */
	public static void main(String[] args) {
			showMenu();
	}
}