package com.codes.trees;

public class leafNodes {
    Node root;

    void leaf(Node node){
        if (node.left==null&& node.right==null)
            System.out.println(node.key + " ");

        else{
            leaf(node.left);
            leaf(node.right);

        }
    }
    public static void main(String[] args)
    {
        leafNodes tree = new leafNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("\n leaf Nodes of binary tree are ");
        tree.leaf(tree.root);


    }
}
