package GeeksForGeeks.April;

import java.util.Arrays;

public class April_5_StrictlyIncreasingArray {
    public int min_operations(int []nums)
    {
        int n=nums.length;
        int dp[]=new int[n];
        int lis=1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if( nums[i] - nums[j] >= i - j )
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            lis=Math.max(lis,dp[i]);
        }
        return n-lis;
    }
}
