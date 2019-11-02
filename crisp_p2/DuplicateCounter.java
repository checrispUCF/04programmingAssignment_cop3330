import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;

public class DuplicateCounter {
	HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

	public void count(String dataFile) throws IOException {
		FileInputStream fileByeStream = null; // File input stream
		Scanner scnr = null; // Scanner object
		Integer i;
		String word;

		// Try to open file
		fileByeStream = new FileInputStream(dataFile);
		scnr = new Scanner(fileByeStream);

		while (scnr.hasNext()) {
			word = scnr.next().toLowerCase();
			i = wordCounter.get(word);

			if (i == null) {
				i = 1;
			}
			else {
				i = i + 1;
			}
			wordCounter.put(word, i);
		}

		scnr.close();
		fileByeStream.close();
		System.out.println("An exceptional IO event has occurred.");
	}

	public void write(String outputFile) throws IOException {
		System.out.println(wordCounter);
		FileOutputStream fileByeStream = null; // File output stream
		PrintWriter outFS = null; // Output stream
		Integer i;
		String word;

		// Try to open file
		fileByeStream = new FileOutputStream(outputFile);
		outFS = new PrintWriter(fileByeStream);

		// Writing to file
		outFS.println(wordCounter);

		outFS.flush();
		fileByeStream.close();
		System.out.println("An exceptional IO event has occurred.");

	}

}
