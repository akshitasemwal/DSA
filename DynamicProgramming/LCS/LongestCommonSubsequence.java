/*
Given two strings, find the length of longest subsequence present in both of them.
Both the strings are in uppercase latin alphabets.
https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(|n|*|m|)
SC: O(|n|*|m|)
*/

package DynamicProgramming.LCS;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "ABCDGH";
        String y = "AEDFHR";
        int n = 6;
        int m = 6;
        System.out.println(lcs(n, m, x, y));
    }

    static int lcs(int n, int m, String x, String y)
    {
        int[][] dp = new int[n+1][m+1];                          //[1]
        for(int i = 0; i<n+1; i++)                               //[2]
        {
            for(int j = 0; j<m+1; j++)
            {
                if( i == 0 || j == 0 )
                {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<m+1; j++)
            {
                if( x.charAt(i-1) == y.charAt(j-1) )             //[3]
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

/*
In this problem, we have to find the length of the longest common subsequence.
We could have used frequency tables to store the frequency of the characters present, but a subsequence needs to maintain its order.
The longest common subsequence in the above example is: 'ADH'

[1] a matrix called dp is made, with the variables as its size. Here, the variables are the lengths of both the strings.
[2] initialising/base case is saved in the matrix. If the sizes of any of the strings is 0, the output will always be 0,
since no common subsequence would then be possible.
[3] the dp is then filled according to the choice diagram for this problem.
The choice diagram states that:
If the character at the current index in string x, equals the current character in string y,
then the dp[i][j] can store the length of the common subsequence, that can be incremented from the last stored value.
If the characters are unequal, the calculation can start either from the previous row or the previous column, whichever gives the bigger value.
*/