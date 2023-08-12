/*
Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
If there is no possible substring then print -1.
https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
TC: O(n)
SC: O(n)
*/

package SlidingWindow.VariableWindow;
import java.util.*;

public class LongestKUniqueCharacterSubstring {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestkSubstr(s, k));  //"cbebebe" is the longest substring with 3 distinct characters.
    }
    public static int longestkSubstr(String s, int k) {
        int i = 0;
        int j = 0;
        int l = 0;
        int max = -1;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();   //to store the frequency of the characters
        while( j < n )
        {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1); //add the current character's frequency to the map
            if(map.size() == k)                     //[1]
            {
                l = j - i + 1;
                max = Math.max(l, max);
            }
            if(map.size() > k)                      //[2]
            {
                while(map.size() > k)
                {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                    if(map.get(s.charAt(i))<=0)
                    {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}

/*
In variable sliding window, instead of doing all the calculations when the window size == k,
here we make sure that the required condition is met.
And then, if the condition is surpassed, the window is made smaller from the left.

[1] map contains all the distinct characters with their respective frequencies.
If the size of map equals k, it means the window contains k distinct characters with variable frequencies.
The size of the window( j - i + 1 ) is stored and compared with max value.

[2] if the size of the map is greater than k, it means the map contains extra characters,
which can be removed by shortening the window.
While the size is greater than k, all the extra characters are removed from map if their frequency becomes 0.

The window is moved forward from right and then the max variable is returned.
*/