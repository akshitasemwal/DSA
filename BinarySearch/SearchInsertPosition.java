/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
https://leetcode.com/problems/search-insert-position/description/
TC: O(log n)
SC: O(1)
*/

package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )                          //[1]
        {
            mid = l + ( r - l ) / 2;
            if ( nums[mid] <= target )
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        if( l-1 >= 0 && nums[l-1] == target )      //[2]
        {
            return l-1;
        }
        return l;
    }
}

/*
Since our main objective is to find the index where the target element can be inserted, we have to find the upperbound of the target.
We do so because at the index where the upperbound of target lies, the target can be inserted.
Incase the target is already present in the array, we can return the element just before the upperbound.

[1] we run a binary search function to find the upperbound of the target.
If the mid element is > target, it means all the elements to the right of it will also be greater than the target,
hence, r can be updated.
If the target is <= mid element, it means it lies in the right part of the array, and l can be updated.
Here, l becomes a candidate for the required index.

[2] incase the target is already present in the array, we can return the element just before the upperbound.
We check if l-1 >= 0, so that no checks are done out of bounds.
*/
