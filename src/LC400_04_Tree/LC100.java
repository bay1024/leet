package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-26.
 */
public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        TreeNode currP = p, currQ = q;

        while ((currP != null && currQ != null) || (!stackP.isEmpty() && !stackQ.isEmpty())) {
            while (currP != null || currQ != null) {
                // check if root node q==p
                if (currP == null || currQ == null || currP.val != currQ.val) return false;
                stackP.push(currP);
                currP = currP.left;
                stackQ.push(currQ);
                currQ = currQ.left;
            }
            // when exit while loop p==q==null, now turn back to its parent which is the last left node.
            currP = stackP.pop();
            currQ = stackQ.pop();
            // traverse to right
            currP = currP.right;
            currQ = currQ.right;
        }
        return true;
    }
}
