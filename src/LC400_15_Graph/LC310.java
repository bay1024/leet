package LC400_15_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Gary on 2019-01-29.
 */
public class LC310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) return result;
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            result = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int current = queue.poll();
                result.add(current);
                degree[current]--;
                for (int k = 0; k < graph.get(current).size(); k++) {
                    int next = graph.get(current).get(k);
                    if (degree[next] == 0) continue;
                    if (degree[next] == 2) queue.offer(next);
                    degree[next]--;
                }
            }
        }
        return result;
    }
}
