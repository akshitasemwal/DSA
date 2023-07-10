/*
You are given a 0-indexed array nums of n integers and an integer target.
You are initially positioned at index 0. In one step, you can jump from index i to any index j such that: 0 <= i < j < n and -target <= nums[j] - nums[i] <= target
Return the maximum number of jumps you can make to reach index n - 1. If there is no way to reach index n - 1, return -1.
https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/
TC: O(n^3)
SC: O(n)
*/

package LeetcodeContests.WeeklyContest353;
import java.util.*;
public class MaxJumpsToReachTheLastIndex {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 4, 1, 2};
        int target = 3;
        System.out.println(maximumJumps(nums, target));
    }
    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);                                                  //filled with -1 to differentiate between accessed and not accessed dp[j]
        dp[0] = 0;                                                                //[1]
        for(int i = 1; i<n; i++)                                                  //[2]
        {
            for(int j = 0; j<i; j++)                                              //[3]
            {
                if( Math.abs( nums[j] - nums[i] ) <= target && dp[j] != -1 )
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }
}

/*
We need to find the maximum no. of steps required to reach the last index,
given, the absolute difference between two steps should be less than or equal to target.

We cannot use greedy approach because: we will not be able to find max no. of steps,
and we can get stuck at an index from where no further movement is possible(no backtracking allowed).

We use a trivial dp solution to solve this problem. We divide the problem into smaller problems,
and instead of directly finding the no. of steps to reach last index, we first find the no. of steps required to move from jth index to ith index,
if and only if the absolute difference between the elements is <= target.
For this, we will first find the maximum no. of steps required to reach jth index( dp[j] ).
Then the steps required to reach ith index would be: dp[j] + 1. This process when done repetitively, gives the required result.

[1] dp[0] is set as 0 as the no. of steps required to be at 0th index will remain zero
[2] we access the nums array to fill dp[i], which is the no. of steps required to reach the ith index
[3] for every ith index, we calculate no. of steps required to reach ith index from jth indices,
by considering all the elements from 0 to i-1th index.
Only the indices which satisfy the given condition: Math.abs(nums[j] - nums[i]) <= target, are allowed to be compared and stored in dp[i].
The other condition that needs to be met is that: dp[j] != -1. If dp[j] remains unreachable by any other element, then it remains at -1.
If both the conditions are satisfied, then dp[i] stores the maximum of the steps taken from j to i.

Example: for i = 4, j = 0, 1, 3. j = 2 is neglected as it doesnt satisfy the required condition.
j = 0: dp[4] = max(-1, 0 + 1) = 1
j = 1: dp[4] = max(1, 1 + 1) = 2
j = 3: dp[4] = max(2, 3 + 1) = 4
Therefore, dp[4] = 4.
The max possible steps is stored in the dp[i], as the question demands.

We return dp[n-1] as it stoores the max possible steps to reach n-1th index.
*/