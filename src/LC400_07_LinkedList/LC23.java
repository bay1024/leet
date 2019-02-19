package LC400_07_LinkedList;

import java.util.PriorityQueue;

/**
 * Created by Gary on 2019-02-15.
 */
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l = helper(lists, left, mid);
        ListNode r = helper(lists, mid + 1, right);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                tail.next = l;
                tail = l;
                l = l.next;
            } else {
                tail.next = r;
                tail = r;
                r = r.next;
            }
        }
        if (l != null) tail.next = l;
        else tail.next = r;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode n : lists) {
            if (n != null) pq.offer(n);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode head = pq.poll();
            curr.next = head;
            curr = curr.next;
            if (head.next != null) pq.offer(head.next);
        }
        return dummy.next;
    }
}
