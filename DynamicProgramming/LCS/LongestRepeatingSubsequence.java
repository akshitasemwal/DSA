/*
Given string str, find the length of the longest repeating subsequence such that it can be found twice in the given string.
The two identified subsequences A and B can use the same ith character from string str if and only if
that ith character has different indices in A and B. For example, A = "xax" and B = "xax"
then the index of first "x" must be different in the original string for A and B.
https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "axxxy";
        System.out.println(LRS(s));
    }

    public static int LRS(String s)
    {
        String t = new String(s);
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
                if(s.charAt(i-1) == t.charAt(j-1) && i != j)         //[1]
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
Duplicating the string and comparing it with itself helps identify the longest repeating subsequence.
By avoiding overlapping positions (i != j), we ensure that the repeating subsequence is non-overlapping.

[1] if characters at positions i-1 in string s and j-1 in string t are the same and the positions i and j are not equal
(to avoid overlapping):
Update dp[i][j] to be one more than the value in the diagonal top-left cell, indicating an extended common subsequence.
If characters are different or the positions are equal:
Update dp[i][j] to be the maximum of the value in the cell above or the cell to the left,
representing the length of the longest repeating subsequence found so far.
*/