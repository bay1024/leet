package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-15.
 */
public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode before = dummy1, after = dummy2;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = head;
            } else {
                after.next = head;
                after = head;
            }
            head = head.next;
        }
        after.next = null;
        before.next = dummy2.next;
        return dummy1.next;
    }
}
