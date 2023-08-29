package Arrays.WindowSlidingTechnique;

public class MaxConsecutiveSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 8, 30, -5, 20, 7 };
        int n = arr.length;
        int k = 3;
        System.out.println("The max consecutive sum is:" + getMaxConsecutiveSum(arr, n, k));
    }
    // Naive Soln : O(n^2)
    // static int getMaxConsecutiveSum(int[] arr,int n,int k){
    // int res=Integer.MIN_VALUE;

    // for(int i=0;i+k-1<n;i++){
    // int curr_sum=0;
    // for(int j=0;j<k;j++)
    // curr_sum+=arr[i+j];
    // res=Math.max(res,curr_sum);
    // }
    // return res;
    // }

    // Efficient Soln : O(n)
    static int getMaxConsecutiveSum(int[] arr, int n, int k) {
        int res = Integer.MIN_VALUE;
        int curr_sum = 0;

        // initial window of size k
        for (int i = 0; i < k; i++)
            curr_sum += arr[i];

        // removing 1st & adding last ele to the window
        for (int i = k; i < n; i++) {
            curr_sum += (arr[i] - arr[i - k]);
            res = Math.max(res, curr_sum);
        }
        return res;
    }
}