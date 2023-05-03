/*
Given a square matrix, calculate the absolute difference between the sums of its diagonals.
https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
TC: O(n^2)
SC: O(1)
 */

package Easy;
import java.util.*;
public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        arr.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        arr.add(new ArrayList<>(Arrays.asList(9, 8, 9)));
        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int m = arr.get(0).size();
        int sum1 = 0;
        int sum2 = 0;
        int diff = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j == i)
                {
                    sum1 += arr.get(i).get(i);
                    sum2 += arr.get(i).get(n-i-1);
                }

            }
        }
        diff = Math.abs(sum1 - sum2);
        return diff;
    }
}
