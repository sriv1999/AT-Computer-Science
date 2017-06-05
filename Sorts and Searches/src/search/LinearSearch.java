package search;

public class LinearSearch {
	
	public static int linSearch(int [] elements, int x){
		for (int i = 0; i < elements.length; i++){
			if (elements[i] == x){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
