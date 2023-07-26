/*
You are given an integer array nums and an integer target.
You want to build an expression out of nums by:
adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
https://leetcode.com/problems/target-sum/
TC: O( N * sum )
SC: O( N * sum )
*/

package DynamicProgramming.Knapsack;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int t = 3;
        System.out.println(findTargetSumWays(nums, t));
    }

    public static int subsetSum(int[] arr, int n, int sum)            //[1]
    {
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<sum+1; j++)
            {
                if(i == 0)
                {
                    dp[i][j] = 0;   //single empty subset
                }
                if(j == 0)
                {
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 0; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++)                     //[2]
        {
            sum += nums[i];
        }
        sum += t;                                   //[3]
        if( sum % 2 != 0 || sum < 0 )
        {
            return 0;
        }
        sum /= 2;
        return subsetSum(nums, n, sum);             //[4]
    }
}

/*
We have to find the no. of ways to assign signs to elements in the array such that its sum is target.

On decoding the problem further, we observe that:
we simply have to divide the array into 2 subsets such the absolute difference of the sum of the subsets is equal to target.
This problem now becomes exactly similar to count of subsets with given difference, which is implemented using count of subsets with given sum.

[1] this function implements the count of subset with given sum function, and returns the number of subsets which fulfill the desired criteria.
[2] the sum of the entire array is calculated.
[3] now, the sum is calculated according to the given statement: s1 = (sum + d) / 2.
We also check if ( sum + d ) is divisible by 2 or not, or if ( sum + d ) is negative, because if it is not divisible by 2,
then it simply will not be possible to divide the sum into 2 parts, such tha both the parts are whole numbers.
If it is not divisible by 2, we return 0 as the no. of possible subsets. If ( sum + d ) < 0, it will mean that, not even 1 subset is possible with the given target.
[4] now, we call the subset sum function to calculate the no. of subsets with the newly calculated sum.
*/