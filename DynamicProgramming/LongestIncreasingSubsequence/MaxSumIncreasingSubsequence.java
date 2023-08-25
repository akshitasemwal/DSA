/*
Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that
the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.
https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n*n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;

public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        int n = 5;
        System.out.println(maxSumIS(arr, n));
    }

    public static int maxSumIS(int arr[], int n)
    {
        int[] LIS = new int[n];
        for(int i = 0; i<n; i++)
        {
            LIS[i] = arr[i];
        }
        int max = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0;j<i; j++)
            {
                if( arr[i] > arr[j] )             //[1]
                {
                    LIS[i] = Math.max(LIS[i], arr[i] + LIS[j]);
                }
            }
            max = Math.max(LIS[i], max);
        }
        return max;
    }
}

/*
This problem is based on LIS since we have to find the max sum of an increasing subsequence.
[1] we traverse the given array like we do in conventional LIS problem and check if the current element
is greater than the older elements. If it is, we can update the value of sum of the current element in the LIS array.
This is done by checking if the sum in the LIS[i] is greater than or lesser to the sum of LIS[j],
which contains the sum of the longest increasing subsequence till the jth index.
*/