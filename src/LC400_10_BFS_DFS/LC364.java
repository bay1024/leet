package LC400_10_BFS_DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> list, int res) {
        List<NestedInteger> nestList = new LinkedList<>();
        for (NestedInteger ni : list) {
            if (ni.isInteger()) res += ni.getInteger();
            else                nestList.addAll(ni.getList());
        }
        res += nestList.isEmpty() ? 0 : helper(nestList, res);
        return res;
    }
}
