package hashTable;

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTable {
	private LinkedList<Object>[] table;

	public HashTable() {
		table = new LinkedList[10];
	}

	public void add(Object obj) {
		Number n = new Number((int) obj);
		int i = n.hashCode();
		if (table[i] == null)
			table[i] = new LinkedList<Object>();
		table[i].add(n);
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < 10; i++) {
			System.out.print("bucket " + i + " ");
			if (table[i] == null) {
				System.out.print("null ");
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
		HashTable one = new HashTable();
		System.out.println("HASHTABLE");
		one.add(34);
		one.add(56);
		one.add(78);
		one.add(9);
		one.add(12);
		one.add(23);
		one.add(45);
		one.add(98);
		one.add(76);
		one.add(65);
		one.add(54);
		one.add(43);
		one.add(21);
		one.add(1);
		one.add(5);
		one.add(6);
		one.add(7);
		one.add(8);
		one.add(11);
		one.add(10);
		one.add(2);
		one.add(3);
		one.add(4);

		System.out.println(one);
	}
}