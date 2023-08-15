/*
You are given two strings s and t, print all longest common sub-sequences in lexicographical order.
https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1
TC: O(n*m)
SC: O(n*m)
*/

package DynamicProgramming.LCS;
import java.util.*;

public class PrintLCS {
    public static void main(String[] args) {
        String s = "abaaa";
        String t = "baabaca";
        System.out.println(lcs(s, t));
    }

    public static String lcs(String s, String t)
    {
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
        while( i>0 && j>0 )
        {
            if(s.charAt(i-1) == t.charAt(j-1))               //[1]
            {
                char c = s.charAt(i-1);
                str += c;
                i--;
                j--;
            }
            else                                             //[2]
            {
                if(dp[i-1][j] > dp[i][j-1])
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }
        }
        StringBuilder sb = new StringBuilder(str);         //since we backtracked the dp matrix, the string was stored in reverse order
        sb.reverse();
        return sb.toString();
    }
}

/*
Starting from the last characters of s and t (i = n and j = m),
the algorithm backtracks through the dp array to reconstruct the LCS string.

Now, to print the longest common subsequence,
[1] we check if the elements at the current index match.
If they do, it means that the current element is a part of the lcs, and it can be added to the string.
To check for the prev elements, we directly go to the i-1 row and j-1 column,i.e.,move diagonally in the dp array,
because while filling the table, that is where the last common elements were found.

[2] if they are not same, we trace the path of the current cell,
and check the dp values to decide whether to move up or left in the dp array. If dp[i-1][j] > dp[i][j-1],
it means that the max was found in the dp[i-1][j], and hence to go there we decrement i, otherwise we can decrement j.
*/