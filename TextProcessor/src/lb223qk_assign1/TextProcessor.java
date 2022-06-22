/*
 * A program which changes the a character to the next one in the alphabet. If character
 * is aeiou, make capitalized.
 */
package lb223qk_assign1;

public class TextProcessor {
	public static void main(String[] args) {
		LetterChange letterChanges = new LetterChange();
		letterChanges.print();
	}
}

// make the letter changes
class LetterChange {

	/**
	 * loop through the letters and return the new letters/words
	 * @param str
	 * @return
	 */
	public static String changeLetters(String str) {
		char[] letters = str.toCharArray();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < letters.length; i++)
			sb.append(getNextChar(letters[i]));

		return sb.toString();
	}

	/**
	 * if the word is between 64-122 in the ascii table (the amount of letters that
	 * are in there) return the word, if its equal to 122(Z), return a capitalized
	 * A. increment each character by 1, being the next letter in the alphabet.
	 * 
	 * @param word
	 * @return
	 */
	private static char getNextChar(char word) {

		if (word < 64 || word > 122)
			return word;

		else if (word == 122)
			return 'A';
		else
			return capitalize((char) (word + 1));
	}

	/**
	 * make aeiou (vowels) capitalized and return the word
	 * 
	 * @param word
	 * @return
	 */
	private static char capitalize(char word) {
		if (word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u')
			return Character.toUpperCase(word);
		else
			return word;
	}

	/**
	 * print out
	 */
	public void print() {

		System.out.println(LetterChange.changeLetters(("Hi! I’m Nadeem, 38 years old.")));

	}
}
