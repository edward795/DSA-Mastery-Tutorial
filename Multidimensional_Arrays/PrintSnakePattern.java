package Multidimensional_Arrays;

public class PrintSnakePattern {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSnakePatern(arr);
    }
    
    //TC : O(R*C)
    static void printSnakePatern(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(flag){                         // or give i%2==0  ->   even rows are printed from o->n-1
                for(int j=m-1;j>=0;j--)
                    System.out.print(arr[i][j]+" ");
            }else{
                for(int j=0;j<m;j++)
                    System.out.print(arr[i][j]+" ");
            }
            flag=!flag;
        }
    }
}
