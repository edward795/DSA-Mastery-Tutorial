package Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr=new int[]{ -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum SubArray Sum is:"+maxSubArraySum(arr));
    }
    
    //Efficient Soln - Kadane's Algorithm - O(n)
    // static int maxSubArraySum(int[] arr){
    //     int n=arr.length;
    //     int res=Integer.MIN_VALUE;
    //     int maxSoFar=arr[0];
    //     for(int i=1;i<n;i++){
    //         maxSoFar=Math.max(arr[i],arr[i]+maxSoFar);
    //         res=Math.max(res,maxSoFar);
    //     }
    //     return res;
    // }
    
    //Efficient Soln : O(n)
    static int maxSubArraySum(int[] arr){
        int n=arr.length;
        if(n==1) return arr[0];
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        
        int curr_max=arr[0];
        int max_so_far=arr[0];
        int curr_min=arr[0];
        int min_so_far=arr[0];

        for(int i=0;i<n;i++){
            curr_max=Math.max(arr[i],curr_max+arr[i]);
            max_so_far=Math.max(max_so_far,curr_max);

            curr_min=Math.min(curr_min+arr[i],curr_min);
            min_so_far=Math.min(min_so_far,curr_min);
        }

        if(min_so_far==sum)
            return max_so_far;
        
        return Math.max(max_so_far,sum-min_so_far);
    }
}
