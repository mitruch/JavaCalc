package pl.edu.uksw.wmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * All the calculations.
 * 
 * @author Katarzyna Mitrus
 *
 */

public class Calculator implements Readable {
	private int result;
	
	/**
	 * Read from *.txt file.
	 * 
	 * @param fileName the name of file
	 * @throws FileNotFoundException the exception if the file not found
	 */
	@Override
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
	
	/** 
	 * All calculations needed to get result.
	 * 
	 * @param operation 	the simply algebraic expression
	 * @return 				result of math operations
	 */
	public Integer calculate(String operation) {
		
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
	
	/**
	 * Match an operator to valid calculation.
	 * 
	 * @param number 	the parameter of calculation
	 * @param operator	the operator used in calculation
	 */
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
