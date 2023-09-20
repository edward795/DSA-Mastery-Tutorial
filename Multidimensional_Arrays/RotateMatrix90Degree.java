package Multidimensional_Arrays;

import Multidimensional_Arrays.utils.PrintMultiArray;

public class RotateMatrix90Degree {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("Array after rotating by 90 degree:");
        rotate90(arr);
        PrintMultiArray pr=new PrintMultiArray();
        pr.printArray(arr);
    }

    //Naive Solution : O(n^2)
    // static void rotate90(int[][] arr){
    //     int n=arr.length;
    //     int[][] temp=new int[n][n];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             temp[n-j-1][i]=arr[i][j];
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             arr[i][j]=temp[i][j];
    //         }
    //     }
    // }
    
    //Efficient Soln
    static void rotate90(int[][] arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;i++){
                int ele=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=ele;
            }
        }

        for(int i=0;i<n;i++){
            int low=0,high=n-1;
            while(low<=high){
                int temp=arr[low][i];
                arr[low][i]=arr[high][i];
                arr[high][i]=temp;
                low++;
                high--;
            }
        }
    }
}
