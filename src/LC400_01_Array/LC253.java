package LC400_01_Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Gary on 12/22/18.
 */
public class LC253 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 把interval数组先按start排好序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        // 使用优先级队列来维护一个小顶堆来存储merged interval，每次弹出最早结束的interval
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(interval -> interval.end));
        // start with the first meeting
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // get teh meeting room that finished earliest
            Interval interval = pq.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after there is no need a new room
                // merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise this meeting needs a new room
                pq.offer(intervals[i]);
            }
            // put the meeting room back
            pq.offer(interval);
        }
        return pq.size();
    }
}
