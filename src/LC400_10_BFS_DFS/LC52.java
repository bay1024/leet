package LC400_10_BFS_DFS;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC52 {
    int total = 0;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        dfs(grid, 0);
        return total;
    }

    private void dfs(char[][] grid, int col) {
        if (col == grid.length) {
            total++;
            return;
        }
        for (int i = 0; i < grid.length; i++) {
            if (valid(grid, i, col)) {
                grid[i][col] = 'Q';
                dfs(grid, col + 1);
                grid[i][col] = '.';
            }
        }
    }

    private boolean valid(char[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'Q' && (row + col == i + j || row + j == col + i || i == row))
                    return false;
            }
        }
        return true;
    }
}
