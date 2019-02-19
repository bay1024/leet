package LC400_04_Tree;

import java.util.Stack;

/**
 * Created by Gary on 2018-12-30.
 */
public class LC255 {
    // Space: O(n)
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder) {
            if (p < low) return false;
            while (!path.empty() && p > path.peek()) low = path.pop();
            path.push(p);
        }
        return true;
    }

    // Space: O(1)
    public boolean verifyPreorder1(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low) return false;
            while (i >= 0 && p > preorder[i]) low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}
