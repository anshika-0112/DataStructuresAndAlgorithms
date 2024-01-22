package GeeksForGeeks.January;

import java.util.ArrayList;

/* Level - Medium (Binary Tree)
    Problem Statement:- Given a Binary tree and a sum S, print all the paths, starting from root, that sums up to the given sum. Path not necessarily end on a leaf node.

    Example 1:

    Input :
    sum = 8
    Input tree
             1
           /   \
         20      3
               /    \
             4       15
            /  \     /  \
           6    7   8    9

    Output :
    1 3 4
    Explanation :
    Sum of path 1, 3, 4 = 8.
 */
public class Jan_22_PathsFromRoot {
    static ArrayList<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        solve(root, sum, 0, path);
        return res;
    }

    public static void solve(Node cur, int sum, int currSum, ArrayList<Integer> path){
        path.add(cur.data);

        if( currSum + cur.data  == sum){
            ArrayList<Integer> arr = new ArrayList<>(path);
            res.add(arr);
        }

        if(cur.left!=null) solve(cur.left, sum, currSum + cur.data, path);
        if(cur.right!=null) solve(cur.right, sum, currSum + cur.data, path);

        path.remove(path.size()-1);
    }
}
