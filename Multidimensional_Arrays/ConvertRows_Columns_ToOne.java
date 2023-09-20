package Multidimensional_Arrays;

import Multidimensional_Arrays.utils.PrintMultiArray;

public class ConvertRows_Columns_ToOne {
    public static void main(String[] args) {
        int[][] mat=new int[][]{{1,0,0,0},{0,1,0,0},{0,0,0,0},{1,1,0,0}};
        
        PrintMultiArray pr=new PrintMultiArray();
        pr.printArray(mat);
        System.out.println("Array after converting all the rows & columns with 1 occurences:");
        booleanMatrix(mat);
        pr.printArray(mat);
    }
    
    //TC : O(n*m)
    static void booleanMatrix(int[][] mat){
        int n=mat.length,m=mat[0].length;
        int[] row=new int[n];
        int[] col=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || col[j]==1){
                    mat[i][j]=1;
                }
            }
        }
    }
}
