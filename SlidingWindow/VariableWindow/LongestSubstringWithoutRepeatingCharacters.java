/*
Given a string s, find the length of the longest substring without repeating characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
TC: O(n*k)
SC: O(n)
*/

package SlidingWindow.VariableWindow;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.print(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        while( j < n )
        {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);  //frequency of each character
            if(map.size() == (j - i + 1))                                  //[1]
            {
                max = Math.max(max, map.size());
            }
            else if(map.size() < (j - i + 1))                              //[2]
            {
                while(map.size() < (j - i + 1))
                {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                    if(map.get(s.charAt(i)) < 1)
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
[1] if the size of the map equals the size of the current window, it means that the window contains only unique characters.
The size of the map or window can be compared with the max size stored till now.

[2] if the size of the map is less than that of the window, it means that the window contains duplicate elements,
whose frequency has been increased in the hashmap.
So, we reduce the size of the window, and side by side remove the elements from the hashmap,
which are not a part of the window anymore.
Once the size of the hashmap equals the size of the window, the window size is increased and the process is continued.
*/