package LeetCode.Feburary;

/* Level - Easy (Topic - Bit Manipulation)
Problem Statement:- iven an integer n, return true if it is a power of two. Otherwise, return false.
    Example 1:

    Input: n = 1
    Output: true
    Explanation: 20 = 1
    Example 2:

    Input: n = 16
    Output: true
    Explanation: 24 = 16
 */
public class Feb_19_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}
