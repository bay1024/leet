package LC400_01_Array;

/**
 * Created by Gary on 12/11/18.
 */
public class LC309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int len = prices.length;
        //buy[i]表示在第i天不持有股票所能获得的最大累积收益
        int[] buy = new int[len];
        //sell[i]表示在第i天持有股票所能获取的最大累积收益
        int[] sell = new int[len];

        //第0天持有，那么收益就是：0-该天股价
        buy[0] = -prices[0];

        //第一天如果持有，那么取两个值得最大值作为第一天得最大收益。
        //第一个值：第0天持有，那么第一天继续持有收益和第0天一样
        //第2个值：第0天不持有，那么第一天持有，最大收益就是0-当天股价
        buy[1] = Math.max(-prices[0], -prices[1]);

        //第一天不持有：1.第0天不持有；2.第0天持有，那么就是第0天买，第一天卖，也就是prices[1] - prices[0]
        sell[0] = 0;
        //第一天不持有：1.第0天不持有；2.第0天持有，那么就是第0天买，第一天卖，也就是prices[1] - prices[0]
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < len; i++) {//根据状态转移方程填充数组
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }
        return sell[len - 1];
    }
}
