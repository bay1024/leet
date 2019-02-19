package LC400_04_Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC226 {
    // recursive DFS
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left   = invertTree(right);
        root.right  = invertTree(left);
        return root;
    }

    // stack迭代
    public TreeNode invertTreeIterator(TreeNode root) {
        if (root == null) return null;
        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left   = node.right;
            node.right  = left;
            if (node.left != null)  stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }

    // 广搜
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null)  queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
