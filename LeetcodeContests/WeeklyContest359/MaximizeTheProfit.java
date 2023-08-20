/*
You are given an integer n representing the number of houses on a number line, numbered from 0 to n - 1.
Additionally, you are given a 2D integer array offers where offers[i] = [starti, endi, goldi],
indicating that ith buyer wants to buy all the houses from starti to endi for goldi amount of gold.
As a salesman, your goal is to maximize your earnings by strategically selecting and selling houses to buyers.
Return the maximum amount of gold you can earn.
Note that different buyers can't buy the same house, and some houses may remain unsold.
https://leetcode.com/problems/maximize-the-profit-as-the-salesman/description/
TC: O(n * m)
SC: O(n)
*/

package LeetcodeContests.WeeklyContest359;
import java.util.*;

public class MaximizeTheProfit {
    public static void main(String[] args)
    {
        int n = 5;
        List<List<Integer>> offers = Arrays.asList(
                Arrays.asList(0, 0, 1),
                Arrays.asList(0, 2, 2),
                Arrays.asList(1, 3, 2)
        );
        System.out.print(maximizeTheProfit(n, offers));
    }
    public static int maximizeTheProfit(int n, List<List<Integer>> offers)
    {
        int m = offers.size();
        int[] dp = new int[n+1];  //array dp of size (n+1) is used to store the maximum profit that can be obtained up to each day.
        int offerIdx = 0;  // used to keep track of the current offer being processed.
        Collections.sort(offers, (a, b) -> a.get(1) != b.get(1) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));  //[1]

        for (int i = 1; i<n+1; i++)
        {
            dp[i] = dp[i-1];                                                                 //[2]
            while (offerIdx<m && offers.get(offerIdx).get(1) == i-1)                         //[3]
            {
                dp[i] = Math.max(dp[i],                                                      //[4]
                        dp[offers.get(offerIdx).get(0)]+offers.get(offerIdx).get(2));
                offerIdx++;
            }
        }
        return dp[n];
    }
}

/*
This code aims to maximize profit from a series of offers given certain conditions.

[1] the offers are sorted based on their end day (a.get(1)).
If two offers have the same end day, they are sorted based on their start day (a.get(0)).
This sorting ensures that the offers are processed in the correct order.

The sorting is based on a custom comparator defined using a lambda expression.
The comparator compares two elements a and b based on two criteria:
-> If the second element of offer a is not equal to the second element of offer b,
it sorts them based on the ascending order of the second element.
-> If the second elements are equal, it then sorts them based on the ascending order of the first element.

[2] initializes the maximum profit for the current day (i) with the maximum profit obtained on the previous day (i-1).
Its a way to ensure that the profit for the current day is initialized with the best profit obtained so far.
This is based on the principle that if an offer is not applied on the current day,
the profit on the current day remains the same as the profit on the previous day.

[3] while offerIdx is less than the number of offers (m) and the end day of the current offer matches i-1,
the code enters this loop. This means the current offer can be applied on the current day.

[4] the maximum profit at day i is calculated by comparing the current profit at day i with the profit
that can be obtained by applying the current offer on the start day of the offer (offers.get(offerIdx).get(0))
plus the profit of the current offer (offers.get(offerIdx).get(2)).

The loop continues for all eligible offers for the current day.
After processing all offers for the current day, the maximum profit up to day i is stored in dp[i].
dp[n] contains the maximum profit that can be obtained by applying the given offers up to the last day.
*/