package LC400_01_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gary on 12/9/18.
 */
public class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else {
                int index = map.get(nums[i]);
                if ((i - index) <= k)   return true;
                else                    map.put(nums[i], i);
            }
        }
        return false;
    }
}
