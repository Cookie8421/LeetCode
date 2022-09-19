package com.leetcode.algorithms.MediumMode;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 *
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 *
 *
 * Constraints:
 *
 *     1 <= prices.length <= 3 * 104
 *     0 <= prices[i] <= 104
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        /**
         * Runtime: 2 ms, faster than 48.47% of Java online submissions for Best Time to Buy and Sell Stock II.
         * Memory Usage: 44.3 MB, less than 51.78% of Java online submissions for Best Time to Buy and Sell Stock II.
         */
        int ans = 0;
        boolean flag = false;
        int temp = -1;
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i+1] - prices[i] > 0){
                if(flag){
                    continue;
                } else {
                    flag = true;
                    temp = prices[i];
                }
            } else if(prices[i+1] - prices[i] < 0){
                flag = false;
                if(temp != -1){
                    ans += prices[i] - temp;
                    temp = -1;
                }
            }
        }
        if(temp != -1){
            ans += prices[prices.length-1] - temp;
        }
        return ans;
    }

    /*public int maxProfit(int[] prices) {
        *//**
         * Runtime: 2 ms, faster than 48.47% of Java online submissions for Best Time to Buy and Sell Stock II.
         * Memory Usage: 43.7 MB, less than 82.36% of Java online submissions for Best Time to Buy and Sell Stock II.
         *//*
        int pwos = -prices[0];
        int pwns = 0;

        for(int i = 1;i < prices.length;i++){
            int new_pwos = (pwns - prices[i] > pwos)? pwns - prices[i] : pwos;
            int new_pwns = (pwos + prices[i] > pwns)? pwos + prices[i] : pwns;
            pwos = new_pwos;
            pwns = new_pwns;
        }
        return pwns;
    }*/

}
