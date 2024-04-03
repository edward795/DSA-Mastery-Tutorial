package Trie;

public class SearchQueryString {

    public static void main(String[] args) {
        int n = 8, q = 3;
        String[] words = new String[] { "the", "a", "there", "answer", "any", "by", "bye", "their" };
        String[] queries = new String[] { "the", "an", "any" };
        TrieNode root = new TrieNode();
        for (String i : words)
            insert(root, i);
        for (String i : queries)
            System.out.println("is the word present '" + i + "' : " + search(root, i));
    }

    static void insert(TrieNode root, String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }

    static boolean search(TrieNode root, String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.child[index] == null) {
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isEnd;
    }

}

class TrieNode {
    TrieNode[] child = new TrieNode[26];;
    boolean isEnd;

    TrieNode() {
        isEnd = false;
        for (int i = 0; i < 26; i++) {
            child[i] = null;
        }
    }
}