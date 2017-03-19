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
	 * The overload method based on recursive rules.
	 * 
	 * @param 	operation 	the algebraic expression
	 * @return	call overload method double calculate(String,String) 
	 */
	public double calculate(String operation) {
     	return calculate(operation, "+-");
  	}
	
	/** 
	 * All calculations needed to get result.
	 * 
	 * @param operation 	the algebraic expression
	 * @param delim			the delimiters witch delimit numbers 
	 * @return				result of math operations
	 */
	private double calculate(String operation, String delim) {		    		
      	double result = 0.0;
      	
      	if (!operation.matches("^.[+-/*/0-9]*$")) {
        	return result;
      	}
		
      	double number = 0.0;
        String operator = null;
      	StringTokenizer strToken = new StringTokenizer(operation, delim, true);
		
		while (strToken.hasMoreElements()) {
          
			String nextOperator = strToken.nextToken();          	
			  
			if (NumberUtils.isCreatable(nextOperator)) {
				number = NumberUtils.toDouble(nextOperator);
              	result = (operator != null) ? operate(result, number, operator) : number;
              
			} else {
				
				if (nextOperator.length() > 1) {
					number = calculate(nextOperator, "*/");
					result = (operator != null) ? operate(result, number, operator) : number;
                  
              	} else {
                  	operator = nextOperator;
              	}
			}
		}
		System.out.println(operation + "=" + result);
		return result;
	}

	/**
	 * Match an operator to valid calculation.
	 * 
	 * @param left 		the left parameter of calculation
	 * @param right 	the right parameter of calculation
	 * @param operator	the operator used in calculation
	 */
	private double operate( double left, double right, String operator) {      	      	
      	double result = left;
		switch (operator) {
			case "+": result += right; break;
			case "-": result -= right; break;
			case "/": result /= right; break;
			case "*": result *= right; break;
			default : System.out.println("Incorrect operation: " + operator); break;
		}
      	return result;
	}
}
