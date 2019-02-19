package LC400_14_Random;
import java.util.Random;

/**
 * Created by Gary on 2019-02-01.
 */
public class LC382 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        private ListNode head;
        private int count;
        private Random r;

        public Solution(ListNode head) {
            r = new Random();
            this.head = head;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                this.count++;
            }
        }

        public int getCount() { return this.count; }

        public int getRandom() {
            int rand = r.nextInt(getCount());
            ListNode t = head;
            while (rand > 0) {
                t = t.next;
                rand--;
            }
            return t.val;
        }
    }
}
