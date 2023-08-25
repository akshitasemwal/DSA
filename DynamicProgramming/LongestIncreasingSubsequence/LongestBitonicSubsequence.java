/*
Given an array of positive integers. Find the maximum length of Bitonic subsequence.
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
TC: O(n*n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(LongestBitonicSequence(nums));
    }

    public static int LongestBitonicSequence(int[] nums)
    {
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
        for(int i = n-1; i>=0; i--)           //exactly same as LIS, just traversed in reverse order
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
        for(int i = 0; i<n; i++)
        {
            bitonic[i] = LIS[i] + LDS[i] - 1;
            max = Math.max(max, bitonic[i]);
        }

        return max;
    }
}

/*
Bitonic if it is: increasing / decreasing / increasing then decreasing
bitonic[i] = LIS[i] + LDS[i] - 1

[1]  calculate the length of the bitonic sequence at that index as the sum of the corresponding LIS[i] and LDS[i],
and then subtract 1 to avoid counting the common element twice.
This subtraction of 1 is necessary because the common element at index i is counted twice if we simply add LIS[i] and LDS[i].
Since the bitonic sequence needs to have both increasing and decreasing parts,
we need to exclude the common element from either the LIS or LDS part of the sequence.

We do not need to check if LIS[i]/LDS[i] == 1 as a bitonic sequence need not have both increasing and decreasing elements, unlike the mountains array.
*/
