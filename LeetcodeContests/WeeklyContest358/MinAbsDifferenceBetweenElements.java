/*
You are given a 0-indexed integer array nums and an integer x.
Find the minimum absolute difference between two elements in the array that are at least x indices apart.
In other words, find two indices i and j such that abs(i - j) >= x and abs(nums[i] - nums[j]) is minimized.
Return an integer denoting the minimum absolute difference between two elements that are at least x indices apart.
https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
TC: O(n)
SC: O(n)
*/

package LeetcodeContests.WeeklyContest358;
import java.util.*;

public class MinAbsDifferenceBetweenElements {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 3, 2, 10, 15));
        int x = 1;
        System.out.println(minAbsoluteDifference(nums, x));
    }

    public static int minAbsoluteDifference(List<Integer> nums, int x)
    {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();              //maintains the sorted order or the elements
        for(int i = x; i<n; i++)
        {
            set.add(nums.get(i - x));                        //[1]
            Integer high = set.higher(nums.get(i) - 1);   // returns the smallest element in set that is greater than current element - 1
            if(high != null)
            {
                min = Math.min(Math.abs(high - nums.get(i)), min);
            }
            Integer low = set.lower(nums.get(i) + 1);     //returns the largest element which is smaller then current element +1
            if(low != null)
            {
                min = Math.min(Math.abs(low - nums.get(i)), min);
            }
        }
        return min;
    }
}

/*
This code efficiently uses a TreeSet to keep track of elements within a specific range (a sliding window) and
iteratively finds the closest elements that are greater or smaller than the current element,
calculating the absolute differences and updating the min value accordingly.
The final result is the minimum absolute difference between any element in the list and the given value x.

starting the loop from index x ensures that the sliding window is correctly established and contains the required number of elements
for meaningful comparisons and calculations related to the subsequences of size x.

[1] add the element at (i - x) index to the set. This keeps the size of the set constant at x,
maintaining a sliding window of x elements. This is done so that instead of traversing for the entire array,
we can directly find the high and low valid no. for each index and
calculate the min abs difference between the current number, and its low and high numbers.
*/