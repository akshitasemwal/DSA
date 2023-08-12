/*
Given two strings. The task is to find the length of the longest common substring.
https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "ABEDFH";
        String y = "AEDFHR";
        int n = 6;
        int m = 6;
        System.out.println(longestCommonSubstr(x, y, n, m));
    }

    static int longestCommonSubstr(String x, String y, int n, int m){
        int[][] dp = new int[n+1][m+1];                             //[1]
        for(int i = 0; i<n+1; i++)                                  //[2]
        {
            for(int j = 0; j<m+1; j++)
            {
                if( i==0 || j==0 )
                {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i<n+1; i++)                                 //[3]
        {
            for(int j = 1; j<m+1; j++)
            {
                if( x.charAt(i-1) == y.charAt(j-1) )
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        int max = -1;
        for(int i = 0; i<n+1; i++)                                 //[4]
        {
            for(int j = 0; j<m+1; j++)
            {
                if( dp[i][j]>max )
                {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}

/*
[1] a matrix called dp is made, with the variables as its size. Here, the variables are the lengths of both the strings.
[2] initialising/base case is saved in the matrix. If the sizes of any of the strings is 0, the output will always be 0,
since no common subsequence would then be possible.
[3] the dp is then filled according to the choice diagram for this problem.
The choice diagram states that:
If the character at the current index in string x, equals the current character in string y,
then the dp[i][j] can store the length of the common subsequence, that can be incremented from the last stored value.
If the characters are not equal, it means the substring breaks, and 0 will be stored at dp[i][j], since the length of the substring at that particular index is 0.
[4] instead of returning the last cell's values,i.e., dp[n+1][m+1], we find the largest value and return it.
*/