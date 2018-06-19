package com.codes.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatation {

        static void longestSubstring2(String inputString)
        {
            //Convert inputString to charArray

            char[] charArray = inputString.toCharArray();

            //Initialization

            String longestSubstring = null;

            int longestSubstringLength = 0;

            //Creating LinkedHashMap with characters as keys and their position as values.

            LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>();

            //Iterating through charArray

            for (int i = 0; i < charArray.length; i++)
            {
                char ch = charArray[i];

                //If ch is not present in charPosMap, adding ch into charPosMap along with its position

                if(!charPosMap.containsKey(ch))
                {
                    charPosMap.put(ch, i);
                }

                //If ch is already present in charPosMap, reposioning the cursor i to the position of ch and clearing the charPosMap

                else
                {
                    i = charPosMap.get(ch);

                    charPosMap.clear();
                }

                //Updating longestSubstring and longestSubstringLength

                if(charPosMap.size() > longestSubstringLength)
                {
                    longestSubstringLength = charPosMap.size();

                    longestSubstring = charPosMap.keySet().toString();
                }
            }

            System.out.println("Input String : "+inputString);

            System.out.println("The longest substring : "+longestSubstring);

            System.out.println("The longest Substring Length : "+longestSubstringLength);
        }
    static private void longestSubstring(String str){
        char ch[]=str.toCharArray();
        int length=0;
        String max="null";
        Map<String,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<str.length();i++) {
            if (!mp.containsKey(String.valueOf(ch[i]))) {
                mp.put(String.valueOf(ch[i]), i);
            } else{
                i = mp.get(String.valueOf(ch[i]));
                mp.clear();
            }
            if(mp.size()>length){
                length=mp.size();
                max=mp.keySet().toString();
            }

        }
        System.out.println("Size of max string "+length);
        System.out.println("max string is"+max);
    }

    public static void main(String[] args) {
        longestSubstring("longestsubstringswithoutrepeating");
        longestSubstring2("longestsubstringswithoutrepeating");
    }
}
