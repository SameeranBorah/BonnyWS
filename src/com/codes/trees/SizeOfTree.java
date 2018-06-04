package com.codes.trees;

public class SizeOfTree {
    Node root;
    SizeOfTree(){
        root=null;
    }
    int size(Node node){
        if(node==null)
            return 0;
        else{
            int lsize= size(node.left);
            int rsize= size(node.right);
            return (lsize+rsize+1);
        }
    }
    public static void main(String[] args)
    {
        SizeOfTree tree = new SizeOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("\nsize of tree is " +tree.size(tree.root));


    }
}
