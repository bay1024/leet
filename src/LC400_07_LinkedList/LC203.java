package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-09.
 */
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (head.next.val == val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return dummy.next;
    }
}
