package GeeksForGeeks.Feburary;

/*  Level - Easy (Topic - Heap)
 Problem Statement:- Given an array arr of size n, the task is to check if the given array can be a level order
 representation of a Max Heap.

    Example 1:
    Input:
    n = 6
    arr[] = {90, 15, 10, 7, 12, 2}
    Output:
    1
    Explanation:
    The given array represents below tree
           90
         /    \
       15      10
      /  \     /
    7    12  2
    The tree follows max-heap property as every
    node is greater than all of its descendants.
 */
public class Feb_17_DoesArrayRepresentHeap {
    public boolean countSub(long arr[], long n)
    {
        for(long i=n-1;i>=1;i-=2){
            if(arr[(int)(i/2)]<arr[(int)i] || arr[(int)(i-1/2)]<arr[(int)i]){
                return false;
            }
        }
        return true;
    }
}
