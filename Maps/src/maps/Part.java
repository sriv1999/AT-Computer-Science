package maps;

public class Part implements Comparable<Part> {
	private String make, model, rest = "";
	private int year;

	public Part(String line) {
		String[] list = line.split(" ");
		year = Integer.parseInt(list[list.length - 1]);
		model = list[list.length - 2];
		make = list[list.length - 3];
		for (int i = 0; i < list.length - 3; i++)
			rest += list[i] + " ";
		rest.trim();
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getPartName() {
		return rest;
	}

	public int compareTo(Part rhs) {
		if (make.compareTo(rhs.getMake()) == 0)
			if (model.compareTo(rhs.getModel()) == 0)
				if (year == rhs.getYear())
					return rest.compareTo(rhs.getPartName());
				else
					return year - rhs.getYear();
			else
				return model.compareTo(rhs.getModel());
		else
			return make.compareTo(rhs.getMake());
	}

	public String toString() {
		return make + " " + model + " " + year + " " + rest;
	}
}