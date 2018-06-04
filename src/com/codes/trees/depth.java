package com.codes.trees;

public class depth {
    Node root;
    depth()
    {
        root=null;
    }
    int depth(Node node){
        if (node==null)
            return 0;
        else{
            int ldepth=depth(node.left);
            int rdepth=depth(node.right);
            if(ldepth>rdepth)
                return ldepth+1;
            else
                return rdepth+1;
        }
    }
    public static void main(String[] args)
    {
        depth tree = new depth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("\nDepth of tree is " +tree.depth(tree.root));


    }
}
