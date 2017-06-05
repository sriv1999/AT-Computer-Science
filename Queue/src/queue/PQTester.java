package queue;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester {
	private Queue<String> pQueue;

	public PQTester() {
		pQueue = new PriorityQueue <String> ();
	}

	public PQTester(String list) {
		pQueue = new PriorityQueue <String> ();
		setPQ(list);
	}

	public void setPQ(String list) {
		String [] input = list.split(" ");
		for (String e : input){
			pQueue.add(e);
		}
	}

	public Object getMin() {
		return pQueue.peek();
	}

	public String getNaturalOrder() {
		String output = "";
		while (!pQueue.isEmpty()){
			output += pQueue.remove() + " ";
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

	public static void main(String[] args) {
		PQTester one = new PQTester("one two three four five six seven");
		System.out.println("toString() " + one);
		System.out.println("getMin() - " + one.getMin());
		System.out.println("getNaturalOrder() - " + one.getNaturalOrder());
		System.out.println();
		
		PQTester two = new PQTester("1 2 3 4 5 one two three four five");
		System.out.println("toString() " + two);
		System.out.println("getMin() - " + two.getMin());
		System.out.println("getNaturalOrder() - " + two.getNaturalOrder());
		System.out.println();
		
		PQTester three = new PQTester("a p h j e f m c i d k l g n o b");
		System.out.println("toString() " + three);
		System.out.println("getMin() - " + three.getMin());
		System.out.println("getNaturalOrder() - " + three.getNaturalOrder());
	}
}