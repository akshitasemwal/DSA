/*
There are a number of different toys lying in front of him, tagged with their prices.
Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.
Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.
https://www.hackerrank.com/challenges/mark-and-toys/problem?isFullScreen=true
TC: O(n log n)
SC: O(1)
*/

package Easy;
import java.util.*;

public class MarkAndToys {
    public static void main(String[] args) {
    int k = 50;
    List<Integer> arr = Arrays.asList(1, 12, 5, 111, 200, 1000, 10);
    System.out.println(maximumToys(arr, k));
    }

    public static int maximumToys(List<Integer> prices, int k) {
        Collections.sort(prices);
        int sum = 0;
        int count = 0;
        for(int i = 0; i< prices.size(); i++)
        {
            if( sum <= k && prices.get(i)+sum<=k)
            {
                sum += prices.get(i);
                count++;
            }
        }
        return count;
    }
}
