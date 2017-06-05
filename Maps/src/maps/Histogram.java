package maps;

import java.util.Map;
import java.util.TreeMap;
import static java.lang.System.*;

public class Histogram {
	private Map<String, Integer> histogram;

	public Histogram() {
		histogram = new TreeMap<String, Integer>();
	}

	public Histogram(String sent) {
		histogram = new TreeMap<String, Integer>();
		setSentence(sent);
	}

	public void setSentence(String sent) {
		String [] input = sent.split(" ");
		for (String e : input){
			if (histogram.get(e) == null)
				histogram.put(e, 0);
			histogram.put(e, histogram.get(e) + 1);
		}
	}

	public String toString() {
		String output = "";
		String allStars = "";
		output += "char\t1---5----01---5\n";
		for (String e : histogram.keySet()){
			for (int i = 0; i < histogram.get(e); i++){
				allStars += "*";
			}
			output += e + "\t" + allStars + "\n";
			allStars = "";
		}
		
		return output + "\n\n";
	}

	public static void main(String args[]) {
		Histogram test = new Histogram("a b c d e f g h i a c d e g h i h k");
		out.println(test);

		Histogram test2 = new Histogram("1 2 3 4 5 6 1 2 3 4 5 1 3 1 2 3 4");
		out.println(test2);

		Histogram test3 = new Histogram("Y U I O Q W E R T Y");
		out.println(test3);

		Histogram test4 = new Histogram("4 T # @ ^ # # #");
		out.println(test4);
	}
}