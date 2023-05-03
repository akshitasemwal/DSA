/*
Given an array of integers, find the sum of its elements.
TC: O(n)
SC: O(1)
https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true
 */

package Easy;

import java.util.Arrays;
import java.util.List;

public class SimpleArraySum {
    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1, 2, 3, 4);
        System.out.println(simpleArraySum(ar));
    }

    public static int simpleArraySum(List<Integer> ar) {
        int n = ar.size();
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += ar.get(i);
        }
        return sum;
    }
}
