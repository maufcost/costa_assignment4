package costa_problem1;

import java.io.File;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileNotFoundException;

public class DuplicateRemover {
	
	private ArrayList< String > uniqueWords;
	
	public DuplicateRemover() {
		this.uniqueWords = new ArrayList< String >();
	}
	
	public void remove(String dataFile) {
		// dataFile: path to input file.
		// Gets content from input file and remove duplicates from its content.
		
		try {
			// Opening the file.
			Scanner input = new Scanner(new File(dataFile)); // throws.
			
			// Creating an array list of strings to store the contents of the file.
			ArrayList< String > content = new ArrayList< String >();
			
			// Reading the contents of the file.
			while(input.hasNext()) {
				content.add(input.next());
			}
			
			// Using a Set of Strings to eliminate duplicate words from the file.
			Set< String > set = new HashSet< String >(content);
			
			// "The unique words should be stored in an instance variable called uniqueWords."
			this.uniqueWords.addAll(set);
			
			// Closing the file.
			input.close();
			
		}catch(FileNotFoundException fileNotFoundException) {
			
			System.err.println("File not found.");
		    System.exit(1);
		}
	}
	
	public void write(String outputFile) {
		// outputFile: Path to output file.
		// Writes the words contained in 'uniqueWords' to the file pointed to by outputFile.
		try {
			Formatter output = new Formatter(outputFile); // throws.
			
			// Writing the unique words to the output file.
			if (uniqueWords != null) {
				for(String word: this.uniqueWords) {
					output.format("%s ", word);
				}
				
				// Closing file.
				if (output != null) {
					output.close();
				}
			}
			
		}catch(SecurityException securityException) {
			
			System.err.println("You do not have writing access to this file.");
			System.exit(1);
			
		}catch(FileNotFoundException fileNotFoundException) {
			
			System.err.println("Error creating file.");
		    System.exit( 1 );
		}
	}
}
