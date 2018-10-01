package com.assignment;

import java.util.Scanner;

public class assign94_21 {
    public static void main(String[] args) {
        int decimalNumber;
        assign94_21 num=new assign94_21();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to convert into binary");
        decimalNumber = in.nextInt();
        num.printBinary(decimalNumber);
    }


     void printBinary(int n) {
        int r;
        if (n <= 1) {
            System.out.print(n);
            return;
        }
        r = n % 2;
        printBinary(n / 2);
        System.out.print(r);
    }
}
