package LeetCode.Feburary;

import java.util.*;

/* Level - Medium (Topic- HashMap)
Problem Statement:- Given an array of integers arr and an integer k. Find the least number of unique integers after
removing exactly k elements.
    Example 1:

    Input: arr = [5,5,4], k = 1
    Output: 1
    Explanation: Remove the single 4, only 5 is left.

    Example 2:
    Input: arr = [4,3,1,1,3,3,2], k = 3
    Output: 2
    Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 */

public class Feb_16_LeastUniqueIntegersAfterKRemoval {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i:arr){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(hmap.entrySet());
        Collections.sort(list,(entry1,entry2)->{
            return entry1.getValue().compareTo(entry2.getValue());
        });

        int total=hmap.size();
        for(Map.Entry<Integer,Integer> entry:list){
            int v=entry.getValue();
            if(k>=v){
                k-=v;
                total-=1;
            }
            else{
                return total;
            }
        }
        return total;
    }
}
