package queue;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class SwimmerPQ {
	private Queue<Swimmer> pQueue;

	public SwimmerPQ() {
		pQueue = new PriorityQueue <Swimmer> ();
	}

	public void add(Swimmer obj) {
		pQueue.add(obj);
	}

	public Object getMin() {
		Swimmer min = pQueue.peek();
		for (Swimmer e : pQueue){
			if (e.compareTo((Swimmer) min) < 0)
				min = e;
		}
		return min;
	}

	public Object removeMin() {
		return pQueue.poll();
	}

	public String getNaturalOrder() {
		String output = "";
		while (!pQueue.isEmpty()){
			output += pQueue.remove() + ", ";
		}
		return output;
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
}