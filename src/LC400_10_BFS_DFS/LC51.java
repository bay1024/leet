package LC400_10_BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        dfs(res, grid, 0);
        return res;
    }

    private void dfs(List<List<String>> res, char[][] grid, int col) {
        if (col == grid.length) {
            res.add(create(grid));
            return;
        }
        for (int i = 0; i < grid.length; i++) {
            if (isValid(grid, i, col)) {
                grid[i][col] = 'Q';
                dfs(res, grid, col + 1);
                grid[i][col] = '.';
            }
        }
    }

    // 判断是否合法
    private boolean isValid(char[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'Q' && (row + col == i + j || row + j == col + i || row == i))
                    return false;
            }
        }
        return true;
    }

    //增加到结果
    private List<String> create(char[][] grid) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            String s = new String(grid[i]);
            list.add(s);
        }
        return list;
    }

}
