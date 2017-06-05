package linkedLists;
import java.util.LinkedList;
import java.util.ListIterator;
import static java.lang.System.*;

public class Fruit {
	private LinkedList <String> bowl;
	
	public Fruit(){
		bowl = new LinkedList <String> ();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl.addLast("lime");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		bowl.addLast("watermelon");
	}
	
	public void displayFruit(){
		out.println(bowl);
	}
	
	public void displayFruit2(){
		for (String t : bowl){
			out.println(t);
		}
	}
	
	public void displayFruit3(){
		//Using Iterators
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			out.println(iter.next());
		}
	}
	
	public void displayOther(){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			out.println(iter.next());
			if (iter.hasNext()){
				iter.next();
			}
		}
	}
	
	public void removeOther(){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			iter.next();
			iter.remove();
			if (iter.hasNext()){
				iter.next();
			}
		}
	}
	
	public void displayReverse(){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			iter.next();
		}
		while (iter.hasPrevious()){
			out.println(iter.previous());
		}
	}
	
	public void newFruit(String s){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			if (s.compareTo(iter.next()) <= 0){
				iter.previous();
				iter.add(s);
				break;
			}
		}
	}
	
	public void removeFruitBegin(char a){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			String temp = iter.next();
			if (temp.charAt(0) == a){
				iter.remove();
			}
		}
	}
	
	public String inList(String s){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			if (iter.next().compareTo(s) == 0){
				return s + " is indeed in list";
			}
		}
		return s + " is not in list";
	}
	
	public LinkedList <String> writeReverse(){
		ListIterator <String> iter = bowl.listIterator();
		while (iter.hasNext()){
			iter.next();
		}
		
		LinkedList <String> bowlReverse = new LinkedList <String> ();
		while (iter.hasPrevious()){
			bowlReverse.addLast(iter.previous());
		}
		return bowlReverse;
	}
	
	public void removeNonPrimes(int n){
		LinkedList <Integer> numList = new LinkedList <Integer> ();
		for (int i = 2; i <= n; i++){
			numList.addLast(i);
		}
		out.println("Original List: " + numList);
		
		for (int i = 0; i < numList.size(); i++){
			for (int j = i + 1; j < numList.size(); j++){
				if (numList.get(j)%numList.get(i) == 0){
					numList.remove(j);
				}
			}
		}
		
		out.println("Prime List: " + numList);
		out.println("There are " + numList.size() + " primes under " + n);
	}
	
	public static void main(String[] args) {
		Fruit one = new Fruit();
		one.removeNonPrimes(1000000);
	}

}
