package LC400_01_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long next = lower;// 下一个要找的数字
        for (long current : nums) {
            // 还没到range范围
            if (current < next) continue;
            // 继续找下一个
            if (current == next) {
                next++;
                continue;
            }
            result.add(getRange(next, current - 1));
            next = current + 1;
        }
        if (next <= upper) result.add(getRange(next, upper));
        return result;
    }

    private String getRange(long num1, long num2) {
        return (num1 == num2) ? String.valueOf(num1) : String.format("%d->%d", num1, num2);
    }
}
