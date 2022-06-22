package lb223qk_assign2;

// call and test on word class
public class TestWord {

	public static void main(String[] args) {
		
		Word w3 = new Word("nej");
		Word w4 = new Word("NEJ");

	    System.out.println(w3.hashCode());
	    System.out.println(w4.hashCode());

	    System.out.println(w3.equals(w4));
	    System.out.println(w3.compareTo(w4));

	}

}
