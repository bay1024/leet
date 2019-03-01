package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return;
        boolean row = false, col = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) setZeroForRow(matrix, i);
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) setZeroForCol(matrix, i);
        }

        if (row) setZeroForRow(matrix, 0);
        if (col) setZeroForCol(matrix, 0);

    }

    private void setZeroForRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) matrix[row][i] = 0;
    }

    private void setZeroForCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) matrix[i][col] = 0;
    }
}
