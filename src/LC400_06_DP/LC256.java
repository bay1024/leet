package LC400_06_DP;

/**
 * Created by Gary on 2019-01-07.
 */
public class LC256 {
    /**
     有一排房子，每个房子可以被刷成红蓝绿三种颜色之一。
     每种颜色刷到每个房子上的花费是不一样的。需要刷出来的房子挨着的颜色不能相同。
     cost[n][3]:
         {{34,22,17},
          {36,12,11},
          {64,25,10},
          {13,28,98} }例如该矩阵，第一行是0号房子刷三种颜色的代价34，22，17
     找到一种最便宜的方法，满足上述条件
    */

    /* 思路，用DP：时间O(N) 空间O(1)
     1. 对于房子i，最小的代价是 直到房子i-1的最小代价 + 房子i本身的刷颜色代价。
     2. 房子i的涂色方案要根据房子i-1的涂色方案来决定，所以对房子i-1要记录三种颜色分别的不同代价，
        这样在房子i刷颜色的时候，就知道三种颜色各自的最小代价是多少了。 在原数组上进行修改的话，可以做到不用额外空间
    */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)  return 0;
        for(int i = 1; i<costs.length; i++){
            // 刷第0号颜色的话，上一个房子就不能刷第0号颜色，所以要在上一个房子的第1和第3号颜色的代价中找较小的那个
            // 然后加上第i个刷第0号颜色的代价
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            // 同理,刷第1号颜色的话，取上个房子刷第0和第2号颜色个代价的较小值 + 当前刷1号颜色的代价
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            // 同理
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[costs.length - 1][0],
                Math.min(costs[costs.length - 1][1],costs[costs.length - 1][2]));
    }
}
