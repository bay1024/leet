package LC400_10_BFS_DFS;

/**
 * Created by Gary on 2019-01-14.
 */

import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
// 用来过编译器
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() { }

    // Constructor initializes a single integer.
    public NestedInteger(int value) { }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() { return false; }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() { return 0; }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) { }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) { }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() { return null; }
}

public class LC339 {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) result += ni.getInteger() * depth;
            else result += dfs(ni.getList(), depth + 1);
        }
        return result;
    }
}
