package com.assignment;

import java.util.Scanner;

public class assign92_21 {
    public static void main(String[] args)
    {

        System.out.println("Enter the height of the BST :");
        Scanner sc1=new Scanner(System.in);
        int height=sc1.nextInt();
        System.out.println("Enter the number of nodes in BST :");
        Scanner sc2=new Scanner(System.in);
        int node=sc2.nextInt();
        int newHeight=height+1;
        int maxNode=(int) Math.pow(2,newHeight)-1;
        int minNode= minNode(height);

        if(minNode<=node && maxNode>=node)
        {
            System.out.println("Whether the BST is AVL: Yes\n");
        }
        else
        {
            System.out.println("Whether the BST is AVL: No\n");
        }
    }
    public static  int minNode(int height)
    {
        if(height<0)
            return 0;
        int x=1;
        int y=2;
        int z;
        for(int i=1;i<height;i++){
            z=x+y+1;
            x=y;
            y=z;
        }
        return y;
    }
}
