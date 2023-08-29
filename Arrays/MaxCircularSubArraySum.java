package Arrays;

public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        int[] arr=new int[]{5,-2,3,4};
        int n=arr.length;
        System.out.println("The max value of subarray is:"+getCircularSubArraySum(arr, n));
    }
    
    //Naive soln: O(n^2)
    // static int  getCircularSubArraySum(int[] arr,int n){
    //     int res=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         int curr_sum=0;
    //         for(int j=1;j<n;j++){
    //             curr_sum+=(arr[(i+j)%n]);
    //         }
    //         res=Math.max(res,curr_sum);
    //     }
    //     return res;
    // }
    //Kadane's algorithm
    static int getMaxSubArraySum(int[] arr,int n){
        int res=arr[0];
        int maxEnding=arr[0];
        for(int i=1;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            res=Math.max(res,maxEnding);
        }
        return res;
    }
    //Efficient Soln : O(n)
    static int getCircularSubArraySum(int[] arr,int n){
        int normalSubArrSum=getMaxSubArraySum(arr, n);
        if(normalSubArrSum<0) return normalSubArrSum;
        
        int total_sum=0;
        for(int i=0;i<n;i++){
            total_sum+=arr[i];
            arr[i]=-arr[i];
        }
        int minSubArrSum=getMaxSubArraySum(arr, n);
        int maxCircularSum=total_sum+minSubArrSum;

        return Math.max(normalSubArrSum,maxCircularSum);
    }
}
