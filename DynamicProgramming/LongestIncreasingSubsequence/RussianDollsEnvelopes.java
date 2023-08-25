/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
https://leetcode.com/problems/russian-doll-envelopes/description/
TC: O(n log n)
SC: O(n)
*/

package DynamicProgramming.LongestIncreasingSubsequence;
import java.util.*;

public class RussianDollsEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int binarySearch(List<Integer> LIS, int target)
    {
        int l = 0;
        int r = LIS.size() - 1;
        int mid = l + ( r - l ) / 2;
        while ( l <= r )
        {
            mid = l + ( r - l ) / 2;
            if( LIS.get(mid) <= target )
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        if( l - 1 >= 0 && LIS.get(l - 1) == target )
        {
            return l - 1;
        }
        return l;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        List<Integer> LIS = new ArrayList<>();
        Arrays.sort(envelopes, (a,b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));
        for(int i = 0; i<n; i++)
        {
            int index = binarySearch(LIS, envelopes[i][1]);
            if( index == LIS.size() )
            {
                LIS.add(envelopes[i][1]);
            }
            else
            {
                LIS.set(index, envelopes[i][1]);
            }
        }
        return LIS.size();
    }
}
