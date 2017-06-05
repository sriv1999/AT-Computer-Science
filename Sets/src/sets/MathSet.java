package sets;

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;

public class MathSet {
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet() {
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
	}

	public MathSet(String o, String t) {
		String[] inO = o.split(" ");
		String[] inT = t.split(" ");

		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();

		for (String e : inO)
			one.add(Integer.parseInt(e));

		for (String f : inT)
			two.add(Integer.parseInt(f));
	}

	public Set<Integer> union() {
		Set<Integer> union = new TreeSet<Integer>();
		for (int e : one)
			union.add(e);
		for (int f : two)
			union.add(f);
		return union;
	}

	public Set<Integer> intersection() {
		Set<Integer> uniques = new TreeSet<Integer>();
		for (int i : one)
			uniques.add(i);
		Set<Integer> dupe = new TreeSet<Integer>();
		
		for (int f : two){
			if (!uniques.add(f)){
				dupe.add(f);
			}
		}
		return dupe;
	}

	public Set<Integer> differenceAMinusB() {
		Set<Integer> data = new TreeSet<Integer>();
		for (int i : one)
			data.add(i);
		for (int f : two){
			if (data.contains(f)){
				data.remove(f);
			}
		}
		return data;
	}

	public Set<Integer> differenceBMinusA() {
		Set<Integer> data2 = new TreeSet<Integer>();
		for (int j : two)
			data2.add(j);
		for (int e : one){
			if (data2.contains(e)){
				data2.remove(e);
			}
		}
		return data2;
	}

	public Set<Integer> symmetricDifference() {
		Set<Integer> dataOne = new TreeSet<Integer>();
		Set<Integer> dataTwo = new TreeSet<Integer>();
		Set<Integer> intersection = new TreeSet<Integer>();
		Set<Integer> result = new TreeSet<Integer>();
		
		for (int i : one)
			dataOne.add(i);
		for (int j : two)
			dataTwo.add(j);
		for (int k : intersection())
			intersection.add(k);
		
		for (int e : dataOne){
			for (int f : dataTwo){
				if (!intersection.contains(f))
					result.add(f);
			}
			if (!intersection.contains(e))
				result.add(e);
		}
		return result;
	}

	public String toString() {
		return "Set one " + one + "\n" + "Set two " + two + "\n";
	}
	
	public static void main(String[] args){
		MathSet one = new MathSet("1 2 3 4 5", "4 5 6 7 8");
		System.out.println(one);
		System.out.println("Union - " + one.union());
		System.out.println("Intersection - " + one.intersection());
		System.out.println("Difference A-B - " + one.differenceAMinusB());
		System.out.println("Difference B-A - " + one.differenceBMinusA());
		System.out.println("Symmetric Difference - " + one.symmetricDifference());
		System.out.println("---------------------------------------");
		System.out.println();
		
		MathSet two = new MathSet("10 11 12 13 14 15 16 17", "11 13 15 17 19 21 23");
		System.out.println(two);
		System.out.println("Union - " + two.union());
		System.out.println("Intersection - " + two.intersection());
		System.out.println("Difference A-B - " + two.differenceAMinusB());
		System.out.println("Difference B-A - " + two.differenceBMinusA());
		System.out.println("Symmetric Difference - " + two.symmetricDifference());
		System.out.println("---------------------------------------");
		System.out.println();
		
		MathSet three = new MathSet("4 5 5 6 76 7 7 8 8 8 8 8", "23 3 4 3 5 3 53 5 46 46 4 6 5 3 4");
		System.out.println(three);
		System.out.println("Union - " + three.union());
		System.out.println("Intersection - " + three.intersection());
		System.out.println("Difference A-B - " + three.differenceAMinusB());
		System.out.println("Difference B-A - " + three.differenceBMinusA());
		System.out.println("Symmetric Difference - " + three.symmetricDifference());
	
	}
}