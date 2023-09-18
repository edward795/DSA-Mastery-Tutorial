package Multidimensional_Arrays;

public class ExampleOne {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printArray(arr);

        System.out.println();

        int m=3,n=3;
        int[][] arr2=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr2[i][j]=i+j+1;
            }
        }

        printArray(arr2);
    }

    static void printArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
