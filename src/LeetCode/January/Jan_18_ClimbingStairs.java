package LeetCode.January;

/* Level - Easy
    Problem Statement:- You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        Example 1:

        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

     I have written recursion and tabulation solution.
 */
public class Jan_18_ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+2;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n+1];
    }
    public int helper(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return helper(n-1)+helper(n-2);
    }
}
