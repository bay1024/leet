package LC400_14_Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Gary on 2019-01-31.
 */

public class LC398 {
    class Solution {
        private Map<Integer, ArrayList<Integer>> map;
        public Solution(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                ArrayList<Integer> list = map.get(nums[i]);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                } else {
                    list.add(i);
                }
            }
        }

        public int pick(int target) {
            ArrayList<Integer> result = map.get(target);
            Random r = new Random();
            return result.get(r.nextInt(result.size()));
        }
    }
}
