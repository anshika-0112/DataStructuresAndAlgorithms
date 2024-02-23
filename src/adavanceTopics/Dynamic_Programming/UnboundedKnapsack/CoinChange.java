package adavanceTopics.Dynamic_Programming.UnboundedKnapsack;

/*
    You are given an integer array coins representing coins of different denominations and an integer amount representing
    a total amount of money.
    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
     combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.

    Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
 */
public class CoinChange {

    //Tabulation Approach
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    int c=dp[i-coins[j]];
                    if(c!=Integer.MAX_VALUE){
                        dp[i]=Math.min(dp[i],c+1);
                    }}
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
//        return helper(coins,amount,coins.length);
    }

    // Recursive Approach
    public int helper(int[] coins,int amount,int n){
        if(n==0){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        int ch1=0, ch2=0;
        if(amount>=coins[n-1]){
            ch1= 1 +helper(coins,amount-coins[n-1],n-1);
        }
        ch2= helper(coins,amount,n-1);
        return Math.min(ch1,ch2);
    }
}
