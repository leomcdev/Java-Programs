/*
 * A program which takes in the 
 */

package lb223qk_assign1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {

		String anagram = "";

		CheckForAnagrams.isAnagram(anagram);

	}
}

class RetrieveTextFile {

	public static String[] readArray() {
		String path = "/Users/leo/Downloads/wordlist/";
		String line = "";
		String words[] = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				line = line.replaceAll("'", "");
				line = line.toLowerCase();
				words = line.split(",");

				for (int i = 0; i < words.length; i++)
					System.out.println(words[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
}

class CheckForAnagrams {

	public static void isAnagram(String word) {

		String[] words1 = RetrieveTextFile.readArray();
		String[] sortedWords = sort(words1);
		String input;

		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		for (int i = 0; i < input.length(); i++) {

		}
	}

	public static String[] sort(String[] words) {
		String temp;
		String[] words1 = RetrieveTextFile.readArray();

		for (int j = 0; j < words1.length; j++) {
			for (int i = j + 1; i < words1.length; i++) {
				// comparing adjacent strings
				if (words1[i].compareTo(words1[j]) < 0) {
					temp = words1[j];
					words1[j] = words1[i];
					words1[i] = temp;
				}
			}
			System.out.println(words1[j]);
		}
		return words;

	}

	public static void sortString(String words) {

	}
}
