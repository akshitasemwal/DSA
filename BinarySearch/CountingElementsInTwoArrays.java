/*
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates.
For each element in arr1[] count elements less than or equal to it in array arr2[].
https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1?page=1&category[]=Binary%20Search&sortBy=submissions
TC: O(n log m) n = size of arr1, m = size of arr2
SC: O(m)
*/

package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingElementsInTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 7, 9 };
        int[] arr2 = { 0, 1, 2, 1, 1, 4 };
        System.out.println(countEleLessThanOrEqual(arr1, arr2));
    }

    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[])
    {
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<arr1.length; i++)                //[1]
        {
            int target = arr1[i];
            int l = 0;
            int r = arr2.length - 1;
            int mid = l + ( r - l ) / 2;
            while( l <= r )                               //[2]
            {
                mid = l + ( r - l ) / 2;
                if( target >= arr2[mid] )
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            list.add(l);
        }
        return list;
    }
}

/*
Since the problem wants us to calculate the number of elements in arr2, less than or equal to each number in arr1,
we can use the upperbound technique of binary search to find the number of elements, store them in a list, and return it.

[1] traversing each element of arr1, and storing it in a variable called target.
[2] for each target, we run a binary search algorithm to find the no. of elements less than or equal to it.
The upperbound technique is used to do so, after sorting the second array since it can only be implemented on monotonic functions.
All the possible candidates for number of values is stored in l, which is stored in an araylist.
If the target is greater than or equal to arr2[mid], then l is updated as the required number of elements can now go upto right side of mid.
Otherwise, the r pointer is updated.
*/