package recursion;
import java.util.*;
import static java.lang.System.*;

public class PermuRunner {
   public static void main( String args[] ) {
	    Permutation one = new Permutation("abc");
	    one.permutation();
	    System.out.println(one);
	    
	    Permutation two = new Permutation("ABC");
	    two.permutation();
	    System.out.println(two);
	    
	    Permutation three = new Permutation("toad");
	    three.permutation();
	    System.out.println(three);
	    
	    Permutation four = new Permutation("me");
	    four.permutation();
	    System.out.println(four);
	}
}