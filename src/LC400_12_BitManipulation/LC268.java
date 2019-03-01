package LC400_12_BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC268 {
    public int missingNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int value : nums) {
            list.add(value);
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (!list.contains(i)) return i;
        }
        if (i == nums.length) return i;
        return -1;
    }
}
