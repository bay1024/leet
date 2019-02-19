package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // find the middle node of the list
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the half after middle node:
        // 1->2->3->4->5->6->7->8 changes to 1->2->3->4->8->7->6->5
        ListNode middle = slow, prev = slow.next;
        while (prev.next != null) {
            ListNode curr = prev.next;
            prev.next = curr.next;
            curr.next = middle.next;
            middle.next = curr;
        }

        // reorder one by one
        ListNode before = head, after = middle.next;
        while (before != middle) {
            middle.next = after.next;
            after.next = before.next;
            before.next = after;
            before = after.next;
            after = middle.next;
        }
    }
}
