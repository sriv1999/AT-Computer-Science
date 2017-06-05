package sets;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class MyCoinSet{
	private LinkedList<Coin> [] set;
	
	public MyCoinSet(){
		set = new LinkedList [100000000];
	}
	
	public void add(Coin c){
		int pos = c.hashCode();
		set[pos] = new LinkedList<Coin>();
		LinkedList <Coin> one = set[pos];
		boolean test = false;
		ListIterator<Coin> iter = one.listIterator();
		while (iter.hasNext()){
			if (iter.next().equals(c)){
				test = true;
			}
		}
		if (!test)
			iter.add(c);
	}
	
	public String toString(){
		String result = "COIN COLLECTION CONTENTS\n";
		for (int x = 0; x < set.length; x++){
			if (set[x] != null){
				result += set[x].toString();
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		 MyCoinSet one = new MyCoinSet();
		 one.add(new Coin(1941, "penny"));
		 one.add(new Coin(2010, "dime"));
		 one.add(new Coin(2009, "quarter"));
		 one.add(new Coin(1954, "nickel"));
		 one.add(new Coin(1987, "dime"));
//		 one.add(new Coin(1949, "penny"));
//		 one.add(new Coin(1982, "dime"));
		 one.add(new Coin(1955, "penny"));
//		 one.add(new Coin(2002, "quarter"));
//		 one.add(new Coin(2008, "quarter"));
//		 one.add(new Coin(1952, "nickel"));
		 one.add(new Coin(1931, "penny"));
//		 one.add(new Coin(1989, "dime"));
		 System.out.println(one);
		 
	}

}
