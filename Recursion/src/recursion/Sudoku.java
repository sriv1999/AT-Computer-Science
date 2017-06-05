package recursion;
import java.util.Scanner;

/**
 * @author Srivatsan  Srinivasan
 * @author Shreyas Srinivasan
 * ATCS Pd 5
 */

public class Sudoku {

	private static int[][] grid;
	
	/**
	 * Method to solve whole Sudoku grid
	 */
	public static void sudokuSolver() {
		//start by solving first square individually
		sudokuSolver1(0, 0);
		sudokuSolver2(grid.length/2, 0);
	}
	
	/**
	 * Method to solve individual Sudoku square
	 * @param r is row number from 0 to n-1, inclusive
	 * @param c is column number from 0 to n-1, inclusive
	 * @return true if individual square is correctly filled, false otherwise
	 */
	private static boolean sudokuSolver1(int r, int c) {
		//Find column and row number of next square in Sudoku grid
		int nextC = (c + 1) % grid.length;
		int nextR = nextC > c ? r : r + 1;
		
		//Boolean that is true if value has been used in same row/column, false otherwise
		boolean used;
		
		//Try to fill the square with every possible value from 1-n, inclusive
		for (int i = 1; i <= grid.length; i++) {
			//Initially assume value has not been used
			used = false;
			//Check all values in that row and column to see if the value has been used
			for (int j = 0; j < c; j++)
				if (grid[r][j] == i)
					used = true;
			for (int k = 0; k < r; k++)
				if (grid[k][c] == i)
					used = true;
			
			//If the value has not been used, fill the square with that value
			//If using that value means all following squares work, try no more values
			if (!used) {
				grid[r][c] = i;
				if (nextR == grid.length/2 || sudokuSolver1(nextR, nextC))
					break;
			}
		}
		//return true if the square was properly filled
		if (grid[r][c] != 0)
			return true;
		//return false if the square could not be filled
		return false;
	}
	
	private static boolean sudokuSolver2(int r, int c) {
		//Find column and row number of next square in Sudoku grid
		int nextC = (c + 1) % grid.length;
		int nextR = nextC > c ? r : r + 1;
		
		//Boolean that is true if value has been used in same row/column, false otherwise
		boolean used;
		
		//Try to fill the square with every possible value from 1-n, inclusive
		for (int i = 1; i <= grid.length; i++) {
			//Initially assume value has not been used
			used = false;
			//Check all values in that row and column to see if the value has been used
			for (int j = 0; j < c; j++)
				if (grid[r][j] == i)
					used = true;
			for (int k = 0; k < r; k++)
				if (grid[k][c] == i)
					used = true;
			
			//If the value has not been used, fill the square with that value
			//If using that value means all following squares work, try no more values
			if (!used) {
				grid[r][c] = i;
				if (nextR == grid.length || sudokuSolver2(nextR, nextC))
					break;
			}
		}
		//return true if the square was properly filled
		if (grid[r][c] != 0)
			return true;
		//return false if the square could not be filled
		return false;
	}

	public static void main(String[] args) {
		//Retrieve grid size as an int value
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How big do you want the Sudoku grid to be?");
		int n = keyboard.nextInt();

		//Define grid as 2D array
		grid = new int[n][n];
		//Run static method Sudoku
		sudokuSolver();
		//Return elements of Sudoku
		for (int[] array : grid) {
			for (int element : array) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		//Close scanner
		keyboard.close();
	}

}

