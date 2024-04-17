package Trie;

import java.util.HashMap;

public class RenamingCities {
    public static void main(String[] args) {
        int n = 6;
        String[] cities = new String[] { "shimla", "safari", "sammu", "delhi", "jammu", "dehradun" };
        check(cities, n);
    }

    public static TrieNode root;
    public static HashMap<String, Integer> h = new HashMap<>();

    public static void check(String[] arr, int n) {
        root = new TrieNode();
        h = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public static void insert(String s) {
        TrieNode curr = root;
        h.put(s, h.getOrDefault(s, 0) + 1);
        String code_num = String.valueOf(h.get(s));
        String code = "";
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (!found)
                code += s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
                found = true;
            }
            curr = curr.children[index];
            if (!found && curr.isEnd) {
                System.out.println(s + "" + code_num);
            } else {
                System.out.println(code);
                curr.isEnd = true;
            }
        }
    }
}

class TrieNode {
    public TrieNode children[];
    public boolean isEnd;

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
