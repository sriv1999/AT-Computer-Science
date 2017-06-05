package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Scanner;

public class PartList {
	private Map<Part, Integer> partsTable;

	public PartList(File fileName) throws FileNotFoundException {
		partsTable = new TreeMap<Part, Integer>();
		Scanner add = new Scanner(fileName);
		while (add.hasNext())
			putEntry(add.nextLine());
		add.close();
	}

	private void putEntry(String line) {
		Part temp = new Part(line.trim());
		if (partsTable.containsKey(temp))
			partsTable.put(temp, partsTable.get(temp) + 1);
		else
			partsTable.put(temp, 1);
	}

	public String toString() {
		String out = "";
		for (Entry<Part, Integer> temp : partsTable.entrySet())
			out += temp.getKey() + " - " + temp.getValue() + "\n";
		return out;

	}

	public static void main(String[] args) throws IOException {
		PartList prog = new PartList(new File("H:\\partinfo.dat"));
		System.out.println(prog);
	}
}