package LC400_18_Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary on 2019-01-17.
 */
class TwoSum {
    List<Integer> list;
    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // O(1)
    public void add(int number) {
        list.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // O(n)
    public boolean find(int value) {
        for (int current : list) {
            int remainder = value - current;
            if (current != remainder) {
                if (map.containsKey(remainder)) return true;
            } else {
                if (map.get(current) > 1) return true;
            }
        }
        return false;
    }
}

public class LC170 {
}
