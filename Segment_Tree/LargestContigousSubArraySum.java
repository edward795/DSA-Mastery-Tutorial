package Segment_Tree;

public class LargestContigousSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = 8;
        System.out.println("Sum in query range query(5,8): " + getRangeSubArraySum(arr, 5, 8, n));
        update(arr, n, 1, 11);
        System.out.println("Sum in query range query(5,8): " + getRangeSubArraySum(arr, 1, 3, n));
    }

    static void update(int[] arr, int n, int index, int val) {
        arr[index - 1] = val;
        return;
    }

    static int getRangeSubArraySum(int[] arr, int left, int right, int n) {
        int ans = arr[left - 1];
        int sum = arr[left - 1];
        for (int i = left; i < right; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
