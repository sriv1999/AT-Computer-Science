package transplant;

public class Patient implements Comparable<Patient> {
	private String name;
	private int priority;

	public Patient(String s, int p) {
		name = s;
		priority = p;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Patient p) {
		if (this.getPriority() == p.getPriority())
			return 0;
		else if (this.getPriority() < p.getPriority())
			return -1;
		else
			return 1;
	}
	
	public String toString(){
		return name + " " + priority;
	}

}
