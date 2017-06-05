package palindrome;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalinList {
	private Queue <String> q;
	private Stack <String> s;
	
	public PalinList(String str){
		q = new LinkedList <String> ();
		s = new Stack <String> ();
		String [] list = str.split(" ");
		for (String e : list){
			q.offer(e);
			s.push(e);
		}
	}
	
	public boolean isPalin(){
		for (int i = 0; i < q.size(); i++){
			if (!q.remove().equals(s.pop())){
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String result = "[";
		for (Object e : q){
			result += e + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		if (isPalin())
			return result + " is a palinlist.";
		return result + " is not a palinlist.";
	}

	public static void main(String[] args) {
		PalinList one = new PalinList("one two three two one");
		System.out.println(one);
		
		PalinList two = new PalinList("1 2 3 4 5 one two three four five");
		System.out.println(two);
		
		PalinList three = new PalinList("a b c d e f g x y z g f h");
		System.out.println(three);
		
		PalinList four = new PalinList("racecar is racecar");
		System.out.println(four);
		
		PalinList five = new PalinList("1 2 3 a b c c b a 3 2 1");
		System.out.println(five);
		
		PalinList six = new PalinList("chicken is a chicken");
		System.out.println(six);

	}

}
