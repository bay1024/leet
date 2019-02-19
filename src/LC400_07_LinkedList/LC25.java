package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC25 {
    /**
     * 先搞清楚怎么逆转一个单链表。O(n).
     * 第一个肯定是last one. 然后每遍历到一个node就把它放到链表的首位，最后一个自然就成了第一个。
     * 步骤如下：
     * ListNode dummy = new ListNode(0);
     * dummy.next = head;
     * ListNode pre = dummy;
     * ListNode cur = head.next;
     * ListNode last = head;
     * while(cur != null){
     *      last.next = cur.next;
     *      cur.next = pre.next;
     *      pre.next = cur;
     *      cur = last.next;
     * }
     * head = dummy.next;
     *
     * 因为有放到链表首位的操作，需要一个dummy的头结点，遇到新节点，就pre.next = cur;
     * 保持一个invariant（不变量）就是last节点始终在最后(cur的前面)
     */

    /**
     * 于是就有了如下reverse方法
     * reverse a link list between pre and next exclusively
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     *
     * after call pre = reverse(pre,next)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *         pre next
     * @return the last node of reversed list, which is the precedence of parameter next
     * 就是区间的reverse
     */
    private ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
    // 题目要求的是k group逆转。所以上面的区间逆转返回的的是最后一个节点（last），
    // 这样下一个k group就可以用上了（该方法体贴周到）。
    // 主方法里，遍历的过程中每次都计数，每次达到k个节点，就可以使用pre和head.next调用上面的方法进行逆转了。
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)  return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                pre = reverse(pre, head.next);
                head = pre.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }

}
