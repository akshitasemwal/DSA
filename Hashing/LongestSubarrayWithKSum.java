/*
Given an array containing N integers and an integer K.
Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n)
SC: O(n)
*/

package Hashing;
import java.util.*;

public class LongestSubarrayWithKSum {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int n = 6;
        System.out.println(lenOfLongSubarr(arr, n, k));
    }

    public static int lenOfLongSubarr (int arr[], int n, int k) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i<n; i++)
        {
            sum += arr[i];
            if(map.containsKey(sum - k))                       //[1]
            {
                if( max < (i - map.get( sum - k )))
                {
                    max = i - map.get( sum - k );
                }
            }
            if(!map.containsKey(sum))                          //[2]
            {
                map.put(sum, i);
            }
        }
        return max;
    }
}

/*
Sliding window can only be used if all the elements are positive.
Uses hashmap and prefix sum to check if the map contains the subarray with required sum k.
[1] if the hashmap contains prefix sum(till arr[i]) - k(sum of the subarray),
then the difference between the current index, and the first occurrence of ( sum - k ) is compared with max length fund till now.
[2] if hashmap doesnt contain the sum, it'll be added to the map along with its first occurrence,
to calculate the longest length.

If the question requires calculating length -> map contains prefix sum, with its first occurrence.
If the question requires the count of subarrays -> map contains prefix sum, and their frequency.
*/