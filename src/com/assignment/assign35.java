package com.assignment;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class assign35 {
    public static void main(String[] args) {
        System.out.println("How many questions you want to solve?");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int arr[]=new int[2*i];
        int count=1;
        for(int k=0;k<arr.length;k=k+2){
            System.out.println("enter the first numbers for "+count+" question");
            Scanner scc = new Scanner(System.in);
            arr[k] = scc.nextInt();
            System.out.println("enter the second number for "+count+" question");
            Scanner sc1 = new Scanner(System.in);
            arr[k+1] = sc1.nextInt();
            count++;
        }
        int c1=0;
        int output[]=new int[(2*i)-2];
        for(int l=0;l<arr.length;l++){
            if(l==i || l==i-1){
            }
            else {
                output[c1]=arr[l];
                c1++;
            }

        }
        System.out.println("array");
        for(int l=0;l<output.length;l++){
                System.out.print(""+output[l]+" ");
            }
        System.out.println("");
        System.out.println("queue");
        Queue<Integer> queue = new LinkedList<>();
        for(int l=0;l<output.length;l=l+2){
                queue.add(HCF(output[l],output[l+1]));
        }
        System.out.println(queue);
        System.out.println("stack");
        Stack<Integer> stack = new Stack<>();
        for(int l=0;l<output.length;l=l+2){
            stack.add((output[l]*output[l+1])/(HCF(output[l],output[l+1])));
        }
        System.out.println(stack);
        System.out.println("new array");
        for(int l=0;l<arr.length;l++){
            System.out.print(""+arr[l]+" ");
        }
        System.out.println("");
        System.out.println("new queue");
        Queue<Integer> queue1 = new LinkedList<>();
        for(int l=0;l<arr.length;l=l+2){
            queue1.add(HCF(arr[l],arr[l+1]));
        }
        System.out.println(queue1);
        System.out.println("new stack");
        Stack<Integer> stack1 = new Stack<>();
        for(int l=0;l<arr.length;l=l+2){
            stack1.add((arr[l]*arr[l+1])/(HCF(arr[l],arr[l+1])));
        }
        System.out.println(stack1);
        int c2=0;
        int[] output2=new int[(2*i)-4];
        for(int l=0;l<output.length;l++){
            if(l==0||l==1){
            }
            else {
                output2[c2]=output[l];
                c2++;
            }

        }
        System.out.println("new array");
        for(int l=0;l<output2.length;l++){
            System.out.print(""+output2[l]+" ");
        }
        System.out.println("");
        System.out.println("new queue");
        Queue<Integer> queue2 = new LinkedList<>();
        for(int l=0;l<output2.length;l=l+2){
            queue2.add(HCF(output2[l],output2[l+1]));
        }
        System.out.println(queue2);
        System.out.println("new stack");
        Stack<Integer> stack2 = new Stack<>();
        for(int l=0;l<output2.length;l=l+2){
            stack2.add((output2[l]*output2[l+1])/(HCF(output2[l],output2[l+1])));
        }
        System.out.println(stack2);

    }
    static int HCF(int n1, int n2){
        int gcd=1;
        for(int i = 1; i <= n1 && i <= n2; ++i)
        {
            if(n1 % i==0 && n2 % i==0)
                gcd = i;
        }
        return gcd;


    }
}


