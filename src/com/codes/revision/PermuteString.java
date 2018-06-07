package com.codes.revision;

public class PermuteString {
    public static void permute(String str,int l,int r){
        if(l==r)
            System.out.println(str);
        for(int i=l;i<=r;i++){
            str=swap(str,l,i);
            permute(str,l+1,r);
            str=swap(str,l,i);
        }

    }
    static String swap(String str, int l, int r){
        char[] ch=str.toCharArray();
        char temp=ch[l];
        ch[l]=ch[r];
        ch[r]=temp;

        return String.valueOf(ch);


    }

    public static void main(String[] args) {
        permute("ABC",0,2);
    }
}
