package LC400_04_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2018-12-26.
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.offer(root);
        right.offer(root);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            // 左右都空,继续向下判断
            if (l == null && r == null) continue;
                // 一个是空一个不是空，肯定不对称
            else if (l == null || r == null) return false;
            // 左右都不空，判断值是否相等，值不等，肯定不对称
            if (l.val != r.val) return false;
            else {
                // 注意入队顺序，要保持对称
                left.offer(l.left);
                left.offer(l.right);
                right.offer(r.right);
                right.offer(r.left);
            }
        }
        // 循环结束，则对称
        return true;
    }

    public boolean isSymmetricRecursion(TreeNode root) {
        if (root == null)   return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null)      return true;    // 都为空 true
        else if (right == null || left == null) return false;   // 一个空一个不空 false
        if (left.val != right.val)              return false;   // 都不空, 左右不等 false
        if (!isSym(left.left, right.right))     return false;   // 都不空， 左右等，判断左左是否和右右是否same
        if (!isSym(left.right, right.left))     return false;   // 都不空，左右相等，判断左右和右左是否same
        return true;
    }
}
