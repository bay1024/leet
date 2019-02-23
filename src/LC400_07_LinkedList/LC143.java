package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // Find the middle node
        ListNode middle = findMiddle(head);
        // Reverse the second half
        ListNode head2 = reverse(middle.next);
        middle.next = null;
        // Link the two halves together
        while (head != null && head2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = tmp1;
            head2 = tmp2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
