package lb223qk_assign2;

public class QueueMain {

	public static void main(String[] args) {
		
		ClassQueue<String> list = new ClassQueue<String>();

		// add
		list.enqueue("Tjena");
		list.enqueue("123");
		list.enqueue("321");
		list.enqueue("OK");

		System.out.println("list size: " + list.size());

	    
        //Check the next element in the queue without removing. Prints B.
        System.out.println("check first element: " + list.first());
        
		// remove first element
        System.out.println("removed: " + list.dequeue());
        
        //Check the next element in the queue without removing. Prints B.
        System.out.println("check last element: " + list.last());
            
        // check updated size
        System.out.println("updated list size: " + list.size());
        
        // Why is this wrong? 
        //Iterating LinkedList
      //  Iterator<String> iterator=list.iterator();
        //while(iterator.hasNext()){
          //System.out.println(iterator.next());
      //  }
	}

}
