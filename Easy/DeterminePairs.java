/*
There is a large pile of socks that must be paired by color.
Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true
TC: O(n)
SC: O(n)
*/

package Easy;
import java.util.*;

public class DeterminePairs {
    public static void main(String[] args) {
        int n = 9;
        List<Integer> arr = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        System.out.println(sockMerchant(n, arr));
    }

    public static int sockMerchant(int n, List<Integer> arr) {
        int count = 0;
        int[] freq = new int[100];
        for(int i = 0; i<n; i++)
        {
            freq[arr.get(i)]++;
        }
        for(int i = 0; i<100; i++)
        {
            count += freq[i]/2;
        }
        return count;
    }
}
