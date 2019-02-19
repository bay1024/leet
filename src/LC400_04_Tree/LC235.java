package LC400_04_Tree;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC235 {
    // recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // iterator
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if ((root.val - p.val) * (root.val - q.val) <= 0) return root;
            root = p.val < root.val ? root.left : root.right;
        }
    }
}
