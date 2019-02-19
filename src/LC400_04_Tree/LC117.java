package LC400_04_Tree;

/**
 * Created by Gary on 2019-01-01.
 */
public class LC117 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode leftEnd = root;
        while (leftEnd != null) {
            TreeLinkNode cur = leftEnd;
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode pr = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pr.next = cur.left;
                    pr = cur.left;
                }
                if (cur.right != null) {
                    pr.next = cur.right;
                    pr = cur.right;
                }
                cur = cur.next;
            }
            leftEnd = dummy.next;
        }
    }
}
