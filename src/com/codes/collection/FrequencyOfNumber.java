package com.codes.collection;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfNumber {
    static void findFreq(int arr[]) {
        Map<Integer, Integer> list11 = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            Integer count = list11.get(arr[i]);
            if (list11.get(arr[i]) == null) {
                list11.put(arr[i], 1);
            } else {
                list11.put(arr[i], ++count);
            }
        }
        System.out.println(list11);
//        for (Map.Entry m:list11.entrySet()){
//            System.out.println("Frequency of "+m.getKey()+" is "+m.getValue());
//        }

    }

    public static void main(String[] args) {
        FrequencyOfNumber test=new FrequencyOfNumber();
        int arr[]={2,8,7,4,1,9,8,3,4,6,1,9,8,2,2,7,4,5};
        test.findFreq(arr);
    }
}
