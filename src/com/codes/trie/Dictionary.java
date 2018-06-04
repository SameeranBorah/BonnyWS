package com.codes.trie;
public class Dictionary {
    private TrieNode root;

    public Dictionary() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd)
                return true;
        }

        return false;
    }

    public TrieNode searchNode(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }

        if (p == root)
            return null;

        return p;

    }

    public static void main(String[] args) {
        Dictionary abc = new Dictionary();

        abc.insert("mango");
        abc.insert("orange");
        System.out.println(abc.search("mang"));
    }

    class TrieNode {
        boolean isEnd;
        TrieNode arr[];
        public TrieNode(){
            this.arr=new TrieNode[26];

        }

    }
}
