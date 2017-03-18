import java.io.FileNotFoundException;

public interface Readable {
	/**
	 * Read from *.txt file.
	 * 
	 * @param fileName the name of file 
	 * @throws FileNotFoundException
	 */
	public void readFromFile(String fileName) throws FileNotFoundException;
}
