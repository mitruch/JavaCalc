import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

public class Calculator implements Readable {
	int result;
	
	public void readFromFile(String fileName) throws FileNotFoundException{
		File inFile = new File(fileName);
	    Scanner in = new Scanner(inFile);
	    while(in.hasNextLine()){
		    String operation = in.nextLine();
		    System.out.println(operation);
		    calculate(operation);
	    }
	    in.close();
	}
	
	public int calculate(String operation) {
		
		int number;
		String operator = null;
		StringTokenizer strToken = new StringTokenizer(operation, "+-/*", true);
		
		while (strToken.hasMoreElements()) {
			String nextOperator = strToken.nextToken();
			
			if (NumberUtils.isCreatable(nextOperator)) {
				number = NumberUtils.toInt(nextOperator);
				if (operator != null) {
					operate(number, operator);
				} 
				else {
					this.result = number;
				}
			} else {
				operator = nextOperator;
			}
		}
		System.out.println(operation + "=" + result);
		return this.result;
	}

	private void operate( int number, String operator) {
		switch (operator) {
			case "+": {
				this.result += number;
				break;
			}
			case "-": {
				this.result -= number;
				break;
			}
			case "/": {
				this.result /= number;
				break;
			}
			case "*": {
				this.result *= number;
				break;
			}
			default : {
				System.out.println("Incorrect operation !");
				break;
			}
		}

	}
	
	
}
