package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break; // 快指针追上慢指针，说明有环，break跳出循环
        }
        // 错误检查，没有碰撞，也就是没有环路
        if (fast == null || fast.next == null) return null;
        // 将fast指向首部，slow留在碰撞处，两者距离环路起始处K步，
        // 若两者以相同速度移动，则必定会在环路起始处碰在一起
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 至此两者均指向环路起始处
        return fast;
    }
}
