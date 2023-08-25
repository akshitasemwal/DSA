/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
TC: O(n)
SC: O(1)
*/

package DynamicProgramming.Miscellaneous;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int currBuy = prices[0];
        int currSell = prices[0];
        int profit = 0;
        for(int i = 0; i<n; i++)
        {
            if( prices[i] < currBuy )          //[1]
            {
                currBuy = prices[i];
                currSell = prices[i];
            }
            if( prices[i] > currSell )         //[2]
            {
                currSell = prices[i];
            }
            profit = Math.max( profit, currSell - currBuy );
        }
        return profit;
    }
}

/*
[1] if the current price in the array is less than the buying price,
we update the buying price as it is a potential buying opportunity.
We also update the selling price because we cannot sell a stock without first buying it.

[2] if the current price in the array is greater than the selling price,
we update the selling price as we can now get more profit for that particular stock.
*/
