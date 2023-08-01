/*
An array arr is a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
You must solve it in O(log(arr.length)) time complexity.
https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2 };
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int mid = l + ( r - l ) / 2;
        int num = 0;
        while( l<=r)
        {
            mid = l + ( r - l ) / 2;
            if( arr[mid] < arr[mid + 1])
            {
                l = mid + 1;
            }
            if( arr[mid] > arr[mid + 1])
            {
                r = mid - 1;
            }
        }
        return l;
    }
}

/*
[1] if the current mid element is lesser than the element next to it, it means the mid is on the left of the peak element,
and the left part of the mid can be neglected. Hence, the l pointer is updated.
[2] vice versa for the right pointer.

Since, l can be a possible solution because, for example, in the array : 1 3 4 5 2 1, if mid is at 4, l is updated to be 5.
*/