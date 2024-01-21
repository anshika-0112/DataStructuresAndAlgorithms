package GeeksForGeeks.January;

/* Level - Hard
    Problem Statement:- Given a binary tree with N nodes, in which each node value represents number of candies present
     at that node. In one move, one may choose two adjacent nodes and move only one candy from one node to another
     (the move may be from parent to child, or from child to parent.)
    The task is to find the minimum number of moves required such that every node has exactly one candy.
    Note that the testcases are framed such that it is always possible to achieve a configuration in which every node
    has exactly one candy, after some moves.

    Example 1:

    Input :      3
               /   \
              0     0
    Output : 2
    Explanation:
    From the root of the tree, we move one
    candy to its left child, and one candy to
    its right child.
 */
public class Jan_20_DistributeCandiesInBinaryTree {
    int moves = 0;

    public int distributeCandy(Node root) {
        int m = minMove(root);
        return moves + m;
    }

    public int minMove(Node root) {
        if(root == null)    return 0;
        int m = minMove(root.left) + minMove(root.right) + root.data-1;
        moves += Math.abs(m);
        return m;
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
