package uppgift2;

import java.util.Scanner;

public class Nm {

	public static void main(String args[]) {

		// skapa nytt objekt och kalla på klassmetoden
		Datorn obj = new Datorn();
		obj.spela();
	}
}

// spela är superklassen
class Spela {

	// spela spelet
	public void spela() {

		System.out.println("Welcome to Nm\nPlayer 1: Computer \nPlayer 2: Human ");

		// deklarera och initiera variabler
		int newMatches = 0;
		int matchesLeft;
		int playerMove = 0;
		int computerMove;
		int input;

		// skapa nya object och kalla på metoden computersturn
		Datorn d = new Datorn();
		Människan m = new Människan();
		d.computersTurn(newMatches);

		// användare input
		System.out.println("Please pick a number");
		matchesLeft = m.input();

		// kör programmet så länge det är det finns 1 eller mindre än 1 sticka
		while (matchesLeft > 1) {

			// datorns tur
			computerMove = d.computersTurn(newMatches);
			System.out.println("Computer removes " + computerMove);
			matchesLeft -= computerMove;

			// datorn vinner
			System.out.println("New amount of matches " + matchesLeft);
			if (matchesLeft == 1) {
				System.out.println("Computer wins ggwp");
				break;
			}

			// människans tur
			do {
				System.out.println("Your move ");
				playerMove = m.input();
				if (playerMove > matchesLeft / 2) {
					System.out.println("Måste vara mindre än hälften av stickor som är kvar");
				} 
				else {
					// ta bort dragna stickor om inmatning är korrekt
					System.out.println("Human removes " + playerMove + " matches");
					matchesLeft -= playerMove;
					System.out.println("Amount left: " + matchesLeft);
				}

				// användaren vinner
				if (matchesLeft == 1) {
					System.out.println("You win legend");
					break;
				}
			} 
			while (playerMove > matchesLeft / 2);
		}
	}
}

// slumpa tal av datorn mellan 1-2
class Datorn extends Spela {

	public int computersTurn(int matches) {
		matches = (int) (Math.random() * 1) + 1;
		return matches;
	}
}

// hantera spelarens användar input
class Människan extends Spela {
	public int input() {

		Scanner userInput = new Scanner(System.in);

		int input = 0;
		String input1;

		// om användarinput är negativt
		while (true) {
			if (userInput.hasNextInt()) {
				input = userInput.nextInt();
				return Math.abs(input);
			}
			// om input inte är integer
			if (!userInput.hasNextInt()) {
				input1 = userInput.next();
				System.out.printf(input1 + " is incorrect, enter an integer ");
			} 
			else {
				return input;
			}
		}
	}
}
