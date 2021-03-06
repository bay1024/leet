package LC400_06_DP;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-08.
 */
public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] height = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) height[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else height[i][j] += (matrix[i][j] == '1' ? height[i - 1][j] + 1 : 0);
            }
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < col; j++) {
                while (!stack.empty() && height[i][j] < height[i][stack.peek()]) {
                    int pos = stack.peek();
                    stack.pop();
                    result = Math.max(result, height[i][pos] * (stack.empty() ? j : j - stack.peek() - 1));
                }
                stack.push(j);
            }

            while (!stack.empty()) {
                int pos = stack.pop();
                result = Math.max(result, height[i][pos] * (stack.empty() ? col : col - stack.peek() - 1));
            }
        }
        return result;
    }
}
