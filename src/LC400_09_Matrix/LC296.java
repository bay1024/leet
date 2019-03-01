package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC296 {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row_sum = new int[n], col_sum = new int[m];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                row_sum[j] += grid[i][j];
                col_sum[i] += grid[i][j];
            }

        return minDistance1D(row_sum) + minDistance1D(col_sum);
    }

    private int minDistance1D(int[] vector) {
        int i = -1, j = vector.length;
        int d = 0, left = 0, right = 0;

        while (i != j) {
            if (left < right) {
                d += left;
                left += vector[++i];
            } else {
                d += right;
                right += vector[--j];
            }
        }
        return d;
    }
}
