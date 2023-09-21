package Multidimensional_Arrays;

public class DeterminantOfMatrix {
    public static void main(String[] args) {
        int[][] mat=new int[][]{{4,3},{2,3}};
        System.out.println("Determinant of the matrix is:"+determinant(mat, mat.length));
    }
    
    //Time Complexity : O(n^4) - aux space - O(n^2)
    static int determinant(int[][] arr,int n){
        int d=0;
        if(n==1) return arr[0][0];
        int[][] temp=new int[n][n];
        int sign=1;
        for(int f=0;f<n;f++){
            getCofactor(arr,temp,0,f,n);
            d+=sign*arr[0][f]*determinant(temp, n-1);
            sign=-sign;
        }
        return d;
    }

    static void getCofactor(int[][] mat,int[][] temp,int p,int q,int n){
        int i=0,j=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(row!=p && col!=q){
                    temp[i][j++]=mat[row][col];
                    if(j==n-1){
                        j=0;
                        i++;
                    }
                }
            }
        }
    }
}
