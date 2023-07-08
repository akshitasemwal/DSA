/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length),
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Return the index of target if it is in nums, or -1 if it is not in nums.
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
TC: O(log n)
sc: O(1)
*/

package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 0, 2};
        int k = 0;
        System.out.println(search(arr, k));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int mid = l + ( r - l ) / 2;
        int index = -1;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( nums[mid] == target )
            {
                index = mid;
                break;
            }
            else if ( nums[0] <= nums[mid] )        //[1]
            {
                if( nums[mid] < target || target < nums[l] )    //target doesnt lie in the given sorted sequence
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
            else if ( nums[0] >= nums[mid] )       //[2]
            {
                if( nums[mid] > target || target > nums[r] )    //target doesnt lie in the given sorted sequence
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
        }
        return index;
    }
}

/*
The array is divided into 2 increasing sequences.
This solution derives the answer in 2 steps:
Step 1: figure out if the mid lies in the first increasing sequence or the 2nd increasing sequence.
Step 2: check if the target can be found within the left of the increasing sequence 1, or the right of the increasing sequence 2.
If the target isn't in the above mentioned indices,
these indices can be ignored and the left and the right index can be updated, respectively.

[1] this condition checks if the nums[mid] lies in the first segment or not. It does so by comparing it with nums[0],
if nums[mid] >= nums[0], then it'll be in the first sequence as the sequences, in itself, are sorted.
Next, we eliminate/neglect the left side of the first sequence and update the l pointer if: target is greater than nums[mid],
or if target is less than nums[l].
In the second case, the element will surely lie in the second sequence as elements which are lesser tha nums[l] lie in the second sequence.
If the element lies in the left part, i.e., within l and mid, the r pointer gets updated.

[2] this condition checks if the nums[mid] lies in the second sequence. It does the same by comparing it with nums[0],
if nums[mid] < nums[0], it'll mean that the element lies in the second increasing sequence,
as nums[0] is always going to be greater than the elements in the second sequence.
Next, we eliminate the right side of the mid of the second sequence if the target is less than nums[mid] or if it is less than nums[mid].
In these both cases, the target lies outside the mid to r window, and hence r pointer gets updated.
If the target does lie in the mid - r window, then l is updated and target is searched for within that window.

As soon as the element is found, it is returned.
*/