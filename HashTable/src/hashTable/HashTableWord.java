package hashTable;

import java.util.LinkedList;

public class HashTableWord {
	private LinkedList<Object>[] table;

	public HashTableWord() {
		table = new LinkedList[10];
	}

	public void add(Object obj) {
		Word w = new Word((String) obj);
		int i = w.hashCode();
		if (table[i] == null)
			table[i] = new LinkedList<Object>();
		table[i].add(w);
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < 10; i++) {
			System.out.print("bucket " + i + " ");
			if (table[i] == null) {
				System.out.print(" ");
				System.out.println();
			} else {
				for (Object e : table[i]) {
					System.out.print(e + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		return output;
	}

	public static void main(String[] args) {
		HashTableWord one = new HashTableWord();
		System.out.println("HASHTABLE");
		one.add("one");
		one.add("two");
		one.add("dog");
		one.add("cat");
		one.add("chicken");
		one.add("pig");
		one.add("owl");
		one.add("jump");
		one.add("run");
		one.add("hop");
		one.add("shortcut");
		one.add("ferret");
		one.add("goat");
		one.add("hootowl");
		one.add("go");
		one.add("alligator");
		one.add("onimonapia");
		one.add("food");
		one.add("a");
		System.out.println(one);
	}

}
