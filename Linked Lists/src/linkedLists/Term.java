package linkedLists;

public class Term {
	private int coeff;
	private int degree;
	
	public Term(int c, int d){
		coeff = c;
		degree = d;
	}
	
	//Assume the powers are equal
	public Term add(Term other){
		return new Term(other.getCoeff() + coeff, degree);
	}
	
	public Term multiply(Term other){
		return new Term(other.getCoeff() * coeff, other.getDegree() + degree);
	}

	public int getCoeff() {
		return coeff;
	}

	public int getDegree() {
		return degree;
	}
	
	public String toString(){
		return coeff + "x^" + degree;
	}

	public static void main(String[] args) {
		Term p = new Term(3, 5);
		Term q = new Term(2, 5);
		Term r = new Term(4, 6);
		
		System.out.println(p.multiply(q));
	}

	public Term derivative() {
		return new Term(getCoeff()*getDegree(), getDegree()-1);
	}

}
