package com.codes.trees;

public class TraversalOfTree {

        Node root;
        TraversalOfTree(){
            root=null;
        }
        void inorder(Node node){
            if (node==null)
                return;
            else{
                inorder(node.left);
                System.out.println(node.key + " ");
                inorder(node.right);
            }
        }
        public static void main(String[] args)
        {
            TraversalOfTree tree = new TraversalOfTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);


            System.out.println("\nInorder traversal of binary tree is ");
            tree.inorder(tree.root);


        }
    }


