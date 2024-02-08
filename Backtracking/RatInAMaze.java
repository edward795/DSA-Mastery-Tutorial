package Backtracking;

public class RatInAMaze {
    static int N=5;
    public static void main(String[] args) {
        int[][] maze = new int[][]{{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        int[][] sol = new int[3][3];
        solveMaze(maze,sol);
    }

    static boolean isSafe(int i,int j,int[][] maze){
        return (i<N && j<N && maze[i][j]==1);
    }

    static boolean solveMaze(int[][] maze,int[][] sol){
        if(solveMazeRec(0,0,maze,sol)==false){
            return false;
        }else{
            printMatrix(sol);
            return true;
        }
    }

    static boolean solveMazeRec(int i,int j,int[][] maze,int[][] sol){
        if(i==N-1 && j==N-1){
            sol[i][j]=1;
            return true;
        }

        if(isSafe(i,j,maze)==true){
            sol[i][j]=1;
            if(solveMazeRec(i+1, j, maze, sol)==true) return true;
            else if(solveMazeRec(i,j+1,maze,sol)==true) return true;
            sol[i][j]=0;
        }
        return false;
    }

    static void printMatrix(int[][] sol){
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[i].length;j++){
                System.out.println(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}
