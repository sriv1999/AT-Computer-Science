package stacks;

public class MyStackTester {

	static void arrayListStack() {

		ArrayListStack tc = new ArrayListStack();

		System.out.println(tc.push("quarter"));
		System.out.println(tc.push("dime"));
		System.out.println(tc.push("nickel"));
		System.out.println(tc.push("penny"));
		System.out.println();

		System.out.println("toString() " + tc);
		System.out.println();

		System.out.println("peek() " + tc.peek());
		System.out.println();

		System.out.println("Search for Dime " + tc.search("dime"));
		System.out.println();

		System.out.println("Search for Euro " + tc.search("euro"));
		System.out.println();

		System.out.println("Size " + tc.size());
		System.out.println();

		System.out.println("pop() and isEmpty()");

		while (!tc.isEmpty())
			System.out.println(tc.pop());
	}

	public static void main(String[] args) {
		arrayListStack();
	}
}
