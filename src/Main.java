import java.util.Scanner;
/**
 * 
 * @author Admin
 *
 */
public class Main {
	public static void showMenu() {
		
		Scanner keyboard = new Scanner(System.in);
		String choice;
		boolean isEnd = true;
		
		System.out.println("MENU");
		System.out.println("Choose 'p' to start enter numbers");
		System.out.println("Choose 'f' to load from file");
	
		do {
			choice = keyboard.nextLine();
			switch (choice) {
				case "p" : {
					System.out.println("jeden");
				//...
					break;
				}
				case "f" : {
					//...
					System.out.println("ZERO");
					break;
				}
				default : {
				System.out.println("Nie");
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