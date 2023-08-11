/*
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
SC: O(1)
TC: O(n)
*/

package SlidingWindow.FixedWindow;
import java.util.*;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(100, 200, 300, 400);
        int k = 2, n = 4;
        System.out.println(maximumSumSubarray(k, arr, n));
    }

    static long maximumSumSubarray(int k, List<Integer> arr,int n){
        long sum = 0;
        long max = 0;
        int i = 0;
        int j = 0;
        while ( j < n )                            //[1]
        {
            sum += arr.get(j);                     //[2]
            if( j - i + 1 == k)                    //[3]
            {
                max = Math.max( sum, max);
                sum -= arr.get(i);
                i++;
            }
            j++;
        }
        return max;
    }
}

/*
This solution uses two pointers to mark the start and end of a sliding window.
This solution is the staple sliding window format.

[1] we run a loop while the end of the window, i.e., the j pointer, doesn't reach the end of the array.

[2] this statement adds the current element to the sum variable

[3] if the size of the window equals k, we will now have to do 2 operations:
-> calculating the result
If the sum of the current window is maximum, it gets stored in the max variable.

-> sliding the window forward by 1 character, and hence removing the effect of the ith index.
Subtract the element at the ith index from sum to remove it from the total sum of the next window.
*/