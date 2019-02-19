package LC400_16_UnionFind;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Gary on 2019-01-22.
 */

/***********解法1：并查集**********/
public class LC261 {
    public boolean validTree(int n, int[][] edges) {
        int[] numbers = new int[n];
        Arrays.fill(numbers, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = find(numbers, edges[i][0]);
            int y = find(numbers, edges[i][1]);
            if (x == y) return false;
            numbers[x] = y;
        }
        return edges.length == n - 1;
    }

    int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}

/***********解法2：图**********/
class MyGraph{
    private int vCount;
    private LinkedList<Integer>[] adjs;
    public MyGraph(int v, int[][] edges){
        this.vCount = v;
        this.adjs = new LinkedList[v];
        for(int i = 0;i<v;i++)
            this.adjs[i] = new LinkedList<>();
        for(int i=0;i < edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            add(a, b);
        }
    }
    private void add(int a, int b) {
        adjs[a].add(b);
        adjs[b].add(a);
    }
    public int getVCount(){return this.vCount;}
    public Iterable<Integer> adj(int v){return this.adjs[v];}
}
class Cycle{
    private boolean[] marked;
    private int count;
    private boolean hasCycle = false;

    public Cycle(MyGraph g) {
        marked = new boolean[g.getVCount()];
        for (int s = 0; s < g.getVCount(); s++)
            if (!marked[s]) {
                dfs(g, s, s);
                count++;
                if(count>1)
                    break;
            }
    }

    private void dfs(MyGraph g, int v, int u) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w])
                dfs(g, w, v);
            else if (w != u) {
                hasCycle = true;
                return;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
    public int getCount(){return count;}
}
class Solution{
    public boolean validTree(int n, int[][] edges) {
        MyGraph g = new MyGraph(n, edges);
        Cycle c = new Cycle(g);
        return !c.hasCycle() && c.getCount()==1;
    }
}
