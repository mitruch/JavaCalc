import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator implements Readable {
	int result;
	
	public void readFromFile(String fileName) throws FileNotFoundException{
		File inFile = new File(fileName);
	    Scanner in = new Scanner(inFile);
	    while(in.hasNextLine()){
		    String operation = in.nextLine();
		    System.out.println(operation);
		    //this.calculate(operation)?
	    }
	    in.close();
	}
	
}
