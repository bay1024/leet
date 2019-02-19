package LC400_01_Array;

/**
 * Created by Gary on 12/22/18.
 */
public class LC289 {
    private final int DEAD = 0;
    private final int ALIVE = 1;
    private final int DEAD_TO_DEAD = 0;
    private final int ALIVE_TO_ALIVE = 1;
    private final int ALIVE_TO_DEAD = 2;
    private final int DEAD_TO_ALIVE = 3;
    // 判断某点在本轮变化之前的生死状态
    private boolean isAliveOld(int o)
    {   return (o == ALIVE_TO_ALIVE || o == ALIVE_TO_DEAD);  }
    // 判断某点在本轮变化后的生死状态
    private boolean isAliveNew(int o)
    {	return (o % 2 == 1);    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)      return;
        int height = board.length, width = board[0].length;
        int count;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                count = 0;
                if (i > 0 && j > 0 && isAliveOld(board[i - 1][j - 1]))              count++;
                if (i > 0 && isAliveOld(board[i - 1][j]))                           count++;
                if (i > 0 && j < (width - 1) && isAliveOld(board[i - 1][j + 1]))    count++;
                if (j < (width - 1) && isAliveOld(board[i][j + 1]))                 count++;
                if (i < (height - 1) && j < (width - 1) && isAliveOld(board[i + 1][j + 1])) count++;
                if (i < (height - 1) && isAliveOld(board[i + 1][j]))                count++;
                if (i < (height - 1) && j > 0 && isAliveOld(board[i + 1][j - 1]))   count++;
                if (j > 0 && isAliveOld(board[i][j - 1]))                           count++;
                if (isAliveNew(board[i][j])) {
                    if (count < 2)                      board[i][j] = ALIVE_TO_DEAD;
                    else if (count == 2 || count == 3)  board[i][j] = ALIVE_TO_ALIVE;
                    else                                board[i][j] = ALIVE_TO_DEAD;
                } else {
                    if (count == 3)                 board[i][j] = DEAD_TO_ALIVE;
                    else                            board[i][j] = DEAD_TO_DEAD;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isAliveNew(board[i][j]))        board[i][j] = ALIVE;
                else                                board[i][j] = DEAD;
            }
        }
    }
}
