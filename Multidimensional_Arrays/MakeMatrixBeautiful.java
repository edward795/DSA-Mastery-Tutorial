package Multidimensional_Arrays;

public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        int[][] mat=new int[][]{{1,2},{3,4}};
        System.out.println("Minimum count of operations to make sum of every row & column equal:"+countOfOperations(mat));
    }
    
    //TC : O(n*m)
    static int countOfOperations(int[][] mat){
        int n=mat.length;
        int sumRow[]=new int[n];
        int sumCol[]=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sumRow[i]+=mat[i][j];
                sumCol[j]+=mat[i][j];
            }
        }

        int maxSum=0;
        for(int i=0;i<n;i++){
            maxSum=Math.max(maxSum,sumRow[i]);
            maxSum=Math.max(maxSum,sumCol[i]);
        }

        int count=0;
        for(int i=0,j=0;i<n&&j<n;){
            int diff=Math.min(maxSum-sumRow[i],maxSum-sumCol[j]);
            mat[i][j]+=diff; 
            sumCol[j]+=diff;
            sumRow[i]+=diff;
            count+=diff;

            if(sumRow[i]==maxSum) ++i;
            if(sumCol[j]==maxSum) ++j;
        }
        return count;
    }
}
