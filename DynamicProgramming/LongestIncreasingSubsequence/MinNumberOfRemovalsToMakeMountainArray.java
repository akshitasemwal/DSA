/*
Given an integer array nums, return the minimum number of elements to remove to make nums a mountain array.
https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description/
TC: O(n*n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class MinNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minimumMountainRemovals(nums));
    }
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];
        int[] bitonic = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        int max = 0;

        //LIS
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if( nums[i] > nums[j] )
                {
                    LIS[i] = Math.max( LIS[i], LIS[j] + 1 );
                }
            }
        }

        //LDS
        for(int i = n-1; i>=0; i--)
        {
            for(int j = n-1; j>=i; j--)
            {
                if( nums[i] > nums[j] )
                {
                    LDS[i] = Math.max( LDS[i], LDS[j] + 1 );
                }
            }
        }

        //Bitonic
        for(int i = 0; i<n; i++) {
            bitonic[i] = LIS[i] + LDS[i] - 1;
            if (LDS[i] == 1 || LIS[i] == 1)           //[1]
            {
                continue;
            }
            max = Math.max(max, bitonic[i]);
        }
        return n - max;
    }
}

/*
Similar to longest bitonic subsequence, as mountain array is a purely bitonic sequence:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

[1] if either LIS[i] or LDS[i] is 1, it means that the element at index i is the only element in either the increasing or decreasing subsequence.
In this case, the element alone cannot form a bitonic sequence,
so we continue to the next iteration as this ensures there are atleast 2 elements in both inc and dec sequences.

We return the no. of elements that are not a part of the bitonic sequence.
*/