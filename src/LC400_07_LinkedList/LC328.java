package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-09.
 */
public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddStart = odd;
        ListNode evenStart = even;
        head = head.next.next;
        int i = 1;
        while (head != null) {
            if (i % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            i++;
        }
        even.next = null;
        odd.next = evenStart;
        return oddStart;
    }
}
