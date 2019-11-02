import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class DuplicateRemover {
	HashSet<String> uniqueWords = new HashSet<String>(); // Using this to store the strings

	public void remove(String dataFile) throws IOException {
		FileInputStream fileByteStream = null; // File input stream
		Scanner scnr = null; // Scanner object

		// Try to open file
		fileByteStream = new FileInputStream(dataFile);
		scnr = new Scanner(fileByteStream);

		while (scnr.hasNext()) {
			uniqueWords.add(scnr.next());
		}

		scnr.close();
		fileByteStream.close();

		System.out.println("An exceptional IO event has occurred.");

	}

	public void write(String outputFile) throws IOException {
		FileOutputStream fileByteStream = null; // File output stream
		PrintWriter outFS = null; // Output stream
		String word;

		// Try to open file
		fileByteStream = new FileOutputStream(outputFile);
		outFS = new PrintWriter(fileByteStream);

		// Can now write to the file
		Iterator<String> uniqueWordsIterator = uniqueWords.iterator();

		while (uniqueWordsIterator.hasNext()) {
			word = (String)uniqueWordsIterator.next();
			outFS.println(word);
		}

		outFS.flush();
		fileByteStream.close();

		System.out.println("An exceptional IO event has occurred.");
	}
}
