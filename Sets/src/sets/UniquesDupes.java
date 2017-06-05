package sets;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes {
	public static Set<String> getUniques(String input) {
		String [] in = input.split(" ");
		Set<String> uniques = new TreeSet<String>(Arrays.asList(in));
		return uniques;
	}

	public static Set<String> getDupes(String input) {
		String [] in = input.split(" ");
		Set<String> uniques = new TreeSet<String>();
		Set<String> dupe = new TreeSet<String>();
		
		for (String e : in){
			if (!uniques.add(e)){
				dupe.add(e);
			}
		}
		return dupe;
	}
	
	public static void main(String args[]) {
		String one = "a b c d e f g h a b c d e f g h i j k";
		System.out.println("Original List: " + one);
		System.out.println(getUniques(one));
		System.out.println(getDupes(one));
		System.out.println();
		
		String two = "one two three one two three six seven one two";
		System.out.println("Original List: " + two);
		System.out.println(getUniques(two));
		System.out.println(getDupes(two));
		System.out.println();
		
		String three = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
		System.out.println("Original List: " + three);
		System.out.println(getUniques(three));
		System.out.println(getDupes(three));
	}
}