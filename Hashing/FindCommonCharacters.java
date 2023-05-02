/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
You may return the answer in any order.

TC: O(n^2)
SC: O(n)
 */

import java.util.*;
public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        commonChars(words);
    }

    public static void commonChars(String[] words) {
        int n = words.length;
        HashMap<Character, Integer> minFreq = new HashMap<>();    //frequency of every character in a word
        String str = words[0];
        for(int i = 0; i < str.length(); i++)
        {
            if(minFreq.containsKey(str.charAt(i)))
            {
                minFreq.put(str.charAt(i), minFreq.get(str.charAt(i)) + 1);
            }
            else
            {
                minFreq.put(str.charAt(i), 1);
            }
        }
        for(int i = 1; i< n; i++)
        {
            str = words[i];
            int m = str.length();
            HashMap<Character, Integer> freq = new HashMap<>();    //min frequency of a character in all the words
            for(int j = 0; j < m; j++)
            {
                if(freq.containsKey(str.charAt(j)))
                {
                    freq.put(str.charAt(j), freq.get(str.charAt(j)) + 1);
                }
                else
                {
                    freq.put(str.charAt(j), 1);
                }
            }

            for( char key : minFreq.keySet())
            {
                if(!freq.containsKey(key))
                {
                    minFreq.put(key, 0);
                }
                if(freq.containsKey(key) && minFreq.get(key) > freq.get(key))
                {
                    minFreq.put(key, freq.get(key));
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(char key : minFreq.keySet())
        {
            for(int i = 0; i < minFreq.get(key); i++)
            {
                String s = "" + key;
                res.add(s);
            }
        }
        System.out.print(res);
    }
}
