package chess;
public class ChessComplete {
	private int[][] board;
	private int startR;
	private int startC;
	private int stepsTotal;
	private int stepOrder;

	public ChessComplete(int n) {
		board = new int[n][n];
		startR = 0;
		startC = 0;
		stepsTotal = 0;
		stepOrder = 0;
	}

	public void move(int i, int j) {
		// TODO Auto-generated method stub
		startR = i;
		startC = j;
	}

	private void findPath() {
		findPath(startR, startC);
	}

	private boolean findPath(int r, int c) {
		if ((r < 0 || r >= board.length) || (c < 0 || c >= board[r].length) || board[r][c] != 0)
			return false;
		stepsTotal++;
		stepOrder++;
		board[r][c] = stepOrder;
		if (r > 1 && c > 0 && board[r - 2][c - 1] == 0 && findPath(r - 2, c - 1))
			return true;
		if (r > 1 && c < board[r].length - 1 && board[r - 2][c + 1] == 0 && findPath(r - 2, c + 1))
			return true;
		if (r > 0 && c < board[r].length - 2 && board[r - 1][c + 2] == 0 && findPath(r - 1, c + 2))
			return true;
		if (r < board.length - 1 && c < board[r].length - 2 && board[r + 1][c + 2] == 0 && findPath(r + 1, c + 2))
			return true;
		if (r < board.length - 2 && c < board[r].length - 1 && board[r + 2][c + 1] == 0 && findPath(r + 2, c + 1))
			return true;
		if (r < board.length - 1 && c > 1 && board[r + 1][c - 2] == 0 && findPath(r + 1, c - 2))
			return true;
		if (r < board.length - 2 && c > 0 && board[r + 2][c - 1] == 0 && findPath(r + 2, c - 1))
			return true;
		if (r > 0 && c > 1 && board[r - 1][c - 2] == 0 && findPath(r - 1, c - 2))
			return true;
		if( stepOrder == Math.pow( board.length, 2))
			return true;
		stepOrder--;
		board[r][c] = 0;
		return false;
	}

	public void displayBoard() throws InterruptedException {
		// TODO Auto-generated method stub
		findPath();
				for (int[] x : board) {
			for (int y : x) {
				System.out.print(y + "\t");
			}
			System.out.println();
		}
	}

	public int getSteps() {
		return stepsTotal;
	}
	
    public static void main(String[] args) throws InterruptedException {
    	
		ChessComplete one = new ChessComplete(6);
		one.move(0, 0);

		one.displayBoard();
		System.out.print("Recursive method call count: ");
		System.out.printf("%,d", +one.getSteps());
		System.out.println();

    }

}
