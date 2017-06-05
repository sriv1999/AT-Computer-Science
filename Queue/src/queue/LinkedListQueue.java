package queue;

import java.util.LinkedList;

public class LinkedListQueue implements MyQueue {
	private LinkedList data;

	public LinkedListQueue() {
		data = new LinkedList();
	}

	@Override
	public boolean empty() {
		return data.size() == 0;
	}

	@Override
	public boolean offer(Object item) {
		data.addLast(item);
		return false;
	}

	@Override
	public Object poll() {
		if (empty())
			return null;
		return data.removeFirst();
	}

	@Override
	public Object peek() {
		return data.peekFirst();
	}
	
	public String toString(){
		String result = "[";
		for (Object e : data){
			result += e + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		return result;
	}

	@SuppressWarnings("unchecked")
	public void append(LinkedListQueue q) {
		for (Object e : q.data){
			data.addLast(e);
		}
	}
	
	public LinkedListQueue alternate(LinkedListQueue q) {
		LinkedListQueue temp = new LinkedListQueue ();
		while (!q.empty() && !this.empty()){
			temp.offer(q.poll());
			temp.offer(this.poll());
		}
		if (q.empty()){
			while (!this.empty()){
				temp.offer(this.poll());
			}
		}
		else{
			while (!q.empty()){
				temp.offer(q.poll());
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		LinkedListQueue queue = new LinkedListQueue();

		for (int k = 1; k <= 5; k++)
			queue.offer(new Integer(k));
		LinkedListQueue queue2 = new LinkedListQueue();

		for (int k = 11; k <= 15; k++)
			queue2.offer(new Integer(k));
		LinkedListQueue queue3 = new LinkedListQueue();

		for (int k = 21; k <= 27; k++)
			queue3.offer(new Integer(k));

		queue.append(queue3);
		System.out.println(queue);

		while (!(queue.empty())) {
			System.out.print(queue.poll() + "  ");
		}

		LinkedListQueue queue4 = queue3.alternate(queue2);

		System.out.println();
		System.out.println("Alternate");
		System.out.println(queue4);

		LinkedListQueue queue5 = queue3.alternate(queue2);

		System.out.println("Alternate");
		System.out.println(queue4);

	}

}
