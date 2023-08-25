/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
TC: O(n)
SC: O(1)
*/

package DynamicProgramming.Miscellaneous;

public class BuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 2, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int currBuy = prices[0];
        int currSell = prices[0];
        int profit = 0;
        for(int i = 0; i<n; i++)                   //[1]
        {
            if( prices[i] > currSell )
            {
                currSell = prices[i];
            }
            if( prices[i] < currSell )             //[2]
            {
                profit += (currSell - currBuy);
                currBuy = prices[i];
                currSell = prices[i];
            }
        }
        profit += (currSell - currBuy);           //[3]
        return profit;
    }
}

/*
While in best time to buy and sell stock 1 we had to print the max profit calculated,
here we have to print the sum of stocks that we buy, greedily.
We can own only 1 stock at a time, and as soon as we see that we can buy another stock( arr[i] < selling price ),
we sell the current stock we own.

[1] if the current price in the array is greater than the selling price,
we update the selling price as we can now get more profit for that particular stock.

[2] if the current price in the array is less than the selling price, it means the stock price is decreasing, and that we need to buy a new stock,
and hence sell the current stock ( currSell - currBuy ) and add it to the profit.
We then update the values of current buying and selling prices to buy a new stock.

[3] calculate and add the final profit from the last remaining buying and selling opportunity by subtracting currBuy from currSell.
*/