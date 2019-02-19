package LC400_04_Tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC298 {
    // 递归
    public int longestConsecutive(TreeNode root) {
        return (root == null) ? 0 : Math.max(helper(root.left, 1, root.val), helper(root.right, 1, root.val));
    }

    private int helper(TreeNode root, int count, int val) {
        if (root == null) return count;
        count = (root.val - val == 1) ? count + 1 : 1;
        int leftCount = helper(root.left, count, root.val);
        int rightCount = helper(root.right, count, root.val);
        return Math.max(Math.max(leftCount, rightCount), count);
    }

    // 迭代
    public int longestConsecutiveIterator(TreeNode root) {
        if (root == null) return 0;
        int max = 1;
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        map.put(root, 1);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int left = cur.left != null && cur.left.val - cur.val == 1 ? map.get(cur) + 1 : 1;
            int right = cur.right != null && cur.right.val - cur.val == 1 ? map.get(cur) + 1 : 1;
            max = Math.max(max, Math.max(left, right));
            if (cur.right != null) {
                stack.push(cur.right);
                map.put(cur.right, right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                map.put(cur.left, left);
            }
        }
        return max;
    }
}
