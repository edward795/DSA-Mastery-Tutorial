package Trie;

import java.util.HashMap;

public class RenamingCities {
    public static void main(String[] args) {
        int n = 6;
        String[] cities = new String[] { "Shimla", "Safari", "Jammu", "Delhi", "Jammu", "Dehradun" };
        for (String i : cities) {
            insert(i);
        }
    }

    public static TrieNode root;
    public static HashMap<String, Integer> h;

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
                code += s.charAt(index);
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
                found = true;
            }
            curr = curr.child[index];
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

    public boolean isEnd;
    public TrieNode[] child;

}
