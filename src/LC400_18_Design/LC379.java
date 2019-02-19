package LC400_18_Design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Gary on 2019-01-20.
 */
class PhoneDirectory {
    Set<Integer> used = new HashSet<>();
    Queue<Integer> available = new LinkedList<>();
    int max;

    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }

    public int get() {
        Integer result = available.poll();
        if (result == null) {
            return -1;
        }
        used.add(result);
        return result;
    }

    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    public void release(int number) {
        if (used.remove(number)) {
            available.offer(number);
        }
    }
}

public class LC379 {
}
