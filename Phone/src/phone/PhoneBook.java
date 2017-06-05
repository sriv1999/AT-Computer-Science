package phone;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class PhoneBook {
	private LinkedList<PhoneEntry>[] book;

	public PhoneBook() {
		book = new LinkedList[100];
		for (int i = 0; i < 100; i++) {
			book[i] = new LinkedList<PhoneEntry>();
		}
	}

	public PhoneBook(int numSlots) {
		book = new LinkedList[numSlots];
		for (int i = 0; i < numSlots; i++) {
			book[i] = new LinkedList<PhoneEntry>();
		}
	}

	public void add(Object obj) {
		int index = obj.hashCode() % book.length;
		boolean duplicate = false;

		for (PhoneEntry e : book[index]) {
			if (e.equals((PhoneEntry) obj))
				duplicate = true;
		}
		if (!duplicate)
			book[index].add((PhoneEntry) obj);
	}

	public int getCapacity() {
		return book.length;
	}

	public int getSize() {
		int count = 0;
		for (int i = 0; i < book.length; i++) {
			count += book[i].size();
		}
		return count;
	}

	public int getNumberOfNulls() {
		int count = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].size() == 0)
				count++;
		}
		return count;
	}

	public int getLongestList() {
		int max = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].size() > max) {
				max = book[i].size();
			}
		}
		return max;
	}

	public String lookup(String lookfor) {
		for (int i = 0; i < book.length; i++) {
			for (PhoneEntry e : book[i]) {
				if (e.getName().equalsIgnoreCase(lookfor))
					return e.getNumber();
			}
		}
		return null;
	}

	public void load() throws IOException {
		File file = new File("H:\\Files-AT\\phone.txt");
		Scanner in = new Scanner(file);

		while (in.hasNext()) {
			add(new PhoneEntry(in.next(), in.next()));
		}
		in.close();
	}

	public void display() {
		System.out.println("Name\t\t" + "Bucket\t\t" + "Number");
		System.out.println("----------------------------------------------");
		for (int i = 0; i < book.length; i++) {
			for (PhoneEntry e : book[i])
				System.out.println(e.getName() + "\t\t" + i + "\t\t" + e.getNumber());
		}
	}

	public boolean changeNumber(String lookfor, String newNumb) {
		for (int i = 0; i < book.length; i++) {
			for (PhoneEntry e : book[i]) {
				if (e.getName().equalsIgnoreCase(lookfor)) {
					book[i].remove(e);
					book[i].add(new PhoneEntry(lookfor, newNumb));
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		PhoneBook b = new PhoneBook();
		b.load();
		b.display();

		b.changeNumber("Price", "1111111");
		PhoneEntry h = new PhoneEntry("SantaClaus", "7165100");
		b.add(h);
		b.display();
		System.out.println();
		System.out.println("Capacity: " + b.getCapacity() + "\nSize: " + b.getSize() + "\nLongest list length: "
				+ b.getLongestList() + "\nNull entries: " + b.getNumberOfNulls());
	}
}
