package LeetCode.January;
import java.util.*;

/* Level - Easy
Problem Statement:- Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
    Input: arr = [1,2,2,1,1,3]
    Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 */
public class Jan_17_Unique_Occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> hset=new HashSet<>();

        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key:map.keySet()){
            int occurrence=map.get(key);
            if(hset.contains(occurrence)){
                return false;
            }
            hset.add(occurrence);
        }
        return true;
    }
}
