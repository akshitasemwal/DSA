/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
In one step, you can delete exactly one character in either string.
https://leetcode.com/problems/delete-operation-for-two-strings/description/
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class DeleteOperationsForTwoStrings {
    public static void main(String[] args) {
        String s = "leetcode";
        String t = "etco";
        System.out.println(minDistance(s, t));
    }

    public static int minDistance(String s, String t) {
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
        return (n + m - (2 * dp[n][m]));
    }
}

/*
This problem is very similar to shortest common supersequence.
The strings will be equal if and only if they are the lcs of themselves.
Now, to find no. of deletions, we need to subtract 2 * length from the sum of lengths of both the strings.
We do so because we need to convert both the strings into lcs, and hence the lengths of both he strings will be 2*lcs.
*/
