package GeeksForGeeks.Feburary;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.left=null;
        this.right=null;
        this.data=data;
    }
}

/* Level - Medium (Topic - BST)
Problem Statement:- You are given a Binary Search Tree (BST) with n nodes, each node has a distinct value assigned to it.
The goal is to flatten the tree such that, the left child of each element points to nothing (NULL), and the right child
points to the next element in the sorted list of elements of the BST.

    Example 1:

    Input:
              5
            /    \
           3      7
          /  \    /   \
         2   4  6     8
    Output: 2 3 4 5 6 7 8
    Explanation:
    After flattening, the tree looks
    like this
        2
         \
          3
           \
            4
             \
              5
               \
                6
                 \
                  7
                   \
                    8
    Here, left of each node points
    to NULL and right contains the
    next node.
 */
public class Feb_16_FlattenBSTtoSortedList {
    Node dummy = new Node(0);
    Node prev = dummy;

    public Node flattenBST(Node root) {
        helper(root);
        prev.left=null;
        prev.right=null;
        return dummy.right;
    }

    public void helper(Node root) {
        if (root == null)
            return;

        helper(root.left);
        prev.left=null;
        prev.right = root;
        prev = root;

        helper(root.right);
    }
}
