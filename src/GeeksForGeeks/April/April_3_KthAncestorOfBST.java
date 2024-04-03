package GeeksForGeeks.April;

import java.util.*;

public class April_3_KthAncestorOfBST {
    boolean flag = false;
    int c = 0;
    int ans = -1;

    public int kthCommonAncestor(Node root, int k, int x, int y) {
        if(root == null || (root.left == null && root.right == null))
            return -1;

        List<Integer> list = new LinkedList<>();
        kthAncestor(root, x, y, list);
        int count = 1, idx = list.size() - 1;
        while(count < k) {
            idx--;
            if(idx < 0)
                return -1;
            count++;
        }

        return idx >= 0 ? list.get(idx) : -1;
    }

    private void kthAncestor(Node root, int x, int y, List<Integer> list) {
        if(root == null)
            return;

        list.add(root.data);
        if(root.data > x && root.data > y)
            kthAncestor(root.left, x, y, list);
        if(root.data < x && root.data < y)
            kthAncestor(root.right, x, y, list);
    }
}
