package LC400_04_Tree;

/**
 * Created by Gary on 2018-12-28.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//[-10,-3,0,5,9],
public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode tn = new TreeNode(slow.val);
        tn.left = toBST(head, slow);
        tn.right = toBST(slow.next, tail);
        return tn;
    }
}
