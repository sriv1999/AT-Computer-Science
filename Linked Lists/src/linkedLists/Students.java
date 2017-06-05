package linkedLists;
import java.util.LinkedList;
import java.util.ListIterator;

public class Students {

	public static void main(String[] args) {
		LinkedList <String> roster = new LinkedList <String>();
		
		roster.addLast("Abhinav");
		roster.addLast("BadBroth&Beyond");
		//System.out.println(roster);
		
		roster.addFirst("Liz");
		roster.addFirst("Kurt");
		//System.out.println(roster);
		
		roster.add("Agenda");
		//System.out.println(roster);
		//System.out.println(roster.remove());
		
		ListIterator <String> iter = roster.listIterator();
		iter.add("Vijay");
		System.out.println(roster);
		iter.add("Nick");
		System.out.println(roster);
		
		iter.next();
		iter.next();
		iter.previous();
		iter.remove();
		iter.previous();
		iter.remove();
		System.out.println(roster);
	}

}
