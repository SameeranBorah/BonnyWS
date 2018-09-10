package com.assignment;
import java.util.LinkedList;
import java.util.Queue;
class BST2 {


    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public boolean isFullTree(Node node)
    {
        if(node == null)
            return true;

        if(node.left == null && node.right == null )
            return true;

        if((node.left!=null) && (node.right!=null))
            return (isFullTree(node.left) && isFullTree(node.right));

        return false;
    }
    public boolean isCompleteBT(Node root)
    {
        if(root == null)
            return true;

        Queue<Node> queue =new LinkedList<>();

        boolean flag = false;

        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp_node = queue.remove();

            if(temp_node.left != null)
            {

                if(flag == true)
                    return false;

                queue.add(temp_node.left);
            }
            else
                flag = true;

            if(temp_node.right != null)
            {

                if(flag == true)
                    return false;

                queue.add(temp_node.right);

            }
            else
                flag = true;
        }
        return true;
    }
    public int heightOfBinaryTree(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            return 1 +
                    Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
        }
    }
    public int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (root.left==null&&root.right==null) {
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }
    public int countNode(Node root){
        if (root == null) {
            return 0;
        }
        return 1+countNode(root.left)+countNode(root.right);
    }

   public void isPerfect(Node root){
        if(countLeaves(root)==Math.round(Math.pow(2,(heightOfBinaryTree(root)-1)))){
           System.out.println("Perfect BT: Yes");
       }
       else
            System.out.println("Perfect BT: No");
    }

    static int count=0;
    public Node insertIterative(Node root, int key) {
        Node curr = root;

        Node parent = null;

        if (root == null) {
            return new Node(key);
        }

        while (curr != null) {
            parent = curr;

            if (key < curr.data) {
                curr = curr.left;
                //count++;
            } else {
                curr = curr.right;
                //count++;
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
public class assign7 {
    void permute(String str, int l,int r)
    {
        if(l==r){
            System.out.println("\n"+str);
            int[] intArray = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                intArray[i] = Character.digit(str.charAt(i), 10);
            }
            BST2 b= new BST2();
            Node root=null;
            for (int i = 0; i < str.length(); i++) {


                root=b.insertIterative(root,intArray[i]);

            }
           // b.inorder(root);
            b.isPerfect(root);
           if(b.isCompleteBT(root)){
               System.out.println("Complete BT: Yes");
           }
           else
               System.out.println("Complete BT: No");
            if(b.isFullTree(root)){
                System.out.println("Full BT: Yes");
            }
            else
                System.out.println("Full BT: No");
            //constructBST(intArray);

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
        String str="1234";

        assign7 ptr = new assign7();
        ptr.permute(str,0,str.length()-1);

    }

}

