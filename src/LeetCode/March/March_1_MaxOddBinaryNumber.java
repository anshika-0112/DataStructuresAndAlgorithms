package LeetCode.March;

/*
You are given a binary string s that contains at least one '1'.
You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that
can be created from this combination.
Return a string representing the maximum odd binary number that can be created from the given combination.

Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".
 */
public class March_1_MaxOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(r) == '1') {
                s = swap(l, r, s);
                l++;
            } else {
                r--;
            }
        }
        s = swap(l - 1, s.length() - 1, s);
        return s;
    }

    public String swap(int l, int r, String s) {
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, temp);
        return sb.toString();
    }
}
