package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-29.
 */
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode current = stack.pop();
        pushAll(current.right);
        return current.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

public class LC173 {

}
