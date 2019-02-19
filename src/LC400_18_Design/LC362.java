package LC400_18_Design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2019-01-17.
 */
//class HitCounter {
//    int[] times;
//    int[] hits;
//
//    public HitCounter() {
//        times = new int[300];
//        hits = new int[300];
//    }
//
//    public void hit(int timestamp) {
//        int index = timestamp % 300;
//        if (times[index] != timestamp) {
//            times[index] = timestamp;
//            hits[index] = 1;
//        } else {
//            hits[index]++;
//        }
//    }
//
//    public int getHits(int timestamp) {
//        int result = 0;
//        for (int i = 0; i < 300; i++) {
//            if (timestamp - times[i] < 300) {
//                result += hits[i];
//            }
//        }
//        return result;
//    }
//}
class HitCounter {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        queue = new LinkedList<>();
    }

    /**
     * Record a hit.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
}

public class LC362 {

}
