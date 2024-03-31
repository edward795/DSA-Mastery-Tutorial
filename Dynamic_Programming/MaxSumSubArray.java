package Dynamic_Programming;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int n = 8;
        int arr[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("The Max Sum SubArray is " + maxSumSubArray(arr, n));
    }

    // TC : O(n )
    // static int maxSumSubArray(int[] arr, int n) {
    // int[] fmax = new int[n];
    // int[] bmax = new int[n];

    // fmax[0] = arr[0];
    // bmax[n - 1] = arr[n - 1];
    // int max_so_far = Math.max(fmax[0], bmax[n - 1]);
    // for (int i = 1; i < n; i++) {
    // fmax[i] = Math.max(arr[i], fmax[i - 1] + arr[i]);
    // max_so_far = Math.max(max_so_far, fmax[i]);
    // }

    // for (int i = n - 2; i >= 0; i--) {
    // bmax[i] = Math.max(arr[i], arr[i] + bmax[i + 1]);
    // max_so_far = Math.max(max_so_far, bmax[i]);
    // }

    // int fans = max_so_far;
    // for (int i = 1; i < n - 1; i++) {
    // fans = Math.max(fans, fmax[i - 1] + bmax[i + 1]);
    // }
    // return fans;
    // }

    // TC : O(n)
    static int maxSumSubArray(int[] arr, int n) {
        int res = Integer.MIN_VALUE, prev = 0, curr = 0;
        for (int x : arr) {
            curr = Math.max(prev, x + curr);
            prev = Math.max(x, x + prev);
            res = Math.max(res, Math.max(curr, prev));
        }
        return res;
    }
}
