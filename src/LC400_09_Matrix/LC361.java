package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int rowCount = 0;
        int[] colCounts = new int[n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果扫描到最左端需要rowCount清零，或者左边那个位置是墙壁，也需要清零
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0;
                    // 这种情况下清零后，要从当前列号往后，重新计算有多少个E
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowCount += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                // 如果扫描到的是第0行的元素，或者上面那个位置是墙壁，需要把当前列的E个数清零
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCounts[j] = 0;
                    // 该情况下，要从当前行号往下，重新计算有多少个E，放入colCount[j]中
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colCounts[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                // 若碰到可放炸弹的地方，把对应的列号的数组中的值（当前列能炸掉的E的个数）+ rowCount 和结果比较取较大值
                if (grid[i][j] == '0') {
                    result = Math.max(result, colCounts[j] + rowCount);
                }
            }
        }

        return result;
    }
}
