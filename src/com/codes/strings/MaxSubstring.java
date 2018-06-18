package com.codes.strings;

import java.util.*;

public class MaxSubstring {
    void uniqueStr(String str){
        int n=str.length();
        char ch[]=str.toCharArray();
        List<String> l=new LinkedList<>();
        Map<Integer,String> tmap= new HashMap<>();
        for(int i=0; i<n; i++){
            if(l.contains(String.valueOf(ch[i]))) {
                tmap.put(l.size(), String.valueOf(l));
                l.clear();
                l.add(String.valueOf(ch[i]));
            }
            else{
                l.add(String.valueOf(ch[i]));

            }
        }
        tmap.put(l.size(),String.valueOf(l));
        System.out.println(tmap);

        Collection c = tmap.values();
        System.out.println(Collections.max(c));
    }

    public static void main(String[] args) {
        MaxSubstring m=new MaxSubstring();
        m.uniqueStr("AMSUAWEghjklAOUpI");
    }
}
