/*
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
SC: O(1)
TC: O(n)
*/

package SlidingWindow;
import java.util.*;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(100, 200, 300, 400);
        int k = 2, n = 4;
        System.out.println(maximumSumSubarray(k, arr, n));
    }

    static long maximumSumSubarray(int k, List<Integer> arr,int n){
        long sum = 0;
        long max = Long.MIN_VALUE;
        int j = 0;
        for(int i = 0; i<k; i++)                    //[1]
        {
            sum += arr.get(i);
        }
        max = Math.max(sum, max);
        for(int i = k; i<n; i++)                    //[2]
        {
            sum += arr.get(i) - arr.get(j);
            j++;
            max = Math.max(sum, max);
        }
        return max;
    }
}

/*
This solution uses two pointers to mark the start and end of a sliding window.
[1] we first calculate the sum of the initial window
[2] next, we keep on moving the window ahead by one place- adding arr[i] and subtracting arr[j] from the sum.
We then compare it with max value, for a fixed window size.
*/