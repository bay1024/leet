package LC400_04_Tree;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC337 {
    // dfs all the nodes of the tree, each node return two number,
    // num[0] is the max value while rob this node,
    // num[1] is max value while not rob this value.
    // Current node return value only depend on its children's value.
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}
