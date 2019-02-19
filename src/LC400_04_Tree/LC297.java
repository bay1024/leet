package LC400_04_Tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Gary on 2018-12-29.
 */
class Codec {
    private final String delimiter = ",";
    private final String emptyNode = "#";

    // 序列化，给根节点，返回字符串
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        helper(root, res);
        if (res.length() > 0) res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // 序列化的递归函数
    private void helper(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append(emptyNode).append(delimiter);
        } else {
            res.append(root.val).append(delimiter);
            helper(root.left, res);
            helper(root.right, res);
        }
    }

    // 反序列化，给字符串，构造树，返回根节点
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(delimiter)));
        return helper2(nodes);
    }

    //反序列化的递归
    private TreeNode helper2(LinkedList<String> nodes) {
        String nodeValue = nodes.pollFirst();
        if (nodeValue.equals(emptyNode)) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
            node.left = helper2(nodes);
            node.right = helper2(nodes);
            return node;
        }
    }
}

public class LC297 {
}
