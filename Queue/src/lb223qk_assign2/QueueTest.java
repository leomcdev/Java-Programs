package lb223qk_assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

	private static int testCount = 0;

	@BeforeEach
	public void setUp() {
		// Executed before each test method
		System.out.println("Going to run test" + ++testCount);
	}

	@AfterEach
	public void tearDown() {
		// Executed after each test method
		System.out.println(" -- Done with test" + testCount);
	}

	@Test
	void testSize() {
		String s = "yes";
		ClassQueue<String> list = new ClassQueue<String>();
		list.enqueue(s);
		// check if list is 1 and its not empty
		assertEquals(1, list.size());
		assertTrue(!list.isEmpty());

		// integer extreme test using enqueue
		ClassQueue<Integer> list3 = new ClassQueue<Integer>();
		for (int i = 0; i < 100; i++) {
			list3.enqueue(i);
		}
		assertEquals(100, list3.size());
	}

	@Test
	void testIsEmpty() {

		String s = "yes";
		ClassQueue<String> list = new ClassQueue<String>();
		list.enqueue(s);
		// check if list is 1 and its not empty
		assertEquals(1, list.size());
		assertTrue(!list.isEmpty());

		// check if empty
		ClassQueue<String> list2 = new ClassQueue<String>();
		assertTrue(list2.isEmpty());
		assertFalse(!list2.isEmpty());

	}

	@Test
	void testEnqeue() {
		String s = "yes";
		String s1 = "no";
		String s2 = "141";
		String s3 = "12421";
		String s4 = "nhh";
		String s5 = "pkpk";
		String s6 = "pwpw";
		String s7 = "nbnb";

		ClassQueue<String> list = new ClassQueue<String>();
		list.enqueue(s);
		list.enqueue(s1);
		list.enqueue(s2);
		list.enqueue(s3);
		list.enqueue(s4);
		list.enqueue(s5);
		list.enqueue(s6);
		list.enqueue(s7);

		// check so first list isnt empty
		assertFalse(list.isEmpty());

		// check correct size
		assertEquals(8, list.size());

		// if list is empty
		ClassQueue<String> list2 = new ClassQueue<String>();
		assertTrue(list2.isEmpty());
		assertEquals(0, list2.size());

		// integer extreme test
		ClassQueue<Integer> list3 = new ClassQueue<Integer>();
		for (int i = 0; i < 100; i++) {
			list3.enqueue(i);
		}
	}

	@Test
	void testdequeue() {
		String s = "yes";
		String s1 = "no";
		String s2 = "141";
		String s3 = "12421";
		String s4 = "nhh";
		String s5 = "pkpk";
		String s6 = "pwpw";
		String s7 = "nbnb";

		ClassQueue<String> list = new ClassQueue<String>();
		list.enqueue(s);
		list.enqueue(s1);
		list.enqueue(s2);
		list.enqueue(s3);
		list.enqueue(s4);
		list.enqueue(s5);
		list.enqueue(s6);
		list.enqueue(s7);

		list.dequeue();

		// first string is now
		System.out.println(list.toString());
		// check correct size, correct since we dequeued/removed first string
		assertEquals(7, list.size());

		// check so first list isnt empty
		assertFalse(list.isEmpty());

		// integer extreme test first add
		ClassQueue<Integer> list3 = new ClassQueue<Integer>();
		for (int i = 0; i < 100; i++) {
			list3.enqueue(i);
			// for clarity that enqueue worked, decomment
			// System.out.println((i));
		}

		// integer extreme test dequeue elements from list
		for (int i = 0; i < 100; i++) {
			list3.dequeue();
		}
		// true if dequeued worked else false
		assertTrue(list3.isEmpty());

		// extreme case if the list is empty

		ClassQueue<Integer> list4 = new ClassQueue<Integer>();
		boolean res = false;
		try {
			list4.dequeue();
		} catch (IllegalStateException e) {
			res = true;
		}
		assertTrue(res);

		// need proper toString method?
		// for (String cq : list) {
		// System.out.println(cq);

		// }

	}

	@Test
	void testFirst() {
		String s = "yes";
		String s1 = "no";

		ClassQueue<String> list = new ClassQueue<String>();
		list.enqueue(s);
		list.enqueue(s1);

		// test interior if first element in list is s
		assertEquals(s, list.first());

		ClassQueue<String> list2 = new ClassQueue<String>();
		/*
		 * extreme case if the list is empty
		 */
		boolean res = false;
		try {
			list2.first();
		} catch (IllegalStateException e) {
			res = true;
		}
		assertTrue(res);
	}

	@Test
	void testLast() {
		String s = "yes";
		String s1 = "no";

		ClassQueue<String> list = new ClassQueue<String>();
		list.enqueue(s);
		list.enqueue(s1);

		// test interior if last element in list is s1
		assertEquals(s1, list.last());

		/*
		 * extreme case if the list is empty
		 */
		ClassQueue<Integer> list4 = new ClassQueue<Integer>();
		boolean res = false;
		try {
			list4.last();
		} catch (IllegalStateException e) {
			res = true;
		}
		assertTrue(res);

	}
}
