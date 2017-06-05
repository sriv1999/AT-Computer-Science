package recursion;
import java.util.Random;

public class GridCounter {
	
	private String[][] atMat;

	public GridCounter() {
		String [] choices = {"@", "-"};
		Random g = new Random();
		atMat = new String[10][10];
		for (int r = 0; r < atMat.length; r++){
			for (int c = 0; c < atMat[r].length; c++){
				atMat[r][c] = choices[g.nextInt(2)];
			}
		}
	}

	public int countAts(int r, int c) {
		if (r >= 0 && c >= 0 && r <= 9 && c <= 9) {
			if (atMat[r][c] == "@" && atMat[r][c] != "visited") {
				if (r == 0) {
					if (c == 0) {
						atMat[r][c] = "visited";
						return 1 + countAts(r, c + 1) + countAts(r + 1, c);
					} else if (c == 9) {
						atMat[r][c] = "visited";
						return 1 + countAts(r, c - 1) + countAts(r + 1, c);
					}
					atMat[r][c] = "visited";
					return 1 + countAts(r, c + 1) + countAts(r + 1, c)
							+ countAts(r, c - 1);
				} else if (c == 0) {
					if (r == 9) {
						atMat[r][c] = "visited";
						return 1 + countAts(r, c + 1) + countAts(r - 1, c);
					}
					atMat[r][c] = "visited";
					return 1 + countAts(r, c + 1) + countAts(r - 1, c)
							+ countAts(r + 1, c);
				} else if (r == 9 && c == 9) {
					atMat[r][c] = "visited";
					return 1 + countAts(r - 1, c) + countAts(r, c - 1);
				}
				atMat[r][c] = "visited";
				return 1 + countAts(r, c + 1) + countAts(r + 1, c)
						+ countAts(r - 1, c) + countAts(r, c - 1);
			}
		}
		return 0;

	}

	public void returnString() {
		for (int r = 0; r < atMat.length; r++){
			for (int c = 0; c < atMat[r].length; c++){
				System.out.print(atMat[r][c]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		GridCounter one = new GridCounter();
		one.returnString();
		
		System.out.println();
		System.out.println(one.countAts(0, 0));
	}
}
