package hashTable;

public class Word {
	private String theValue;

	public Word(String w) {
		theValue = w;
	}

	public String getValue() {
		return theValue;
	}

	public boolean equals(Word other) {
		return this.getValue().equalsIgnoreCase(other.getValue());
	}

	public int hashCode() {
		String[] word = theValue.split("");
		String vowels = "aeiou";
		int v = 0;
		int letters = theValue.length();

		for (String s : word) {
			if (vowels.contains(s))
				v++;
		}
		return (v * letters) % 10;
	}

	public String toString() {
		return theValue;
	}

	public static void main(String[] args) {
		Word one = new Word("45alligator");
		System.out.println(one.hashCode()); // should out 4

		Word two = new Word("cat");
		System.out.println(two.hashCode()); // should out 3

		Word three = new Word("whootit");
		System.out.println(three.hashCode()); // should out 1
	}

}
