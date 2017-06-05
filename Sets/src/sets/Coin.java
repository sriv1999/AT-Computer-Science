package sets;

public class Coin {
	private int year;
	private String type;
	
	public Coin(int y, String t){
		year = y;
		type = t;
	}

	public int getYear() {
		return year;
	}

	public String getType() {
		return type;
	}
	
	public int hashCode(){
		final int HASHNUMBER = 9;
		int h = 0;
		for (int i = 0; i < type.length(); i++)
			h = HASHNUMBER*h + type.charAt(i);
		h += this.getYear();
		return h;
	}
	
	public boolean equals(Coin other){
		if (this.getType().equalsIgnoreCase(other.getType())){
			int thisYear = (this.getYear()%100/10);
			int otherYear = (other.getYear()%100/10);
			if (thisYear == otherYear){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return year + ", " + type;
	}
	
	public static void main(String[] args){
		Coin one = new Coin(1941, "penny");
		Coin two = new Coin(1949, "penny");
		System.out.println(one.equals(two));
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
		System.out.println(one.equals(two));
	}

}
