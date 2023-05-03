/*
Given an array of integers and a positive integer,
determine the number of i,j pairs where i<j and  arr[i] + arr[j]  is divisible by k.
TC: O(n^2) since the coonstraints are small
SC: O(n)
https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true
 */

package Easy;

import java.util.*;

public class DivisibleSumPair {
    public static void main(String[] args) {
        int n = 6, k = 3;
        List<Integer> ar = Arrays.asList(1, 3, 2, 6, 1, 2);
        System.out.println(divisibleSumPairs(n, k, ar));
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;
        for(int i = 0; i<ar.size(); i++)
        {
            for(int j = i+1; j<ar.size(); j++)
            {
                if((ar.get(i)+ar.get(j))%k == 0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
