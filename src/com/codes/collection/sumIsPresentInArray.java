package com.codes.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class sumIsPresentInArray {
    static void findSum(int arr[])
    {
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        boolean found=false;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
                if(set.contains(arr[i]+arr[j])) {
                    found = true;
                    System.out.println("" + arr[i] + "" + arr[j]);
                }
                else
                    found=false;
        }
        if(found==false)
            System.out.println("doesnt contain");
    }


    public static void main(String[] args) {
        sumIsPresentInArray sum = new sumIsPresentInArray();
        int arr[]={1,3,7};
        findSum(arr);
    }
}
