package wrestlerJoe;

public class Wrestler {
	private String name;
	private int weight;
	/**
	 * Constructor for objects of class Wrestler
	 */
	public Wrestler(String theName, int theWeight)

	{
		name = theName;
		weight = theWeight;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {

		return name;
	}

	public String toString() {

		return name + "  " + weight;
	}
}
