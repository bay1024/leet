package LC400_06_DP;

/**
 * Created by Gary on 2019-01-08.
 */
public class LC221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int result = 0;
        int[][] helper = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    helper[i][j] = Math.min(Math.min(helper[i][j - 1], helper[i - 1][j - 1]), helper[i - 1][j]) + 1;
                    result = Math.max(helper[i][j], result);
                }
            }
        }
        return result * result;
    }
}
