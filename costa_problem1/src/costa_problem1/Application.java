package costa_problem1;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove("problem1.txt");
		duplicateRemover.write("unique_words.txt");
	}
}
