/*
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
SC: O(n*n)
TC: O(n*n)
*/

package DynamicProgramming.LCS;

public class FindMinInsertions {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(findMinInsertions(s));
    }

    static int findMinInsertions(String s){
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
        return n - dp[n][m];
    }
}

/*
To convert a string to palindrome, we first need to find its palindromic subsequence.
Reversing the string and finding the longest palindromic subsequence between the original string and its reverse
helps identify the longest common subsequence that can be used to construct a palindrome.
The minimum number of insertions needed to make a string a palindrome is equal to the
length of the string minus the length of its longest palindromic subsequence.
*/