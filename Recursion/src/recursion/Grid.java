package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Grid {
	private String[][] grid;
	private String[][] orig;
	private String[] values;

	public Grid() {
	}

	public Grid(int rows, int cols, String[] vals) {
		grid = new String[rows][cols];
		setGrid(rows, cols, vals);
		values = vals;

	}

	public int gridPart(String val, int r, int c) {
		if (r > grid.length - 1 || r < 0 || c > grid[0].length - 1 || c < 0 || grid[r][c] != val) {
			return 0;
		}
		grid[r][c] = "";
		return 1 + gridPart(val, r - 1, c) + gridPart(val, r, c - 1) + gridPart(val, r + 1, c)
				+ gridPart(val, r, c + 1);
	}

	public void setGrid(int rows, int cols, String[] vals) {
		orig = new String[rows][cols];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				grid[y][x] = vals[(int) (Math.random() * vals.length)];
				orig[y][x] = grid[y][x];
			}
		}

	}

	public int findMax(String val) {
		return findMax(0, 0, val);
	}

	private int findMax(int r, int c, String search) {
		int max = 0;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				max = Math.max(max, gridPart(search, y, x));
			}
		}
		return max;
	}

	public String toString() {
		String output = "";
		for (int y = 0; y < orig.length; y++) {
			for (int x = 0; x < orig[0].length; x++) {
				output += orig[y][x];
			}
			output += "\n";
		}

		for (int x = 0; x < values.length; x++) {
			output += values[x] + " == " + findMax(values[x]) + "\n";
		}
		return output;
	}

	public static void main(String args[]) throws IOException {
		Grid grid = new Grid(12, 12, new String[] { "A", "E", "I", "O", "U" });
		System.out.println(grid);

		System.out.println("\n\n");
		Grid grid2 = new Grid(11, 6, new String[] { "X", "Y", "Z", "7", "8", "2" });
		System.out.println(grid2);

	}
}