package LC400_01_Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gary on 12/22/18.
 */
public class LC252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return false;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        //遍历，如果一个会议要开始，可是前一个会议还没有结束，就返回FALSE
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }
        // 能遍历到最后，就说明可以attend所有会
        return true;
    }
}
