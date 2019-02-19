package LC400_13_TopologicalSort;

/**
 * Created by Gary on 2019-01-31.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 图的深搜之前中后序遍历
 */
class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre; // 所有顶点的前序排列
    private Queue<Integer> post; // 所有顶点的后序排列
    private Stack<Integer> reversePost;// 所有顶点的逆后序排列

    public DepthFirstOrder(Digraph g) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[g.getVertexCount()];
        for (int v = 0; v < g.getVertexCount(); v++)
            if (!marked[v]) dfs(g, v);
    }

    private void dfs(Digraph g, int v) {
        pre.offer(v);
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w]) dfs(g, w);
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() { return pre; }

    public Iterable<Integer> post() { return post; }

    public Stack<Integer> reversePost() { return reversePost; }
}

class Topological {
    private Stack<Integer> order;//顶点的拓扑排序

    public Topological(Digraph d) {
        DirectedCycle cycleFinder = new DirectedCycle(d);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(d);
            order = dfs.reversePost();
        }
    }

    public Stack<Integer> order() { return order; }

    public boolean isDAG() { return order != null; }
}

public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Digraph d = new Digraph(numCourses, prerequisites);
        Topological t = new Topological(d);
        if (!t.isDAG()) return new int[0];
        Stack<Integer> stack = t.order();
        int[] result = new int[stack.size()];
        int i = 0;
        for (int v : stack) result[i++] = v;
        return result;
    }
}
