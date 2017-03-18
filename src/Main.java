import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * 
 * @author mitruch
 *
 */
public class Main {
	public static void showMenu() {
		
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
						 System.out.println("Write what You need to calculate:  ");
						 operation = keyboard.nextLine();
						 if(!operation.equals("end")){
							 calc.calculate(operation);
						 }
					  } while (!operation.endsWith("end"));
					showMenu();
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
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
			showMenu();
	}
}