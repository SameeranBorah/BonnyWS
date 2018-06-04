package com.codes.collection;
import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrl= new ArrayList<>();

        arrl.add(1);
        arrl.add(4);

        System.out.println(arrl);
        Integer[] arr= new Integer[arrl.size()];
        arr= arrl.toArray(arr);
        for(Integer x:arr)
            System.out.println(x);
    }
}
