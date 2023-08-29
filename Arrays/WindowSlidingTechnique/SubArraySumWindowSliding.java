package Arrays.WindowSlidingTechnique;

public class SubArraySumWindowSliding {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 20, 3, 10, 5 };
        int sum = 33;
        System.out
                .println("Does subarray with sum " + sum + " exists in the given array?:" + SubArraySum(arr, sum, sum));
    }

    // Efficient Soln _ O(n)
    static boolean SubArraySum(int[] arr, int sum, int n) {
        int curr_sum = arr[0], s = 0;
        for (int e = 1; e < n; e++) {
            while (curr_sum > sum && s < e - 1) {
                curr_sum -= arr[s++];
            }

            if (curr_sum == sum)
                return true;
            if (e < n)
                curr_sum += arr[e];
        }

        return (curr_sum == sum);
    }
}
