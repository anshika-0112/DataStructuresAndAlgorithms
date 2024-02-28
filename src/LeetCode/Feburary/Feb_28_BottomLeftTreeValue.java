package LeetCode.Feburary;

/*
Problem Statement:- Given the root of a binary tree, return the leftmost value in the last row of the tree.
Example 1:
    2
   / \
  1    3
Input: root = [2,1,3]
Output: 1
 */

public class Feb_28_BottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] result = new int[]{0, 0};
        help(root, 1, result);
        return result[1];
    }

    private void help(TreeNode node, int currD, int[] result) {
        if (node == null) {
            return;
        }
        if (currD > result[0]) {
            result[0] = currD;
            result[1] = node.val;
        }

        help(node.left, currD + 1, result);
        help(node.right, currD + 1, result);
    }
}

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