/*
You are given an integer array nums and an integer k.
Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions.
If no subarray meets the conditions, return 0.
https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
SC: O(n)
TC: O(n)
*/

package SlidingWindow.FixedWindow;
import java.util.*;

public class MaxSumOfDistinctSubarraysWithSizeK {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSubarraySum(arr, k));
    }

    public static long maximumSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long max = 0;
        int i = 0;
        int j = 0;
        while(j < arr.length)
        {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);       //[1]
            sum += arr[j];
            if (j - i + 1 == k)                                                //[2]
            {
                if (map.size() == k)
                {
                    max = Math.max(max, sum);
                }
                sum -= arr[i];
                map.put(arr[i], map.get(arr[i])-1);
                if (map.get(arr[i]) == 0)
                {
                    map.remove(arr[i]);
                }
                i++;
            }
            j++;
        }
        return max;
    }
}

/*
This problem is a mix of max subarray sum, and count of subarrays having distinct k characters.
[1] this loop enters the frequency of each character present in the array, into a map.
This step is done to later check if the elements in the window are distinct or not.
Next, we add the elements to the variable sum.

[2] if the size of the window equals k, we will now have to do 2 operations:
-> calculating the result
If the size of the map is equal to k, it means that the elements in the window are distinct.
Now, we just have to check if the sum of this subarray is max or not.

-> sliding the window forward by 1 index, and hence removing the effect of the ith index.
We first remove the ith number from the given map. We do so by subtracting its frequency.
If this step results in frequency becoming <= 0,
it means that the number at ith index was unique and it can simply be removed from the map.
Next we subtract the element at ith index from the sum, so that it contains the sum of the current window only.
*/