/*
Given an integer array nums, return true if you can partition the array into two subsets
such that the sum of the elements in both subsets is equal or false otherwise.
https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
TC: O( N * sum of elements )
SC: O( N * sum of elements )
*/

package DynamicProgramming.Knapsack;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean subsetSum(int[] nums, int s)         //[1]
    {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][s+1];
        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<s+1; j++)
            {
                if( i == 0 )
                {
                    dp[i][j] = false;
                }
                if(j == 0 )
                {
                    dp[i][j] = true;
                }
            }
        }
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<s+1; j++)
            {
                if(nums[i - 1] <= j)
                {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][s];
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++)
        {
            sum += nums[i];
        }
        if( sum%2 == 0)
        {
            int s = sum/2;
            return subsetSum(nums, s);                       //[2]
        }
        return false;
    }
}

/*
This problem is divided into two parts.
The first part checks if equal partition sum is a possibility or not.
To check that, we calculate the sum of he entire array.
If the sum is divisible by 2, it means that there are chances of the array to be partitioned into subsets of equal sum.
If the sum is odd, in no possible way can it be divided into two parts such that the numbers are whole numbers.

After the initial check, to verify is equal subset sum is actually possible or not, we implement subset sum algorithm to find it.

[1] implementation of subset sum algorithm is done using the given array,
to verify if the nums array consists of a subset with sum given as: total sum/2.

[2] we do not need to check for the existence of both the subsets individually.
If there exists even 1 subset with half the total sum, there obviously be another subset with half of the total sum too.
To verify this observation, we apply subset sum algorithm which returns true if subset exists, or false if it doesn't.
*/
