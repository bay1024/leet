package LC400_06_DP;

/**
 * Created by Gary on 2019-01-08.
 */
public class LC64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int col = grid[0].length;
        int[] sum = new int[col];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = Integer.MAX_VALUE;
        }
        sum[0] = 0;
        for (int[] ints : grid) {
            sum[0] = sum[0] + ints[0];
            for (int j = 1; j < col; j++) {
                sum[j] = Math.min(sum[j], sum[j - 1]) + ints[j];
            }
        }
        return sum[col - 1];
    }
}
