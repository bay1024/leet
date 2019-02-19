package LC400_04_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC103 {
    // BFS: time: O(n)    space: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true; // true 从左到右； false从右到左
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (flag) list.add(curr.val);     // flag: true 从左到右 每次往list尾部加
                else list.add(0, curr.val);  // flag: false 从右到左 每次往list头部加
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            result.add(list);   // 把list加入结果集
            flag = !flag;       // 当前层结束，flag改变状态
        }
        return result;
    }

    // recursion
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        travel(res, 0, root);
        return res;
    }

    private void travel(List<List<Integer>> res, int level, TreeNode cur) {
        if (cur == null) return;
        if (res.size() <= level) res.add(new ArrayList<>());

        if (level % 2 == 0) res.get(level).add(cur.val);
        else                res.get(level).add(0, cur.val);

        travel(res, level + 1, cur.left);
        travel(res, level + 1, cur.right);
    }
}
