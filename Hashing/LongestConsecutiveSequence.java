/*
Given an unsorted array of integers arr, return the length of the longest consecutive elements sequence.
https://leetcode.com/problems/longest-consecutive-sequence/
TC: O(n)
SC: O(n)
 */

package Hashing;
import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longest = 0;
        int count = 0;
        for(int i = 0; i<arr.length; i++)
        {
            map.put(arr[i], false);                                     //[1]
        }
        for(int i = 0; i<arr.length; i++)
        {
            if( !map.containsKey( arr[i]-1 ) && !map.get( arr[i] ) )    //[2]
                {
                    for(int j = arr[i]; ; j++)
                    {
                        if( map.containsKey(j) )
                        {
                            map.put(j, true);
                            count++;
                        }
                        else                                            //[3]
                        {
                            if( longest < count )
                            {
                                longest = count;
                            }
                            count = 0;
                            break;
                        }
                    }
                }
        }
        return longest;
    }
}

/*
This solution uses hashmap to find the longest consecutive sequence.
To find if an element is the starting point of a consecutive sequence: if arr[i]-1 is not present in the hashmap, it’ll be the starting point.
[1] populate the map with arr elements and value as false.
[2] start traversing the array while checking if arr[i] is the starting element.
If it is, keep finding its successors, while marking them as true. Once they are all found, input their length in the given variable.
[3] if the successors are not found, or if no more successors are found then the next element of the array is checked- if it is the starting point or not.
If it is, the entire process is repeated. If it is not, the next element in the array is checked.
 */



