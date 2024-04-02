package GeeksForGeeks.April;

public class April_2_MinAbsoluteDiffInBST {
    int diff=Integer.MAX_VALUE;
    int prev=-1;

    int absolute_diff(Node root)
    {
        helper(root);
        return diff;
    }
    void helper(Node root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=-1){
            diff=Math.min(diff,Math.abs(prev-root.data));
        }
        prev=root.data;
        helper(root.right);
    }
}
