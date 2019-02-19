package LC400_01_Array;

/**
 * Created by Gary on 12/11/18.
 */
public class LC121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int low = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) low = prices[i];
            else max = Math.max(prices[i] - low, max);
        }
        return max;
    }
}
