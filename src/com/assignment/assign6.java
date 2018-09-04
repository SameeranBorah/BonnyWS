package com.assignment;


class BST {


    // Function to perform inorder traversal of the tree
    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static int count=0;
    // Iterative function to insert an key into BST.
    // Root is passed by reference to the function
    public Node insertIterative(Node root, int key) {
        // start with root node
        Node curr = root;

        // pointer to store parent node of current node
        Node parent = null;

        // if tree is empty, create a new node and set root
        if (root == null) {
            return new Node(key);
        }

        // traverse the tree and find parent node of key
        while (curr != null) {
            // update parent node as current node
            parent = curr;

            // if given key is less than the current node,
            // go to left subtree else go to right subtree
            if (key < curr.data) {
                curr = curr.left;
                count++;
            } else {
                curr = curr.right;
                count++;
            }
        }


        // construct a new node and assign to appropriate parent pointer
        if (key < parent.data) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }

        return root;
    }
}

public class assign6 {

    void permute(String str, int l,int r)
    {
        if(l==r){
            System.out.println(str);
            int[] intArray = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                intArray[i] = Character.digit(str.charAt(i), 10);
            }
            BST b= new BST();
            Node root=null;
            for (int i = 0; i < str.length(); i++) {


                root=b.insertIterative(root,intArray[i]);

            }
            //b.inorder(root);

            System.out.println("the number of comparision is"+b.count);
            b.count=0;

            // constructBST(intArray);

        }
        for(int i=l;i<=r;i++){
            str=swap(str,l,i);
            permute(str,l+1,r);
            str=swap(str,l,i);
        }
    }
    String swap(String str, int l, int r)
    {
        char ch[]=str.toCharArray();
        char temp=ch[l];
        ch[l]=ch[r];
        ch[r]=temp;
        return String.valueOf(ch);

    }

    public static void main(String[] args) {
        String str="123";

        assign6 ptr = new assign6();
        ptr.permute(str,0,str.length()-1);

    }

}

