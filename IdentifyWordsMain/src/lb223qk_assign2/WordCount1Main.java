package lb223qk_assign2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WordCount1Main {
	
	public static void main(String[] args) {

	String fileContent = "";
	
	File file = new File("/Users/leo/Desktop/words.txt");
	try {
		Scanner scan = new Scanner(file);
	
	while (scan.hasNextLine()) {
		fileContent = scan.nextLine();
		System.out.println(fileContent);
	}
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("no file");
	}
	
	}
}
