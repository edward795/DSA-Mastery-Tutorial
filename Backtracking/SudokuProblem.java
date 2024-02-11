package Backtracking;

public class SudokuProblem {
    static int N = 4;

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 1, 0, 3, 4 }, { 0, 0, 2, 1 }, { 0, 1, 4, 2 }, { 2, 4, 1, 0 } };
        solve(grid);
        System.out.println("Solution to the sudoku puzzle is " + grid);
    }

    static boolean solve(int[][] grid) {
        int i = 0, j = 0;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    break;
            }
        }

        if (i == N && j == N)
            return true;

        for (int x = 1; x <= N; x++) {
            if (isSafe(i, j, x, grid)) {
                grid[i][j] = x;
                if (solve(grid))
                    return true;
                grid[i][j] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int i, int j, int x, int[][] grid) {
        for (int k = 0; k < N; k++) {
            if (grid[k][j] == x || grid[i][k] == x)
                return false;
            int s = (int) Math.sqrt(N);
            int rs = i - i % s;
            int cs = j - j % s;

            for (i = 0; i < s; i++) {
                for (j = 0; j < s; j++) {
                    if (grid[i + rs][j + cs] == x)
                        return false;
                }
            }
        }
        return true;
    }
}
