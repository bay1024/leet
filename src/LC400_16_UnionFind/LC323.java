package LC400_16_UnionFind;

/**
 * Created by Gary on 2019-01-22.
 */
class WeightedQuickUnion {
    private int[] id;   // 父连接数组
    private int[] size; // 由触点索引的各个根节点所对应的分量大小
    private int count;  // 分量数量

    public WeightedQuickUnion(int n) {
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;      //初始化连接数组，都指向自己
            size[i] = 1;    //初始化size大小，每个都是1
        }
    }

    /**
     * 得到分量数量
     */
    public int getConnectedCount() { return this.count; }

    /**
     * 判断p和q是否贼同一个分量中
     */
    public boolean isConnected(int p, int q) { return find(p) == find(q); }

    /**
     * 跟随连接找到根节点
     */
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    /**
     * 连接p和q
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        // 如果两个根相同，说明已经在一个连通分两种，直接返回，无需操作
        if (i == j) return;
        // 将小树的根节点连接到大树的根节点，并增加大树的size
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        // 分量数目减一
        count--;
    }
}

public class LC323 {
    public int countComponents(int n, int[][] edges) {
        WeightedQuickUnion union = new WeightedQuickUnion(n);
        for (int[] edge : edges) {
            union.union(edge[0], edge[1]);
        }
        return union.getConnectedCount();
    }
}
