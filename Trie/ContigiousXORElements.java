package Trie;

public class ContigiousXORElements {
    static final int INT_SIZE = 32;
    static TrieNode root;

    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[] { 8, 1, 2, 12 };
        System.out.println("The contigous elements max xor is " + maxSubArrayXOR(arr, n));
    }

    // NAive Soln : TC : O(n^2)
    // static int maxSubArrayXOR(int[] arr, int n) {
    // int res = Integer.MIN_VALUE;
    // for (int i = 0; i < n; i++) {
    // int curr_xor = 0;
    // for (int j = i; j < n; j++) {
    // curr_xor = curr_xor ^ arr[j];
    // res = Math.max(res, curr_xor);
    // }
    // }
    // return res;
    // }

    static void insert(int pre_xor) {
        TrieNode curr = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (curr.children[val] == null) {
                curr.children[val] = new TrieNode();
            }
            curr = curr.children[val];
        }
        curr.value = pre_xor;
    }

    static int query(int pre_xor) {
        TrieNode curr = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (curr.children[1 - val] != null)
                curr = curr.children[val];
            else if (curr.children[val] != null)
                curr = curr.children[val];
        }
        return pre_xor ^ (curr.value);
    }

    static int maxSubArrayXOR(int[] arr, int n) {
        root = new TrieNode();
        insert(0);
        int result = Integer.MIN_VALUE;
        int pre_xor = 0;
        for (int i = 0; i < n; i++) {
            pre_xor = pre_xor ^ arr[i];
            insert(pre_xor);
            result = Math.max(result, query(pre_xor));
        }
        return result;
    }
}

class TrieNode {
    int value;
    TrieNode[] children = new TrieNode[2];

    TrieNode() {
        value = 0;
        children[0] = null;
        children[1] = null;
    }
}
