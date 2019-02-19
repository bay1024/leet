package LC400_07_LinkedList;

/**
 * Created by Gary on 2019-02-09.
 */
public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
