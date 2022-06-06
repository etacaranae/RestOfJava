import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Gets the frequency of words in a book
 * 
 * @author s-ALEAVITT
 *
 */
public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		Scanner bookScan = openBook(console);

		// make a map to store words
		Map<String, Integer> wordMap = new TreeMap<String, Integer>();

		// read and print each line of the book
		while (bookScan.hasNextLine()) {
			String line = bookScan.nextLine();
			line = formatWord(line);

			// scan the current line
			Scanner lineScan = new Scanner(line);
			while (lineScan.hasNext()) {
				String w = lineScan.next();

				// is this word in the map
				if (wordMap.containsKey(w)) {
					// if so, increment frequency
					int cur = wordMap.get(w);
					wordMap.put(w, cur + 1);
				} else {
					// otherwise add it to the map
					wordMap.put(w, 1);
				}
			}
			lineScan.close();

		}

		// prompt the user for a word and display the frequency
		boolean stop = false;
		while (!stop) {
			System.out.print("Word (q to quit): ");
			String word = console.nextLine();
			if (word.equals("q")) {
				stop = true;
			} else {
				System.out.println(word + ": " + wordMap.get(word));
			}
		}

		// list every word with more than 500 occurences
		for (String k : wordMap.keySet()) {
			int occ = wordMap.get(k);
			if (occ >= 500) {
				System.out.println(k + ": " + wordMap.get(k));
			}
		}

		// System.out.println(wordMap.toString());

		bookScan.close();
		console.close();
	}

	/**
	 * Strips most punctuation and uppercase
	 * 
	 * @param s
	 *            the string to format
	 * @return the formatted string
	 */
	public static String formatWord(String s) {
		s = s.toLowerCase();
		s = s.replace('!', ' ');
		s = s.replace(',', ' ');
		s = s.replace('.', ' ');
		s = s.replace('(', ' ');
		s = s.replace(')', ' ');
		s = s.replace(';', ' ');
		s = s.replace(':', ' ');
		s = s.replace('?', ' ');
		s = s.replace('-', ' ');
		s = s.replace('\"', ' ');
		s = s.replace('$', ' ');
		s = s.replace('<', ' ');
		s = s.replace('>', ' ');
		s = s.replace('\'', ' ');
		s = s.replace('&', ' ');
		s = s.replace('*', ' ');
		s = s.replace('/', ' ');
		s = s.replace('[', ' ');
		s = s.replace(']', ' ');
		return s;
	}

	/**
	 * Returns a book scanner
	 * 
	 * @param console
	 *            the scanner to read the file name
	 * @return a scanner of a book
	 * @throws FileNotFoundException
	 */
	public static Scanner openBook(Scanner console) throws FileNotFoundException {
		System.out.print("Give me the book file name: ");
		File f = new File(console.nextLine());
		Scanner s = new Scanner(f);
		return s;
	}

}
