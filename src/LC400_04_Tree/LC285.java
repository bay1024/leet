package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-29.
 */
public class LC285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // 找到目标节点并把路径上的节点压入栈
        while (current != p) {
            stack.push(current);
            if (current.val > p.val) current = current.left;
            else current = current.right;
        }
        // 如果目标节点有右节点，则找到其右节点的最左边的节点，就是下一个数
        if (current.right != null) {
            current = current.right;
            while (current.left != null) current = current.left;
            return current;
        } else {
            // 如果没有右节点，pop栈找到第一个比目标节点大的节点
            while (!stack.isEmpty() && stack.peek().val < current.val) stack.pop();
            // 如果栈都pop空了还没有比目标节点大的，说明没有更大的了
            return stack.isEmpty() ? null : stack.pop();
        }
    }
    // 解法2
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }
            else root = root.right;
        }
        return succ;
    }
}
