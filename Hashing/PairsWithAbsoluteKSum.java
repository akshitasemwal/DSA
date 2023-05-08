/*
Given an integer array arr and an integer k, return the number of pairs (i, j) where i < j such that |arr[i] - arr[j]| == k.
https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
TC: O(n)
SC: O(n)
*/

package Hashing;
import java.util.*;

public class PairsWithAbsoluteKSum {
    public static void main(String[] args) {
        int k = 1;
        int[] arr = {1, 2, 2, 1};
        System.out.println(countKDifference(arr, k));
    }

    public static int countKDifference(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr )
        {
            int requiredNumber1 = i + k;
            int requiredNumber2 = i - k;
            if( map.containsKey(i) )                               //[1]
            {
                map.put( i, map.get(i) + 1 );
            }
            else
            {
                map.put( i, 1 );
            }
            if( map.containsKey( requiredNumber1 ) )              //[2]
            {
                count += map.get( requiredNumber1 );
            }
            if( map.containsKey( requiredNumber2 ) )              //[3]
            {
                count += map.get( requiredNumber2 );
            }
        }
        return count;
    }
}

/*
This solution uses hashmap to find the number of pairs such that |arr[i] - arr[j]| == k.
,i.e., the absolute difference between arr[i] and arr[j] is present.
For this, the hashmap isn't already populated with elements as keys because we need to check the frequency, as well as the indices of the element.
To solve this problem, we populate the hashmap while traversing the array.

[1] if map doesnt contain arr[i], then it is inserted into the map along with 1 as its frequency.
If it is found in the map, its frequency is increased.
[2,3] if map contains the required numbers, the frequency of required numbers is added to the count,
as the required numbers appeared before the current element(arr[i]) and they all form individual pairs with the current element.

Can also be done using count sort if the number of elements in less.
*/
