package LC400_04_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC113 {
    // 递归
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, result, path);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }
    }

    // 迭代
    public List<List<Integer>> pathSumIterator(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        int currentSum = 0;
        TreeNode currentNode = root;
        TreeNode pre = null;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                path.add(currentNode.val);
                currentSum += currentNode.val;
                currentNode = currentNode.left;
            }
            currentNode = stack.peek();
            if (currentNode.right != null && currentNode.right != pre) {
                currentNode = currentNode.right;
                continue;
            }
            if (currentNode.left == null && currentNode.right == null && currentSum == sum)
                res.add(new ArrayList<>(path));

            pre = currentNode;
            stack.pop();
            path.remove(path.size() - 1);
            currentSum -= currentNode.val;
            currentNode = null;
        }
        return res;
    }
}
