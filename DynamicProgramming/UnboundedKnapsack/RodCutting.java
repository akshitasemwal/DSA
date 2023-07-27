/*
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n*n)
SC: O(n*n)
*/

package DynamicProgramming.UnboundedKnapsack;

public class RodCutting {
    public static void main(String[] args) {
        int n = 8;
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price, n));
    }

    public static int cutRod(int price[], int n) {
        int[] length = new int[n];                                    //[1]
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i<n; i++)
        {
            length[i] = i + 1;
        }

        for(int i = 0; i<n+1; i++)
        {
            for( int j = 0; j<n+1; j++)
            {
                if( i==0 || j==0 )
                {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i<n+1; i++)                                   //[2]
        {
            for(int j = 1; j<n+1; j++)
            {
                if( length[i - 1] <= j )
                {
                    dp[i][j] = Math.max( price[ i - 1 ] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}

/*
In this problem, we have to cut the rod in such lengths such that the total price for all the lengths of the rod is maximum.
The rod can be cut into any number of pieces.
We realize that it is an unbounded knapsack problem because we dont specifically have to cut the rod into different lengths.
The choice that we have to make is: whether to cut the rod in a specific length or not.

[1] we make a 'length' array, to map the prices with its respective length, and then populate it with numbers from 1 to n.
[2] now, since we have our prices array, and our length array, we can solve this problem using unbounded knapsack algorithm.
*/