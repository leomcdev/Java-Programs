package lb223qk_assign2;

import java.util.Iterator;

public interface Queue<E> extends Iterable<E> {

	int size(); // current queue size

	boolean isEmpty(); // true if queue is empty

	void enqueue(E element); // add element at end of queue

	E dequeue(); // return and remove first element.

	E first(); // return (without removing) first element

	E last(); // return (without removing) last element

}

class ClassQueue<E> implements Queue<E> {

	int size;
	Node<E> first;
	//item at the end of the queue
	Node<E> tail;

	private class Node<E> {

		E element;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	public Iterator<E> iterator() {
		return null;
	}

	// get size
	public int size() {
		return size;
	}

	// if empty
	public boolean isEmpty() {

		return first == null;
	}

	// adds the element in the end of the queue
	public void enqueue(E element) {
		/*
		 * if first element is null create a new node with and give it last nodes value.
		 * now the new node is the last node. else the same as before, last node is the
		 * front node.
		 */
		if (tail != null) {
			tail.next = new Node<E>(element, null);
			tail = tail.next;
		} else {
			tail = new Node<E>(element, null);
			first = tail;
		}
		size++;
	}

	// removes element from the queue, from the front, first in first out
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Empty Queue");
		}

		/*
		 * gets the value from first element into new element, set first element
		 * to next element with next.
		 *  count = -1 element in the array count
		 */
		E element = first.element;
		first = first.next;
		size--;

		// element deleted if first element is null and last element is null
		if (first == null) {
			tail = null;
		}
		return element;
	}

	// return first element without removing
	public E first() {
		if (isEmpty()) {
			throw new IllegalStateException("Empty Queue");
		}
		return first.element;
	}

	// return last element without removing
	public E last() {
		if (isEmpty()) {
			throw new IllegalStateException("Empty Queue");
		}
		return tail.element;
	}
	
}