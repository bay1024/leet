package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC37 {
    public void solveSudoku(char[][] board) {
        help(board);
    }

    private boolean help(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {                // 若当前没有填充，需要进行填充
                    for (char c = '1'; c <= '9'; c++) {  // 从1-9开始试着往该位置填充
                        if (valid(board, i, j, c)) {// 判断填充是否有效
                            board[i][j] = c;        // 若有效，则填充
                            if (help(board)) return true;// 继续DFS，如果成功，返回true
                            else board[i][j] = '.';         // 如果不成功，恢复原状，返回上一层，试别的数
                        }
                    }
                    return false;    // 1-9都不成功，返回FALSE
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            // 检测第i行上有无重复
            if (board[i][k] != '.' && board[i][k] == ch) return false;
            // 检测第j列上有无重复
            if (board[k][j] != '.' && board[k][j] == ch) return false;
            // 根据大矩阵中的行列号计算小矩阵的行列号
            // 3*(i/3) 和 3*(j/3)是小矩阵中的起始位置
            // k/3, k%3是3x3小矩阵中的元素位置的偏移量
            int r = 3 * (i / 3) + k / 3;
            int c = 3 * (j / 3) + k % 3;
            // 检测小矩阵上有无重复
            if (board[r][c] != '.' && board[r][c] == ch) return false;
        }
        return true;
    }
}
