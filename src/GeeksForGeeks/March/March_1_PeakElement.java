package GeeksForGeeks.March;

/*
Given an 0-indexed array of integers arr[] of size n, find its peak element. An element is considered to be peak if it's
value is greater than or equal to the values of its adjacent elements (if they exist).

Note: The output will be 1 if the index returned by your function is correct; otherwise, it will be 0.

Example 1:

Input:
n = 3
arr[] = {1, 2, 3}
Peak element's index: 2
Output:
1
Explanation:
If the index returned is 2, then the output printed will be 1. Since arr[2] = 3 is greater than its adjacent elements,
and there is no element after it, we can consider it as a peak element. No other index satisfies the same property.
 */
public class March_1_PeakElement {
    public int peakElement(int[] arr,int n)
    {
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if((m==0 || arr[m-1]<=arr[m]) && (m==n-1 || arr[m+1]<=arr[m]))
            {
                return m;
            }
            else if(m>0 && arr[m]<arr[m-1]){
                r=m-1;
            }
            else
                l=m+1;
        }
        return -1;
    }
}
