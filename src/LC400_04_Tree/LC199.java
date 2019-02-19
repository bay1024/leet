package LC400_04_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC199 {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // 先将右孩子入队，每次i==0时，也就是每层第一个保证是最右边的，加入结果
                if (i == 0) result.add(current.val);
                if (current.right != null) queue.offer(current.right);
                if (current.left != null) queue.offer(current.left);
            }
        }
        return result;
    }

    // Recursion
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null)    return;
        if(currDepth == result.size()) result.add(curr.val);
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}
