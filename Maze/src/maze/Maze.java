package maze;

public class Maze {
	private char[][] grid;
	int iStart, jStart;
	int iExit, jExit;
	int step;

	public Maze(char[][] g, int i, int j) {
		grid = g;
		iStart = i;
		jStart = j;
		step = -1;
	}

	public void display() {
		for (char[] row : grid) {
			for (char space : row)
				System.out.print(space + " ");
			System.out.println();
		}
	}

	public boolean findExit() {
		return findExit(iStart, jStart);
	}

	private boolean findExit(int i, int j) {
		if ((i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) || grid[i][j] == '*')
			return false;
		grid[i][j] = '.';
		step++;
		display();
		System.out.println();
		System.out.println(step);
		System.out.println();
		if (isExit(i, j)) {
			iExit = i;
			jExit = j;
			return true;
		}
		if (grid[i][j+1] == ' ' && findExit(i, j + 1))
			return true;
		else if (grid[i-1][j] == ' ' && findExit(i - 1, j))
			return true;
		else if (grid[i+1][j] == ' ' && findExit(i + 1, j))
			return true;
		else if (grid[i][j-1] == ' ' && findExit(i, j - 1))
			return true;
		return false;

	}

	private boolean isExit(int i, int j) {
		if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1)
			return true;
		return false;
	}

	public int getIExit() {
		return iExit;
	}

	public int getJExit() {
		return jExit;
	}

	public int getSteps() {
		return step;
	}
	
	public static void main(String args[]) {
        char[][] m = { 
		{ '*', ' ', '*', '*', '*', '*', '*', '*', '*' }, 
		{ '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
		{ '*', ' ', '*', '*', '*', '*', '*', ' ', '*' }, 
		{ '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },
		{ '*', ' ', '*', '.', '*', '*', '*', ' ', '*' }, 
		{ '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
		{ '*', '*', '*', ' ', '*', ' ', '*', ' ', '*' }, 
		{ '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
		{ '*', '*', '*', '*', '*', '*', '*', '*', '*' } };


        Maze maze = new Maze(m, 4, 3);
        maze.display();
        if (maze.findExit())
            System.out.println("There is an exit at (" + maze.getIExit() + ", " + maze.getJExit() + ")");
        else
            System.out.println("No exit was found");


        System.out.println();
        System.out.println();
        maze.display();
        System.out.println("Steps:" + maze.getSteps());


    }


}
