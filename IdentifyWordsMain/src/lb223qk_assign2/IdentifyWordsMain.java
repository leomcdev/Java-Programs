package lb223qk_assign2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// task 5 and 5.1
public class IdentifyWordsMain {

	public static void main(String[] args) throws IOException, IOException {

		// takes in a new file
		File file = new File("/Users/leo/Desktop/HistoryOfProgramming.txt");

		ArrayList<String> words = new ArrayList<String>();
		String sequencedWords = "";

		// read in the file from hashSet
		readFile(file, words);

		// the new file
		FileWriter writer = new FileWriter("/Users/leo/Desktop/words1.txt");
		for (String word : words) {
		writer.write(word + " ");
		
		}
		System.out.println("here" + sequencedWords);
		writer.close();

	}

	// read the file
	public static void readFile(File file, ArrayList<String> words) throws IOException {

		int totalWords = 0;

		BufferedReader br = new BufferedReader(new FileReader("/Users/leo/Desktop/HistoryOfProgramming.txt"));
		String line = br.readLine();

		while (line != null) {
			System.out.println("Line: " + line);

			if (!line.trim().equals("")) {
				String w[] = line.split(" ");
				totalWords += w.length;

				for (String word : w) {
					String cleanWords = word.toString();
					cleanWords = cleanWords.replaceAll("[^a-zA-Z0-9]", "");
					cleanWords = cleanWords.replaceAll("\\d", "");
					cleanWords = cleanWords.trim();
					if (cleanWords.length() > 0) {
						if (cleanWords.charAt(cleanWords.length() - 1) == ',') {
							cleanWords = cleanWords.substring(0, cleanWords.length() - 1);
						}
						words.add(cleanWords);
					}
				}
			}
			line = br.readLine();
		}
		System.out.println("words initially: " + totalWords);
	}
}
