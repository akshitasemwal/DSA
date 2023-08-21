/*
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
https://leetcode.com/problems/longest-increasing-subsequence/description/
TC: O(n*n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class LIS {
    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 7, 9, 1};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] LIS = new int[n];                //stores the LIS uptill each index
        Arrays.fill(LIS, 1);               //the array is filled with 1 since
        for(int i = 1; i<n; i++)               //[1]
        {
            for(int j = 0; j<i; j++)
            {
                if(arr[i] > arr[j])
                {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(LIS));
        int l = 0;
        for(int i = 0; i<n; i++)
        {
            l = Math.max(l, LIS[i]);
        }
        return l;
    }
}

/*
[1] iterate through the array starting from the second element (i = 1):
For each element at index i, iterate through all elements before it (indices j from 0 to i-1).

Check if the element at index i is greater than the element at index j.
If it is, it means that the current element can be included in the LIS ending at index i.
Update the value at index i in the LIS array to be the maximum of its current value and LIS[j] + 1.
This ensures that we consider the longest sequence possible by adding the current element to the LIS ending at index j.
*/