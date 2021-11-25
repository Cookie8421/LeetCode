package com.leetcode.algorithms.EasyMode;

/**
 * @Author JoeyYoung
 * @ClassName: Best Time to Buy and Sell Stock
 * @Date 2021/11/25 14:01
 * @Description:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 *
 * Constraints:
 *
 *     1 <= prices.length <= 105
 *     0 <= prices[i] <= 104
 *
 */
public class BestTime2BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i+1; j < prices.length; j++){
                maxProfit = prices[j] - prices[i] > maxProfit ? prices[j] - prices[i] : maxProfit;
            }
        }
        return maxProfit;
    }

    //Better Solution
    /*public int maxProfit(int[] prices) {
            int ans=0;
            if(prices.length==0)
            {
                return ans;
            }
            int bought=prices[0];
            for(int i=1;i<prices.length;i++)
            {
                if(prices[i]>bought)
                {
                    if(ans<(prices[i]-bought))
                    {
                        ans=prices[i]-bought;
                    }
                }
                else
                {
                    bought=prices[i];
                }
            }
     return ans;
}*/

}
