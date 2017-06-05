package stacks;

import java.util.Stack;
import static java.lang.System.*;

public class StackTest {
	private Stack<String> stack;

	public StackTest() {
		setStack("");
	}

	public StackTest(String line) {
		setStack(line);
	}

	public void setStack(String line) {
		stack = new Stack <String> ();
		String[] array = line.split(" "); 
		for (int i = 0; i < array.length; i++){
			stack.push(array[i]);
		}
	}

	public void popEmAll() {
		System.out.println("Popping all items from the stack");
		while (!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	public String toString(){
		return stack.toString();
	}

	public static void main(String[] args) {
		StackTest one = new StackTest("a b c d e f g h i");
		System.out.println(one);
		System.out.println();
		one.popEmAll();
		System.out.println();
		
		StackTest two = new StackTest("1 2 3 4 5 6 7 8 9 10");
		System.out.println(two);
		System.out.println();
		two.popEmAll();
		System.out.println();
		
		StackTest three = new StackTest("# $ % ^ & * ( ) ) _");
		System.out.println(three);
		System.out.println();
		three.popEmAll();
	}
}