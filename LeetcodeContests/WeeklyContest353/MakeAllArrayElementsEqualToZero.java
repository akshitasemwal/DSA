/*
You are given a 0-indexed integer array nums and a positive integer k.
You can apply the following operation on the array any number of times:
Choose any subarray of size k from the array and decrease all its elements by 1.
Return true if you can make all the array elements equal to 0, or false otherwise.
A subarray is a contiguous non-empty part of an array.
https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/
TC: O(n)
SC: O(1)
*/

package LeetcodeContests.WeeklyContest353;

public class MakeAllArrayElementsEqualToZero {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 1, 1, 0};
        int k = 3;
        System.out.println(checkArray(nums, k));
    }

    public static boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int increment = 0;
        for(int i = 0; i<n; i++)
        {
            if(increment > nums[i])                  //[1]
            {
                return false;
            }
            nums[i] -= increment;                    //[2]
            increment += nums[i];                    //[3]
            if( i - k + 1 >= 0)                      //[4]
            {
                increment -= nums[i - k + 1];
            }
        }
        return increment == 0;
    }
}

/*
The brute force approach for this problem includes subtracting the first element(x) in each window, from all the elements in that window of size k.
while making sure these elements are >= nums[i]. We can then traverse through the entire array to see if there is some element != 0.
Since it would require a max of n^2 operations, we instead use "Update range" method to optimally solve the problem in O(n) time.

[1] check if increment is greater than current element.If it is, return false since it is not possible to make array 0.
[2] calculate the increment for the current element by subtracting it from nums[i]
[3] update increment by adding the previously calculated increment for the current element, to it.
[4] if k elements are processed already, we subtract the increment for the element which lies outside the window

After iterating over all the elements, check if increment is equal to 0.
If it is, return true since it means that it is possible to make the array 0. Otherwise, return false.
*/