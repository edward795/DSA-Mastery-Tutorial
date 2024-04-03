package Trie;

public class CountDistinctRows {
    static int[][] mat = new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };

    public static void main(String[] args) {
        System.out.println("Count of distinct rows : " + distinctRows());
    }

    // TC : O(m*m*n)
    // static int distictRows(int[][] mat) {
    // int count = 0;
    // for (int i = 0; i < mat.length; i++) {
    // boolean flag = false;
    // for (int k = i + 1; k < mat.length; k++) {
    // for (int j = 0; j < mat[i].length; j++) {
    // if (mat[i][j] != mat[k][j])
    // flag = true;
    // }
    // }
    // if (flag == false)
    // count++;
    // }
    // return count;
    // }

    static boolean insert(TrieNode root, int row) {
        TrieNode curr = root;
        boolean flag = false;
        for (int i = 0; i < mat.length - 1; i++) {
            int index = mat[row][i];
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
                flag = true;
            }
            curr = curr.child[index];

        }
        return flag;
    }

    // TC : O(m*n)
    static int distinctRows() {
        TrieNode root = new TrieNode();
        int res = 0;
        for (int row = 0; row < mat.length; row++) {
            if (insert(root, row) == true)
                res++;
        }
        return res;
    }

}

class TrieNode {
    TrieNode child[] = new TrieNode[2];
}