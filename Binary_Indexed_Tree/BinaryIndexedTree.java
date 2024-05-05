package Binary_Indexed_Tree;

public class BinaryIndexedTree {
    static int[] bTree;

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40, 50 };
        constructBtree(arr, arr.length);
        for (Integer i : bTree)
            System.out.println(i + " ");

        System.out.println("Sum of range : " + getSum(3));
        updateIndex(2, 70, arr, 5);

        for (Integer i : bTree)
            System.out.println(i + " ");
    }

    // TC : O(nlogn) - construct binary-indexed-tree
    static void constructBtree(int[] arr, int n) {
        bTree = new int[n + 1];
        for (int i = 0; i <= n; i++)
            bTree[i] = 0;

        for (int i = 0; i < n; i++)
            update(i, arr[i], n);
    }

    static void update(int i, int x, int n) {
        i = i + 1;
        while (i <= n) {
            bTree[i] += x;
            i = i + (i & (-i));
        }
    }

    // TC : O(logn)
    static int getSum(int i) {
        i = i + 1;
        int res = 0;
        while (i > 0) {
            res += bTree[i];
            i = i - i & (-i);
        }
        return res;
    }

    // TC : O(logn)
    static void updateIndex(int i, int x, int[] arr, int n) {
        int diff = x - arr[i];
        arr[i] = x;
        i = i + 1;
        while (i < n) {
            bTree[i] += diff;
            i = i + i & (-i);
        }
    }
}
