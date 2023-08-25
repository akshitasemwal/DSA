/*
Given a string s, return the longest palindromic substring in s.
https://leetcode.com/problems/longest-palindromic-substring/description/
TC: O(n*n)
SC: O(n*n)
*/

package DynamicProgramming.Substrings;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "abccbadad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean [n][n];
        int maxLen = 0;
        int start = 0;
        int end = 0;

        for(int len = 0; len<n; len++)
        {
            for(int i = 0, j = len; j<n; i++, j++)
            {
                if(len == 0)
                {
                    dp[i][j] = true;
                }
                else if(len == 1 && s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = true;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
                {
                    dp[i][j] = true;

                }
            }
        }

        for(int i = 0; i<n; i++)                   //[1]
        {
            for(int j = 0; j<n; j++)
            {
                if(dp[i][j] == true)
                {
                    if(j - i + 1 > maxLen)
                    {
                        maxLen = j - i + 1;
                        start = i;
                        end = j+1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}

/*
This problem uses the concept of count of palindromic substrings to mark the all the palindromic substrings in the dp matrix.

[1] this loop traverses through the entire matrix.
If a cell has been marked true for a particular index, we compare its length( j - i + 1, similar to storing the window size)
to previously calculated maxLen, and save the start index as i, and end index as j+1.
The substring with the saved start and end index are returned.
*/