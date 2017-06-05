package llw;
import java.util.LinkedList;
import java.util.ListIterator;
import static java.lang.System.*;

public class JavaLinkedList{
	private LinkedList<Integer> list;

	public JavaLinkedList(){
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums){
		list = new LinkedList<Integer>();
		for(int num : nums){
			list.add(num);
		}
	}

	public double getSum(){
		ListIterator <Integer> iter = list.listIterator();
		double total=0;
		while (iter.hasNext()){
			total += iter.next();
		}
		return total;
	}

	public double getAvg(){
		return getSum()/list.size();
	}

	public int getLargest(){
		ListIterator <Integer> iter = list.listIterator();
		int largest=Integer.MIN_VALUE;
		while (iter.hasNext()){
			if (iter.next() > largest){
				iter.previous();
				largest = iter.next();
			}
		}
		return largest;
	}

	public int getSmallest(){
		ListIterator <Integer> iter = list.listIterator();
		int smallest = Integer.MAX_VALUE;
		while (iter.hasNext()){
			if (iter.next() < smallest){
				iter.previous();
				smallest = iter.next();
			}
		}
		return smallest;
	}

	public String toString(){
		return "Sum: " + getSum()
				+ "\nAverage: " + getAvg()
				+ "\nSmallest: " + getSmallest()
				+ "\nLargest: " + getLargest();
	}
	
	public static void main ( String[] args ){
	  JavaLinkedList test = new JavaLinkedList(new int[]{4,5,6,7,8,9,10,11,12,13});
		out.println(test);
		out.println();

		test = new JavaLinkedList(new int[]{24,75,86,37,82,94,111,82,43});
		out.println(test);
		out.println();

		test = new JavaLinkedList(new int[]{0,4,5,2,1,4,6});
		out.println(test);
		out.println();
	}

}
