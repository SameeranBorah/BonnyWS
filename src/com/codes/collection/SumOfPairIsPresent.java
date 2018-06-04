package com.codes.collection;

import java.util.HashSet;
import java.util.Set;

public class SumOfPairIsPresent {
    static void findSum(int arr[])
    {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            int temp = 10 - arr[i];
            if (temp >= 0 && set.contains(temp)) {
                System.out.println("(" + arr[i] + ", " + "" + temp + ")");

            }
            set.add(arr[i]);
        }
        System.out.println(""+set);
    }


    public static void main(String[] args) {
        SumOfPairIsPresent sum = new SumOfPairIsPresent();
        int arr[]={2,4,5,3,7,8,6};
        findSum(arr);
    }
}
