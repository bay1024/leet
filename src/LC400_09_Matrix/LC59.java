package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] result = new int[n][n];
        int current = 1;
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        while (top < bottom && left < right) {
            // left -- right
            for (int i = left; i < right; i++) result[top][i] = current++;
            // top -- bottom
            for (int i = top; i < bottom; i++) result[i][right] = current++;
            // right -- left
            for (int i = right; i > left; i--) result[bottom][i] = current++;
            // bottom -- top
            for (int i = bottom; i > top; i--) result[i][left] = current++;

            top++;
            bottom--;
            left++;
            right--;
        }

        if (n % 2 == 1) result[n / 2][n / 2] = current;

        return result;
    }
}
