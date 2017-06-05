package rational;
import java.util.Random;

public class Rational {
	private int numer;
	private int denom;
	
	public Rational(int n, int d){
		numer = n;
		if (d == 0){
			denom = 1;
		}
		else{
			denom = d;
		}
	}

	public int getNumer() {
		return numer;
	}

	public int getDenom() {
		return denom;
	}
	
	public void setNumer(int n) {
		numer = n;
	}

	public void setDenom(int d) {
		denom = d;
	}
	
	public Rational getReciprocal() {
		Rational temp = new Rational(denom, numer);
		return temp;
	}
	
	public Rational add(Rational one){
		int base = denom*one.getDenom();
		Rational add = new Rational(((base/denom)*numer) + ((base/one.getDenom())*one.getNumer()), base);
		add.reduce();
		return add;
	}
	
	public Rational subtract(Rational two){
		int base = denom*two.getDenom();
		Rational subtract = new Rational(((base/denom)*numer) - ((base/two.getDenom())*two.getNumer()), base);
		subtract.reduce();
		return subtract;
	}
	
	public Rational multiply(Rational three){
		Rational multiply = new Rational(numer*three.getNumer(), denom*three.getDenom());
		multiply.reduce();
		return multiply;
	}
	
	public Rational divide(Rational four){
		Rational divide = multiply(four.getReciprocal());
		divide.reduce();
		return divide;
	}
	
	public void reduce(){
		for (int x = 1; x <= Math.max(numer, denom); x++){
			if ((numer%x == 0) && (denom%x == 0)){
				numer /= x;
				denom /= x;
			}
		}
	}
	
	public boolean equals(Rational five){
		five.reduce();
		this.reduce();
		return ((five.getNumer() == this.getNumer()) && (five.getDenom() == this.getDenom()));
	}
	
	public int compareTo(Rational six){
		if ((double)numer/denom == (double)six.getNumer()/six.getDenom())
			return 0;
		else if ((double)numer/denom < (double)six.getNumer()/six.getDenom())
			return -1;
		else
			return 1;
	}
	
	public String toString(){
		if (numer == 0 && denom != 0){
			return 0 + "";
		}
		else if (denom == 0){
			return "Undefined";
		}
		return numer + "/" + denom;
	}
	
	public static void main(String[] args){
		//DOCUMENT TESTER
		int [] num = new int [] {-20, -19, -18, -17, -16, -15, -14, 
							-13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, 
							-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 
							13, 14, 15, 16, 17, 18, 19, 20};
		
		Random gen = new Random();
		
		Rational r1 = new Rational(4, 2);
		Rational r2 = new Rational(num[gen.nextInt(41)], num[gen.nextInt(41)]);
		
		Rational rSum, rDiff, rProd, rQuot, rRecip;

		System.out.println ("First rational number: " + r1);
		System.out.println ("Second rational number: " + r2);

		if (r1.equals(r2))
		    System.out.println ("r1 and r2 are equal.");
		else
		    System.out.println ("r1 and r2 are NOT equal.");
		if (r1.compareTo(r2) < 0)
		    System.out.println ("r1 is less than r2.");
		else if (r1.compareTo(r2) > 0)
		    System.out.println ("r1 is greater than r2.");
		else
		    System.out.println ("r1 and r2 are equal.");

		rRecip = r1.getReciprocal();
		System.out.println ("The reciprocal of r1 is: " + rRecip);

		rSum = r1.add(r2);
		rDiff = r1.subtract(r2);
		rProd = r1.multiply(r2);
		rQuot = r1.divide(r2);

		System.out.println ("r1 + r2: " + rSum);
		System.out.println ("r1 - r2: " + rDiff);
		System.out.println ("r1 * r2: " + rProd);
		System.out.println ("r1 / r2: " + rQuot);
		
		System.out.println();
		
		//CLASS TESTER
		Rational one = new Rational(2, 8);
		Rational two = new Rational(3, 0);
		System.out.println(one + " + " + two + " = " + one.add(two));
		
		Rational three = new Rational(2, 5);
		Rational four = new Rational(3, 7);
		System.out.println(three + " ÷ " + four + " = " + three.divide(four));
	}

}
