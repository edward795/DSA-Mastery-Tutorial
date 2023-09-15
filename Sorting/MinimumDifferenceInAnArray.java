import java.util.Arrays;

public class MinimumDifferenceInAnArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,8,12,5,18};
        int n=arr.length;
        System.out.println("The maximum element in the array is:"+minDiff(arr, n));
    }
    
    //Naive Solution : O(n^2)
    // static int minDiff(int[] arr,int n){
    //     int res=Integer.MAX_VALUE;
    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<n;j++)
    //             res=Math.min(res,Math.abs(arr[i]-arr[j]));
    //     }
    //     return res;
    // }
    
    //Efficient Soln :O(nlogn)
    static int minDiff(int[] arr,int n){
        Arrays.sort(arr);
        int res=Integer.MAX_VALUE;
        for(int i=1;i<n;i++)
            res=Math.min(res,arr[i]-arr[i-1]);
        return res;
    }
}
