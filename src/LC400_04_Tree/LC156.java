package LC400_04_Tree;

/**
 * Created by Gary on 2018-12-30.
 */
public class LC156 {
    // Iterator
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode current = root;
        TreeNode next, temp = null, prev = null;
        while (current != null) {
            next = current.left;
            // swapping nodes now, need temp to keep the previous right child
            current.left = temp;
            temp = current.right;
            current.right = prev;

            prev = current;
            current = next;
        }
        return prev;
    }

    // Recursion
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        if(root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree1(root.left);
        root.left.left = root.right;   // node 2 left children
        root.left.right = root;         // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
