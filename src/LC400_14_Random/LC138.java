package LC400_14_Random;

public class LC138 {
    /**
     * Created by Gary on 2019-02-02.
     * Definition for singly-linked list with a random pointer.
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;
            RandomListNode current = head;
            //第一遍扫描，复制每个节点，放在原节点之后
            while (current != null) {
                RandomListNode newNode = new RandomListNode(current.label);
                newNode.next = current.next;
                current.next = newNode;
                current = newNode.next;
            }
            //第二遍扫描，根据原节点的random指针，给新节点的random赋值
            current = head;
            while (current != null) {
                if (current.random != null) {
                    current.next.random = current.random.next;
                }
                current = current.next.next;
            }
            // 第三遍扫描，把新节点从原链表中拆出来
            current = head;
            RandomListNode newHead = head.next;
            while (current != null) {
                RandomListNode newNode = current.next;
                current.next = newNode.next;
                if (newNode.next != null) {
                    newNode.next = newNode.next.next;
                }
                current = current.next;
            }
            return newHead;
        }
    }
}
