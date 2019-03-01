package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC240 {
    //time: O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            int current = matrix[row][col];
            if (target == current) return true;
            else if (target < current) col--;
            else row++;
        }
        return false;
    }
}
