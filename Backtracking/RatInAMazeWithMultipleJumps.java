package Backtracking;

public class RatInAMazeWithMultipleJumps {
    public static void main(String[] args) {
        int N = 4;
        int[][] maze = new int[][] { { 2, 1, 0, 0 }, { 3, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 } };
        solve(maze, N);
    }

    public static boolean isSafe(int N, int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    public static void solve(int[][] maze, int N) {
        int[][] sol = new int[N][N];
        if (findMinPath(maze, N, sol, 0, 0)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.println(sol[i][j] + " ");
                }
            }
        } else {
            System.out.println("-1");
        }
    }

    public static boolean findMinPath(int[][] maze, int N, int[][] sol, int i, int j) {
        sol[i][j] = 1;

        if (i == N && j == N)
            return true;

        if (maze[i][j] != 0) {
            for (int k = 1; k <= maze[i][j]; k++) {
                if (isSafe(N, i, j + k)) {
                    if (findMinPath(maze, N, sol, i, j + k))
                        return true;
                    sol[i][j + k] = 0;
                }

                if (isSafe(N, i + k, j)) {
                    if (findMinPath(maze, N, sol, i + k, j))
                        return true;
                    sol[i + k][j] = 0;
                }
            }
        }
        return false;
    }
}
