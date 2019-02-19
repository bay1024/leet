package LC400_04_Tree;

/**
 * Created by Gary on 2018-12-31.
 */
public class LC222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
//        int rightDepth = rightDepth(root);  // 计算右边深度 注意不是右子树深度
//        int leftDepth = leftDepth(root);    // 计算左边深度 注意不是左子树深度
        // 若左右相等，则是满二叉树: 直接通过公式得出
//        if (leftDepth == rightDepth) return (1 << leftDepth) - 1;
        // 否则递归调用
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }

    // 方法2
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        int height = 0;
        int nodesSum = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            nodesSum += (1 << height);
            height++;
            curr = curr.left;
        }
        return nodesSum + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if (height == 1)
            if (root.right != null) return 2;
            else if (root.left != null) return 1;
            else return 0;
        TreeNode midNode = root.left;
        int currHeight = 1;
        while (currHeight < height) {
            currHeight++;
            midNode = midNode.right;
        }
        if (midNode == null) return countLastLevel(root.left, height - 1);
        else return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
    }
}
