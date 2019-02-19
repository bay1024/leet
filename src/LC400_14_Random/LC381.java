package LC400_14_Random;

import java.util.*;

/**
 * Created by Gary on 2019-02-02.
 */
class RandomizedCollection {
    private Map<Integer, Deque<Integer>> map;
    private List<Integer> list;
    private Random random;
    private int size;

    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
        this.size = 0;
    }

    public boolean insert(int val) {
        boolean boo = false;
        Deque<Integer> dq = map.get(val);
        if (dq == null || dq.isEmpty()) {
            dq = new ArrayDeque<>();
            map.put(val, dq);
            boo = true;
        }
        list.add(val);
        dq.push(size);
        size++;
        return boo;
    }

    public boolean remove(int val) {
        Deque<Integer> dq = map.get(val);
        if (dq == null || dq.isEmpty()) return false;
        list.set(dq.pop(), null);
        return true;
    }

    public int getRandom() {
        Integer result = null;
        do {
            result = list.get(random.nextInt(size));
        } while (result == null);
        return result;
    }
}

public class LC381 {
}
