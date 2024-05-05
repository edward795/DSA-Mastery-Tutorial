package Segment_Tree;

public class SegmentTreeConcept {
    static int[] pre_sum;

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40, 50 };
        int n = 5;

        initialize(arr);

        printPreSum(pre_sum);

        System.out.println(getSum(0, 2, arr));
        System.out.println(getSum(0, 3, arr));
        getUpdate(2, 50, arr);

        printPreSum(pre_sum);

    }

    static void initialize(int[] arr) {
        pre_sum = new int[5];
        pre_sum[0] = arr[0];
        for (int i = 1; i < 5; i++) {
            pre_sum[i] = pre_sum[i - 1] + arr[i];
        }
    }

    static int getSum(int qs, int qe, int[] arr) {
        int sum = 0;
        for (int i = qs; i <= qe; i++)
            sum += arr[i];
        return sum;
    }

    static void getUpdate(int i, int new_val, int[] arr) {
        int diff = new_val - arr[i];
        for (int j = i; j < 5; j++)
            arr[j] += diff;
    }

    static void printPreSum(int[] pre_sum) {
        for (int i = 0; i < 5; i++) {
            System.out.print(pre_sum[i] + " ");
        }
    }
}
