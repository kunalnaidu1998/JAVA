import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExercises {

	public FileExercises() {
		
	}
	
	public int checkMonth(int month) throws IOException {

		if (month >= 1 && month <= 12) {
			return month;
		}
		else {
			throw new IOException("Invalid month number");
		}
	}
	
	public boolean numberSearch(double numberToFind, String filename) throws FileNotFoundException {
		File newFile = new File(filename);
		if (newFile.exists()!= true) {
			throw new FileNotFoundException();
		}
		String numberAsString = String.valueOf(numberToFind);
		if (filename.contains(numberAsString)) {
			return true;
		}
		else {
			return false;
		}
	}
}
