package adavanceTopics.Dynamic_Programming.UnboundedKnapsack;

/* Level - Medium
Problem Statement:- You are given an integer array coins representing coins of different denominations and an integer
amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination
of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

    Example 1:

    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1

 */
public class CoiChange2 {

    //Tabulation Solution
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[amount+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=n;j++){
                int ch1=0;
                int ch2=0;
                if(i>=coins[j-1]){
                    ch1=dp[i-coins[j-1]][j];
                }
                ch2=dp[i][j-1];
                dp[i][j]=ch1+ch2;
            }
        }
        return dp[amount][n];
        // return helper(amount,coins,coins.length);
    }

    //Recursive Solution
    int helper(int amount,int[] coins,int n){
        if(n==0){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        int ch1=0;
        int ch2=0;
        if(amount>=coins[n-1]){
            ch1=helper(amount-coins[n-1],coins,n);
        }
        ch2=helper(amount,coins,n-1);
        return ch1+ch2;
    }
}
