package com.assignment;
import java.util.Scanner;
public class Addition_Binary_Numbers {
    public static void main(String args[]) {
        long binary1, binary2;
        int i = 0, remainder = 0;
        int[] sum = new int[30];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any binary number : ");
        binary1 = sc.nextLong();
        System.out.print("Enter another binary number : ");
        binary2 = sc.nextLong();
        if (isBinary(binary1) && isBinary(binary2)) {
            while (binary1 != 0 || binary2 != 0) {
                sum[i++] = (int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
                remainder = (int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
                binary1 = binary1 / 10;
                binary2 = binary2 / 10;
            }
            if (remainder != 0) {
                sum[i++] = remainder;
            }
            --i;
            System.out.print("Sum of two binary numbers : ");
            while (i >= 0) {
                System.out.print(sum[i--]);
            }
        } else {
            System.out.println("Please enter valid binary number..");
        }

    }
    public static boolean isBinary(long number) {
        while (number != 0) {
            if (number % 10 > 1) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }
}