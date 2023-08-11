/*
A string is good if there are no repeated characters.
Given a String s, return the number of good substrings of length k in s.
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
TC: O(n)
SC: O(n)
*/

package SlidingWindow.FixedWindow;
import java.util.*;

public class CountOfSubstringsHavingKDisinctCharacters {
    public static void main(String[] args) {
        String s = "aababcabc";
        int k = 3;
        System.out.println(countGoodSubstrings(s, k));
    }

    public static int countGoodSubstrings(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while ( j < n )
        {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);       //[1]
            if( j - i + 1 == k )                                                         //[2]
            {
                if( map.size() == k )
                {
                    count++;
                }
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if(map.get(s.charAt(i)) <= 0)
                {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return count;
    }
}

/*
This approach uses sliding window technique and a hashmap, to calculate the substrings such that it contains all distinct characters.

[1] this loop enters the frequency of each character present in the string s, into a map.

[2] if the size of the window equals k, we will now have to do 2 operations:
-> calculating the result
We check if the size of the map for the current window equals k.
If it does, it means that the window consists of k distinct characters and the count variable can be increased.

-> sliding the window forward by 1 character, and hence removing the effect of the ith index.
We first remove the ith character from the given map. We do so by subtracting its frequency.
If this step results in frequency becoming <= 0,
it means that the character at ith index was unique and it can simply be removed from the map.

Next, we increase the i and j counter, to move the window forward by 1 step.
*/