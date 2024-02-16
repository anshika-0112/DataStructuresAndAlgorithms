package adavanceTopics.Dynamic_Programming.UnboundedKnapsack;

/* Level - Medium
Problem Statement:- Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost
associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.

It is exactly same as Unbounded Knapsack, they have just changed the way of asking.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

    Sample Input 1:
        2
        5
        2 5 7 8 10
        8
        3 5 8 9 10 17 17 20
    Sample Output 1:
        12
        24
    Explanation of sample input 1:
        Test case 1:

        All possible partitions are:
        1,1,1,1,1           max_cost=(2+2+2+2+2)=10
        1,1,1,2             max_cost=(2+2+2+5)=11
        1,1,3               max_cost=(2+2+7)=11
        1,4                 max_cost=(2+8)=10
        5                   max_cost=(10)=10
        2,3                 max_cost=(5+7)=12
        1,2,2               max _cost=(1+5+5)=12

    Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.
 */
public class RodCutting {
    public static int cutRod(int price[], int n) {
        int length[]=new int[n];
        for(int i=0;i<n;i++){
            length[i]=i+1;
        }
        int size=price.length;
        int dp[][]=new int[size+1][n+1];
        for(int i=0;i<=size;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=size;i++){
            for(int j=1;j<=n;j++){
                int inc=0;
                int exc=0;
                if(j>=length[i-1]){
                    inc=price[i-1]+dp[i][j-length[i-1]];
                }
                exc=dp[i-1][j];
                dp[i][j]=Math.max(inc,exc);
            }
        }
        // return helper(price.length,n,price,length);
        return dp[size][n];
    }
    public static int helper(int i,int n,int[] price,int[] length){
        if(i<=0){
            return 0;
        }
        int inc=0;
        int exc=0;
        if(n>=length[i-1]){
            inc=price[i-1]+helper(n, n-length[i-1], price, length);
        }
        exc=helper(i-1, n, price, length);
        return Math.max(inc,exc);
    }
}
