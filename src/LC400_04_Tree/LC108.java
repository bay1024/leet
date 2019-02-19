package LC400_04_Tree;

import java.util.LinkedList;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC108 {
    // Recursion
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }


    // Iterator
    public TreeNode sortedArrayToBST2(int[] nums) {
        int len = nums.length;
        if (len == 0) return null;

        // 0 as a placeholder
        TreeNode head = new TreeNode(0);

        LinkedList<TreeNode> nodeStack = new LinkedList<TreeNode>() {{
            push(head);
        }};
        LinkedList<Integer> leftIndexStack = new LinkedList<Integer>() {{
            push(0);
        }};
        LinkedList<Integer> rightIndexStack = new LinkedList<Integer>() {{
            push(len - 1);
        }};

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right - left) / 2;
            currNode.val = nums[mid];
            if (left <= mid - 1) {
                currNode.left = new TreeNode(0);
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid - 1);
            }
            if (mid + 1 <= right) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid + 1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }
}
