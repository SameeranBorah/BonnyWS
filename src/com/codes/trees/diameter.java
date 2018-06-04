package com.codes.trees;

public class diameter extends depth {
    Node root;
    diameter(){
        root=null;
    }
    int diameterr(Node node){
        if(node==null)
            return 0;
        /*else {
            int lheight = height(node.left);
            int rheight = height(node.right);
            int ldiameter = diameterr(node.left);
            int rdiameter = diameterr(node.right);
            return Math.max((Math.max(lheight,rheight))+1,(Math.max(ldiameter,rdiameter)));
        }*/
        else {
            int lheight = depth(node.left);
            int rheight = depth(node.right);
            int ldiameter = diameterr(node.left);
            int rdiameter = diameterr(node.right);
            return Math.max((Math.max(lheight,rheight))+1,(Math.max(ldiameter,rdiameter)));
    }
    }
    /*static int height(Node node)
    {
        if(node==null)
            return 0;
        else
            return 1+Math.max(height(node.left),height(node.right));
    }*/
    public static void main(String[] args)
    {
        diameter tree = new diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("\ndiameter of binary tree is " +tree.diameterr(tree.root));


    }
}
