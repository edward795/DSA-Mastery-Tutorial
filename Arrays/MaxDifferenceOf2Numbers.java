package Arrays;

import java.util.Arrays;

public class MaxDifferenceOf2Numbers {
    public static void main(String[] args) {
        int[] arr=new int[]{2,3,10,6,4,8,1};
        System.out.println("The max differece in the arrayis:"+getMaxDiff(arr));

    }
    
    //Naive Soln - O(n^2)
    // public static int getMaxDiff(int[] arr){
    //     int n=arr.length;
    //     int res=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             res=Math.max(res,arr[j]-arr[i]);
    //         }
    //     }

    //     return res;
    // }
    
    //Best Soln : TC : O(n)
    // public static int getMaxDiff(int[] arr){
    //     int n=arr.length;
    //     int res=arr[1]-arr[0],minVal=arr[0];
    //     for(int i=1;i<n;i++){
    //         res=Math.max(res,arr[i]-minVal);
    //         minVal=Math.min(minVal,arr[i]);
    //     }
    //     return res;
    // }

    //Better Soln : O(nlogn) - sorting
    public static int getMaxDiff(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        return arr[n-1]-arr[0];
    }
}
