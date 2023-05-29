/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.
TC: O(n)
SC: O(n)
https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */

package TwoPointer;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -3, -2, -1, 5};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n-1;
        int k = n-1;
        while(i>=0 && j<n && k>=0)
        {
            res[k] = Math.max(Math.abs(nums[i]), Math.abs(nums[j]));
            if( Math.abs(nums[i]) > Math.abs(nums[j]))
            {
                i++;
            }
            else
            {
                j--;
            }
            k--;
        }
        for(i = 0; i<n; i++)
        {
            res[i] *= res[i];
        }
        return res;
    }
}
