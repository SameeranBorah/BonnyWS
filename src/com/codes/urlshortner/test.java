package com.codes.urlshortner;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class test {
    static void inputUrl(String str) {
        // Creates an empty TreeMap
        TreeMap<String, String> tmap =
                new TreeMap<String, String>();
        tmap.put("www.google.com","go.gl/go");
        tmap.put("www.facebook.com","go.gl/fb");
        tmap.put("www.twitter.com","go.gl/tw");
        tmap.put("www.youtube.com","go.gl/yu");
        tmap.put("www.gmail.com","go.gl/gm");
        if (tmap.containsKey(str))
        {
            System.out.println(""+tmap.get(str));
        }
        else {
            System.out.println("Null");
        }
    }

    // Driver method to test above method
    public static void main (String[] args)
    {
        System.out.println("Enter your url");
        Scanner ss = new Scanner(System.in);
        String s = ss.nextLine();
        inputUrl(s);
    }
}
