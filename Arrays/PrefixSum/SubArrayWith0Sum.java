package Arrays.PrefixSum;

import java.util.HashSet;

public class SubArrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, -1, 4, 5, 3, 2, 1 };
        System.out.println("Does this array contains subarray with 0 Sum?:" + isSubArrayWithZeroSum(arr));
    }

    // Naive Soln - O(n^2)
    // static boolean isSubarrayWithZeroSum(int[] arr){
    // int n=arr.length;
    // for(int i=0;i<n;i++){
    // if(arr[i]==0) return true;
    // int sum=arr[i];
    // for(int j=i+1;j<n;j++){
    // sum+=arr[j];
    // if(sum==0) return true;
    // }
    // }
    // return false;
    // }

    
    // Efficent Soln : Prefix sum + Hashing : O(n)
    static boolean isSubArrayWithZeroSum(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int prefix_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            if (arr[i] == 0 || prefix_sum == 0 || hs.contains(arr[i]))
                return true;

            hs.add(prefix_sum);
        }
        return false;
    }
}
