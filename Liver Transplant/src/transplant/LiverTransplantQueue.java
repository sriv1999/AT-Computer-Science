package transplant;

import java.util.PriorityQueue;
import java.util.Queue;

public class LiverTransplantQueue implements PQueue {
	private Queue<Patient> pQueue;

	public LiverTransplantQueue() {
		pQueue = new PriorityQueue<Patient>();
	}

	@Override
	public boolean isEmpty() {
		return pQueue.size() == 1;
	}

	@Override
	public void add(Object x) {
		pQueue.add((Patient) x);
	}

	@Override
	public Object poll() {
		return pQueue.remove().toString();
	}

	@Override
	public Object peek() {
		return pQueue.peek().toString();
	}

	@Override
	public int size() {
		return pQueue.size();
	}
	
	public String toString() {
		String result = "[";
		for (Object e : pQueue){
			result += e + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		return result;
	}

	public static void main(String[] args) {
		LiverTransplantQueue pq = new LiverTransplantQueue();
		pq.add(new Patient("Smith", 3));
		pq.add(new Patient("Jones", 3));
		pq.add(new Patient("Wong", 3));
		pq.add(new Patient("Gupta", 2));
		pq.add(new Patient("Chen", 2));
		pq.add(new Patient("Garcia", 1));
		pq.add(new Patient("Brown", 3));
		System.out.println("The list is");
		System.out.println(pq);
		System.out.println();
		while (pq.size() > 0) {
			System.out.println("The next patient for the liver transplant is");
			System.out.println(pq.poll());
			System.out.println();
		}
	}

}
