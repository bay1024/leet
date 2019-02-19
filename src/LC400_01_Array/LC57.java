package LC400_01_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 12/22/18.
 */
class Interval {
    int start;
    int end;
    Interval()
    { start = 0; end = 0; }
    Interval(int s, int e)
    { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class LC57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) {
            res.add(newInterval);
            return res;
        }

        // 分成三部分
        int index = 0;
        // 第一部分，左边。左边达不到合并要求的interval都要加入到结果。
        while (index < intervals.size() && intervals.get(index).end < newInterval.start)
            res.add(intervals.get(index++));

        // 第二部分，要合并的部分。一直更新newInterval的start和end，最后直到不满足条件，加入结果
        while (index < intervals.size() && newInterval.end >= intervals.get(index).start) {
            Interval current = intervals.get(index);
            newInterval.start = Math.min(current.start, newInterval.start);
            newInterval.end = Math.max(current.end, newInterval.end);
            index++;
        }
        res.add(newInterval);

        // 第三部分，剩余的部分。合并完毕后剩余的interval继续加入结果集。
        while (index < intervals.size())
            res.add(intervals.get(index++));

        return res;
    }
}
