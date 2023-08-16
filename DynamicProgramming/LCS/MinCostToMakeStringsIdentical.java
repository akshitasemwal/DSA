/*
Given two strings X and Y, and two values costX and costY, the task is to find the minimum cost required to make the given two strings identical.
You can delete characters from both the strings. The cost of deleting a character from string X is costX and from Y is costY.
The cost of removing all characters from a string is the same.
https://practice.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class MinCostToMakeStringsIdentical {
    public static void main(String[] args) {
        String s = "heap";
        String t = "pea";
        int costX = 10;
        int costY = 20;
        System.out.println(findMinCost(s, t, costX, costY));
    }
    public static int findMinCost(String s, String t, int costX, int costY)
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
        int c1 = (n - dp[n][m]) * costX;  //delete all the non lcs characters
        int c2 = (m - dp[n][m]) * costY;
        return c1 + c2;
    }
}
