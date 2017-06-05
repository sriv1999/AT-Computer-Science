package graphs;

import java.util.Map;
import java.util.TreeMap;

public class Graph {
	private TreeMap<String, String> map;
	private boolean yahOrNay;

	public Graph(String line) {
		map = new TreeMap<String, String> ();
		String[] input = line.split(" ");
		for (String e : input){
			map.put(e.charAt(0)+"", e.charAt(1)+"");
		}
	}

	public boolean contains(String letter) {
		return map.containsKey(letter);
	}

	public void check(String first, String second, String placesUsed) {
		if (map.get(first) == second){
			yahOrNay = true;
		}
		else{
			
		}
	}

	public String toString() {
		return "";
	}
}