package hashTable;

public class Number {
	private int theValue;

	public Number(int value) {
		theValue = value;
	}

	public int getValue() {
		return theValue;
	}

	public boolean equals(Object obj) {
		return ((int) obj == theValue);
	}

	public int hashCode() {
		return theValue%10;
	}

	public String toString() {
		return theValue + "";
	}

	public static void main(String[] args) {
		Number one = new Number(45);
		System.out.println(one.hashCode());

		Number two = new Number(107);
		System.out.println(two.hashCode());

		Number three = new Number(213);
		System.out.println(three.hashCode());
	}
}