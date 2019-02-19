package LC400_04_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gary on 2018-12-29.
 */
public class LC272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // 用两个栈s1, s2来分别保存 <= 目标的数; 和 > 目标值的数，
        // s1升序入栈，s2降序入栈。
        // 然后while循环从两个栈的栈顶取数，比较哪个接近target，pop放入结果集
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        inorder(root, target, false, s1);
        inorder(root, target, true, s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        while (k-- > 0) {
            if (s1.isEmpty()) res.add(s2.pop());
            else if (s2.isEmpty()) res.add(s1.pop());
            else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) res.add(s1.pop());
            else res.add(s2.pop());
        }
        return res;
    }

    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (root == null) return;
        inorder(reverse ? root.right : root.left, target, reverse, stack);
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
        stack.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }
}
