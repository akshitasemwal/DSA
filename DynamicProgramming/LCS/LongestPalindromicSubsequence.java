/*
Given a String, find the longest palindromic subsequence.
https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n*n)
SC: O(n*n)
*/

package DynamicProgramming.LCS;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestPalinSubseq(s));
    }
    public static int longestPalinSubseq(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<m+1; j++)
            {
                if( i==0 || j==0 )
                {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<m+1; j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

/*
LPS(s) = LCS(s, reverse(s))

This approach takes advantage of the fact that a palindromic subsequence is the same whether read left-to-right or right-to-left.
By comparing the original string with its reverse, the dynamic programming approach finds the longest common subsequence,
which corresponds to the longest palindromic subsequence in the original string.
*/