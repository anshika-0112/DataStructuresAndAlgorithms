package LeetCode.January;

/* Level Medium (Topic - Binary Tree)
    Problem Statement:- Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
    Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Example 1:
    Input: root = [2,3,1,3,1,null,1]
    Output: 2
    Explanation: The figure above represents the given binary tree. There are three paths going from the root node to
    leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and
    green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the
    green path [2,1,1] can be rearranged in [1,2,1] (palindrome).

*/
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class Jan_24_PseudoPalindromicPaths {
    int c = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] pathFreq = new int[10];
        helper(root, pathFreq);
        return c;
    }

    public void helper(TreeNode root, int[] pathFreq) {
        if (root == null) {
            return;
        }

        pathFreq[root.val]++;

        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(pathFreq)) {
                c++;
            }
        } else {
            helper(root.left, pathFreq);
            helper(root.right, pathFreq);
        }

        pathFreq[root.val]--;
    }

    public boolean isPseudoPalindromic(int[] pathFreq) {
        int oddCount = 0;

        for (int freq : pathFreq) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }
}
