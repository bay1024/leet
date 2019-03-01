package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] < target) left = mid;
            else right = mid;
        }
        return matrix[left / n][left % n] == target || matrix[right / n][right % n] == target;
    }
}
