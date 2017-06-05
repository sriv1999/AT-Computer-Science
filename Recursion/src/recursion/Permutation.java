package recursion;

import java.util.*;
import static java.lang.System.*;

public class Permutation {
	private String orig;
	private String list;

	public Permutation(String word) {
		orig = word;
		list = "";
	}

	public void permutation() {
		out.println("\nPERMUTATION OF WORD :: " + orig);
		permutation(orig, "");
	}

	private void permutation(String orig, String sent) {
		if (orig.length() == sent.length()){
			list += " "+sent;
		}
		else{
			for (int i = 0; i < orig.length(); i++){
				if (sent.indexOf(orig.charAt(i)) == -1){
					permutation(orig, sent + orig.charAt(i));
				}
			}
		}
	}

	public String toString() {
		return list;
	}
}