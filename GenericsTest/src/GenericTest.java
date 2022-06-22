import java.util.LinkedList;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item<Integer, String> i = new Item<Integer,String> (5, "leo");
		
		LinkedList<Item<Integer,String>> l = new LinkedList<>();
		l.add(i);
		System.out.println(l.toString());
		
	}
}

class Item<T,U> {
	T x;
	T name;
	U age;
	
	Item(T name, U age) {
		this.name = name;
		this.age = age;
	}
	
	T getX(T x) {
		return x;
	}
	
	void setX(T x) {
	  this.x = x;
	}
	
	public String toString() {
		return this.name+ " "  + this.age;
	}
}
