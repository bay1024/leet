package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-09.
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /* recursive solution */
    public ListNode reverseList1(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)   return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
