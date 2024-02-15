package LeetCode.Feburary;

import java.util.Arrays;

/* Level :- Medium (Topic- Arrays)
Problem Statement:- You are given an array of positive integers nums of length n. A polygon is a closed plane figure
that has at least 3 sides. The longest side of a polygon is smaller than the sum of its other sides.
Return the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if it is not possible to
create a polygon.

Example 1:

Input: nums = [5,5,5]
Output: 15
Explanation: The only possible polygon that can be made from nums has 3 sides: 5, 5, and 5. The perimeter is 5 + 5 + 5 = 15.
Example 2:

Input: nums = [1,12,1,2,5,50,3]
Output: 12
Explanation: The polygon with the largest perimeter which can be made from nums has 5 sides: 1, 1, 2, 3, and 5.
The perimeter is 1 + 1 + 2 + 3 + 5 = 12.
We cannot have a polygon with either 12 or 50 as the longest side because it is not possible to include 2 or more smaller
sides that have a greater sum than either of them.
It can be shown that the largest possible perimeter is 12.

 */
public class Feb_15_PolygonWithLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<nums.length-1;i++){
            sum+=nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            if(sum>nums[i+1]){
                return sum+nums[i+1];
            }
            else{
                sum-=nums[i];
            }
        }
        return -1;
    }
}
