package Arrays;

public class MaxOfSubArray {
    public static void main(String[] args) {
        int[] arr=new int[]{2,3,-8,7,-1,2,3};
        System.out.println("Max of sub array:"+getMaxSubarray(arr));
    }
    
    //Naive Soln : O(n^2)
    // static int getMaxSubarray(int[] arr){
    //     int n=arr.length,res=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         int curr_sum=arr[i];
    //         for(int j=i+1;j<n;j++){
    //             curr_sum+=arr[j];
    //             res=Math.max(res,curr_sum);
    //         }
    //     }

    //     return res;
    // }
   
    //Efficent Soln : Kadane's Algorithm : o(n)
    static int getMaxSubarray(int[] arr){
        int n=arr.length;
        int res=arr[0];
        int maxEnding=arr[0];
        for(int i=1;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            res=Math.max(res,maxEnding);
        }
        return res;
    }
}
