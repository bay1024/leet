package LC400_01_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 12/22/18.
 */
public class LC56 {
    public List<Interval> merge(List<Interval> intervals) {
        // 如果个数小于2就直接返回
        if (intervals.size() <= 1)  return intervals;
        // 按start排序
        intervals.sort((a, b) -> (a.start - b.start));

        List<Interval> res = new ArrayList<>();
        // 初始化start和end
        int start   = intervals.get(0).start;
        int end     = intervals.get(0).end;
        // 从index = 1开始遍历
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            // 重叠，更新end
            if (current.start <= end) end = Math.max(end, current.end);
            else {
                // 不重叠， 把start和end加入；并更新start和end
                res.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        // 不要忘了把最后一个加入
        res.add(new Interval(start, end));
        return res;
    }
}
