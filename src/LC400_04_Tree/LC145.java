package LC400_04_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gary on 2018-12-26.
 */
public class LC145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)   return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.peek();
            if (curr.left == null && curr.right == null) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
            } else {
                if (curr.right != null) {
                    stack.push(curr.right);
                    curr.right = null;
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                    curr.left = null;
                }
            }
        }
        return result;
    }
}
