/*
Given two strings X and Y of lengths m and n respectively,
find the length of the smallest string which has both, X and Y as its sub-sequences.
https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "xycda";
        int n = 4;
        int m = 5;
        System.out.println(shortestCommonSupersequence(s, t, n, m));
    }

    public static int shortestCommonSupersequence(String s,String t,int n,int m)
    {
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
        return (n + m - dp[n][m]);
    }
}

/*
Calculate the LCS as we do.
After filling the matrix, the length of the shortest common supersequence is calculated by:
adding the lengths of both strings and subtracting the length of the longest common subsequence (dp[n][m]).
We do so because on observing the supersequence, we noticed that it contains all the characters from both the arrays,
except the ones which are common in both the arrays.
These common characters can be eliminated as they do not affect the sequencing of the characters in the original array.
The list of these common characters is actually the lcs, which can be subtracted from the sum of the lengths of both the strings.
*/