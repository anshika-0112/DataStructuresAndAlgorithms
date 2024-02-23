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
    public int solve(int[] coins,int amount)
    {
        if(amount==0){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                int c=solve(coins,amount-coins[i]);
                if(c!=Integer.MAX_VALUE){
                    res=Math.min(res,c+1);
                }
            }
        }
        return res;
    }
}
