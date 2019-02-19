package LC400_06_DP;

/**
 * Created by Gary on 2019-01-09.
 */
public class LC276 {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        // same[i] : 第i个post和第i-1个post颜色相同
        int[] same = new int[n];
        // diff[i] : 第i个post和第i-1个post颜色不同
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            same[i] = diff[i - 1];
            diff[i] = (k - 1) * same[i - 1] + (k - 1) * diff[i - 1];
        }
        return same[n - 1] + diff[n - 1];
    }
}
