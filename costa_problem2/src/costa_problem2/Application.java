package costa_problem2;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		duplicateCounter.count("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");
	}

}
