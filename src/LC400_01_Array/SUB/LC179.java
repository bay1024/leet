package LC400_01_Array.SUB;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 */
public class LC179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)   return "";
        Comparator<String> comparator = (left, right) -> Long.valueOf(right + left).compareTo(Long.valueOf(left + right));
        Queue<String> queue = new PriorityQueue<>(nums.length, comparator);
        for (int num : nums) {
            queue.offer(String.valueOf(num));
        }

        StringBuilder sb = new StringBuilder(nums.length);
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }
}
