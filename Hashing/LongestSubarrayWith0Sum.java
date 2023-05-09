/*
Given an array having both positive and negative integers.
The task is to compute the length of the largest subarray with sum 0.
https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/
TC: O(n)
SC: O(n)
*/

package Hashing;
import java.util.*;

public class LongestSubarrayWith0Sum {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {-1, 1, -1, 1};
        System.out.println(maxLen(arr, n));
    }

    static int maxLen(int arr[], int n)
    {
        int count = 0, maxCount = 0;
        for(int i = 1; i<n; i++)
        {
            arr[i] += arr[i-1];                                   //[1]
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);                                           //[3]
        for(int i = 0; i<n; i++)
        {
            if(map.containsKey(arr[i]))                           //[2]
            {
                count = i - map.get(arr[i]);
                maxCount = count > maxCount ? count : maxCount;
            }
            else           //stores prefix sum and the first occurence pf the prefix sum
            {
                map.put(arr[i], i);
            }
        }
        return maxCount;
    }
}

/*
This solution uses prefix sum and hashmap to calculate the length of the longest subarray whose sum is 0.
[1] computation of prefix sum is done.
[2] if arr[i] is not found in hashmap: enter the prefix sum(arr[i]) into the hashmap, along with its first occurrence.
If it is found, subtract the current index with arr[i]'s first occurrence. Then compare it with the max length found till now.
[3] this statement is used in the case where the subarray starts from index 0: where the sum of initial elements is 0.
Without this statement, the code would fail to detect such a subarray because the prefix sum array would not contain the value 0 as a key.
*/