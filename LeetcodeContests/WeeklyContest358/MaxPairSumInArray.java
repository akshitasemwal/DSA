/*
You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums,
such that the maximum digit in both numbers are equal. Return the maximum sum or -1 if no such pair exists.
https://leetcode.com/problems/max-pair-sum-in-an-array/
TC: O(n*n*4)
SC: O(1)
*/

package LeetcodeContests.WeeklyContest358;

public class MaxPairSumInArray {
    public static void main(String[] args) {
        int[] nums = {51, 71, 17, 24, 42};
        System.out.println(maxSum(nums));
    }
    public static int getMax(int num)                     //[1]
    {
        int d = 0;
        while(num!=0)
        {
            d = Math.max(d, num%10);
            num /= 10;
        }
        return d;
    }

    public static int maxSum(int[] nums)
    {
        int n = nums.length;
        int sum = -1;
        int max = -1;
        for(int i = 0; i<n; i++)                         //[2]
        {
            int a = getMax(nums[i]);
            for(int j = i+1; j<n; j++)
            {
                int b = getMax(nums[j]);
                if( a == b )
                {
                    sum = nums[i] + nums[j];
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}

/*
[1] this function returns the max digit in every number

[2] for every element present in the array, we store its max digit in variable a.
Next we traverse through all the remaining elements to find the element whose max digit equals a.
If it does, we calculate the sum of the pairs and compare it with max sum stored till now.
*/