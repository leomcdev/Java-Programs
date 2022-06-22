package lb223qk_assign2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class IdentifyWordsMain1 {
	public static void main(String[] args) throws IOException, IOException {

		// creat sets
		Set<Word> wordsHashSet = new HashSet<Word>();
		Set<Word> wordsTreeSet = new TreeSet<Word>();

		String word = "";
		Word w = new Word(word);

		BufferedReader br = new BufferedReader(new FileReader("/Users/leo/Desktop/words1.txt"));
		String line = br.readLine();

		while (line != null) {
			System.out.println("Line: " + line);
			String strWords[] = line.split(" ");
			for (String str : strWords) {
				wordsHashSet.add(new Word(str));
				wordsTreeSet.add(new Word(str));

			}
			line = br.readLine();
		}
		System.out.println(wordsHashSet.size());
		System.out.println(wordsHashSet);

		System.out.println(wordsTreeSet.size());
		System.out.println(wordsTreeSet);

	}

}