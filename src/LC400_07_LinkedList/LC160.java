package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-10.
 */
public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // 先计算两个链表各自的长度
        int count1 = 0, count2 = 0;
        ListNode l1 = headA, l2 = headB;
        while (l1 != null) {
            l1 = l1.next; count1++;
        }
        while (l2 != null) {
            l2 = l2.next; count2++;
        }
        // 对于较长的那个链表，从头部开始移动指针，
        // 移动到剩余的节点个数 和较短的那个链表相等
        int i = 0; l1 = headA; l2 = headB; int dif;
        if (count1 > count2) {
            dif = count1 - count2;
            while (i < dif) {
                i++; l1 = l1.next;
            }
        } else {
            dif = count2 - count1;
            while (i < dif) {
                i++; l2 = l2.next;
            }
        }
        // 此时，两个指针后面的元素个数相等，开始找相交的地方
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val)  return l1;
            else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        // 最后都遍历完毕，如果还没找到，就说明没有相交
        return null;
    }
}
