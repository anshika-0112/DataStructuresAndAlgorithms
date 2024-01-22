package LeetCode.January;

/* Level - Easy
Problem Statement:- You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of
one number and loss of another number.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

    Example 1:

    Input: nums = [1,2,2,4]
    Output: [2,3]
    Example 2:

    Input: nums = [1,1]
    Output: [1,2]

    We use Bit Manipulation to solve this question.
 */
public class Jan_22_SetMisMatch {
    public int[] findErrorNums(int[] nums) {
        int xor=0;
        int n=nums.length;
        for(int i:nums){
            xor^=i;
        }
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        int rightMostSetBit= xor & -xor;  //xor & ~(xor-1)
        int xorSet=0;
        int xorNotSet=0;
        for(int i=1;i<=n;i++){
            if((i&rightMostSetBit)!=0){
                xorSet^=i;
            }
            else{
                xorNotSet^=i;
            }
            if((nums[i-1]&rightMostSetBit)!=0){
                xorSet^=nums[i-1];
            }
            else{
                xorNotSet^=nums[i-1];
            }
        }
        for(int i:nums){
            if(i==xorSet){
                return new int[]{xorSet,xorNotSet};
            }
        }
        return new int[]{xorNotSet,xorSet};
    }
}
