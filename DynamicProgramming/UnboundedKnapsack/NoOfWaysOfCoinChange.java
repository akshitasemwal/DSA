package DynamicProgramming.UnboundedKnapsack;

public class NoOfWaysOfCoinChange {
    public static void main(String[] args) {
        int n = 3;
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println(count(coins, n, sum));
    }

    public static long count(int coins[], int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        for(int i = 0; i<n+1; i++)                      //[1]
        {
            for(int j = 0; j<sum+1; j++)
            {
                if( i == 0 )
                {
                    dp[i][j] = 0;
                }
                if( j == 0 )
                {
                    dp[i][j] = 1;
                }
            }
        }

        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<sum+1; j++)
            {
                if( coins[i-1] <= j )
                {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}


/*
Why knapsack? Because we have a choice- whether we want to select an element or not.
The sum is equivalent to capacity. If two arrays are not given, value error can be ignored.
Why unbounded? It is an unbounded knapsack since the qn allows us to select any element n no. of times.

We have already observed that when we have to return the max or min value of something, max or min function is used to return the same,
and when we have to calculate the no. of ways, then we add all the possible choices(choices in the choice diagram) together.

This problem combines the above mentioned techniques to return the no. of ways the coins can be added to return the given sum.

[1] if sum is 0, but array has more than 0 elements(n!=0), it means that there can be atleast 1 way to get sum 0: an empty array.
Hence, for sum = 0, n = 1.
But if the array itself is empty(n == 0), the sum can never be reached, and hence remains 0.
*/