/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
TC: O(n log n)
SC: O(n)
https://leetcode.com/problems/two-sum/description/
*/

package TwoPointer;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }

    public static void twoSum(int[] arr, int target) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int n = arr.length;
        int j = n-1;
        int i = 0;
        int[] nums = new int[2];
        while(i<=j)
        {
            if(arr[i]+arr[j]>target)
            {
                j--;
            }
            else if(arr[i]+arr[j]<target)
            {
                i++;
            }
            else if(arr[i]+arr[j]==target)
            {
                nums[0] = arr[i];
                nums[1] = arr[j];
                break;
            }
        }
        int flag = 0;
        for(i = 0; i<n; i++)
        {
            if(temp[i] == nums[0] && flag==0)
            {
                nums[0] = i;
                flag = 1;
            }
            else if(temp[i]==nums[1])
            {
                nums[1] = i;
            }
        }
        System.out.println(nums[0]+" "+nums[1]);
    }
}

/*

*/