package search;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

	public static int binSearch(int [] elements, int x){
		Arrays.sort(elements);
		int first = 1;
		int last = elements.length;
		int mid = last/2;
		int index = -1;
		
		while (first < last){
			mid = (first + last)/2;
			if (x == elements[mid]){
				index = mid;
				break;
			}
			else if (x < elements[mid]){
				last = mid - 1;
			}
			else{
				first = mid + 1;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int [] one = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		System.out.println(binSearch(one, 10));

	}

}
