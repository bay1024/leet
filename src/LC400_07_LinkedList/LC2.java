package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode m = l1, n = l2, curr = dump;
        int carry = 0;
        while (m != null || n != null) {
            int x = (m == null ? 0 : m.val);
            int y = (n == null ? 0 : n.val);
            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            if (m != null) m = m.next;
            if (n != null) n = n.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return dump.next;
    }
}
