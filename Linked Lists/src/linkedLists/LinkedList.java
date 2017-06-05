package linkedLists;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList {

	public LinkedList() {
		first = null;
	}

	public Object getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public Object removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		Object element = first.data;
		first = first.next;
		return element;
	}

	public void addFirst(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}

	/*public ListIterator listIterator() {
		return new LinkedListIterator();
	}*/

	private Node first;

	private class Node {
		public Object data;
		public Node next;
	}

}
