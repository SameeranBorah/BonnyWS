package com.codes.strings;

public class ReverseString {
    public static void main(String[] args) {
        Box b1 = new Box();
        String str1="";
        int length= b1.str.length();
        char crr[]=b1.str.toCharArray();
        for(int i=length-1;i>=0;i--)
        {
            str1=str1+crr[i];
        }
        System.out.println(str1);

        StringBuilder sb = new StringBuilder("Hi how are you?");
        System.out.println(sb);


    }
    static class Box{
        String str="i am a string";
    }
}