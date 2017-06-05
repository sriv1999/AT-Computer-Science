package queue;

public class Swimmer implements Comparable <Swimmer>{
	private int height;
	private int weight;
	private int age;

	public Swimmer() {
		height = 0;
		weight = 0;
		age = 0;
	}

	public Swimmer(int ht, int wt, int a) {
		height = ht;
		weight = wt;
		age = a;
	}

	public void setWeight(int wt) {
		weight = wt;
	}

	public void setHeight(int ht) {
		height = ht;
	}

	public void setAge(int a) {
		age = a;
	}

	public Object clone() {
		return this;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public int getAge() {
		return age;
	}

	public boolean equals(Object o) {
		return ((Swimmer) o).getAge() == getAge() && ((Swimmer) o).getHeight() == getHeight()
				&& ((Swimmer) o).getWeight() == getWeight();
	}

	public String toString() {
		return getHeight() + " " + getWeight() + " " + getAge();
	}

	@Override
	public int compareTo(Swimmer rhs) {
		if (getHeight() < rhs.getHeight())
			return -1;
		else if (getHeight() > rhs.getHeight())
			return 1;
		else {
			if (getWeight() < rhs.getWeight())
				return -1;
			else if (getWeight() > rhs.getWeight())
				return 1;
			else {
				if (getAge() < rhs.getAge())
					return -1;
				if (getAge() > rhs.getAge())
					return 1;
				else
					return 0;
			}
		}
	}

}
