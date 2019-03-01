package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n]; // 缓存，用来存储计算好的结果，降低时间复杂度

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                result = Math.max(result, max);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int min, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= min) return 0; // 边界判断
        if (cache[i][j] != 0) return cache[i][j]; // 如果缓存中有值，直接返回
        min = matrix[i][j];
        // 分别向上下左右各走一步
        int up = dfs(matrix, min, i - 1, j, m, n, cache) + 1;
        int down = dfs(matrix, min, i + 1, j, m, n, cache) + 1;
        int left = dfs(matrix, min, i, j - 1, m, n, cache) + 1;
        int right = dfs(matrix, min, i, j + 1, m, n, cache) + 1;
        // 取四个值中的最大值放入缓存中并返回
        int max = Math.max(up, Math.max(down, Math.max(left, right)));
        cache[i][j] = max;
        return max;
    }
}
