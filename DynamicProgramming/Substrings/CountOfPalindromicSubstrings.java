/*
Given a string s, return the number of palindromic substrings in it.
https://leetcode.com/problems/palindromic-substrings/description/
TC: O(n*n)
SC: O(n*n)
*/

package DynamicProgramming.Substrings;

public class CountOfPalindromicSubstrings {
    public static void main(String[] args) {
        String s = "abccbadad";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean [n][n];

        for(int len = 0; len<n; len++)  //iterate through all possible substring lengths (len) from 0 to n-1.
        {
            for(int i = 0, j = len; j<n; i++, j++)  //iterate through all possible starting positions i and ending positions j such that j = i + len.
            {                                                 //[1]
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

        int count = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if( dp[i][j] == true )
                {
                    count++;
                }
            }
        }
        return count;
    }

//    public int countSubstrings(String s)
//    {
//         int count = 0;
//         for(int i = 0; i<s.length(); i++)    //[2]
//         {
//             count += helper(i, i, s);
//             count += helper(i, i+1, s);
//         }
//         return count;
//    }

    // public int helper(int start, int end, String s)
    // {
    //     int c = 0;
    //     while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end))   //[3]
    //     {
    //         start--;
    //         end++;
    //         c++;
    //     }
    //     System.out.println(c);
    //     return c;
    // }
}

/*
[1] if the current substring has a length of 1 (i.e., len == 0), mark it as a palindrome (dp[i][j] = true).
If the current substring has a length of 2 and the characters at i and j are equal, mark it as a palindrome (dp[i][j] = true).
If the current substring's characters at i and j are equal and the substring between i+1 and j-1 is also a palindrome
(i.e., dp[i+1][j-1] == true), mark the current substring as a palindrome (dp[i][j] = true).

[2] for each character at index i, consider two cases:
Odd Length Palindromes: Call the helper function with (i, i, s). This means that the palindrome's center is the single character at index i,
and we expand the palindrome symmetrically around it.
Even Length Palindromes: Call the helper function with (i, i+1, s). This means that the palindrome's center is between characters at indices i and i+1,
and we expand the palindrome symmetrically around this center.

[3] in each iteration, it expands the palindrome symmetrically around the center and increments the c
*/