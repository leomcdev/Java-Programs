package lb223qk_assign2;

// compare words if theyre equal using hashcode and overriding equals,compareto
public class Word implements Comparable<Word> {
	private String word;

	public Word(String str) {
		this.word = str;
	}

	public String toString() {
		return word;
	}

	@Override
	public int hashCode() {
		return word.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj instanceof Word) {
			Word w = (Word) obj;
			return this.toString().equalsIgnoreCase(w.toString());
		}
		return false;
	}	

	// compares two words lexograpichally
	public int compareTo(Word w) {

		return this.toString().toLowerCase().compareTo(w.toString().toLowerCase());
	}
}
