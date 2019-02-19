package LC400_01_Array;

/**
 * Created by Gary on 12/11/18.
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int dif = prices[i] - prices[i - 1];
            if (dif > 0) {
                result += dif;
            }
        }
        return result;
    }
}
