package Trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CamelCaseStrings {
    public static void main(String[] args) {
        String[] dict = new String[] { "WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks" };
        String pattern = "KG";
        findAllWords(dict, pattern);
    }

    static void findAllWords(String[] dict, String pattern) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < dict.length; i++) {
            insert(root, dict[i]);
        }
        search(root, pattern);
    }

    static void insert(TrieNode root, String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = Math.abs(key.charAt(i) - 'a');
            if (Character.isUpperCase(key.charAt(i)))
                continue;
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
        curr.word.add(key);
    }

    static void search(TrieNode root, String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = Math.abs(key.charAt(i) - 'a');
            if (curr.children[index] == null) {
                System.out.println("No Match Found!");
                return;
            }
            curr = curr.children[index];
        }
        displayAll(curr);
        return;
    }

    static void displayAll(TrieNode root) {
        if (root.isEndOfWord) {
            Collections.sort(root.word);
            for (String s : root.word) {
                System.out.println(s + "");
            }
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                displayAll(root.children[i]);
            }
        }
    }
}

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEndOfWord;
    ArrayList<String> word;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
            word = new ArrayList<>();
        }
    }
}
