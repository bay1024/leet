package LC400_02_String;

import java.util.*;

/**
 * Created by Gary on 11/11/18.
 */
public class LC358 {
    public String rearrangeString(String str, int k) {
        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c))    map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        int len = str.length();
        for (int v: map.values()) {
            if (v > len / k) {
                return "";
            }
        }
        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap
                = new PriorityQueue<>((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);
            // initial k-1 chars, waitQueue not full yet
            if (waitQueue.size() < k) continue;
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) maxHeap.offer(front);
        }

        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }

    public static void main(String[] args) {
        String str = "abcbabab";
        int k = 3;
        LC358 solution = new LC358();
        System.out.println(solution.rearrangeString(str, k));
    }
}
