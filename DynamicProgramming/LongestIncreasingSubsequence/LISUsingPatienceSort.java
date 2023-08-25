/*
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
TC: O(n log n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class LISUsingPatienceSort {
    public static void main(String[] args) {
        int[] arr = {5,8,3,7,9,1};
        int n = 6;
        System.out.println(longestSubsequence(n, arr));
    }

    static int binarySearch(List<Integer> LIS, int target)
    {
        int l = 0;
        int r = LIS.size() - 1;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if ( LIS.get(mid) <= target )
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        if( l-1 >= 0 && LIS.get(l - 1) == target )
        {
            return l-1;
        }
        return l;
    }

    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[])
    {
        List<Integer> LIS = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            //if it finds the number in LIS, return its index
            //otherwise return the position where the number would be inserted

//            int index = Collections.binarySearch(LIS, arr[i], (a, b) -> (a - b));
//            if( index < 0 )//index not found for curr element
//            {
//                index = -(index + 1);
//            }

            int index = binarySearch(LIS, arr[i]);   //[1]
            if( index == LIS.size() )                //[2]
            {
                LIS.add(arr[i]);
            }
            else
            {
                LIS.set(index, arr[i]);
            }
        }
        return LIS.size();
    }
}

/*
It is called patience sort since we sort all the incoming elements like the deck of cards in solitaire.
But instead of forming columns/stack of cards, we simply replace the topmost element at the particular index it should  have been,
and hence get a sorted array of max size.

[1] the binarySearch function performs a binary search on the LIS list to find the position where the current element should be inserted.
If the element is already present in the LIS, it returns the index of the first occurrence of the element.

[2] if the element is greater than all elements in the LIS, add it to the end of the LIS list.
If the element is not greater than all elements in the LIS, update the value at the calculated index with the current element.
This maintains the sorted nature of the LIS list.
*/