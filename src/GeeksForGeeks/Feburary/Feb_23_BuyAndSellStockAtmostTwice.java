package GeeksForGeeks.Feburary;

/*
 Problem Statement:- In daily share trading, a buyer buys shares in the morning and sells them on the same day. If the
 trader is allowed to make at most 2 transactions in a day, the second transaction can only start after the first
 one is complete (buy->sell->buy->sell). The stock prices throughout the day are represented in the form of an array of prices.
Given an array price of size n, find out the maximum profit that a share trader could have made.

    Example 1:

    Input:
    n = 6
    prices[] = {10,22,5,75,65,80}
    Output:
    87
    Explanation:
    Trader earns 87 as sum of 12, 75 Buy at 10, sell at 22, Buy at 5 and sell at 80.
 */
public class Feb_23_BuyAndSellStockAtmostTwice {
    public static int maxProfit(int n, int[] price) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for(int i = 0; i <n; i++) {
            buy1 = Math.max(buy1, -price[i]);
            sell1 = Math.max(sell1, buy1 + price[i]);
            buy2 = Math.max(buy2, sell1 - price[i]);
            sell2 = Math.max(sell2, buy2 + price[i]);
        }

        return sell2;
    }
}
