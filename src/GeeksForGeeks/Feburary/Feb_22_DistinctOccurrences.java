package GeeksForGeeks.Feburary;

import java.util.Arrays;

/* (Level- Medium) Topic - Dynamic Programming
 Problem Statement:- Given two strings s and t of length n and m respectively. Find the count of distinct occurrences of t in s as a sub-sequence modulo 109 + 7.

    Example 1:

    Input:
    s = "banana" , t = "ban"
    Output:
    3
    Explanation:
    There are 3 sub-sequences:[ban], [ba n], [b an].
 */
public class Feb_22_DistinctOccurrences {
    //Memoization Approach
    int MOD = 1000000007;

    int subsequenceCount(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(s, t, n, m, dp);
    }

    int helper(String s, String t, int n, int m, int[][] dp) {
        if (m == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        int result;
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            result = (helper(s, t, n - 1, m - 1, dp) + helper(s, t, n - 1, m, dp)) % MOD;
        } else {
            result = helper(s, t, n - 1, m, dp) % MOD;
        }
        dp[n][m] = result;
        return result;
    }

    //Tabulation Approach
    int  tabulationSubsequenceCount(String s, String t)
    {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%MOD;
                }
                else{
                    dp[i][j]=dp[i-1][j]%MOD;
                }

            }
        }
        return dp[n][m];
    }
}
