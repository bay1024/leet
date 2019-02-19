package LC400_18_Design;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Gary on 2019-01-20.
 */
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    int count;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next; // 先后面：新节点next
        node.next.pre = node;  // 先后面：右节点的pre
        node.pre = head;       // 再前面：新节点的pre
        head.next = node;      // 再前面：head的next
    }

    public int get(int key) {
        Node node = map.get(key);
        // 如果找不到，就返回-1
        if (node == null) return -1;
        // 如果找到，把value保存下来，先从双端链表中删除，
        // 再加入到头部，返回保存下来的值
        int result = node.value;
        deleteNode(node);
        addToHead(node);
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // 找到
        if (node != null) {
            node.value = value; // 更新值value
            deleteNode(node);   // 删除
            addToHead(node);    // 提到头部
        } else { //没找到
            node = new Node(key, value); //用键值对创建一个新的
            map.put(key, node);         // 放入map中
            if (count < capacity) {     // 如果还能放得下
                count++;
                addToHead(node);        // 放入并把count++
            } else {    // 如果放不下
                map.remove(tail.pre.key); //把最后一个node从map中移除
                deleteNode(tail.pre);     // 在双端链表中把最后一个删除
                addToHead(node);          // 把新node 加入到头部
            }
        }
    }
}

class LRUCache1 {
    private HashMap<Integer, Integer> map;
    private LinkedList<Integer> queue;
    private int capacity;

    public LRUCache1(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.removeLastOccurrence(key);
            queue.offerFirst(key);
            map.put(key, value);
        } else {
            if (queue.size() >= capacity && capacity != 1) {
                int temp = queue.removeLast();
                map.remove(temp);
            } else if (capacity == 1 && queue.size() + 1 > capacity) {
                int temp = queue.removeLast();
                map.remove(temp);
            }
            queue.offerFirst(key);
            map.put(key, value);
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int result = map.get(key);
        queue.removeLastOccurrence(key);
        queue.offerFirst(key);
        return result;
    }
}
public class LC146 {
}
