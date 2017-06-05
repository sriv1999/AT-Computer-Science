package wrestlerJoe;

import java.util.HashSet;
import java.util.Set;

public class TeamSet {
	Set<Wrestler> team;
	
	public TeamSet(){
		team = new HashSet<Wrestler> ();
	}
	
	public void add(Wrestler other){
		team.add(other);
	}
	
	public void remove(Wrestler other){
		team.remove(other);
	}
	
	public double avgWeight(){
		double avg = 0;
		for (Wrestler e : team){
			avg += e.getWeight();
		}
		avg /= team.size();
		return avg;
	}
	
	public Set<Wrestler> setLight(){
		Set<Wrestler> light = new HashSet<Wrestler> ();
		for (Wrestler e : team){
			if (e.getWeight() < 120){
				light.add(e);
			}
		}
		return light;
	}
	
	public String toString(){
		String result = "";
		for (Wrestler e : team){
			result += e.toString() + ", ";
		}
		result = result.substring(0, result.length() - 2);
		return result;
	}

}
