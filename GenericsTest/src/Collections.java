import java.util.HashMap;
import java.util.Set;

public class Collections {
	public static void main(String args[]) {
		
		HashMap <String,Integer> h = new HashMap<String,Integer>();
		
		h.put("Sally", 5);
		h.put("Mappe", 2);

		Set <String> keys = h.keySet();
		
		// prints out all the keys 
		for(String key : keys) {
			System.out.println(key);
			// gets the key integer
			System.out.println(h.get(key));
		}
	}

}
