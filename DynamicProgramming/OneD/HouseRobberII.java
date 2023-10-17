/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police
if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money
you can rob tonight without alerting the police.
https://leetcode.com/problems/house-robber-ii
TC: O(n)
SC: O(n)
*/

package DynamicProgramming.OneD;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2, 3, 5, 8};
        System.out.println(rob(nums));
    }
    public static int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i<n+1; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public static int rob(int[] nums)
    {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);   //specific condition of the platform leetcode
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i = 0; i<n; i++)  //copies the array into temp array
        {
            if( i != 0 )
            {
                dp1[i] = nums[i];
            }
            if( i != n - 1 )
            {
                dp2[i] = nums[i];
            }
        }

        int ans = Math.max(helper(dp1), helper(dp2));
        return ans;
    }
}

/*
The solution can NOT contain the first and last element together.

Now, we have 2 options:
we can either include 1st element in our solution, or we can include the last element..
If we choose 1st element, last element will be removed.
If we do not choose fist element, the last element will get included if it gives the first answer.

So, to code this, we calculate 2 dp arrays, one leaving out the first element, and the other leaving out the last element.

To get the answer, we will have to choose the max element from both the arrays, i.e., max( dp1[n], dp2[n] ).
*/