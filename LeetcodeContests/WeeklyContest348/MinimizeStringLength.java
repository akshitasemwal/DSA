/*
Given a 0-indexed string s, repeatedly perform the following operation any number of times:
Choose an index i in the string, and let c be the character in position i. Delete the closest occurrence of c to the left of i (if any) and the closest occurrence of c to the right of i (if any).
Your task is to minimize the length of s by performing the above operation any number of times.
Return an integer denoting the length of the minimized string.
https://leetcode.com/problems/minimize-string-length/
TC: O(n)
SC: O(n)
*/

package LeetcodeContests.WeeklyContest348;
import java.util.*;

public class MinimizeStringLength {
    public static void main(String[] args) {
        String s = "dddaaa";
        System.out.println(minimizedStringLength(s));
    }

    public static int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for(int i = 0; i<n; i++)
        {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}

/*
After observing the test cases, we notice that the solution should aim at returning the distinct characters from the given String.
For this, we simply use a set.
*/