package costa_problem2;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Formatter;
import java.io.FileNotFoundException;

public class DuplicateCounter {
	
	Map< String, Integer > wordCounter;
	
	public DuplicateCounter() {
		// Using a Map of Strings to count how many times each word occurs in the file.
		wordCounter = new HashMap< String, Integer >();;
	}

	public void count(String dataFile) {
		// dataFile: path to input file.
		// Counts how many times each word occurs in the input file.
		
		try {
			// Opening the file.
			Scanner input = new Scanner(new File(dataFile)); // throws.
			
			// Reading the contents of the file.
			while(input.hasNext()) {
				
				String word = input.next().toLowerCase();
				
				if (wordCounter.containsKey(word)) {
					
					wordCounter.put(word, wordCounter.get(word) + 1);
				}else {
					wordCounter.put(word, 1);
				}
			}
						
			// Closing the file.
			input.close();
			
		}catch(FileNotFoundException fileNotFoundException) {
			
			System.err.println("File not found.");
		    System.exit(1);
		}
	}
	
	public void write(String outputFile) {
		// outputFile: Path to output file.
		// Writes the contents of 'wordCounter' to the output file.
		
		try {
			
			Formatter output = new Formatter(outputFile); // throws.
			
			// Writing the contents of 'wordCounter' to the output file.
			if(this.wordCounter != null) {
				
				for(String key: this.wordCounter.keySet()) {
					output.format("%s appears %d time(s)\n", key, this.wordCounter.get(key));
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
