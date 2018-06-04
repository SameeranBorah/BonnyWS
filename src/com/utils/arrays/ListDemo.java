package com.utils.arrays;

import java.util.*;

public class ListDemo {
    static List<Integer> li = new LinkedList<>();
    static List<Integer> li2 = Arrays.asList(1,2,3,4,5);



    public static void main(String[] args) {
        li.add(1);
        li.add(2);
//        li2.add(3);
//        li.add

        for(int i = 2; i < 20; i++) {
            li.add(i);
        }
        System.out.println(li.get(12));

    }
}
