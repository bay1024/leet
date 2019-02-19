package LC400_04_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Gary on 2018-12-30.
 */
public class LC114 {
    // 递归法
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    // 迭代法: 用一个栈和一个队列来实现，队列用来存储先序遍历的结果，栈用于先序遍历
    public void flatten1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root);
        queue.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left != null) {
                queue.add(top.left);
                stack.push(top.left);
                top.left = null;
            } else if (top.right != null) {
                queue.add(top.right);
                stack.push(top.right);
                top.right = null;
            } else { //top.left == null && top.right == null
                stack.pop();
            }
        }
        TreeNode node = queue.poll();
        while (!queue.isEmpty()) {
            node.right = queue.poll();
            node = node.right;
        }
    }
}
