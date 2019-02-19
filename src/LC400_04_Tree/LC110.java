package LC400_04_Tree;

import java.util.*;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC110 {
    // 递归法
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // 迭代法
    public boolean isBalancedIterator(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if ((node.left == null || map.containsKey(node.left)) && (node.right == null || map.containsKey(node.right))) {
                int left = node.left == null ? 0 : map.get(node.left);
                int right = node.right == null ? 0 : map.get(node.right);
                if (Math.abs(left - right) > 1) return false;
                map.put(node, Math.max(left, right) + 1);
            } else {
                if (node.left != null && !map.containsKey(node.left)) {
                    stack.push(node);
                    stack.push(node.left);
                } else {
                    stack.push(node);
                    stack.push(node.right);
                }
            }
        }
        return true;
    }
}
