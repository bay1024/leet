package LC400_12_BitManipulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> en = it.next();
            if (en.getValue() != 3)
                return en.getKey();
        }
        return -1;
    }
}
