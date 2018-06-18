package com.codes.revision;

public class TreeTraversal {
    protected TreeNode root;
    TreeTraversal(){root=null;}
    int count;
    void inOrder(TreeNode root){
        count++;
        if(root==null)
            return;
        else{
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    
    }
    void leavelOrder(TreeNode root){


    }

    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        tree.root= new TreeNode(10);
        tree.root.left=new TreeNode(13);
        tree.root.right= new TreeNode(44);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.inOrder(tree.root);

    }

}
