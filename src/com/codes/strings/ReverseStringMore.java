package com.codes.strings;

public class ReverseStringMore {
    static void reverse(String str)
    {
        String str1 = str;
        char arr[]= str.toCharArray();
        for (int i=str.length()-1; i>=0; i--)
        {
            System.out.print(""+arr[i]);
        }
    }
    static void reverseBuilder(String str, String str2)
    {
        String str1= str;
        StringBuilder strr = new StringBuilder();
        strr.append(str);
        strr.append(str2);
        strr.reverse();
        System.out.println(strr);
    }


    public static void main(String[] args) {
        ReverseStringMore abc= new ReverseStringMore();
        String str= "i am sameeran";
        String str2= "hello its me";
        abc.reverseBuilder(str,str2);

    }
}
