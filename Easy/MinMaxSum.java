/*
Given n positive integers, find the minimum and maximum values that can be calculated by summing exactly n-1 of the n integers.
Then print the respective minimum and maximum values as a single line of two space-separated long integers.
https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
TC: O(n)
SC: O(1)
 */

package Easy;
import java.util.*;

public class MinMaxSum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 3, 5, 7, 9);
        miniMaxSum(arr);
    }

    public static void miniMaxSum(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long maxSum = 0;
        long minSum = 0;
        for(int i = 0; i< arr.size(); i++)
        {
            if( arr.get(i)<min)
            {
                min = arr.get(i);
            }
            if(arr.get(i)>max)
            {
                max = arr.get(i);
            }
        }
        for(int i = 0; i< arr.size(); i++)
        {
            if( arr.get(i)!= min)
            {
                maxSum += arr.get(i);
            }
            if(arr.get(i)!=max)
            {
                minSum += arr.get(i);
            }
        }
        System.out.print(minSum + " ");
        System.out.println(maxSum);
    }
}
