package LC400_12_BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC260 {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1)
                list.add(item.getKey());
        }
        return new int[]{list.get(0), list.get(1)};
    }
}
