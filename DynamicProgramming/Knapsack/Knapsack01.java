/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item or dont pick it (0-1 property).
https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n*w)
SC: O(n*w)
*/

package DynamicProgramming.Knapsack;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int n = 3;
        int w = 4;
        System.out.println(knapSack(w, weight, values, n));
    }

    static int knapSack(int w, int wt[], int val[], int n)
    {
        int[][] dp = new int[n+1][w+1];           //[1]
        for(int i = 0; i < n + 1; i++)            //[2]
        {
            for(int j = 0; j < w + 1; j++)
            {
                if( i == 0 || j == 0 )
                {
                    dp[ i ][ j ] = 0;
                }
            }
        }

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 1; j <  w + 1; j++)
            {
                if( wt[i - 1] <= j )               //[3]
                {
                    dp[ i ][ j ] = Math.max( val[ i - 1 ] + dp[ i - 1 ][ j - wt[ i - 1 ]], dp[ i - 1 ][ j ]);
                }
                else                               //[4]
                {
                    dp[ i ][ j ] = dp [ i - 1 ][ j ];
                }
            }
        }
        return dp[ n ][ w ];
    }
}

/*
[1] reate a 2D array dp of size (n+1) and (w+1) to store the maximum value that can be achieved for different subproblems.
dp[i][j] will represent the maximum value that can be achieved using the first i items and with a knapsack of capacity j.
The final answer will be stored in the last cell, i.e., dp[n][w].

[2] since the base case for the given problem is that if no. of items(n), and capacity of knapsack(w) is 0, the output will be 0,
we initialize al the cells in the dp as 0 wherever i == 0 and j == 0.

[3] We use i-1 to match the 0-based indexing of the array, as the indices 0 are used to store the base case values.
Indexing in array: 0 1 2 3 4 5 6
Indexing in dp:  0 1 2 3 4 5 6 7 (and hence size of dp is taken as n+1)
Therefore, arr[i - 1] == arr[0] as i = 1.

For each item, check if it can be included in the knapsack without exceeding its capacity.
If yes, calculate the value that can be achieved by including the item (i.e., val[i - 1])
and adding it to the maximum value that can be achieved with the remaining capacity (dp[i - 1][j - wt[i - 1]]).
This gives the sum of weights of current element + past elements.
Compare this value with the maximum value achieved without including the item (dp[i - 1][j]) and store the maximum in dp[i][j].

[4] if the item's weight exceeds the knapsack capacity,
simply set dp[i][j] to be equal to dp[i - 1][j], as we cannot include the item.
*/
