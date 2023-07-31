/*
You are given an array nums consisting of positive integers.
We call a subarray of an array complete if the following condition is satisfied:
The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.
https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/
TC: O(n*n)
SC: O(n*n)
*/

package LeetcodeContests.WeeklyContest356;
import java.util.*;

public class CountCompleteSubarrays {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 2, 2};
        System.out.println(countCompleteSubarrays(nums));
    }

    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<n; i++)                           //[1]
        {
            set.add(nums[i]);
        }
        int l = set.size();
        int count = 0;
        for(int i = 0; i<n; i++)                           //[2]
        {
            Set<Integer> s = new HashSet<>();
            for(int j = i; j<n; j++)
            {
                s.add(nums[j]);
                if(s.size() == l)
                {
                    count++;
                }
            }
        }
        return count;
    }
}

/*
In this solution, we have to find the total number of subarrays which contain the distinct elements present in the entire array.
Since the constraints allow us to have n*n complexities, we resolve to the brute force approach.

[1] all the elements from the array are added to the set, as it can contain only distinct values.
 We then save its size to confirm the number of distinct elements.
[2] we use the brute force approach to iterate through each subarray and add the values of subarray to a new set.
If the size of the new set is equal to the number of distinct elements,
the count is incremented as it means that the current subarray is a complete subarray.
*/