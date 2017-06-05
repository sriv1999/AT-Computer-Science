package stacks;

import java.util.Iterator;
import java.util.Stack;

public class PEMDAS {

	public static double simplify(String s) {
		Stack <Double> numbers = new Stack <Double> ();
		Stack <String> operations = new Stack <String> ();
		boolean check = false;
		String result = "";
		int endCount = 0;

		for (int i = 0; i < s.length(); i++) {
			String curr = s.charAt(i) + "";
			if (curr.equals("("))
				check = true;
			if (!check) {
				if ("+-/*^".indexOf(curr) != -1) {
					if ("+-".indexOf(curr) != -1)
						compute(numbers, operations);
					operations.push(curr);
				} 
				else {
					curr = (i > 0 && "+-/*^".indexOf(s.charAt(i - 1)) == -1)
							? numbers.pop().intValue() + "" + curr : curr;
					numbers.push(Double.parseDouble(curr));
				}
			} 
			else {
				result += curr;
				if (curr.equals(")"))
					endCount--;
				else if (curr.equals("("))
					endCount++;
				
				if (endCount == 0) {
					check = false;
					numbers.push(simplify(result.substring(1, result.length() - 1)));
					result = "";
				}
			}
		}
		compute(numbers, operations);
		return numbers.pop();
	}

	public static void compute(Stack<Double> numbers, Stack<String> operations) {
		int operCount = operations.size();
		for (int i = 0; i < operCount; i++) {
			if (numbers.size() > 1) {
				double num = numbers.pop();
				String oper = operations.pop();
				double nextNum = numbers.pop();
				switch (oper) {
				case "+":
					numbers.push(nextNum + num);
					break;
				case "-":
					numbers.push(nextNum - num);
					break;
				case "*":
					numbers.push(nextNum * num);
					break;
				case "/":
					numbers.push(nextNum / num);
					break;
				case "^":
					numbers.push(Math.pow(nextNum, num));
					break;
				}
			} 
			else
				return;
		}
	}

	public static void main(String[] args) {
		System.out.println("4 + 2 x 3 - 8 = " + simplify("4+2*3-8"));
		System.out.println("8 / 2 + 3 x 5 = " + simplify("8/2+3*5"));
		System.out.println("50 / 10 + 2 x 10 = " + simplify("50/10+2*10"));
		System.out.println("3 x (2 + 1) - 3 = " + simplify("3*(2+1)-3"));
	}
}