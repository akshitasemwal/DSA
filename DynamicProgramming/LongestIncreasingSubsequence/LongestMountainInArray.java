/*
Given an integer array arr, return the length of the longest subarray, which is a mountain.
Return 0 if there is no mountain subarray.
https://leetcode.com/problems/longest-mountain-in-array/description/
TC: O(n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class LongestMountainInArray {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(nums));
    }

    public static int longestMountain(int[] arr) {
        int n = arr.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        for(int i = 1; i<n; i++)
        {
            if( arr[i-1] < arr[i])
            {
                LIS[i] = LIS[i] + LIS[i-1];
            }
        }

        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);
        for(int i = n-2; i>=0; i--)
        {
            if( arr[i+1] < arr[i])
            {
                LDS[i] = LDS[i] + LDS[i+1];
            }
        }

        int[] bitonic = new int[n];
        int max = 0;
        for(int i = 0; i<n; i++)
        {
            bitonic[i] = LIS[i] + LDS[i] - 1;
            if( LDS[i] == 1 || LIS[i] == 1 )
            {
                continue;
            }
            max = Math.max(max, bitonic[i]);
        }
        return max;
    }
}

/*
[1] if either LIS[i] or LDS[i] is 1, it means that the element at index i is the only element in either the increasing or decreasing subsequence.
In this case, the element alone cannot form a bitonic sequence,
so we continue to the next iteration as this ensures there are atleast 2 elements in both inc and dec sequences.
*/
