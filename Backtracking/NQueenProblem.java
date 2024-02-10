package Backtracking;

public class NQueenProblem {
    static int N=4;
    static boolean board[][]=new boolean[N][N];
    public static void main(String[] args) {
        solve();
        printMatrix(board);
    }

    static boolean solveRec(int col){
        if(col==N) return true;
        for(int i=0;i<N;i++){
            if(isSafe(i,col)){
                board[i][col]=true;
                if(solveRec(col+1)) return true;
                board[i][col]=false;
            }
        }
        return false;
    }

    static boolean solve(){
        if(solveRec(0)==false)
            return false;
        else{
            printMatrix(board);
            return true;
        }
    }

    static void printMatrix(boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int row,int col){
        for(int i=0;i<col;i++){
            if(board[row][i]) return false;
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }

        for(int i=row,j=col;j>=0 && i<N;i++,j--){
            if(board[i][j]) return false;
        }
        return true;
    }
}
