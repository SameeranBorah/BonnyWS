package com.assignment;
import java.util.*;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;


    Node buildTree(int inorder[], int start, int end, Node node)
    {
        if (start > end)
            return null;

        int i = mid(inorder, start, end);

        node = new Node(inorder[i]);
        if (start == end)
            return node;

        node.left = buildTree(inorder, start, i - 1, node.left);
        node.right = buildTree(inorder, i + 1, end, node.right);

        return node;
    }


    int mid(int arr[], int strt, int end)
    {

        return (strt+end)/2;
    }

    public void printInorder(Node root) {

        if(root == null)
            return;

        Stack<Node> s = new Stack<>();
        Node currentNode=root;

        while(!s.empty() || currentNode!=null){

            if(currentNode!=null)
            {
                s.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                Node n=s.pop();
                System.out.printf("%d ",n.data);
                currentNode=n.right;
            }
        }
    }
    void printPreorder(Node node) {

        if (node == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);


        while (!nodeStack.empty()) {

            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }
     void printPostorder(Node root)
    {
        Stack<Node> s1, s2;
        s1 = new Stack<>();
        s2 = new Stack<>();

        if (root == null)
            return;

        s1.push(root);

        while (!s1.isEmpty())
        {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        while (!s2.isEmpty())
        {
            Node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();


        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode = tree.buildTree(inorder, 0, len - 1, tree.root);

        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(mynode);
        System.out.println("\nPreorder traversal of the constructed tree is ");
        tree.printPreorder(mynode);
        System.out.println("\nPostorder traversal of the constructed tree is ");
        tree.printPostorder(mynode);
    }
}