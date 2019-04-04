package LC400_04_Tree;

import java.util.*;

/**
 * Created by Gary on 2018-12-27.
 */
public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePathsRecursion(root);
    }

    // Recursion
    public List<String> binaryTreePathsRecursion(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }

        for (String s : binaryTreePaths(root.left)) {
            result.add(root.val + "->" + s);
        }

        for (String s : binaryTreePaths(root.right)) {
            result.add(root.val + "->" + s);
        }
        return result;
    }


    //DFS - Stack
    public List<String> binaryTreePathsDfsStack(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> sNode = new Stack<>();
        Stack<String> sStr = new Stack<>();

        if (root == null) return list;
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()) {
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();

            if (curNode.left == null && curNode.right == null) {
                list.add(curStr + curNode.val);
                continue;
            }
            if (curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return list;
    }

    // BFS - Queue
    public List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<String> qStr = new LinkedList<>();

        if (root == null) return list;
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();

            if (curNode.left == null && curNode.right == null) {
                list.add(curStr + curNode.val);
                continue;
            }
            if (curNode.left != null) {
                qNode.add(curNode.left);
                qStr.add(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                qNode.add(curNode.right);
                qStr.add(curStr + curNode.val + "->");
            }
        }
        return list;
    }

}
