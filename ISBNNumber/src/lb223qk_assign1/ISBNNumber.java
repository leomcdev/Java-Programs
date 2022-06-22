// A program which check if the number is an armstrong number or not
package lb223qk_assign1;

import java.util.Scanner;

public class ISBNNumber {

	public static void main(String[] args) {

		Calculations.computeCalculations();
	}
}

// Reads input and calculates to get the armstrongNumber
class Calculations {

	public static Scanner sc = new Scanner(System.in);

	static int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
	static int isbnNumber;

	/**
	 * calculates the ISBN number and prints out
	 */
	public static void computeCalculations() {
		System.out.println("Enter the first 9 digits of an ISBN as integer: ");
		isbnNumber = sc.nextInt();

		// Get the digits of the ISBN
		d1 = 0; // = isbnNumber/100000000
		d2 = (isbnNumber / (int) Math.pow(10, 7)) % 10;
		d3 = (isbnNumber / (int) Math.pow(10, 6)) % 10;
		d4 = (isbnNumber / (int) Math.pow(10, 5)) % 10;
		d5 = (isbnNumber / (int) Math.pow(10, 4)) % 10;
		d6 = (isbnNumber / (int) Math.pow(10, 3)) % 10;
		d7 = (isbnNumber / (int) Math.pow(10, 2)) % 10;
		d8 = (isbnNumber / (int) Math.pow(10, 1)) % 10;
		d9 = isbnNumber % 10;

		d10 = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

		System.out.print("The ISBN-10 number is: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9);

		if (d10 == 10)
			System.out.print("X");
		else
			System.out.print(d10);
	}
}