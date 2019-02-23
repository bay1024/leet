package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode middle = LinkedListUtils.findMiddle(head);
        middle.next = LinkedListUtils.reverse(middle.next);
        while (middle.next != null) {
            middle = middle.next;
            if (head.val != middle.val) return false;
            head = head.next;
        }
        return true;
    }
}
