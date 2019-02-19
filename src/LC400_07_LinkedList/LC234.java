package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = slow.next, pre = head;
        while (last.next != null) {
            ListNode temp = last.next;
            last.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }
        while (slow.next != null) {
            slow = slow.next;
            if (pre.val != slow.val) return false;
            pre = pre.next;
        }
        return true;
    }
}
