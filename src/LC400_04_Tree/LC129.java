package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int prev) {
        if (root == null) return 0;
        int sum = root.val + prev * 10;
        if (root.left == null && root.right == null) return sum;
        return helper(root.left, sum) + helper(root.right, sum);
    }

    // 迭代
    public int sumNumbersIterator(TreeNode root) {
        if (root == null)   return 0;
        int sum = 0;
        TreeNode currentNode;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            currentNode = stack.pop();
            if (currentNode.right != null) {
                currentNode.right.val = currentNode.val * 10 + currentNode.right.val;
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                currentNode.left.val = currentNode.val * 10 + currentNode.left.val;
                stack.push(currentNode.left);
            }
            if (currentNode.left == null && currentNode.right == null) { // leaf node
                sum += currentNode.val;
            }
        }
        return sum;
    }
}
