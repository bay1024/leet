package LC400_09_Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC317 {
    int[][] grid;
    int m;
    int n;
    // dist[i][j]表示[i][j]处的0点到所有城市的距离和，每次都在已有的基础上进行累加
    int[][] dist;
    // nums[i][j]表示[i][j]处的0点到所有城市的城市个数，每次多一个城市并且能到该城市，就自增
    int[][] nums;
    // 城市总数
    int buildingNum;
    int res;

    private void init() {
        m = grid.length;
        n = grid[0].length;
        dist = new int[m][n];
        nums = new int[m][n];
        buildingNum = 0;
        res = Integer.MAX_VALUE;
    }

    public int shortestDistance(int[][] grid) {
        this.grid = grid;
        if (grid == null || grid.length == 0) return -1;
        init();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // 如果是城市，就进行广搜
                    buildingNum++;       // 城市数目++
                    bfs(grid, i, j);   // 进行广搜
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果 是可作为meet地点的0点 && 该地点到能到达的城市和不为0 && 该地点能到的城市的个数为总城市数
                if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum) {
                    res = Math.min(res, dist[i][j]); // 找到最小的那个
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 广搜
    private void bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 上右下左四个方向
        boolean[][] visited = new boolean[m][n];
        int level = 0; // 广搜层次
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) { // (上右下左)四次
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1]; // 计算要搜索的方向
                    // 边界越界，访问过，不是0点，都不用进行
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true; // 标记为访问过
                        dist[x][y] += level;  // dist数组该点处累加层数，也就是距离
                        nums[x][y]++;          // 该点可到达的城市数加一
                        queue.offer(new int[]{x, y}); // 入队
                    }
                }
            }
        }
    }
}
