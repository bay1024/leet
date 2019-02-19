package LC400_18_Design;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Gary on 2019-01-17.
 */

class ZigzagIterator {
    private Iterator<Integer> i, j, temp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.i = v2.iterator();
        this.j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = i;
            i = j;
            j = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

public class LC281 {

}
