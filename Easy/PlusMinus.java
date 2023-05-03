/*
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
Print the decimal value of each fraction on a new line with  places after the decimal.
https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true
TC: O(n)
SC: O(1)
 */

package Easy;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 0, -1, -1);
        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        int pos = 0;
        int neg = 0;
        int zeroes = 0;
        int n = arr.size();
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i) > 0)
            {
                pos++;
            }
            else if(arr.get(i) < 0)
            {
                neg++;
            }
            else
            {
                zeroes++;
            }
        }
        double posRatio = pos/(1.0 * n);
        double negRatio = neg/(1.0 * n);
        double zeroRatio = zeroes/(1.0 * n);
        System.out.println(String.format("%.6f", posRatio));
        System.out.println(String.format("%.6f", negRatio));
        System.out.println(String.format("%.6f", zeroRatio));
    }
}
