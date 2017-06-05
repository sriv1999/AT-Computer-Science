package maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Acronyms {
	private Map<String, String> acronymTable;

	public Acronyms() {
		acronymTable = new TreeMap<String, String>();
	}

	public void putEntry(String entry) {
		String[] split = entry.split(" - ");
		acronymTable.put(split[0], split[1]);
	}

	public String convert(String sent) {
		Scanner chop = new Scanner(sent);
		String result = "";
		while (chop.hasNext()) {
			String temp = chop.next();
			if (acronymTable.get(temp) == null)
				result += temp + " ";
			else
				result += acronymTable.get(temp) + " ";
		}
		chop.close();
		return result;
	}

	public String toString() {
		return acronymTable.toString().replaceAll("\\,", "\n");
	}

	public static void main(String[] args) {
		Acronyms one = new Acronyms();
		one.putEntry("TSO - Texas State Optical");
		one.putEntry("PDA - Personal Display of Affection");
		one.putEntry("RBI - Runs Batted In");
		one.putEntry("SO - Strike Out");
		one.putEntry("FG - Field Goal");
		one.putEntry("CPU - Central Processing Unit");
		one.putEntry("HD - Hard Drive");
		one.putEntry("PU - Pick Up");
		System.out.println(one);

		System.out.println();
		System.out.println(one.convert(
				"I drove my PU to TSO to get a HD . " + "My CPU has a virus. I sometimes SO when trying to kick a FG . "
						+ "I had 2 RBI at the game. I saw 2 PDA infractions in the hall."));
	}
}