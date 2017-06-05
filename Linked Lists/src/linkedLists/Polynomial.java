package linkedLists;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	private LinkedList<Term> terms;

	public Polynomial() {
		terms = new LinkedList<Term>();
	}

	// Add term to polynomial
	// @param t - the new term
	public void addTerm(Term t) {
		ListIterator<Term> iter = terms.listIterator();
		while (iter.hasNext()) {
			Term curr = iter.next();
			if (curr.getDegree() == t.getDegree()) {
				iter.set(curr.add(t));
				return;
			} else if (curr.getDegree() < t.getDegree()) {
				iter.previous();
				iter.add(t);
				return;
			}
		}
		iter.add(t);
	}
	
	public void addTerm(int c, int d){
		addTerm(new Term(c, d));
	}

	private void cleanTerms() {
		ListIterator<Term> iter = terms.listIterator();
		while (iter.hasNext())
			if (iter.next().getCoeff() == 0)
				iter.remove();
	}

	// Add polynomial to polynomial
	// @param p - the other polynomial
	// @return the new polynomial
	public Polynomial add(Polynomial p) {
		Polynomial output = new Polynomial();
		ListIterator<Term> iter1 = terms.listIterator();
		while (iter1.hasNext())
			output.addTerm(iter1.next());
		ListIterator<Term> iter2 = p.getTerms().listIterator();
		while (iter2.hasNext())
			output.addTerm(iter2.next());
		return output;
	}

	// Add polynomial to polynomial
	// @param p - the other polynomial
	// @return the new polynomial
	public Polynomial multiply(Polynomial p) {
		Polynomial output = new Polynomial();
		ListIterator<Term> iter1 = terms.listIterator();
		ListIterator<Term> iter2 = p.getTerms().listIterator();
		while (iter1.hasNext()) {
			Term curr = iter1.next();
			while (iter2.hasNext()) {
				output.addTerm(curr.multiply(iter2.next()));
			}
			while (iter2.hasPrevious())
				iter2.previous();
		}
		return output;
	}

	public Polynomial derivative() {
		Polynomial output = new Polynomial();
		ListIterator<Term> iter = terms.listIterator();
		while (iter.hasNext())
			output.addTerm(iter.next().derivative());
		return output;
	}

	protected LinkedList<Term> getTerms() {
		return terms;
	}

	public String toString() {
		String result = "";
		cleanTerms();
		for (Term e : terms) {
			if (e.getDegree() > 0)
				result += " + " + e.toString();
			else if (e.getDegree() == 0) {
				if (e.getCoeff() < 0)
					result += " - " + e.getCoeff() / -1;
				else
					result += " + " + e.getCoeff();
			} else if (e.getCoeff() < 0) {
				Term temp = new Term(e.getCoeff() / -1, e.getDegree());
				result += " - " + temp.toString();
			}
		}
		return result.substring(3);
	}

	public static void main(String[] args) {
		Polynomial Poly1 = new Polynomial();
		Polynomial Poly2 = new Polynomial();
		Polynomial Poly3 = new Polynomial();

		Poly1.addTerm(3, 4);
		Poly1.addTerm(-2, 0);
		Poly1.addTerm(1, 3);

		Poly2.addTerm(2, 0);
		Poly2.addTerm(1, 2);
		Poly2.addTerm(3, 3);
		Poly2.addTerm(2, 1);
		Poly2.addTerm(1, 5);

		Poly3.addTerm(-3, 3);
		Poly3.addTerm(1, 2);
		Poly3.addTerm(1, 0);

		System.out.println("Poly1");
		System.out.println(Poly1);
		System.out.println("Poly2");
		System.out.println(Poly2);

		System.out.println();
		System.out.println("Poly3");
		System.out.println(Poly3);

		Polynomial r = new Polynomial();
		r = Poly2.add(Poly3);
		System.out.println("Poly2+v");
		System.out.println(r);
		Polynomial u = new Polynomial();
		u = Poly1.add(Poly3);
		System.out.println("Poly1+Poly3");
		System.out.println(u);
		System.out.println("Poly3*Poly3");
		Polynomial s = new Polynomial();
		s = Poly3.multiply(Poly3);
		System.out.println(s);

		System.out.println("Poly1*Poly2");
		Polynomial v = new Polynomial();
		v = Poly1.multiply(Poly2);
		System.out.println(v);
		Polynomial t = new Polynomial();
		System.out.println("Poly2'");
		t = Poly2.derivative();
		System.out.println(t);
		Polynomial x = new Polynomial();
		System.out.println("Poly1'");
		x = Poly1.derivative();
		System.out.println(x);

	}

}
