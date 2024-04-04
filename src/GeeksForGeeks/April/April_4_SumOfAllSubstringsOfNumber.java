package GeeksForGeeks.April;

public class April_4_SumOfAllSubstringsOfNumber {
    public static long sumSubstrings(String s)
    {
        int n = s.length();
        long[] dp = new long[n];
        long sum = 0;

        dp[0] = s.charAt(0) - '0';
        sum += dp[0];
        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            dp[i] = ((i + 1) * digit + 10 * dp[i - 1]) % 1000000007;
            sum = (sum + dp[i]) % 1000000007;
        }

        return sum;

    }
}
