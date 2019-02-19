package LC400_04_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC104 {
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 迭代
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int dep = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode n = q.poll();
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
                size--;
            }
            dep++;
        }
        return dep;
    }
}
