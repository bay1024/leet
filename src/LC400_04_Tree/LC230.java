package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-29.
 */
public class LC230 {
    // time: O(n)  space O(n)
    private static int count = 0;
    private static int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        if (count == 0) return;
        helper(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        helper(root.right);
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode n = stack.pop();
            k--;
            if (k == 0) return n.val;
            current = n.right;
        }
        return -1;
    }
}
