package LC400_13_TopologicalSort;

/**
 * Created by Gary on 2019-01-31.
 */

import java.util.LinkedList;
import java.util.Stack;

/**
 * 有向图
 */
class Digraph {
    private int vCount;
    private int eCount;
    private LinkedList[] adj;

    public Digraph(int v) {
        this.vCount = v;
        this.eCount = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) adj[i] = new LinkedList<>();
    }

    public Digraph(int v, int[][] edges) {
        this(v);
        int e = edges.length;
        for (int i = 0; i < e; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            addEdge(start, end);
        }
    }

    private void addEdge(int start, int end) {
        adj[start].add(end);
        eCount++;
    }

    public int getVertexCount() { return vCount; }

    public int getEdgeCount() { return eCount; }

    /**
     * v指出的所有边所连接的顶点
     */
    public LinkedList<Integer> adj(int v) { return adj[v]; }

    /**
     * 返回该图的反向图
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(this.vCount);
        for (int start = 0; start < vCount; start++) {
            for (int end : adj(start)) reverse.addEdge(end, start);
        }
        return reverse;
    }
}

/**
 * 有向图中的环
 */
class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;    // 有向环中的所有顶点
    private boolean[] onStack;        // 递归调用的栈上的所有顶点

    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.getVertexCount()];
        edgeTo = new int[digraph.getVertexCount()];
        marked = new boolean[digraph.getVertexCount()];
        for (int i = 0; i < digraph.getVertexCount(); i++) {
            //  if(hasCycle()) break;
            if (!marked[i]) dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Stack<Integer> getCycle() { return cycle; }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Digraph d = new Digraph(numCourses, prerequisites);
        DirectedCycle dCycle = new DirectedCycle(d);
        return !dCycle.hasCycle();
    }
}

public class LC207 {
}
