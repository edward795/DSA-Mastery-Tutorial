package Multidimensional_Arrays;

import Multidimensional_Arrays.utils.PrintMultiArray;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("The Array after sorting is:");
        transpose(arr);
        PrintMultiArray pr=new PrintMultiArray();
        pr.printArray(arr);
    }

    static void transpose(int[][] arr){
        int n=arr.length;
        int[][] temp=new int[arr.length][arr[0].length]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[j][i]=arr[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=temp[i][j];
            }
        }
    }
}
