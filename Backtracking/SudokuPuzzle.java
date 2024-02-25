package Backtracking;

public class SudokuPuzzle{
    public static void main(){
        int[][] grid=new int[][]{{3,0,6,5,0,8,4,0,0},
                      {5,2,0,0,0,0,0,0,0},
                      {0,8,7,0,0,0,0,3,1},
                      {0,0,3,0,1,0,0,8,0},
                      {9,0,0,8,6,3,0,0,5},
                      {0,5,0,0,9,0,6,0,0},
                      {1,3,0,0,0,0,2,5,0},
                      {0,0,0,0,0,0,0,7,4},
                      {0,0,5,2,0,6,3,0,0}};
        System.out.println("The solution exists for sudoku ? "+solveSudoku(grid));
    }

    static void printGrid(int grid[][]){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                System.out.println(grid[i][j]+" ");
            }
        }
    }

    static boolean isValid(int grid[][],int row,int col,int k){
        for(int i=0;i<9;i++){
            if(grid[row][i]==k) return false;
            if(grid[i][col]==k) return false;

            if(grid[3*(row/3)+i/3][3*(col/3)+i/3]==k)
                return false;
        }
        return true;
    }
    //TC : O(9^9) - O(N*N)
    static boolean solveSudoku(int grid[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(isValid(grid, i, j, k)){
                            grid[i][j]=k;
                            if(solveSudoku(grid)) return true;
                            else grid[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}