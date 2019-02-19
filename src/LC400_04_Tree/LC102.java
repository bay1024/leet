package LC400_04_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Gary on 2018-12-26.
 */
public class LC102 {
    //
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);// 根节点入队
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                curLevel.add(head.val);
                if (head.left != null) q.offer(head.left);
                if (head.right != null) q.offer(head.right);
            }
            res.add(curLevel);
        }
        return res;
    }

    //dfs
    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int depth) {
        if (node == null) return;
        if (res.size() == depth) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(depth).add(node.val);
        helper(res, node.left, depth + 1);
        helper(res, node.right, depth + 1);
    }

}
