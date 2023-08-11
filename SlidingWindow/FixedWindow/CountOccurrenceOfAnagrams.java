/*
Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
TC: O(n)
SC: O(1)
*/

package SlidingWindow.FixedWindow;
import java.util.*;

public class CountOccurrenceOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(pat, txt));
    }

    static int search(String pat, String txt) {
        int n = txt.length();
        int k = pat.length();
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Character, Integer> mapPat = new HashMap<>();
        Map<Character, Integer> mapTxt = new HashMap<>();
        for(int l = 0; l<k; l++)                                                               //[1]
        {
            mapPat.put(pat.charAt(l), mapPat.getOrDefault(pat.charAt(l), 0) + 1);
        }
        while( j < n )
        {
            mapTxt.put(txt.charAt(j), mapTxt.getOrDefault(txt.charAt(j), 0) + 1);   //[2]
            if(j - i + 1 == k)                                                                 //[3]
            {
                if(mapTxt.equals(mapPat))
                {
                    count++;
                }
                mapTxt.put(txt.charAt(i), mapTxt.getOrDefault(txt.charAt(i), 0) - 1);
                if(mapTxt.get(txt.charAt(i)) <= 0)
                {
                    mapTxt.remove(txt.charAt(i));
                }
                i++;
            }
            j++;
        }
        return count;
    }
}

/*
This solution uses sliding window approach and hashmaps, to calculate the no. of anagrams of a given string pat.
This problem is not a direct sliding window problem, since no window size is given directly.
On understanding the qn further, we realize that the size of the string pat, which acts as the source of the anagrams,
is to be taken as the fixed window size because we need to find the anagrams as substrings, and hence they should be of the same size.

[1] this loop enters the frequency of each character present in the string pat, into a map.
We can directly use the frequency as we just need an anagram of the string.

[2] this statement enters the jth character of the string txt into the map.

[3] if the size of the window equals k, we will now have to do 2 operations:
-> calculating the result
if the mapTxt and mapPat have equal frequency for all the characters present in them,
it means the window contains an anagram and the count can be increased.

-> sliding the window forward by 1 character, and hence removing the effect of the ith index.
We first remove the ith character from the given map. We do so by subtracting its frequency.
If this step results in frequency becoming <= 0,
it means that the character at ith index was unique and it can simply be removed from the mapTxt.

Next, we increase the i and j counter, to move the window forward by 1 step.
*/