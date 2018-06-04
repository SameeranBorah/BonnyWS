package com.codes.practice;

public class Dictionary {
    private Node root;

    public Dictionary() {
        root = new Node();
    }

    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                Node temp = new Node();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        Node p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd)
                return true;
        }

        return false;
    }

    public Node searchNode(String s) {
        Node p = root;
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
}
class Node{
    boolean isEnd;
    Node arr[];
    public Node(){
        this.arr=new Node[26];

    }

}