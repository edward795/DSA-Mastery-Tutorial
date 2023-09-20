package Multidimensional_Arrays.utils;

public class PrintMultiArray {
    public static void printArray(int[][] arr){
        int n=arr.length,m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
