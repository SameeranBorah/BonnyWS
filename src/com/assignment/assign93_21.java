package com.assignment;

import java.util.Scanner;

public class assign93_21 {
    public boolean isPalindrome(String text){
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        return Palindrome(clean,0,clean.length()-1);
    }

    private boolean Palindrome(String text, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if ((text.charAt(forward)) != (text.charAt(backward))) {
            return false;
        }
        if (forward < backward + 1) {
            return Palindrome(text, forward + 1, backward - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        assign93_21 str= new assign93_21();
        String string = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome");
        string = in.nextLine();
        if(str.isPalindrome(string))
            System.out.println("String is Palindrome");
        else{
            System.out.println("String is not Palindrome");
        }
    }
}
