/*
Given a wooden stick of length n units. The stick is labelled from 0 to n.
Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
You should perform the cuts in order, you can change the order of the cuts as you wish.
The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut).
Return the minimum total cost of the cuts.
https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
TC: O(n*n*n)
SC: O(n*n)
*/

package DynamicProgramming.MatrixChainMultiplication;
import java.util.*;

public class MinCostToCutAStick {
    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        System.out.print(minCost(n, cuts));
    }

    public static int minCost(int len, int[] cuts) {
        int n = cuts.length;
        int[] temp = new int[n + 2];           //[1]
        for(int i = 0; i < n; i++)
        {
            temp[i] = cuts[i];
        }
        temp[n] = 0;
        temp[n + 1] = len;
        Arrays.sort(temp);

        n = temp.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 2; i >= 1; i--)       //[2]
        {
            for (int j = i; j <= n-2 ; j++)
            {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                {
                    int steps = temp[j + 1] - temp[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 2];
    }
}

/*
[1] the array cuts is extended with additional positions to include the start and end of the stick and is then sorted.

[2] the outer loop iterates through different stick lengths from smaller to larger.
The inner loop iterates through different pairs of start and end positions of the stick.
For each stick length and position range, the code calculates the minimum cost
by considering all possible cutting positions within that range and updating the dp array.

[3] temp[j + 1] - temp[i - 1]: This calculates the length of the stick after it has been cut at position k.
temp[j + 1] represents the right end of the stick after the cut, and temp[i - 1] represents the left end of the stick before the cut.
So, this part calculates the length of the stick that is being cut.
dp[i][k - 1]: This is the minimum cost of cutting the left part of the stick, which is the subproblem with a range [i, k - 1].
dp[k + 1][j]: This is the minimum cost of cutting the right part of the stick, which is the subproblem with a range [k + 1, j].
*/