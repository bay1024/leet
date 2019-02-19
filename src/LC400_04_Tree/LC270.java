package LC400_04_Tree;

/**
 * Created by Gary on 2018-12-29.
 */
public class LC270 {
    // recursion
    public int closestValue(TreeNode root, double target) {
        int value = root.val;
        TreeNode which = value < target ? root.right : root.left;
        if (which == null) return value;
        int another = closestValue(which, target);
        return Math.abs(value - target) < Math.abs(another - target) ? value : another;
    }

    // iterator
    public int closestValue1(TreeNode root, double target) {
        int result = root.val;
        while (root != null) {
            if (Math.abs(result - target) >= Math.abs(root.val - target)) result = root.val;
            root = target < root.val ? root.left : root.right;
        }
        return result;
    }
}
