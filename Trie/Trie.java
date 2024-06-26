package Trie;

import Trie.TrieNode;

public class Trie {
    TrieNode root;

    void insert(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.child[index] == null)
                curr.child[index] = new TrieNode();
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }

    boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.child[index] == null)
                return false;
        }
        return curr.isEnd;
    }

    boolean isEmpty(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null)
                return false;
        }
        return true;
    }

    TrieNode delNode(TrieNode root, String key, int i) {
        if (root == null)
            return null;
        if (i == key.length()) {
            root.isEnd = false;
            if (isEmpty(root) == true)
                root = null;
            return root;
        }

        int index = key.charAt(i) - 'a';
        root.child[index] = delNode(root.child[index], key, i + 1);
        if (isEmpty(root) && root.isEnd == false)
            root = null;
        return root;
    }
}
