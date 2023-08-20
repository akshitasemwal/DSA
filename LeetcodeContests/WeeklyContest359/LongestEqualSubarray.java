/*
You are given a 0-indexed integer array nums and an integer k.
A subarray is called equal if all of its elements are equal. Note that the empty subarray is an equal subarray.
Return the length of the longest possible equal subarray after deleting at most k elements from nums.
https://leetcode.com/problems/find-the-longest-equal-subarray/
TC: O(n)
SC: O(n)
*/

package LeetcodeContests.WeeklyContest359;
import java.util.*;

public class LongestEqualSubarray {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 2, 3, 1, 3);
        int k = 3;
        System.out.println(longestEqualSubarray(nums, k));
    }

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int maxFreq = 0;
        int n = nums.size();
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j<n; j++)
        {
            map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);   //[1]
            maxFreq = Math.max( maxFreq, map.get(nums.get(j)));
            if(j - i + 1 - maxFreq > k)                                              //[2]
            {
                map.put(nums.get(i), map.get(nums.get(i)) - 1);
                i++;
            }
        }
        return maxFreq;
    }
}

/*
[1] or each element at index j, increment its frequency in the map
and update maxFreq to be the maximum of its frequency and the current maxFreq.

[2] if the difference between the length of the subarray (j - i + 1) and maxFreq is greater than k,
it means the condition of the problem is not satisfied for the current subarray.
Decrease the frequency of the element at index i in the map and move the start pointer i to the right.
*/
