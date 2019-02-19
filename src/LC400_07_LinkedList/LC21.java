package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode last = dump;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        if (l1 != null) last.next = l1;
        else last.next = l2;
        return dump.next;
    }
}
