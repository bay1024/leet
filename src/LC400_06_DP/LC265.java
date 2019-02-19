package LC400_06_DP;

/**
 * Created by Gary on 2019-01-07.
 */
public class LC265 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int prevMin = 0;        // 最小
        int preSec = 0;         // 次小
        int prevIdx = -1;       // 最小值的颜色index

        for (int i = 0; i < costs.length; i++) {
            int currentMin = Integer.MAX_VALUE, currentSecond = Integer.MAX_VALUE, currentIdx = -1;
            for (int j = 0; j < costs[0].length; j++) {
                // 如果和上个房子选的颜色一样，选择次小代价；否则选择最小代价
                costs[i][j] = costs[i][j] + (prevIdx == j ? preSec : prevMin);
                // 找出最小的和次小的，并记录最小的颜色下标，方便下一轮判断
                if (costs[i][j] < currentMin) {  // 先和最小的比，如果比最小的还小
                    currentSecond = currentMin;  // 把最小赋值给次小
                    currentMin = costs[i][j];    // 把最小（当前值）赋值给最小
                    currentIdx = j;              // 记录当前最小值的索引
                } else if (costs[i][j] < currentSecond) { // 比最小值大，但是比次小值小
                    currentSecond = costs[i][j];        // 更新次小值
                }
            }
            // 每走完一行，就更新previous的三个值
            prevMin = currentMin;       // 更新previous 最小值
            preSec = currentSecond;     // 更新previous 次小值
            prevIdx = currentIdx;       // 更新previous 最小值的索引
        }
        //全部遍历完成，返回previous 最小值
        return prevMin;
    }
}
