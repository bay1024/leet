package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int prev) {
        if (root == null) return 0;
        int sum = root.val + prev * 10;
        if (root.left == null && root.right == null) return sum;
        return helper(root.left, sum) + helper(root.right, sum);
    }




    // 迭代
    public int sumNumbersIterator(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        nums.offer(root.val);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int tmp = nums.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    nums.offer(tmp * 10 + cur.left.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    nums.offer(tmp * 10 + cur.right.val);
                }
                if (cur.left == null && cur.right == null) {
                    sum += tmp;
                }
            }
        }

        return sum;
    }


    ////******************************
    public void dfs(TreeNode root, int[] sum,int[] x){
        if(root == null){
            return;
        }
        x[0] = x[0]*10 + root.val;
        if(root.left == null && root.right == null){
            sum[0] += x[0];
        }
        dfs(root.left,sum,x);
        dfs(root.right,sum,x);
        x[0] = x[0]/10;
    }

    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        int[] x = {0};
        dfs(root,sum,x);
        return sum[0];
    }
}
