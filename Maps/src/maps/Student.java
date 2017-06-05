package maps;

public class Student implements Comparable <Student>{
	private String first;
	private String last;
	private int id;

	public Student(String f, String l, int i) {
		first = f;
		last = l;
		id = i;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		return first + " " + last + " (ID: " + id + ")";
	}
	
	public int hashcode(){
		return first.charAt(0);
	}
	
	@Override
	public int compareTo(Student other){
		if (this.getLast().compareToIgnoreCase(other.getLast()) < 0)
			return -1;
		else if (this.getLast().compareToIgnoreCase(other.getLast()) > 0)
			return 1;
		else{
			if (this.getFirst().compareToIgnoreCase(other.getFirst()) < 0)
				return -1;
			else if (this.getFirst().compareToIgnoreCase(other.getFirst()) > 0)
				return 1;
			else{
				if (this.getId() < other.getId())
					return -1;
				if (this.getId() > other.getId())
					return 1;
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
