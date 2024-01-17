package GeeksForGeeks.January;

import java.util.*;

/* Level - Medium
Problem Statement :- Find all possible unique permutations of the array in sorted order.
    Input:
        n = 3
        arr[] = {1, 2, 1}
    Output:
        1 1 2
        1 2 1
        2 1 1
*/
public class Jan_17_UniquePermutations {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        HashSet<ArrayList<Integer>> hset = new HashSet<>();
        boolean[] f = new boolean[n];
        helper(arr, n, f, a, res, hset);
        Collections.sort(res,(k, l)->{
            for(int i=0;i<n;i++){
                int cmp=Integer.compare(k.get(i),l.get(i));
                if(cmp!=0){
                    return cmp;
                }
            }
            return 0;
        });
        return res;
    }

    static void helper(ArrayList<Integer> arr, int n, boolean[] f, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> res, HashSet<ArrayList<Integer>> hset) {
        if (a.size() == n) {
            if (hset.add(new ArrayList<>(a))) {
                res.add(new ArrayList<>(a));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!f[i]) {
                a.add(arr.get(i));
                f[i] = true;
                helper(arr, n, f, a, res, hset);
                a.remove(a.size() - 1);
                f[i] = false;
            }
        }
    }
}
