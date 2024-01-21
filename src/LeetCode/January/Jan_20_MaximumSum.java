package LeetCode.January;

import java.util.Stack;

/* Level - Medium (Topic - Stack)
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
Since the answer may be large, return the answer modulo 109 + 7.
    Example 1:

    Input: arr = [3,1,2,4]
    Output: 17
    Explanation:
    Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    Sum is 17.
*/
public class Jan_20_MaximumSum {
    public int sumSubarrayMin(int[] arr) {
        int n = arr.length;
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        long mod = 1000000007;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;

        // Calculate left array
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && arr[i] <= arr[leftStack.peek()]) {
                leftStack.pop();
            }
            left[i] = (i - (leftStack.isEmpty() ? -1 : leftStack.peek()));
            leftStack.push(i);
        }

        // Calculate right array
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && arr[i] < arr[rightStack.peek()]) {
                rightStack.pop();
            }
            right[i] = ((rightStack.isEmpty() ? n : rightStack.peek()) - i);
            rightStack.push(i);
        }

        // Calculate the final result
        for (int i = 0; i < n; i++) {
            ans = (int) ((ans + (left[i] * right[i] % mod) * arr[i]) % mod);
        }

        return ans;
    }
}
