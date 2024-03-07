package LeetCode.March;

import java.util.Arrays;

/*
 Problem Statement:- Given an integer array nums sorted in non-decreasing order, return an array of the squares of
 each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */

public class March_2_SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] t = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            t[i] = nums[i] * nums[i];
        }
        Arrays.sort(t);
        return t;
    }
}
