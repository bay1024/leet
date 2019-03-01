package LC400_09_Matrix;

import java.util.HashSet;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC36 {
    // time: O(m*n)
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            // 通过i来计算第i小正方形的第一个位置[0,0]点
            int rowIndex = 3 * (i / 3);
            int colIndex = 3 * (i % 3);
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;
                // 通过j来计算实际在大正方形中的行列号
                int r = rowIndex + j / 3;
                int c = colIndex + j % 3;
                if (board[r][c] != '.' && !cube.add(board[r][c]))
                    return false;
            }
        }
        return true;
    }
}
