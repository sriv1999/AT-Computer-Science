package phone;

public class PhoneEntry {
	private String name;
	private String number;
	
	public PhoneEntry(String na, String nu){
		name = na;
		number = nu;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}
	
	public String toString() {
		return name + " " + number;
	}
	
	public boolean equals(PhoneEntry other){
		return (this.getName().equalsIgnoreCase(other.getName()) && this.getNumber() == other.getNumber());
	}
	
	public int compareTo(PhoneEntry other){
		if (this.getName().compareTo(other.getName()) < 0)
			return -1;
		else if (this.getName().compareTo(other.getName()) > 0)
			return 1;
		else{
			if (this.getNumber().compareTo(other.getNumber()) < 0)
				return -1;
			else if (this.getNumber().compareTo(other.getNumber()) > 0)
				return 1;
			return 0;
		}
	}

}
