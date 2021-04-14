// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// Say you have an array for which the ith element is the price of a given stock on day i.
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
// Example 1:
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// Example 2:
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
// Example 3:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
// Example 4:
// Input: prices = [1]
// Output: 0
// Constraints:
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105

import java.util.*;

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int[] left = new int[prices.length];
        left[0] = 0;
        int minLeft = prices[0];
        for(int i = 1; i < prices.length; i++) {
            left[i] = Math.max(prices[i] - minLeft, left[i - 1]);
            minLeft = Math.min(minLeft, prices[i]);
        }
        int[] right = new int[prices.length];
        right[prices.length - 1] = 0;
        int maxRight = prices[prices.length - 1];
        for(int i = prices.length - 2; i > 0; i--) {
            right[i] = Math.max(maxRight - prices[i], right[i + 1]);
            maxRight = Math.max(maxRight, prices[i]);
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
    public static void main(String args[]) {
        int[] test1 = {3,3,5,0,0,3,1,4};
        System.out.println("Max Profit for the array " + Arrays.toString(test1) + " is = " + maxProfit(test1));
        int[] test2 = {7,6,5,4,3,2,1,0};
        System.out.println("Max Profit for the array " + Arrays.toString(test2) + " is = " + maxProfit(test2));
        int[] test3 = {};
        System.out.println("Max Profit for the array " + Arrays.toString(test3) + " is = " + maxProfit(test3));
    }
}