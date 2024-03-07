package LeetCode.March;

/*
Problem Statement  - Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).

Example:

Input: s = "aabccabba"
Output: 3
Explanation: An optimal sequence of operations is:
- Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
- Take prefix = "b" and suffix = "bb" and remove them, s = "cca".

 */

public class March_5_MinLenOfStringAfterDeletingFromEnds {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char ch = s.charAt(l);
            while (l <= r && s.charAt(l) == ch) l++;
            while (l <= r && s.charAt(r) == ch) r--;
        }
        return r - l + 1;
    }
}
