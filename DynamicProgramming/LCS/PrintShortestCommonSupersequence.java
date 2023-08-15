/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
If there are multiple valid strings, return any of them.
A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
https://leetcode.com/problems/shortest-common-supersequence/description/
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String s = "abac";
        String t = "cab";
        System.out.println(shortestCommonSupersequence(s, t));
    }

    public static String shortestCommonSupersequence(String s, String t) {
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
        int i = n;
        int j = m;
        String str = "";
        while(i>0 && j>0)                         //[1]
        {
            if(s.charAt(i-1)==t.charAt(j-1))
            {
                char c = s.charAt(i-1);
                str += c;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                char c = s.charAt(i-1);
                str += c;
                i--;
            }
            else
            {
                char c = t.charAt(j-1);
                str += c;
                j--;
            }
        }
        while(i>0)
        {
            char c = s.charAt(i-1);
            str += c;
            i--;
        }
        while(j>0)
        {
            char c = t.charAt(j-1);
            str += c;
            j--;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}

/*
Construct the lcs matrix for the given strings.

This solution involves backtracking of the dp matrix to construct a supersequence of the given strings.
[1] initialize two pointers i and j to the last indices of strings s and t.
While i and j are greater than 0:
If the current characters are same:
Add the character to the str, move both pointers i and j leftwards.
When the value to the left of dp[i][j] (i.e., dp[i][j-1]) is greater,
it suggests that the character at position j-1 in string t has contributed to a longer common subsequence.
By appending this character to the str, we ensure that this character is included in the constructed supersequence.
Otherwise: Add the character at position j-1 in t to the str, move j leftwards.

[2] after the above operations, there might be remaining characters in either s or t
because the loop terminates as soon as any string finishes. Add them to the str using separate loops.
*/