package LC400_04_Tree;

import java.util.LinkedList;
/**
 * Created by Gary on 2018-12-27.
 */
public class LC111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }


    class Pair {
        public TreeNode node;
        public int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepthBFS(TreeNode root) {
        LinkedList<Pair> stack = new LinkedList<>();
        if (root == null) return 0;

        stack.add(new Pair(root, 1));
        int currentDepth = 1;
        while (!stack.isEmpty()) {
            Pair current = stack.poll();
            root = current.node;
            currentDepth = current.depth;
            if ((root.left == null) && (root.right == null)) break;
            if (root.left != null) stack.offer(new Pair(root.left, currentDepth + 1));
            if (root.right != null) stack.offer(new Pair(root.right, currentDepth + 1));
        }
        return currentDepth;
    }
}
