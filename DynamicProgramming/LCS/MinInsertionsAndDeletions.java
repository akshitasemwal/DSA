/*
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class MinInsertionsAndDeletions {
    public static void main(String[] args) {
        String s = "heap";
        String t = "pea";
        System.out.println(minOperations(s, t));
    }

    public static int minOperations(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
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
        int deletions = n - dp[n][m];  //all the extra characters(apart from LCS) are deleted
        int insertions = m - dp[n][m]; //all the characters from 2nd string, which are not a part of the LCS, are inserted
        return deletions+insertions;
    }
}
