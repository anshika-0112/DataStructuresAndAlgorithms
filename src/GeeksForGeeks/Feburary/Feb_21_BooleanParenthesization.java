package GeeksForGeeks.Feburary;

/*  (Level - Very Hard) (Topic - Dynamic Programming)
    Problem Statement:- Given a boolean expression s of length n with following symbols.
    Symbols
        'T' ---> true
        'F' ---> false
    and following operators filled between symbols
    Operators
        &   ---> boolean AND
        |   ---> boolean OR
        ^   ---> boolean XOR
    Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

    Note: The answer can be large, so return it with modulo 1003

    Example 1:

    Input:
    n = 7
    s = T|T&F^T
    Output:
    4
    Explaination:
    The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
 */
public class Feb_21_BooleanParenthesization {
    static int countWays(int n, String s) {
        int mod = 1003;
        char[] symbols = s.toCharArray();
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i += 2) {
            if (symbols[i] == 'T') {
                dp[i][i][1] = 1;
            } else {
                dp[i][i][0] = 1;
            }
        }

        for (int len = 2; len < n; len += 2) {
            for (int i = 0; i < n - len; i += 2) {
                int j = i + len;
                for (int k = i + 1; k < j; k += 2) {
                    char operator = symbols[k];
                    if (operator == '&') {
                        dp[i][j][1] = (dp[i][j][1] + (dp[i][k - 1][1] * dp[k + 1][j][1]) % mod) % mod;
                        dp[i][j][0] = (dp[i][j][0] + ((dp[i][k - 1][0] * dp[k + 1][j][0]) % mod
                                + (dp[i][k - 1][0] * dp[k + 1][j][1]) % mod
                                + (dp[i][k - 1][1] * dp[k + 1][j][0]) % mod) % mod) % mod;
                    } else if (operator == '|') {
                        dp[i][j][0] = (dp[i][j][0] + (dp[i][k - 1][0] * dp[k + 1][j][0]) % mod) % mod;
                        dp[i][j][1] = (dp[i][j][1] + ((dp[i][k - 1][1] * dp[k + 1][j][1]) % mod
                                + (dp[i][k - 1][0] * dp[k + 1][j][1]) % mod
                                + (dp[i][k - 1][1] * dp[k + 1][j][0]) % mod) % mod) % mod;
                    } else if (operator == '^') {
                        dp[i][j][1] = (dp[i][j][1] + ((dp[i][k - 1][1] * dp[k + 1][j][0]) % mod
                                + (dp[i][k - 1][0] * dp[k + 1][j][1]) % mod) % mod) % mod;
                        dp[i][j][0] = (dp[i][j][0] + ((dp[i][k - 1][1] * dp[k + 1][j][1]) % mod
                                + (dp[i][k - 1][0] * dp[k + 1][j][0]) % mod) % mod) % mod;
                    }
                }
            }
        }

        return dp[0][n - 1][1];
    }
}
