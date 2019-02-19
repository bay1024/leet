package LC400_04_Tree;

import java.util.*;

/**
 * Created by Gary on 2019-01-05.
 */
public class LC314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // 广搜辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        // key:第几列  value:对应列的元素
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 列数
        Queue<Integer> cols = new LinkedList<>();

        queue.add(root);
        cols.add(0);
        int min = 0, max = 0; //记录列的上下边界

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }

        }

        for (int i = min; i <= max; i++) {//从左向右 每列数据加入结果集
            result.add(map.get(i));
        }
        return result;
    }
}
