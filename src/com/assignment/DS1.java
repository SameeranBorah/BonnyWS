package com.assignment;
import java.util.Arrays;
import java.util.Scanner;

public class DS1 {
    public static int[] increment(int[] A) {
        int count=0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1)
                count = count + 1;
        }
        while(true) {
            boolean carry = true;
            for (int i = (A.length - 1); i >= 0; i--) {
                if (carry) {
                    if (A[i] == 0) {
                        A[i] = 1;
                        carry = false;
                    } else {
                        A[i] = 0;
                        carry = true;
                    }
                }
            }
            int count1=0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 1)
                    count1 = count1 + 1;
            }
            if(count==count1)
                return A;
        }
    }
    public static int[] increment2(int[] A) {
        boolean carry = true;
            for (int i = (A.length - 1); i >= 0; i--) {
                if (carry) {
                    if (A[i] == 0) {
                        A[i] = 1;
                        carry = false;
                    } else {
                        A[i] = 0;
                        carry = true;
                    }
                }
            }

                return A;

    }



    private static int[] convertInt2Array(String s)  {
        int[] intArray = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            intArray[i] = Character.digit(s.charAt(i), 10);
        }
        return intArray;

    }


    public static void main(String[] args)
    {
        Scanner in1 = new Scanner(System.in);

        System.out.print("Enter assignment's number: ");

        int Number;

        Number = in1.nextInt();

        switch (Number) {

            case 1:

                String binary1;
                Scanner in = new Scanner(System.in);

                System.out.print("Input the binary number: ");
                binary1 = in.nextLine();
                String check=binary1;
                int one = check.length() - check.replaceAll("1", "").length();
                if(one==binary1.length())
                    System.out.println("max bit, can't increment");
                int arr[];
                arr= Arrays.copyOf(increment(convertInt2Array(binary1)),increment(convertInt2Array(binary1)).length);
                StringBuilder builder = new StringBuilder();
                for (int i : arr) {
                    builder.append(i);
                }
                String text = builder.toString();
                System.out.println(text);
                break;


            case 2:
                String binary2;
                Scanner in2 = new Scanner(System.in);

                System.out.print("Input the binary number: ");
                binary2 = in2.nextLine();
                String check1=binary2;
                int one1 = check1.length() - check1.replaceAll("1", "").length();
                if(one1==binary2.length())
                    System.out.println("max bit, can't increment");
                int arr2[];
                arr2= Arrays.copyOf(increment2(convertInt2Array(binary2)),increment2(convertInt2Array(binary2)).length);
                StringBuilder builder1 = new StringBuilder();
                for (int i : arr2) {
                    builder1.append(i);
                }
                String text1 = builder1.toString();
                System.out.println(text1);
                break;


            default:
                System.out.println("Invalid response");
        }

    }
}