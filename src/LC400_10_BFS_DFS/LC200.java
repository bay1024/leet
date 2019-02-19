package LC400_10_BFS_DFS;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC200 {
    private int m, n;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 | j < 0 || i >= m || j >= n || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        for (int[] ints : dir) {
            int x = i + ints[0];
            int y = j + ints[1];
            dfs(grid, x, y, visited);
        }
    }
}
