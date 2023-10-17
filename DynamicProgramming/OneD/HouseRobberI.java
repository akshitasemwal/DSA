/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.
https://leetcode.com/problems/house-robber
TC: O(n)
SC: O(n)
*/

package DynamicProgramming.OneD;

import java.util.Arrays;

public class HouseRobberI {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2, 3, 5, 8};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];        //stores the maximum amount that can be stolen till ith element, hence the nth
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i<n+1; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}

/*
For every ith element, we have 2 options:
option 1: choose current element, and sum of the max robbery till i - 2th element ( nums[i - 1] + dp[i - 2] )
option 2: choose i - 1th element. ( dp[i - 1] )

Now, select whichever option gives the maximum sum.
*/