/*
 * A program that computes the square root of a positive number, called the babolonyan algorithm. 
 */
package lb223qk_assign1;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String args[]) {

		ComputeSquareRoot.compute();
	}
}

// computes the squareroot of inputted number from user
class ComputeSquareRoot {

	/**
	 * Reads input then break the input down to get the square roots.
	 */
	public static void compute() {

		System.out.println("This programs estimates square root");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer to estimate the square root of: ");
		double n = sc.nextInt();

		double lastDigit = 0;
		double r = 0;
		double guess = n / 2;
		double lastGuess = guess;
		double differenceInPercentage = Double.MAX_VALUE;

		// compute to get the square root of the guess
		while (Math.abs(differenceInPercentage) >= 0.01) {

			r = n / guess;
			guess = (guess + r) / 2;
			differenceInPercentage = ((guess - lastGuess) / lastGuess);
			lastGuess = guess;
			lastDigit = guess % 10;

			System.out.println("Current guess: " + guess);
		}
		
		System.out.printf("The estimated square root of " + (int) n + " is " + "%.2f", (lastDigit));
	}
}
