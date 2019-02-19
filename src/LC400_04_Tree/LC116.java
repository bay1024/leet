package LC400_04_Tree;

/**
 * Created by Gary on 2019-01-01.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class LC116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode leftEnd = root;
        while (leftEnd.left != null) {
            TreeLinkNode cur = leftEnd;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            leftEnd = leftEnd.left;
        }
    }
}
