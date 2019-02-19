package LC400_04_Tree;

import java.util.LinkedList;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        //return hasPathSumBFS(root, sum);
        return hasPathSumRecursion(root, sum);
    }

    // 迭代法
    public boolean hasPathSumBFS(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pollLast();
            Integer currentSum = sumStack.pollLast();

            if ((currentNode.right == null) && (currentNode.left == null) && (currentSum == 0)) return true;

            if (currentNode.right != null) {
                nodeStack.add(currentNode.right);
                sumStack.add(currentSum - currentNode.right.val);
            }
            if (currentNode.left != null) {
                nodeStack.add(currentNode.left);
                sumStack.add(currentSum - currentNode.left.val);
            }
        }
        return false;
    }

    // 递归法
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if ((root.left == null) && (root.right == null)) return (sum == 0);
        return hasPathSumRecursion(root.left, sum) || hasPathSumRecursion(root.right, sum);
    }
}
