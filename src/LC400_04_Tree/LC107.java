package LC400_04_Tree;

import java.util.*;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC107 {
    // BFS
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                levelList.add(current.val);
            }
            result.add(0, levelList);
        }
        return result;
    }

    // DFS
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelMaker(result, root, 0);
        return result;
    }

    private void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
