package recursion;

public class Recursion2D {
	
	public static int add(int [][] array2D){
		return add(array2D, array2D.length-1);
	}
	
	public static int add(int [][] array2D, int index){
		if (index == 0){
			return add(array2D[0], array2D[0].length - 1);
		}
		return add(array2D[index], array2D[index].length - 1) + add(array2D, index-1);
	}
	
	public static int add(int [] array, int index){
		if (index > 0){
			return array[index] + add(array, index-1);
		}
		return array[0];
	}

	public static void main(String[] args) {
		System.out.println(add(new int[][] { {4, 7, 3, 0},
												{2, 8, 1, 9},
												{6, 3, 2, 0},
												{8, 6, 5, 8},
												{2, 1, 1, 4},}));
	

	}

}
