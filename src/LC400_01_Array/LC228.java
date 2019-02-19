package LC400_01_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // 判断后面一个和当前一个是否连续，i指针一直后移到不连续状态停止
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (current != nums[i]) result.add(current + "->" + nums[i]);
            else result.add(current + "");
        }
        return result;
    }
}
