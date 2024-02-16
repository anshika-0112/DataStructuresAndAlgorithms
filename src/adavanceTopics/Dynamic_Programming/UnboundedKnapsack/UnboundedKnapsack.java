package adavanceTopics.Dynamic_Programming.UnboundedKnapsack;

/* Level - Medium
 Problem Statement:- A thief is robbing a store and can carry a maximal weight of W into his knapsack.
 There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that
 a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

 Sample Input:
    1
    4
    1 2 4 5
    5 4 8 6
    5
  Sample Output:
    13
 */
public class UnboundedKnapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][]=new int[n+1][maxWeight+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=maxWeight;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxWeight;j++){
                if(j-weight[i-1]>=0){
                    dp[i][j]=Math.max(value[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][maxWeight];

    }

    static int helper(int[] weight,int[] value,int n,int maxWeight,int[][] dp){
        if(n<=0 || maxWeight<=0){
            return 0;
        }

        if(dp[n][maxWeight]!=-1){
            return dp[n][maxWeight];
        }
        int ch1=0;
        int ch2=0;
        if(maxWeight-weight[n-1]>=0){
            ch1= value[n-1]+helper(weight, value, n-1, maxWeight-weight[n-1],dp);
        }
        ch2= helper(weight, value, n-1, maxWeight,dp);
        return dp[n][maxWeight]=Math.max(ch1,ch2);
    }
}
