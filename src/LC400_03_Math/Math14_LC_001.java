package LC400_03_Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math14_LC_001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                return new int[]{map.get(remainder), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
