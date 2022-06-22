/*
 * A program that takes in user input. Calculate the armstrong number between two 
 * integer numbers then prints out the armstrong number. The armstrong number is found
 * by taking the nth^ of every single digit and then sum it together. 
 */

package lb223qk_assign1;

import java.util.Scanner;

public class ExtractArmstrongNumber	 {

	/**
	 * Reads input, handles user information and print outs information	
	 */
	public void readInput() {

		Scanner sc = new Scanner(System.in);
		int startingNumber, endingNumber;
		String stringInput;
		String quit = "N";

		while (true) {
			System.out.println("Enter the starting number of the range: ");
			startingNumber = sc.nextInt();
			System.out.println("Enter the ending number of the range: ");
			endingNumber = sc.nextInt();

			compute(startingNumber, endingNumber);

			System.out.println("Do you want to repeat? (Y/N): ");
			stringInput = sc.next();

			if (stringInput.equals(quit)) {
				System.out.println("Bye");
				System.exit(0);
			}
		}
	}

	/**
	 * Calculates the armstrong number
	 * @param startingNumber
	 * @param endingNumber
	 */
	public void compute(int startingNumber, int endingNumber) {

		int remainder, sum, digits;
		int initialNumber = 0;

		// loop as long as number is lower than endingNumber
		for (int number = startingNumber; number < endingNumber; number++) {
			sum = 0;
			digits = 0;
			initialNumber = number;

			// erase the numbers and as many numbers there are digits.
			while (initialNumber != 0) {
				initialNumber /= 10;
				digits++;
			}
			
			initialNumber = number;

			// extract the remainder and calculate the sum
			while (initialNumber != 0) {

				remainder = initialNumber % 10;
				sum += Math.pow(remainder, digits);
				initialNumber /= 10;
				
			}
			if (sum == number) {
				System.out.println(number + " ");
			}
		}
	}

}