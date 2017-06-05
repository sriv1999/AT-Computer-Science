package chess;

public class Queen {

    private int[] x;
    private int count;

    public Queen(int N) {
        x = new int[N];
    }

    public boolean canQueen(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i]))
            {
                return false;
            }
        }
        return true;
    }

    public void print(int[] x) {
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void place(int r, int n) {
        for (int c = 0; c < n; c++) {
            if (canQueen(r, c)) {
                x[r] = c;
                if (r == n - 1) {
                    print(x);
                    System.out.println("Possibility: " + count);
                    System.out.println();
                    count++;
                } else {
                    place(r + 1, n);
                }
            }
        }
    }

    public void call() {
        place(0, x.length);
    }

    public static void main(String args[]) {
        Queen Q = new Queen(8);
        Q.call();
    
    }
}