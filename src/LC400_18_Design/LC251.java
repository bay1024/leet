package LC400_18_Design;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Gary on 2019-01-17.
 */
class Vector2D implements Iterator<Integer> {
    int indexList, indexElement;
    List<List<Integer>> list;

    public Vector2D(List<List<Integer>> vec2d) {
        indexElement = 0;
        indexList = 0;
        list = vec2d;
    }

    @Override
    public Integer next() {
        return list.get(indexList).get(indexElement++);
    }

    @Override
    public boolean hasNext() {
        while (indexList < list.size()) {
            if (indexElement < list.get(indexList).size()) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}

public class LC251 {

}
