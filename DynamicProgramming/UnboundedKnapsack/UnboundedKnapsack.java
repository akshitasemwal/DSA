/*
Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively.
Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.
https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n * w)
SC: O(w)
*/

package DynamicProgramming.UnboundedKnapsack;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] values = {1, 4, 5, 7};
        int[] weight = {1, 3, 4, 5};
        int n = 4;
        int w = 8;
        System.out.println(knapSack(n, w, values, weight));
    }

    static int knapSack(int n, int w, int val[], int wt[])
    {
        int[][] dp= new int[n+1][w+1];
        for(int i = 0; i<n+1; i++)                                   //[1]
        {
            for( int j = 0; j<w+1; j++)
            {
                if( i==0 || j==0 )
                {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<n+1; i++)                                  //[2]
        {
            for(int j = 1; j<w+1; j++)
            {
                if( wt[i-1] <= j)
                {
                    dp[i][j] = Math.max( val[i-1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);     //[3]
                }
                else
                {
                    dp[i][j] =  dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}

/*
A 01 knpasack aims at finding the subset from a given array, while fitting to the weight criteria of the knapsack, such that the profit is maximized.
We can use 1 element only once.
Whereas, in an unbounded knapsack, we can choose any no. of elements any no. of times.
Hence, it called unbounded, because it has no upper limit on the no. of times an element can be used.

[1] like 01 knapsack, it also has to be initialised with base case values.

[2] for each item, check if it can be included in the knapsack without exceeding its capacity.
If yes, calculate the value that can be achieved by including the item (i.e., val[i - 1])
and adding it to the maximum value that can be achieved with the remaining capacity (dp[i][j - wt[i - 1]]).
This gives the sum of weights of current element + past elements.
Compare this value with the maximum value achieved without including the item (dp[i - 1][j]) and store the maximum in dp[i][j].

[3] now, the expression from 01 knapsack: dp[i][j] = Math.max( val[i-1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
ensures that each item is used at most once because for each 'i', we access 'dp[i-1][j]' and 'dp[i][j - wt[i - 1]]',
which correspond to the cases when the current item 'i' is excluded and included in the knapsack, respectively.
Since we use 'dp[i-1][j]' while considering the current item 'i',
it means we exclude the current item from further consideration in the same iteration.

On the other hand, the second expression dp[i][j] = Math.max( val[i-1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
does not ensure that each item is used at most once, as it considers the same item again in the same iteration.
This violates the constraint of the 0/1 Knapsack problem, where we can include each item only once in the knapsack.
*/