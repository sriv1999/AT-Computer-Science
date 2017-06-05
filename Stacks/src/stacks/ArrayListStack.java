package stacks;
import java.util.ArrayList;

public class ArrayListStack implements MyStack{
	ArrayList <Object> stack;

	public ArrayListStack(){
		stack = new ArrayList <Object> ();
	}
	
	@Override
	public Object push(Object item) {
		stack.add(item);
		return item;
	}

	@Override
	public Object pop() {
		Object temp = stack.get(stack.size() - 1); 
		stack.remove(stack.size() - 1);
		return temp;
	}

	@Override
	public Object peek() {
		return stack.get(stack.size()-1);
	}

	@Override
	public boolean isEmpty() {
		return stack.size() == 0;
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public int search(Object a) {
		if (stack.indexOf(a) == -1){
			return stack.indexOf(a);
		}
		return stack.size() - stack.indexOf(a);
	}
	
	@Override
	public String toString() {
		String result = "[";
		for (Object e : stack){
			result += e + ", ";
		}
		result = result.substring(0, result.length()-2);
		result += "]";
		return result;
	}

}
