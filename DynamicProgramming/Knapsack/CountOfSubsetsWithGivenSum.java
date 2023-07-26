/*
Given an array arr[] of non-negative integers and an integer sum,
the task is to count all subsets of the given array with a sum equal to a given sum.
Note: Answer can be very large, so, output answer modulo 109+7
https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1
TC: O(N * sum)
SC: O(N * sum)
*/

package DynamicProgramming.Knapsack;

public class CountOfSubsetsWithGivenSum {
    public static void main(String[] args) {
        int n = 10;
        int sum = 31;
        int[] nums = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        System.out.println(perfectSum(nums, n, sum));
    }

    public static int perfectSum(int arr[],int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i<n+1; i++)                            //[1]
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
                if(arr[i-1] <= j)                          //[2]
                {
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }
                else                                      //[3]
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

/*
[1] the initialization of dp is done in the first nested loop.
If i == 0, it means there are no elements in the array, and the count of subsets with any sum (except 0) would be 0.
So, dp[0][j] is set to 0 for all j except 0. If j == 0, it means we have an empty subset that contributes to a sum of 0,
so dp[i][0] is set to 1.

[2] for each element arr[i-1], we check if it can be included in the subset with the current sum j.
If arr[i-1] <= j, it means the current element can contribute to the sum j. In this case, we have two choices:
Include the current element in the subset: dp[i-1][j - arr[i-1]]
Exclude the current element from the subset: dp[i-1][j]
So, the total count of subsets with sum j would be the sum of these two choices: dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j].

[3] if the current element arr[i-1] cannot be included in the subset with the current sum j (i.e., arr[i-1] > j),
then we have no choice but to exclude it from the subset: dp[i][j] = dp[i-1][j].
*/