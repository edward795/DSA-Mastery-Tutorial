package Multidimensional_Arrays;


public class BoundaryTraversalOfMatrix {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,2,3,4},
                                {5,6,7,8},
                                {9,10,11,12},
                                {13,14,15,16}}; 
        boundaryTraversal(matrix, matrix.length, matrix[0].length);
    }

    //TC : O(n+m)
    static void boundaryTraversal(int[][] matrix,int n,int m){
        if(n==1){
            for(int i=0;i<m;i++)
                System.out.print(matrix[n-1][i]+" ");
        }else if(m==1){
            for(int j=0;j<n;j++){
                System.out.print(matrix[j][m-1]+" ");
            }
        }else{
            for(int i=0;i<m;i++)
                System.out.print(matrix[0][i]+" ");

            for(int j=1;j<n;j++) 
                System.out.print(matrix[j][m-1]+" ");

            for(int i=m-2;i>=0;i--) 
                System.out.print(matrix[n-1][i]+" ");

            for(int i=n-2;i>=0;i--) 
                System.out.print(matrix[i][0]+" ");
        }
    }
}
