package stacks;

import java.util.Iterator;
import java.util.Stack;

public class StackMethods {

	public static double getAverage(Stack<Integer> one) {
		double sum = 0.0;
		for (Integer e : one) {
			sum += e;
		}
		return sum / one.size();
	}

	public static Stack<String> alternateStack(Stack<String> one, Stack<String> two) {
		// Good Question: For alternating stacks, are they the same size??…Do
		// they have to be???
		Stack<String> temp = new Stack<String>();
		Iterator<String> iter = one.iterator();
		Iterator<String> iter2 = two.iterator();
		while (iter.hasNext() && iter2.hasNext()) {
			temp.push(iter.next());
			temp.push(iter2.next());
		}
		return temp;
	}

	public static Stack<String> removeEveryOther(Stack<String> one) {
		// Removes every other element in the stack – but the order of others
		// shouldn’t change.
		Iterator<String> iter = one.iterator();
		Stack<String> temp = new Stack<String>();
		while (iter.hasNext()) {
			temp.push(iter.next());
			if (iter.hasNext())
				iter.next();
		}
		return temp;
	}

	public static void display(Stack<String> one) {
		// We want to print in the order that it comes off the stack
		while (!one.isEmpty())
			System.out.println(one.pop());
	}

	public static void main(String[] args) {
		Stack<Integer> a = new Stack<Integer>();
		a.push(5);
		a.push(2);
		a.push(7);

		Stack<String> b = new Stack<String>();
		b.push("one");
		b.push("two");
		
		Stack<String> c = new Stack<String>();
		c.push("three");
		c.push("four");
		c.push("five");
		
		display(alternateStack(b, c));
		System.out.println();
		
		Stack<String> d = new Stack<String>();
		d.push("six");
		d.push("seven");
		d.push("eight");
		d.push("nine");
		d.push("ten");
		display(removeEveryOther(d));
	}
}