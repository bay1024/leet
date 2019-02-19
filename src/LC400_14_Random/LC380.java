package LC400_14_Random;

import java.util.*;

/**
 * Created by Gary on 2019-02-01.
 */
public class LC380 {
    public class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        int size;
        Random rand;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            size = 0;
            rand = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, size);
            list.add(val);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int index = map.remove(val);
            if (index != size - 1) {
                map.put(list.get(size - 1), index);
                list.set(index, list.remove(size - 1));
            } else
                list.remove(size - 1);
            size--;

            return true;
        }

        public int getRandom() {
            if (list.isEmpty()) return -1;
            return list.get(rand.nextInt(size));
        }
    }
}
