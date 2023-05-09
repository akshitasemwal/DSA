/*
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.
https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n)
SC: O(n)
*/

package Hashing;
import java.util.*;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10 , 2, -2, -20, 10};
        int k = -10;
        int n = 5;
        System.out.println(findSubArraySum(arr, n, k));
    }

    static int findSubArraySum(int arr[], int n, int k)
    {
        int count = 0;
        for(int i = 1; i<n; i++)
        {
            arr[i] += arr[i-1];       //creates prefix sum
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);                                  //[3]
        for(int i = 0; i<n; i++)
        {
            if(map.containsKey( arr[i] ))               //[1]
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i], 1);
            }
            if(map.containsKey( arr[i] - k ))           //[2]
            {
                count += map.get(arr[i]-k);
            }
        }
        return count;
    }
}

/*
This solution is similar to 'argest subarray with 0 sum' in terms of using prefix sum, and creating a hashmap on the go.
[1] if the prefix sum utill the current element is not present in the map, it is added in the map. If it is present, its frequency is increased.
[2] let s be the prefix sum till the current element, and the required sum of the subarray be k. Then the sum from 0th index to the subarray will be s - k.
( s - k ) + k = s
if ( s - k ) is present in the map, it means that the sum of the subarray is k. We will then increment the counter by the frequency of (s-k) in the map,i.e.,
increment it by the number of times there existed a subarray with sum k.
Because the hashmap is populated while traversal, it will ensure that we are checking only the subarrays which we have traversed till now.
[3] this is done to ensure that the subarrays who start from index 0 are also calculated because then s - k = 0, as s will be equal to k.
*/
