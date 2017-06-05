package stacks;
import java.util.Iterator;
import java.util.Stack;

public class CDStack {
	Stack <String> myStack;
	
	public CDStack(){
		myStack = new Stack <String>();
		
		myStack.push("Journey");
		myStack.push("Iggy Pop");
		myStack.push("Hall & Oats");
		myStack.push("Genesis");
		myStack.push("Foreigner");
		myStack.push("Eagles");
		myStack.push("Deep Purple");
		myStack.push("Cheap Trick");
		myStack.push("Beatles");
		myStack.push("Aerosmith");
	}
	
	public CDStack(String album1, String album2, String album3){
		myStack = new Stack <String>();
		
		myStack.push(album1);
		myStack.push(album2);
		myStack.push(album3);
	}
	
	public String nextCD(){
		return myStack.peek();
	}
	
	public String playNextCD(){
		return myStack.pop();
	}
	
	public void printCDs(){
		while (!myStack.isEmpty())
			System.out.println(myStack.pop());
	}
	
	public void printCDs2(){
		Iterator <String> iter = myStack.iterator();
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
	public void printCDs3(){
		for (String e : myStack){
			System.out.println(e);
		}
	}
	
	public void printCDRecursive(){
		if (myStack.isEmpty()){
			System.out.println();
		}
		else{
			System.out.println(myStack.pop());
			printCDRecursive();
		}
	}
	
	public void reverseStack(){
		Stack <String> temp = new Stack <String> ();
		while (!myStack.isEmpty()){
			temp.push(myStack.pop());
		}
		myStack = temp;
	}
	
	public void combineStacks(CDStack other){
		other.reverseStack();
		while (!other.myStack.isEmpty()){
			this.myStack.push(other.myStack.pop());
		}
	}
	
	public static String binary(int x){
		Stack <Integer> temp = new Stack <Integer> ();
		String result = "";
		while (x != 0){
			temp.push(x%2);
			x/=2;
		}
		while (!temp.isEmpty()){
			result += temp.pop();
		}
		return result;
	}
	
	public static void main(String[] args){
		CDStack cd = new CDStack();
		/*CDStack cd2 = new CDStack("CookiesRFun", "BartGoesToSchool", "AlphabetSongs");
		cd.printCDs2();
		System.out.println();
		System.out.println();
		cd.combineStacks(cd2);
		cd.printCDs2();*/
		System.out.println(binary(34));
	}
}
