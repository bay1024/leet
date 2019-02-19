package LC400_06_DP;

/**
 * Created by Gary on 2019-01-08.
 */
public class LC174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        // DP二维数组表示血量
        int[][] dp = new int[m][n]; // dp[i][j]表示从(i,j)到目的地(m-1, n-1)需要的最小生命值

        // 初始化右下角的血量格子中的值
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        // 逆推最后一列的血量
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        // 逆推最后一行的血量
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }

        // 对于每个节点，从下方和右方逆推出来
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);   // 从下方逆推出来的值
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);  // 从右方逆推出来的值
                dp[i][j] = Math.min(down, right);   // 选择最小血量放入当前血量格子
            }
        }
        return dp[0][0];// 返回骑士起始所在格子对应的血量
    }
}
