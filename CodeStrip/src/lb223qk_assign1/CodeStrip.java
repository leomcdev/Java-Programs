package lb223qk_assign1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * A program that reads in a java file, remove blank lines and commments then
 * prints the result out. It should also print number of lines, code and comments removed.
 */
public class CodeStrip {
	public static void main(String[] args) throws FileNotFoundException {


		String path = "/Users/leo/Desktop/file.txt/";
		String line = "";

		BufferedReader br = new BufferedReader(new FileReader(path));

		final String slashSlash = "//";
		final String slashStar = "/*";
		final String starSlash = "*/";
		final String javadoc = "/**";

		boolean should_keep_ignore = false;
		int comsRemoved = 0;
		int blankLines = 0;
		int totalLines = 0;

		// if asterixs and slashes(comments) are found, ignore and continue the loop and print only if nothing is found
		try {
			while ((line = br.readLine()) != null) {
				if(line.isEmpty()) {
					blankLines++;
					continue;
				}
				if (line.indexOf(slashSlash) >= 0) {
					comsRemoved++;
					continue;
				}
				if (line.indexOf(slashStar) >= 0) {
					should_keep_ignore = true;
					comsRemoved++;
					continue;
				}
				if (line.indexOf(starSlash) >= 0) {
					should_keep_ignore = false;
					continue;
				}
				if (line.indexOf(javadoc) >= 0) {
					comsRemoved++;
					should_keep_ignore = true;
					continue;
				}
				if (!should_keep_ignore) {
					System.out.println(line);
					totalLines++;
				}
			}
			System.out.println(totalLines);
			System.out.println(comsRemoved);
			System.out.println(blankLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
