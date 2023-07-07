/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class FirstAndLastPositionOfAnElement {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        searchRange(nums, target);
    }

    public static void searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1, -1};
        int l = 0, r = n-1;
        int mid = l + ( r - l ) /2;
        int first = -1, second = -1;
        first = firstOcc(nums, l, r, mid, target);
        l = 0;
        r = n-1;
        second = secondOcc(nums, l, r, mid, target);
        System.out.println(first + " " + second);
    }

    public static int firstOcc(int[] nums, int l, int r, int mid, int target)
    {
        int first = -1;
        while( l <= r )
        {
            mid = l + ( r - l ) /2;
            if( nums[mid] == target )
            {
                first = mid;
                r = mid - 1;                                    //[1]
            }
            else if( nums[mid] > target )
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return first;
    }

    public static int secondOcc(int[] nums, int l, int r, int mid, int target)
    {
        int second = -1;
        while( l <= r )
        {
            mid = l + ( r - l ) /2;
            if( nums[mid] == target )
            {
                second = mid;
                l = mid + 1;                                   //[2]
            }
            else if( nums[mid] > target )
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return second;
    }
}

/*
This solution uses binary search technique to find the first and last occurrence of a given target.
We use 2 binary search functions for the same, with different conditions: to find the first occurrence and to find the last occurrence of the given element.
The solution is a basic binary search solution, except the two conditions that are to be implemented whenever nums[mid] == target.

[1] this function checks if the nums[mid] is target or not. If it is, then it searches for another occurrence of target of the left of it,
and hence the right side of mid is neglected. The algorithm continues to divide the array such that it find the element on the mid's left and neglects the right part.
When l==r, first occurrence is found.

[2] this function checks for the last occurrence by neglecting the left side and looking for target or the right side.
The starting element is made as mid+1 and the procedure keeps on repeating till the last occurrence is found.

If no elements are found, -1 is returned from both functions, as instructed in the qn.
*/