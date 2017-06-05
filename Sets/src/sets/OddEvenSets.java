package sets;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets {
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets() {
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
	}

	public OddEvenSets(String line) {
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
		String [] input = line.split(" ");
		for (String e : input){
			int num = Integer.parseInt(e);
			if (num%2 == 1)
				odds.add(num);
			else
				evens.add(num);
		}
	}

	public String toString() {
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n";
	}

	public static void main(String args[]) throws IOException {
		OddEvenSets one = new OddEvenSets("1 5 9 4 6 8 12");
		System.out.println(one);
		
		OddEvenSets two = new OddEvenSets("3 5 7 17 29 4 6 56 72");
		System.out.println(two);
		
		OddEvenSets three = new OddEvenSets("3 6 12 2 28 6");
		System.out.println(three);
		
		OddEvenSets four = new OddEvenSets("4 4 4 4 4 4 4 4 ");
		System.out.println(four);
		
		OddEvenSets five = new OddEvenSets("1 1 1 1 1 1 1 1");
		System.out.println(five);
		
		OddEvenSets six = new OddEvenSets("1 2 3 4 5 6 7 8 9 ");
		System.out.println(six);

	}
}