package wrestlerJoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TeamMap {

	private Map<Wrestler, Integer> tMap;

	public TeamMap() {
		tMap = new HashMap<Wrestler, Integer>();
	}

	public void add(Wrestler w) {
		int team = w.getWeight() / 10 % 10;
		tMap.put(w, team);
	}

	public void changeWeightGroup(Wrestler w, int newWeightGroup) {
		if (tMap.containsKey(w)) {
			tMap.remove(w);
			tMap.put(w, newWeightGroup);
		}
	}

	public int get(Wrestler w) {
		if (tMap.containsKey(w)) {
			return tMap.get(w);
		}
		return -1;
	}

	public String toString() {
		String result = "";
		for (Wrestler i : tMap.keySet()) {
			result += i + " --> Weight Group " + tMap.get(i).toString() + "\n";
		}
		return result;
	}

	public static void main(String[] args) {

		TeamMap a = new TeamMap();
		a.add(new Wrestler("Bob", 157));
		a.add(new Wrestler("Fred", 129));
		a.add(new Wrestler("Jake", 100));
		a.add(new Wrestler("Arnold", 199));
		a.add(new Wrestler("Stan", 120));

		Wrestler juan = new Wrestler("Juan", 180);
		a.add(juan);

		System.out.println(a);

		a.changeWeightGroup(juan, 10);
		System.out.println("Juan is in Weight Group " + a.get(juan));
		System.out.println();

		System.out.println(a);
	}

}
