package LeetCode.January;

/* Level - Medium (Topic - Dynamic Programming)
    Problem Statement:- Given two strings text1 and text2, return the length of their longest common subsequence.
     If there is no common subsequence, return 0.

        Input: text1 = "abcde", text2 = "ace"
        Output: 3
        Explanation: The longest common subsequence is "ace" and its length is 3.
 */
public class Jan_25_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int helper(String s1, String s2,int n,int m){
        if(n<=0 || m<=0){
            return 0;
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return 1+helper(s1,s2,n-1,m-1);
        }
        return Math.max(helper(s1,s2,n-1,m),helper(s1,s2,n,m-1));
    }
}
