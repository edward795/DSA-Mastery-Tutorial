package Trie;

public class MostFrequentWord {
    public static void main(String[] args) {
        String[] arr = new String[] { "geeks", "for", "geeks" };
        int n = 3;
        System.out.println("The most occurring word is " + mostFrequentWord(arr, n));
    }

    class TrieNode {
        public TrieNode children[];
        public int count;
        public int first;

        public TrieNode() {
            count = 0;
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static TrieNode root = new TrieNode();

    public static String mostFrequentWord(String arr[], int n) {
        String ret = "";
        int maxCount = 0;
        int ret_first = 0;
        for (int i = 0; i < n; i++) {
            TrieNode curr = root;
            for (int j = 0; j < arr[i].length(); j++) {
                int index = arr[i].charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.count++;
            if (curr.count == 1)
                curr.first = i;
            if (curr.count > maxCount || (curr.count == maxCount && curr.first > ret_first)) {
                ret = arr[i];
                maxCount = curr.count;
                ret_first = curr.first;
            }
        }
        return ret;
    }
}
