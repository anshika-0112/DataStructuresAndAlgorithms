package LeetCode.January;

/* Level - Medium (Topic - Dynamic Programming)
Problem Statement:- Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly
below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1),
(row + 1, col), or (row + 1, col + 1).

    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
    Output: 13

 */
public class Jan_19_MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int n=matrix[0].length;
        int[][] dp =new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = matrix[i][j] + Math.min(
                        dp[i - 1][j],
                        Math.min(j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE,
                                j < n - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE)
                );
            }
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }

    //Recursive Solution
    public int helper(int i,int n,int[][] matrix,int j,int[][] dp){
        if(i<0 || i>=n){
            return dp[i+1][j+1]=0;
        }
        if(j<0 || j>=n){
            return dp[i+1][j+1]=Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i+1][j+1];
        }
        return dp[i+1][j+1]=matrix[i][j]+Math.min(Math.min(helper(i+1,n,matrix,j,dp),helper(i+1,n,matrix,j+1,dp)),
                helper(i+1,n,matrix,j-1,dp));
    }
}
