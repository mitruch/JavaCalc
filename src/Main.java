import java.util.Scanner;
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
					System.out.println("jeden");
				//...
					break;
				}
				case "l" : {
					//...
					System.out.println("ZERO");
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